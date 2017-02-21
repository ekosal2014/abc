'use strict'

angular.module('myApp').controller('CategoryController',['$scope','CategoryService',function($scope,CategoryService){
	 var self = this;
	 self.Categorys = [];
	
	 self.popUpAddCategory = popUpAddCategory;
	 
	fetchAllCategory();
	
	function fetchAllCategory(){
		CategoryService.fetchAllCategory()
		.then(
			function(d){			
				self.Categorys=d;
			},
			function(errResponse){
				 console.error('Error while fetching Users');
			}
		);	
	}
	
	function popUpAddCategory(){
		
		$('#myModal').css('display','block');
			
	}
	
	self.popUpEditCategroy = function(id){
		CategoryService.fetchEditCategory(id)
		.then(
			 function (d){
				 self.users=d;
				 console.log(d);
			 },
			 function(errResponse){
				 console.error('Error while fetching Users');
			 }
		);
	}
	
}]);

