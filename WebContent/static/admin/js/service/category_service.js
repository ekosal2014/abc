'use strict'
angular.module('myApp').factory('CategoryService',['$http','$q', function($http,$q){
	var REST_SERVICE_URI = 'http://localhost:8080/ProductSale/admin/';
	
	   var factory = {
	        fetchAllCategory: fetchAllCategory,
	        popUpAddCategory: popUpAddCategory,
	        fetchEditCategory:fetchEditCategory
	    };
	
	    return factory;
	    
	    function fetchAllCategory() {
	        var deferred = $q.defer();
	        $http.get(REST_SERVICE_URI+'categorylist/')
	            .then(
	            function (response) {
	            	$.each(response.data.list,function(k,v){
						if (v['MENU_PARENT']  == '0'){					     
							$.each(response.data.list,function(k1,v1){
								if (v['MENU_ID'] == v1['MENU_PARENT'] && v1['MENU_PARENT']  != '0'){
									v1['MENU_NM'] =  ' __ ' + v1['MENU_NM'] ;
									$.each(response.data.list,function(k2,v2){								
										if (v1['MENU_ID'] == v2['MENU_PARENT'] && v2['MENU_PARENT']  != '0'){
											v2['MENU_NM'] =  ' __ __ ' + v2['MENU_NM'] ;										
											return v2;
										}
									});
									return v1;
								}	
							});
						  return v;
						}
					});
	                deferred.resolve(response.data.list);
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
	    
	    function popUpAddCategory(){
	    	var deferred = $q.defer();
	    	$http.get(REST_SERVICE_URI+'categorylist/')
	    	     .then(
	    	    		 function (response){
	    	    			 deferred.resolve(respone.data.list);
	    	    		 },
	    	    		 function (errResponse){
	    	    			 deferred.reject(errResponse);
	    	    		 }	    	    		 
	    	     );
	    	return deferred.promise;
	    }
	    
	    function fetchEditCategory(id){
	    	var deferred = $q.defer();
	    	$http.get(REST_SERVICE_URI+'categoryeditlist/')
	    	     .then(
	    	    		 function (response){
	    	    			 deferred.resolve(response.data.list);
	    	    		 },
	    	    		 function (errResponse){
	    	    			 deferred.reject(errResponse);
	    	    		 }	    	    		 
	    	     );
	    	return deferred.promise;
	    }
   
}])