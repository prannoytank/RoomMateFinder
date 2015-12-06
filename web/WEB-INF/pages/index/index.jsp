<%-- 
    Document   : index
    Created on : 4-Dec-2015, 11:14:27 PM
    Author     : Crusty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />
<div id="content-wrapper">

    <h1>Welcome to index Page </h1>   
<div id="content-wrapper">
    <div class ="row">
        <form class="form-inline">
            <div class="form-group">
                <br><br> <input type="text" class="form-control" id="search" placeholder="Locality">
                <button class ="btn btn-warning btn-sm" for="search">SEARCH</button>
            </div>
        </form>
    </div>
    <div class=" row"></div>

    <div class = "row">
        <br><button class ="btn btn-warning btn-lg" for ="advancedSearch">ADVANCED SEARCH</button><br>
        <br>
    </div>
</div>

</div>
<jsp:include page="includes/footer.jsp" />
