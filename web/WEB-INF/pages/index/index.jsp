<%-- 
    Document   : index
    Created on : 4-Dec-2015, 11:14:27 PM
    Author     : Crusty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="content-wrapper">

    <h1>Welcome to index Page </h1>   
<div id="content-wrapper">
    <div class ="row">
        <form:form cssClass="form-inline" action="/RoomMateFinder/searchindex" method="POST">
            <div class="col-md-4" >	
                    <label for="city">City:</label>
                    <select name="cities">
                        <option value="Select" label=" - Select a city - "></option>
                        <option value="Toronto" lable="Toronto">Toronto</option>
                        <option value="Montreal" lable="Montreal">Montreal</option>
                        <option value="London" lable="London">London</option>
                        <option value="Vancouver" lable="Vancouver">Vancouver</option>
                        <option value="Calgary" lable="Calgary">Calgary</option>
                        <option value="Winnipeg" lable="Winnipeg">Winnipeg</option>
                    </select>
                    <form:errors path="city" class="form-control" cssStyle="color: #ff0000;"/>
                       <input class ="btn btn-default" type="submit" value="Search" /><br>
            </form:form>
                    
                 
       
    
    </div>
    <div class=" row"></div>

    <div class = "row">
        <br><button class ="btn btn-warning btn-lg" for ="advancedSearch">ADVANCED SEARCH</button><br>
        <br>
    </div>
</div>

</div>
<jsp:include page="includes/footer.jsp" />
