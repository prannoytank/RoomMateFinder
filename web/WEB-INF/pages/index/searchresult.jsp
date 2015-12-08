<%-- 
    Document   : searchresult
    Created on : 6-Dec-2015, 7:19:52 PM
    Author     : Crusty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   
<div class="bs-example">
    <c:if test="${searchdata!=null}">
            <table class="table">
           <tr><th>Title</th><th>Street Address</th><th>Date</th><th></th></tr>
          <tbody>
        <c:forEach var="list" items="${searchdata}">
        	<tr class="active">
                <td><c:out value="${list.adTitle}" /></td>
                 <td><c:out value="${list.streetAddress}" /></td>
                <td><c:out value="${list.adPostDate}" /></td>
        <td><a class="btn btn-info" href="/RoomMateFinder/advertisment/view/${adList.adId}" title="View Details">View Details</a></td>    
                </tr>
        </c:forEach>
        </tbody>
    </table>
            
    </c:if>
    
</div>
<jsp:include page="includes/footer.jsp" />
