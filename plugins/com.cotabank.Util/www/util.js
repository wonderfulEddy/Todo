var exec = require('cordova/exec');

function Util() {
};          

Util.prototype.check = function(){
	return getPromisedCordovaExec(arguments, "AppVersionChecker", "checkUpdate");
};

Util.prototype.getToken = function() {
    return getPromisedCordovaExec(arguments, "AccessToken", "getAccessToken");
};

var getPromisedCordovaExec = function (orgArgs, service, action) {
	var args = [];
	var success, fail;
	for (var i=0; i < orgArgs.length; i++) {
		if(typeof orgArgs[i] === "function"){
			if(typeof success === "undefined")
				success = orgArgs[i];
			else
				fail = orgArgs[i];
		}else{
			args.push(orgArgs[i]);
		}
    }
	
	var toReturn, deferred, injector, $q;
	if (success === undefined) {
		if (window.jQuery) {
			deferred = jQuery.Deferred();
			toReturn = deferred;
		} else if (window.angular) {
			injector = angular.injector(["ng"]);
			$q = injector.get("$q");
			deferred = $q.defer();
			toReturn = deferred.promise;
		} else {
			return console.error(service + ' either needs a success callback, or jQuery/AngularJS defined for using promises');
		}
		success = deferred.resolve;
		fail = deferred.reject;
	}
	cordova.exec(success, fail, service, action, args);
	return toReturn;
};

var Util = new Util();
module.exports = Util;