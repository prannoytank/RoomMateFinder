<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- 
    Document   : advancedSearch
    Created on : 4-Dec-2015, 7:46:15 PM
    Author     : DianaA
--%>

<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />

<div id="content-wrapper" class="container-fluid">
    <form:form method="POST" commandName="adModel1">
        <fieldset>
            <legend>Advanced Search</legend>
            <div class="row">  
                <div class="col-md-4" >	
                    <label for="city">City:</label>
                    <form:select path="city">
                        <form:options items="${cities}"  />
                    </form:select>
                    <form:errors path="city" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                <div class="col-md-4" >	
                    <label for="buildingType">Building Type:</label>
                    <form:select path="buildingType">
                        <form:options items="${buildingType}"  />
                    </form:select>
                    <form:errors path="buildingType" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                <div class="col-md-4" >	
                    <label for="noOfRooms">Number of Rooms:</label>
                    <form:select path="noOfRooms">
                        <form:options items="${noOfRooms}"  />
                    </form:select>
                    <form:errors path="noOfRooms" class="form-control" cssStyle="color: #ff0000;"/>
                </div>
            </div> 
            <legend>Preferences</legend>
            <div class="row">
                <div class="col-md-4">
                    <label for="gender">Gender</label>   
                    <label class="checkbox-inline">
                        <form:radiobutton path="gender" value="M"/>Male 
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="gender" value="F"/>Female
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="gender" value="O"/>Other
                    </label>  
                </div> 

                <div class="col-md-4">
                    <label for="pet">Pet Friendly</label>   
                    <label class="checkbox-inline">
                        <form:radiobutton path="pet" value="Y"/>Yes 
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="pet" value="N"/>No
                    </label>

                </div>

                <div class="col-md-4">
                    <label for="diet">Diet</label>   
                    <label class="checkbox-inline">
                        <form:radiobutton path="diet" value="Veg"/>Vegetarian
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="diet" value="Non-Veg"/>Non-Vegetarian
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="diet" value="Vegan"/>Vegan
                    </label>

                </div> 
            </div>
            <br/>
            <div class="row">

                <div class="col-md-4">
                    <label for="smoke">Smoker</label>   
                    <label class="checkbox-inline">
                        <form:radiobutton path="smoke" value="Y"/>Yes 
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="smoke" value="N"/>No
                    </label>

                </div> 

                <div class="col-md-4">
                    <label for="alcohol">Alcohol</label>   
                    <label class="checkbox-inline">
                        <form:radiobutton path="alcohol" value="Y"/>Yes 
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="alcohol" value="N"/>No
                    </label>
                </div>     
            </div>   
        </fieldset>
        <br/>
        <div class="row">
            <input type="submit" name="submit" class="btn btn-success" value="Search">
        </div>
    </form:form>
</div>                                       
<jsp:include page="includes/footer.jsp" />
