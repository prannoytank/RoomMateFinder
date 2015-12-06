<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- 
    Document   : settings
    Created on : 5-Dec-2015, 4:46:15 PM
    Author     : DianaA
--%>

<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />

<div id="content-wrapper" class="container-fluid">
    <form:form method="POST" commandName="userModel">
        <fieldset>
            <legend>SETTINGS</legend>
                <legend>Name : ${userModel.getName()}</legend>
                 <legend>Email : ${userModel.getEmail()}</legend>
            
            <div class="row">  
                <div class="col-md-4" >	
                    <label for="country">Country:</label>
                    <form:input path="country" class="form-control" type="text" value = "${userModel.getCountry()}" id="country"/>
                    <form:errors path="country" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                <div class="col-md-4" >	
                    <label for="streetAddress">Street Address:</label>
                    <form:input path="streetAddress" class="form-control" type="text" value = "${userModel.getStreetAddress()}" id="streetAddress"/>
                    <form:errors path="streetAddress" class="form-control" cssStyle="color: #ff0000;"/>
                </div>
            </div>
            <br/>
            <div class="row">  
                <div class="col-md-4" >	
                    <label for="province">Province:</label>
                    <form:input path="province" class="form-control" type="text" value = "${userModel.getProvince()}" id="province"/>
                    <form:errors path="province" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                <div class="col-md-4" >	
                    <label for="city">City:</label>
                    <form:input path="city" class="form-control" type="text" value = "${userModel.getCity()}" id="city"/>
                    <form:errors path="city" class="form-control" cssStyle="color: #ff0000;"/>
                </div>
            </div>
            <br/>
            <div class="row">  
                <div class="col-md-4" >	
                    <label for="postalCode">Postal Code:</label>
                    <form:input path="postalCode" class="form-control" type="text" value = "${userModel.getPostalCode()}" id="postalCode"/>
                    <form:errors path="postalCode" class="form-control" cssStyle="color: #ff0000;"/>
                </div>
                
                  <div class="col-md-4" >	
                    <label for="contact">Contact Number:</label>
                    <form:input path="contact" class="form-control" type="text" value = "${userModel.getContact()}" id="contact"/>
                    <form:errors path="contact" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                </div>
               
        </fieldset>
        <br/>
        <div class="row">
            <input type="submit" name="submit" class="btn btn-success" value="UPDATE">
        </div>
    </form:form>
</div>                                       
<jsp:include page="includes/footer.jsp" />
