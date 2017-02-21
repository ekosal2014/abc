<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath }/static/admin/css/content.css" type="text/css" rel="stylesheet">

</head>
<body ng-app="myApp">
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="#">Logo</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Home</a></li>
	        <li><a href="#">About</a></li>
	        <li><a href="#">Projects</a></li>
	        <li><a href="#">Contact</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	         <li><a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                 <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image"></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>                
                    
                  </ul>
             
             </li>
	      <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt="">John Doe
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container-fluid text-center" ng-controller="CategoryController as ctrl">    
		  <div class="row content">
		    <div class="col-sm-2 sidenav">
		      <p><a href="#">Dashboard</a></p>
		      <p><a href="./user">User Infor</a></p>
		      <p><a href="./categetoryinfo">Category Infor</a></p>
		      <p><a href="./productinfo">Category Infor</a></p>
		    </div>
		    <div class="col-sm-10 text-left" id="container"> 
		      <div class="content-header blue">lkdaa</div>
				<div class="content-tool">
					<a href="javascript:" ng-click="ctrl.popUpAddCategory()" class="btn btn-blue btn-big">Add New</a>
				</div>
		     <table class="table" id="tbl-result">
	                      <thead>
	                        <tr>
	                          <th>#</th>
	                          <th>Menu Name</th>
	                          <th>Action</th>
	                        </tr>
	                      </thead>
	                      <tbody>
			                   		<tr ng-repeat="u in ctrl.Categorys">
			                          <td scope="row" style="width:10%">{{u.MENU_ID}}</td>
			                          <td style="width:70%">{{u.MENU_NM}}<input type="hidden" value="asdfasd" class="txt-name"></td>
			                          <td><a href="javascript:" ng-click="ctrl.popUpEditCategroy(1)" class="btn btn-small btn-yellow btn-edit" data-id="44">Edit</a> | <a href="javascript:" class="btn btn-small btn-red btn-delete" data-id="44">Delete</a></td>
			                        </tr>
			                   				                                    
	                      </tbody>
	                    </table>
	                    
	                    <!-- The Modal -->
						<div id="myModal" class="modal">						
						  <!-- Modal content -->
						  <div class="modal-content" style="width:800px;">
						    <div class="modal-header">
						      <span class="close">&times;</span>
						      <h3>Modal Header</h3>
						    </div>
						    <div class="modal-body">    		
						      	  <nav>
								    <select style="position: relative;">
								            <option value="0">Main Category</option>
								    		<option ng-repeat="u in ctrl.Categorys" value="{u.MENU_ID}}">{{u.MENU_NM}}</option>
								    </select>
								</nav>    
							
						    </div>
						      <div class="modal-body">    		
						      	
								<nav>								 
								    <input type="text"/>
								</nav>    
								
						    </div>
						   <div class="modal-body">    		  
								<nav>								 
								    <input type="button" value="Save"/>
								</nav>    
						    </div>
						    <div class="modal-footer">
						      <h3>Modal Footer</h3>
						    </div>
						  </div>
		    </div>
		   
		  </div>
	</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="${pageContext.request.contextPath }/static/admin/js/App.js"></script>
<script src="${pageContext.request.contextPath }/static/admin/js/service/category_service.js"></script>
<script src="${pageContext.request.contextPath }/static/admin/js/controller/category_controller.js"></script>

</body>
</html>