'use strict'

angular.module('myApp').controller('UserController',['$scope','UserService',function($scope,Userservice){
	 var self = this;
	 self.user={U_ID:null,Name:'',Address:'',Email:''};
	 self.users = [];
	
	fetchAllUser();
	
	function fetchAllUser(){
		Userservice.fetchAllUser()
		.then(
			function(d){
				self.users=d;
			},
			function(errResponse){
				 console.error('Error while fetching Users');
			}
		);
		
	}
}]);