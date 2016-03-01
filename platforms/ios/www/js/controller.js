
angular.module('starter.controllers', [])

.controller("EventCtrl",function($scope, $ionicPlatform, $http, EventService, getEventService, $window){
    $scope.events = [];
    $scope.eventsTemp = [
        {"title":"Title A", "detail":"happy", id:1, "time":"2015/10/10 17:00:00" },
        { "title": "Title B", "detail": "sad", id: 2, "time": "2015/11/10 17:00:00" },
        { "title": "Title B", "detail": "sad", id: 2, "time": "2015/11/10 17:00:00" }
    ];

    $scope.selected_item = function(val) {
        EventService.selectedEvent = val;
    };

    /*$ionicPlatform.ready(function() {
        getEventService.getEvent()
        .then(function(response){
            $scope.events = JSON.parse(response.d).tns;
            console.log(JSON.parse(response.d).tns);
        });
    });*/

})

.controller("DetailCtrl", ['$scope', '$http','EventService', function($scope, $http, EventService){
    $scope.event = EventService.selectedEvent;
}])

.controller("MainCtrl", ['$scope', '$http', function($scope, $http){

}])

.controller("TestCtrl", ['$scope', '$http', function($scope, $http){

}]);
