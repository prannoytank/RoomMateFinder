<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />

<div id="content-wrapper">
    <form:form method="POST" action="advertisment/create" commandName="adModel">
        <table>
            <tr>

                <td>
                    <div class="form-group">	
                        <label for="streetAddress">Street address</label>
                        <form:input path="streetAddress" class="form-control" type="text" id="streetAddress"/>
                        <form:errors path="streetAddress" class="form-control" cssStyle="color: #ff0000;"/>
                    </div>	
                </td>
            </tr>

            <tr><td>   
                    <div class="form-group"> 
                        <label for="buildingType">Building Type</label>
                        <form:input path="AdvertismentPreference.buildingType" class="form-control" type="text" id="buildingType"/>
                        <form:errors path="AdvertismentPreference.buildingType" class="form-control" cssStyle="color: #ff0000;"/>
                    </div>
                </td></tr>


            <tr> <td><input type="submit" name="submit" class="btn btn-default" value="Submit"></td></tr>

        </table>
    </form:form>
</div>                                       
<jsp:include page="includes/footer.jsp" />
