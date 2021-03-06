
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<jsp:include page="includes/head.jsp" />
<jsp:include page="includes/header.jsp" />

<div id="content-wrapper" class="container-fluid">
    <form:form method="POST" commandName="adModel">
        <fieldset>
            <legend>Location Details</legend>
            <div class="row">  
                
                <div class="col-md-12">
                   <label for="adTitle">Title</label>
                    <form:input path="adTitle" class="form-control" type="text" id="adTitle"/>
                    <form:errors path="adTitle" class="form-control" cssStyle="color: #ff0000;"/>  
                    
                </div>
                
                <div class="col-md-4" >	
                    <label for="country">Country</label>
                    <form:input path="country" class="form-control" type="text" id="country"/>
                    <form:errors path="country" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                <div class="col-md-4" >	
                    <label for="province">Province</label>
                    <form:input path="province" class="form-control" type="text" id="province"/>
                    <form:errors path="province" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                  <div class="col-md-4" >	
                    <label for="city">City:</label>
                    <form:select path="city">
                        <form:options items="${cities}"  />
                    </form:select>
                    <form:errors path="city" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

                <div class="col-md-6" >	
                    <label for="streetAddress">Street address</label>
                    <form:input path="streetAddress" class="form-control" type="text" id="streetAddress"/>
                    <form:errors path="streetAddress" class="form-control" cssStyle="color: #ff0000;"/>
                </div>


                <div class="col-md-6"> 
                    <label for="postalCode">Postal Code</label>
                    <form:input path="postalCode" class="form-control" type="text" id="postalCode"/>
                    <form:errors path="postalCode" class="form-control" cssStyle="color: #ff0000;"/>
                </div>
            </div>   
        </fieldset>         

        <fieldset>
            <legend>House Details</legend>   
            <div class="row">
                 <div class="col-md-6" >	
                    <label for="buildingType">Building Type:</label>
                    <form:select path="buildingType">
                        <form:options items="${buildingType}"  />
                    </form:select>
                    <form:errors path="buildingType" class="form-control" cssStyle="color: #ff0000;"/>
                </div>   

                <div class="col-md-6"> 
                    <label for="roomType">Room Type</label>
                    <form:input path="roomType" class="form-control" type="text" id="roomType"/>
                    <form:errors path="roomType" class="form-control" cssStyle="color: #ff0000;"/>
                </div>

               <div class="col-md-6" >	
                    <label for="noOfRooms">Number of Rooms:</label>
                    <form:select path="noOfRooms">
                        <form:options items="${noOfRooms}"  />
                    </form:select>
                    <form:errors path="noOfRooms" class="form-control" cssStyle="color: #ff0000;"/>
                </div>
                
                
                  <div class="col-md-6">
                     <label for="rent">Rent</label>   
                    <form:input path="rent" class="form-control" type="text" id="rent"/>
                    <form:errors path="rent" class="form-control" cssStyle="color: #ff0000;"/>  
                    </div>    

            </div>   
        </fieldset>

        <fieldset>
            <legend>Extra Details</legend>   
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
                      <form:radiobutton path="gender" value="O"/>Others
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
                     <form:radiobutton path="diet" value="Veg"/>Veg 
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="diet" value="Non-Veg"/>Non-Veg
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="diet" value="Vegan"/>Vegan
                    </label>
                    
                </div> 
                    
                    
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

                    <div class="col-md-4">
                    <label for="furnished">Furnished</label>   
                    <label class="checkbox-inline">
                     <form:radiobutton path="furnished" value="Y"/>Yes 
                    </label>
                    <label class="checkbox-inline">
                        <form:radiobutton path="furnished" value="N"/>No
                    </label>
                    
                </div>
                  
                    
                    
                 <div class="col-md-12">
                  <label for="description">Note</label> 
                  <form:textarea path="description" rows="5" cols="30" />
                 </div>   
            </div>
        </fieldset>

        <div class="row">
        <input type="submit" name="submit" class="btn btn-success" value="Submit">
        </div>

    </form:form>
</div>                                       
<jsp:include page="includes/footer.jsp" />