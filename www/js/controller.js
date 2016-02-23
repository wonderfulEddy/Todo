angular.module('starter.controllers', [])

.controller("EventCtrl", ['$scope', '$http','EventService', function($scope, $http, EventService){
    $scope.events = [];
    $scope.test ="123123";
    $scope.eventsTemp = [
        {"title":"Title A", "content":"happy", id:1 },
        {"title":"Title B", "content":"sad", id:2}
    ];

    $scope.GetEventFake = funtion() {
      $http.post("http://192.168.25.180/PushWb/ServiceTest.asmx").
      success(function(response){console.log(response);}).
      error(function(errorMsg){});
    };

    $scope.GetEvent = function() {
        var deferred = $.Deferred();
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
        promise.then(function(response){
            console.log(JSON.parse(response.d).tns);
            $scope.events = JSON.parse(response.d).tns;

            // Get the selected event information
            $scope.setEvent = function(testVal) {
                console.log(testVal);
                //EventService.selectedEvent = testVal;
            };
        })

    };

    $scope.selected_item = function(val) {
        EventService.selectedEvent = val;
    };

}])

.controller("DetailCtrl", ['$scope', '$http','EventService', function($scope, $http, EventService){
    $scope.event = EventService.selectedEvent;
}])

.controller("MainCtrl", ['$scope', '$http', function($scope, $http){

}]);
