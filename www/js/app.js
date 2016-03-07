// Ionic Starter App
// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
//var todoApp = angular.module('starter', ['ionic', 'ngCordova', 'starter.controllers']);
angular.module('starter', ['ionic','ngCordova','starter.controllers', 'starter.services'])
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
});



































