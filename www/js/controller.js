
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

    $ionicPlatform.ready(function() {
    
        /*var promise = getEventService.getEvent();
        
        promise
        .then(function(response){
            $scope.events = JSON.parse(response.d).tns;
            console.log(JSON.parse(response.d).tns);
        });*/
        
        Util.getToken().then(function(token){
			var myData = {
				"accessToken" : token,
				"from" : "",
				"to" : ""
			}
			var data = JSON.stringify(myData);

			$http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/getEvent",data)
			.success(function(response){ $scope.events = JSON.parse(response.d).tns; })
			.error(function(errorMsg){ alert("error:" + errorMsg); })
            .finally(function(){
                $scope.$broadcast('scroll.refreshComplete');
            });

        });
        
    });
    
    $scope.doRefresh = function() {
        
        /**** Get a promise from service ****/
        /*var promise = getEventService.getEvent();
        promise
        .then(function(response){
            $scope.events = JSON.parse(response.d).tns;
        })
        .finally(function(){
            $scope.$broadcast('scroll.refreshComplete');
        });*/
        
        Util.getToken().then(function(token){
			var myData = {
				"accessToken" : token,
				"from" : "",
				"to" : ""
			}
			var data = JSON.stringify(myData);

			$http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/getEvent",data)
			.success(function(response){ $scope.events = JSON.parse(response.d).tns; })
			.error(function(errorMsg){ alert("error:" + errorMsg); })
            .finally(function(){
                $scope.$broadcast('scroll.refreshComplete');
            });

        });

        
    };
    
    $scope.onHoldEvent = function(event) {
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
			.error(function(errorMsg){ alert("error:" + errorMsg); })
            .finally(function(){
                $scope.$broadcast('scroll.refreshComplete');
            });

        });
    }
    
  $scope.showPopup = function(event) {

  // An elaborate, custom popup
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

.controller("DetailCtrl", ['$rootScope', '$scope', '$http', 'EventService', 'UpdateService' ,'UpdateServiceFake',function($rootScope, $scope, $http, EventService, UpdateService, UpdateServiceFake){
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

.controller("AddCtrl", function($scope, $http, InsertService){
	$scope.newEvent = {
		title : "",
		detail : "",
		time : "2015/03/17 12:00:00"
	}
	
	$scope.submit = function(newEvent) {
		InsertService.insertEvent(newEvent);
        
	}
    
    
});

function getEventPromise() {
    var deferred = $.Deferred();
        Util.getToken().then(function(token){
			var myData = {
				"accessToken" : token,
				"from" : "",
				"to" : ""
			}
			var data = JSON.stringify(myData);

			/*$http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/getEvent",data).
			success(function(response){deferred.resolve(response);}).
			error(function(errorMsg){deferred.reject("error:" + errorMsg);});*/
            
            $.ajax({
                type:"POST",
                url: "https://mobile.cotabank.com.tw/service/TodoWebService.asmx/getEvent",
                data: data,
                dataType: "json",
                success: function(response){deferred.resolve(response);},
                error: function(errorMsg){deferred.reject("error:" + errorMsg);}
            });

        });

        var promise = deferred.promise();
        return promise;
}
