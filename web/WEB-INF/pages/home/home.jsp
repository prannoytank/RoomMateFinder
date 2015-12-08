<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />
<div id="content-wrapper">
    <p><a class="btn btn-success btn-lg btn-block" href="advertisment" role="button">Add New Advertisment</a></p>
    <h1>Welcome to home Page </h1>   


    <c:if test="${not empty advertisementList}">

        <h3>Listing By You !!!</h3>  
        <table class="table">
            <tr><th>Title</th><th>Street Address</th><th>Date</th><th></th></tr>
                    <c:forEach items="${advertisementList}" var="adList">
                <tr>
                    <td><c:out value="${adList.adTitle}" /></td>
                    <td><c:out value="${adList.streetAddress}" /></td>
                    <td><c:out value="${adList.adPostDate}" /></td>
                    <td><a class="btn btn-info" href="/RoomMateFinder/advertisment/view/${adList.adId}" title="View Details">View Details</a></td>    
                </tr>
            </c:forEach>

        </table>   
    </c:if> 

</div>
<jsp:include page="includes/footer.jsp" />

