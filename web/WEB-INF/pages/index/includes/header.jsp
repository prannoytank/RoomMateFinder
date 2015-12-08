<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div class="container-fluid" id="main-wrapper">    
        <div id="header-wrapper" class="row">
            <div class="col-lg-4" >
                <img src="<c:url value="/resources/img/roommate_finder.png" />" alt="Home" />   
            </div>
            
            
            <div class="col-lg-8">
            <ul class="nav nav-pills nav-justified" id="primary-nav-bar">
                 <li role="presentation"><a href="/RoomMateFinder/">Home</a></li>
                <li role="presentation"><a href="/RoomMateFinder/register">Register</a></li>
                <li role="presentation"><a href="/RoomMateFinder/login">Login</a></li>
               

            </ul>
            </div>
        </div>    

