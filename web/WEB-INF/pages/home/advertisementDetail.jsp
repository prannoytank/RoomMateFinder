<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />
<div id="content-wrapper" class="container-fluid">

    <div class="row"> 

        <h2>${adModel.adTitle}</h2>    
        <h3>${adModel.adPostDate}</h3>
        
        
        
        <c:if test="${not empty imagePath}">
              
            <c:forEach items="${imagePath}" var="imgPath">
                ${imagePath} <br />
                <img src="${imgPath}" alt="AdImage" />
            </c:forEach>  
        </c:if> 
        
        <div>

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Location Details</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">House Details</a></li>
                <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Extra Details</a></li>
                <li role="presentation"><a href="#contact" aria-controls="contact" role="tab" data-toggle="tab">Contact</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    Street Address: ${adModel.streetAddress}  <br />
                    Country: ${adModel.country}  <br />
                    Province: ${adModel.province}  <br />
                    City: ${adModel.city}  <br />
                    Postal Code: ${adModel.postalCode}  <br />

                </div>
                <div role="tabpanel" class="tab-pane" id="profile">
                    Building Type: ${adModel.buildingType}  <br />
                    Room Type: ${adModel.roomType}  <br />
                    No of Rooms: ${adModel.noOfRooms}  <br />
                </div>
                <div role="tabpanel" class="tab-pane" id="messages">
                    Gender: ${adModel.gender}  <br />
                    Pet Friendly: ${adModel.pet}  <br />
                    Diet: ${adModel.diet}  <br />
                    Smoker: ${adModel.smoke}  <br />
                    Alcohol: ${adModel.alcohol}  <br />

                </div>
                    <div role="tabpanel" class="tab-pane" id="contact">
                    Name: ${userBean.name}  <br />
                    Email Address: ${userBean.email}  <br />
                    Contact: ${userBean.contact}  <br />
                    
                </div>
               
            </div>

        </div>

    </div>                

</div>

<jsp:include page="includes/footer.jsp" />
