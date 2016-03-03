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
         cache: false,
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
      })
	  .state('main.add', {
           url: '/event/add',
           views: {
             'eventContent' : {
                templateUrl: "template/add.html",
                controller: 'AddCtrl'
              }
            }
      });
       $urlRouterProvider.otherwise('/main/event');
})

/* Get all the events */
.service('getEventService', ['$http','$window','$q', function($http, $window, $q){
    /*var deferred = $.Deferred();
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
    };*/
    
    var deferred = $q.defer();
    var promised = deferred.promise;
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

        return promised;
    };
    
}])

.factory('GetEventFactory', function($http, $window){
    var factory = {};
    
    var deferred = $.Deferred();
    factory.getEvent = function() {
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
    
    return factory;
})

/* Get detailed event */
.service('EventService', function(){
    this.selectedEvent;
})

/* Update events fake... */
.service('UpdateServiceFake', function(){
	this.updateEvent = function(event) {
		alert(JSON.stringify(event));
	}
    
	
})

/* Update events */
.service('UpdateService', function($http, $state){
	this.updateEvent = function(event) {

		Util.getToken().then(function(token){
			var json= {
                "event_id":event.id,
                "accessToken":token,
                "title":event.title,
                "detail":event.detail,
                "time":event.time,
                "notificationId":["-1"],
                "notificationTime":[event.time],
                "notificationMessage":[""],
                "notificationHasBeenEdited":["0"],
                "deleteNotificationId":["0"]
            }

			var data = JSON.stringify(json);

			$http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/updateEvent",data)
			.success(function(){
                $state.go('main.event', null, {reload:true});
            })
			.error(function(errorMsg){alert("error:" + errorMsg);});
		});
		
	};
})

/* Insert events */
.service('InsertService', function($http, $state){
	this.insertEvent = function(event) {

		Util.getToken().then(function(token){
			var json= {
				"accessToken":token,
                "title":event.title,
                "detail":event.detail,
                "time":event.time,
                "notificationTime":[""],
                "notificationMessage":[""],
            }

			var data = JSON.stringify(json);

			$http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/insertEvent",data)
			.success(function(){
                $state.go('main.event');
            })
			.error(function(errorMsg){alert("error:" + errorMsg);});
		});
		
	};
})


/* Delete events */
.service('DeleteService', function($http, $state){
	this.deleteEvent = function(event) {

		Util.getToken().then(function(token){
			var json = {
                "event_id":event.id, "accessToken":token
            }
            
			var data = JSON.stringify(json);

			$http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/deleteEvent",data)
			.success(function(){
                alert("Delete: " + event.title);
            })
			.error(function(errorMsg){alert("error:" + JSON.stringify(errorMsg));});
		});
		
	};
});

































