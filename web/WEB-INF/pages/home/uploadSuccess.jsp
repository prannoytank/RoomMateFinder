<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Crunchify - Upload Multiple Files Example</title>
<style type="text/css">
body {
    background-image:
        url('http://cdn3.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
</head>
<body>
    <br>
    <br>
    <div align="center">
 
        <h1>Crunchify - Spring MVC Upload Multiple Files Example</h1>
        <p>Awesome.. Following files are uploaded successfully.</p>
        <ol>
            <c:forEach items="${files}" var="file">
           - ${file} <br>
            </c:forEach>
        </ol>
        <a href="http://localhost:8080/CrunchifySpringMVC3.2.1/upload.html"><input
            type="button" value="Go Back" /></a> <br />
        <br />
        <br />
        <div
            style="font-family: verdana; line-height: 25px; padding: 5px 10px; border-radius: 10px; border: 1px dotted #A4A4A4; width: 50%; font-size: 12px;">
 
            Spring MVC Upload Multiple Files Example by <a
                href='http://crunchify.com'>Crunchify</a>. Click <a
                href='http://crunchify.com/category/java-web-development-tutorial/'>here</a>
            for all Java, Spring MVC, Web Development examples.<br>
        </div>
    </div>
</body>
</html>
