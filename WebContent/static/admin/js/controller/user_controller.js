'use strict'

angular.moduel('myApp').controller('UserController',['$scop','UserService',function($scop,Userservice){
	var selt = this;
	selt.users = [];
	
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