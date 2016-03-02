
angular.module('starter.controllers', [])

.controller("EventCtrl",function($scope, $ionicPlatform, $http, EventService, getEventService, $window){
    $scope.events = [];
    $scope.eventsTemp = [
        {"title":"Title A", "detail":"happy", id:1, "time":"2015/10/10 17:00:00" },
        {"title":"Title B", "detail":"sad", id:2, "time":"2015/11/10 17:00:00"},
		{"title":"Title C", "detail":"happy", id:3, "time":"2015/10/10 17:00:00" },
		{"title":"Title D", "detail":"happy", id:4, "time":"2015/10/10 17:00:00" },
		{"title":"Title E", "detail":"happy", id:5, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:6, "time":"2015/10/10 17:00:00" },
		{"title":"Title Z", "detail":"happy", id:7, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:8, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:9, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:10, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:11, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:12, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:13, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:14, "time":"2015/10/10 17:00:00" },
    ];

    $scope.selected_item = function(val) {
        EventService.selectedEvent = val;
    };

    $ionicPlatform.ready(function() {
        getEventService.getEvent()
        .then(function(response){
            $scope.events = JSON.parse(response.d).tns;
            console.log(JSON.parse(response.d).tns);
        });
    });

})

.controller("DetailCtrl", ['$scope', '$http', 'EventService', 'UpdateService' ,'UpdateServiceFake',function($scope, $http, EventService, UpdateService, UpdateServiceFake){
    $scope.event = EventService.selectedEvent;
	
	/*$scope.getUpdatedEventFake = function(event) {
		UpdateServiceFake.updatedEvent(event);
	}*/
	
	$scope.getUpdatedEvent = function(event) {
		UpdateService.updateEvent(event);
	}
}])

.controller("MainCtrl", ['$scope', '$http', function($scope, $http){

}])

.controller("TestCtrl", ['$scope', '$http', function($scope, $http){

}]);
