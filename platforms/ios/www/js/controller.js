
angular.module('starter.controllers', [])

.controller("EventCtrl",function($rootScope, $scope, $ionicPlatform, $http, EventService, getEventService, myFactory){
    $rootScope.events = [];
    $scope.eventsTemp = [
        {"title":"Title A", "detail":"happy", id:1, "time":"2015/10/10 17:00:00" },
        {"title":"Title B", "detail":"sad", id:2, "time":"2015/11/10 17:00:00"}
    ];

    $scope.selected_item = function(val) {
        EventService.selectedEvent = val;
    };

    $ionicPlatform.ready(function() {
        /*getEventService.getEvent()
        .then(function(response){
            $scope.events = JSON.parse(response.d).tns;
            console.log(JSON.parse(response.d).tns);
        });*/
        myFactory()
        .then(function(response){
            $rootScope.events = JSON.parse(response.d).tns;
            console.log(JSON.parse(response.d).tns);
        });
    });

})

.controller("DetailCtrl", ['$rootScope', '$scope', '$http','EventService', function($rootScope, $scope, $http, EventService){
    $scope.event = EventService.selectedEvent;
    console.log("Your title: "+$rootScope.events[0].title);
}])

.controller("MainCtrl", ['$scope', '$http', function($scope, $http){

}])

.controller("TestCtrl", ['$scope', '$http', function($scope, $http){

}]);
