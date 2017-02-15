'use strict'
angular.module('myApp').factory('UserService',['$http','$q', function($http,$q){
	var REST_SERVICE_URI = 'http://localhost:8080/ProductSale/admin/';
	
	   var factory = {
	        fetchAllUser: fetchAllUser
	    };
	
	    return factory;
	    
	    function fetchAllUser() {
	        var deferred = $q.defer();
	        $http.get(REST_SERVICE_URI+'userlist/')
	            .then(
	            function (response) {
	                deferred.resolve(response.data.list);
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
   
}])