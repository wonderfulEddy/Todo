
angular.module('starter.controllers', [])

.controller("EventCtrl",function($q, $rootScope, $scope, $ionicPlatform, $http, EventService, getEventService, $window, DeleteService, $ionicPopup, GetDataService, $ionicLoading, $ionicHistory, $ionicActionSheet, $state){
    
    // ---- Loading...
    $scope.$on('$ionicView.beforeEnter', function(event, view){
        console.log("before enter...", view.stateName)
        $ionicLoading.show({
            template: 'Loading...'
        });
    });

    $scope.events = [];
    $scope.eventsTemp = [
        {"title":"Title A", "detail":"happy", id:1, "time":"2015/10/10 17:00:00" },
    ];
    
    // ---- Set selected event information
    $scope.selected_item = function(val) {
        //EventService.selectedEvent = val;
        EventService.setSelectedEvent(val);
    };
    
    // ---- Refresh events (Get events)
    $ionicPlatform.ready(function() {
        console.log("Device Ready in EventCtrl");
        getEventService.getEvent()
        .then(function(response){
            GetDataService.setEvent(JSON.parse(response.d).tns);
            $scope.events = GetDataService.getEvent();
            $ionicLoading.hide();
        });
    });

    // ---- Pull the list to refresh
    $scope.doRefresh = function() {
        var promise = getEventService.getEvent();
        promise
        .then(function(response){
            $scope.events = JSON.parse(response.d).tns;
        })
        .finally(function(){
            $scope.$broadcast('scroll.refreshComplete');
        });
    };
    
    // ---- Long press to show options
    $scope.showPopup = function(event) {
        var myPopup = $ionicPopup.show({
            template: '<button class="button button positive">Delete</button>',
            title: 'Delete this event?',
            subTitle: event.title,
            scope: $scope,
            buttons: [
              { text: 'Cancel', type: 'button-positive' },
              {
                text: 'Delete',
                type: 'button-positive',
                onTap: function(e) {
                    DeleteService.deleteEvent(event).then(function(){
                        getEventService.getEvent()
                        .then(function(response){
                            GetDataService.setEvent(JSON.parse(response.d).tns);
                            $scope.events = GetDataService.getEvent();
                        });
                    });
                }
              }
            ]
        });
    };
    
    // ---- Action Sheet
    $scope.showOptions = function(event) {
        var hideSheet = $ionicActionSheet.show({
            buttons: [{
                text: 'Update'
            }],
            destructiveText: 'Delete',
            titleText: 'Options Menu',
            cancelText: 'Cancel',
            cancel: function() {
                hideSheet();
            },
            buttonClicked: function(index) {
                switch(index) {
                    case 0:     // Update event
                        EventService.setSelectedEvent(event);
                        $state.go('main.detail');
                        break;
                    default:
                        break;
                }
                return true; // Return true to close option, false to keep it.
            },
            destructiveButtonClicked: function() {
                var myPopup = $ionicPopup.show({
                    title: 'Delete this event?',
                    subTitle: event.title,
                    scope: $scope,
                    buttons: [
                      { text: 'Cancel', type: 'button-positive' },
                      {
                        text: 'Delete',
                        type: 'button-positive',
                        onTap: function(e) {
                            DeleteService.deleteEvent(event).then(function(){
                                getEventService.getEvent()
                                .then(function(response){
                                    GetDataService.setEvent(JSON.parse(response.d).tns);
                                    $scope.events = GetDataService.getEvent();
                                });
                            });
                        }
                      }
                    ]
                });
                
                return true; // Return true to close option, false to keep it.
            }
        });
    };
    
    
})

.controller("DetailCtrl",function($ionicPlatform, $rootScope, $scope, $http, EventService, UpdateService, $cordovaDatePicker){
    
    $scope.event = EventService.getSelectedEvent();
    var dateString = "";
    var timeString = "";
    var dateTimeObj = $scope.event.time.split(" ",2);
    $scope.timeLabel = {
        date: dateTimeObj[0],
        time: dateTimeObj[1]
    };
	
    $scope.setDate = function(event) {
        var now = new Date();
        var options = {
                date: now,
                mode: 'date', // or 'time'
                minDate: now,
                allowOldDates: true,
                allowFutureDates: true,
                doneButtonLabel: 'DONE',
                doneButtonColor: '#0000ff',
                cancelButtonLabel: 'CANCEL',
                cancelButtonColor: '#0000ff'
        };
        $cordovaDatePicker.show(options).then(function(date){
            dateString = date.getFullYear() + "/" +
                        (date.getMonth()+1) + "/" +
                        date.getDate();
            $scope.timeLabel.date = dateString;
        });
    }
    
    $scope.setTime = function(event) {
        var now = new Date();
        var options = {
                date: now,
                mode: 'time', // or 'time'
                doneButtonLabel: 'DONE',
                doneButtonColor: '#0000ff',
                cancelButtonLabel: 'CANCEL',
                cancelButtonColor: '#0000ff'
        };
        $cordovaDatePicker.show(options).then(function(time){
            var timeFormatted =
            timeString = (time.getHours()<10 ? "0":"") + time.getHours() + ":" +
                        (time.getMinutes()<10 ? "0":"") + time.getMinutes() + ":" +
                        (time.getSeconds()<10 ? "0":"") + time.getSeconds();
            $scope.timeLabel.time = timeString;
        });
    }
    
    
    
	$scope.getUpdatedEvent = function(event) {
		UpdateService.updateEvent(event);
	}
})


.controller("AddCtrl", function($scope, $http, InsertService){
	$scope.newEvent = {
		title : "",
		detail : "",
		time : "2015/03/17 12:00:00"
	}
	
	$scope.submit = function(newEvent) {
		InsertService.insertEvent(newEvent);
        
	}
    
})

.controller("MainCtrl", ['$scope', '$http', function($scope, $http){
   
}]);
