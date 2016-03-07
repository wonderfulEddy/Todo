angular.module('starter.services', [])

/* Get all the events */
.service('getEventService', ['$http','$window','$q', function($http, $window, $q){
    this.getEvent = function() {
        var deferred = $q.defer();
        var promised = deferred.promise;
        Util.getToken().then(function(token){
			var myData = {
				"accessToken" : token,
				"from" : "",
				"to" : ""
			}
			var data = JSON.stringify(myData);

			$http.post("https://mobile.cotabank.com.tw/service/TodoWebService.asmx/getEvent",data).
			success(function(response){
            console.log("service success");
            deferred.resolve(response);}).
			error(function(errorMsg){deferred.reject("error:" + errorMsg);});

        });

        return promised;
    };
    
}])

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