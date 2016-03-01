// Ionic Starter App
// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
//var todoApp = angular.module('starter', ['ionic', 'ngCordova', 'starter.controllers']);
angular.module('starter', ['ionic','ngCordova','starter.controllers'])
.run(function($ionicPlatform, getEventService) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})
.config(function($stateProvider, $urlRouterProvider) {
     $stateProvider
     .state('main', {
          url: '/main',
          abstract: true,
          templateUrl: "template/menu.html",
          controller: 'MainCtrl'
      })
     .state('main.event', {
         url: '/event',
         views: {
           'eventContent' : {
             templateUrl: "template/event.html",
             controller: 'EventCtrl'
           }
         }

      })
       .state('main.detail', {
           url: '/event/:eventId',
           views: {
             'eventContent' : {
                templateUrl: "template/detail.html",
                controller: 'DetailCtrl'
              }
            }
      });
       $urlRouterProvider.otherwise('/main/event');
})

.service('EventService', function(){
    this.selectedEvent;
})

.service('getEventService', ['$http','$window', function($http, $window){
    var deferred = $.Deferred();
    this.getEvent = function() {
        Util.getToken().then(function(token){
        var myData = {
            "accessToken" : token,
            "from" : "",
            "to" : ""
        }
        var data = JSON.stringify(myData);

        $http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/getEvent",data).
        success(function(response){deferred.resolve(response);}).
        error(function(errorMsg){deferred.reject("error:" + errorMsg);});

        });

        var promise = deferred.promise();
        return promise;
    };
}]);
