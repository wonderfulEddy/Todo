
angular.module('starter.controllers', [])

.controller("EventCtrl",function($q, $rootScope, $scope, $ionicPlatform, $http, EventService, getEventService, $window, DeleteService, $ionicPopup){
    
    $scope.events = [];
    $scope.eventsTemp = [
        {"title":"Title A", "detail":"happy", id:1, "time":"2015/10/10 17:00:00" },
        {"title":"Title B", "detail":"sad", id:2, "time":"2015/11/10 17:00:00"},
		{"title":"Title C", "detail":"happy", id:3, "time":"2015/10/10 17:00:00" },
		{"title":"Title D", "detail":"happy", id:4, "time":"2015/10/10 17:00:00" },
		{"title":"Title E", "detail":"happy", id:5, "time":"2015/10/10 17:00:00" },
		{"title":"Title A", "detail":"happy", id:6, "time":"2015/10/10 17:00:00" },
		{"title":"Title Z", "detail":"happy", id:7, "time":"2015/10/10 17:00:00" },
    ];

    $scope.selected_item = function(val) {
        EventService.selectedEvent = val;
    };
    
    $scope.init = function(){
        $ionicPlatform.ready(function() {
                getEventService.getEvent()
                .then(function(response){
                    $scope.events = JSON.parse(response.d).tns;
                });
        });
    };

    $scope.doRefresh = function() {
        
        /**** Get a promise from service ****/
        var promise = getEventService.getEvent();
        promise
        .then(function(response){
            $scope.events = JSON.parse(response.d).tns;
        })
        .finally(function(){
            $scope.$broadcast('scroll.refreshComplete');
        });
    };
    
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
                DeleteService.deleteEvent(event);
                Util.getToken().then(function(token){
                    var myData = {
                        "accessToken" : token,
                        "from" : "",
                        "to" : ""
                    }
                    var data = JSON.stringify(myData);

                    $http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/getEvent",data)
                    .success(function(response){ $scope.events = JSON.parse(response.d).tns; })
                    .error(function(errorMsg){ alert("error:" + JSON.stringify(errorMsg)); })
                    .finally(function(){
                        $scope.$broadcast('scroll.refreshComplete');
                    });

                });
            }
          }
        ]
        });
    };
    
    
})

.controller("DetailCtrl",function($rootScope, $scope, $http, EventService, UpdateService, $cordovaDatePicker){
    $scope.event = EventService.selectedEvent;
	
    var eventDate = new Date(event.time);
    var dateString = "";
    var timeString = "";
    
    $scope.timeLabel = {
        date: eventDate.getFullYear() + "/" + (eventDate.getMonth()+1) + "/" + eventDate.getDate(),
        time: eventDate.getHours() + ":" + eventDate.getMinutes() + ":" + eventDate.getSeconds()
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
            timeString = time.getHours() + ":" +
                        time.getMinutes() + ":" +
                        time.getSeconds();
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
