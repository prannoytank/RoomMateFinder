<%@ page session="true"%>
<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="content-wrapper">

    <h1>Welcome to RoomMate Finder </h1> 
    <div class ="row">
        <form cssClass="form-inline" action="/RoomMateFinder/searchindex" method="POST">

            <label for="city">City:</label>
            <select name="cities">
                <option value="Toronto" lable="Toronto">Toronto</option>
                <option value="Montreal" lable="Montreal">Montreal</option>
                <option value="London" lable="London">London</option>
                <option value="Vancouver" lable="Vancouver">Vancouver</option>
                <option value="Calgary" lable="Calgary">Calgary</option>
                <option value="Winnipeg" lable="Winnipeg">Winnipeg</option>
            </select>
            <input class ="btn btn-warning btn-lg" type="submit" value="Search" /><br>

        </form>

    </div>

    <div class = "row">
        <br><a class ="btn btn-warning btn-lg" href ="search" role ="button">ADVANCED SEARCH</a><br>
    </div>
</div>


<p><a class="btn btn-success btn-lg" href="advertisment" role="button">Add New Advertisment</a></p>



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

