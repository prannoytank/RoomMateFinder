<%-- 
    Document   : registration
    Created on : 4-Dec-2015, 4:57:24 PM
    Author     : Crusty
--%>
    
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

        <jsp:include page="../index/includes/head.jsp" />
        <jsp:include page="../index/includes/header.jsp" />
            
        <title>Registration</title>
    <body>
        <H1>
            <div class="text-center">
           	<div class="logo">Registration</div>
                </div>
        </H1>
        <form:form commandName="user" action="register" method="POST" enctype="utf8" cssClass="form-horizontal">
            
            <div class="form-group">
                <label class="col-md-4 control-label">Name</label>
                    
                <div class="col-md-6">
                    <form:input path="name" value="" cssClass="form-control"/>
                    <form:errors path="name" element="div" cssClass="alert alert-danger"/>
                </div>
            </div>
                
                
            <div class="form-group">
            
                <label class="col-md-4 control-label">Email</label>
                    
                <div class="col-md-6">
                    <form:input path="email" value="" cssClass="form-control"/>
                    <c:if test="${message != null}">
                        <div class="alert alert-danger">${message}</div>
                    </c:if>
                    <form:errors path="email" element="div" cssClass="alert alert-danger"/>
                </div>
            </div>
                
                
            <div class="form-group">
                <label class="col-md-4 control-label">Password</label>
                    
                <div class="col-md-6">
                    <form:password path="password" value="" cssClass="form-control"/>
                    <form:errors path="password" element="div" cssClass="alert alert-danger"/>
                </div>
            </div>
                
                
            <div class="form-group">
                <label class="col-md-4 control-label">Confirm Password</label>
                    
                <div class="col-md-6">
                    <form:password path="passconf" value="" cssClass="form-control"/>
                    <form:errors path="passconf" element="div" cssClass="alert alert-danger"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6 col-md-offset-4">
                        <button type="submit" class="btn btn-block btn-primary btn-large">
                                Register
                        </button>
                        
            </div>
                
        </form:form>
                <br /> <br /> <br/>
        <a href="<c:url value="login.html" />">
            Login?
        </a>
    </body>
   
        <jsp:include page="../index/includes/footer.jsp" />
