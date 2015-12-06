<%@ page session="true"%>
<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />

<div id="content-wrapper">
    <h1>Welcome to home Page, ${user.name} </h1>   
    <p><a class="btn btn-success btn-lg btn-block" href="advertisment" role="button">Add New Advertisment</a></p>
    


</div>
<jsp:include page="includes/footer.jsp" />

