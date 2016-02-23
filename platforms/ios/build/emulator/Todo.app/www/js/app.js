// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
var todoApp = angular.module('starter', ['ionic', 'ngCordova']);

angular.module('starter', ['ionic'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})

.controller("EventCtrl", ['$scope', '$http', function($scope, $http){
    $scope.jsonStr = "json stirng here";
    $scope.events = [];
    $scope.GetEvent = function() {
        var deferred = $.Deferred();
        Util.getToken().then(function(token){
            var myData ={
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
        promise.then(function(response){
            console.log(response.d);
            //$scope.events = 
        })

    };

}]);
