<%@ page contentType="text/html" language="java" isELIgnored="false"%>
<%--<%@ page  %>--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="language" value="en" scope="session"/>
<!DOCTYPE 'html'>
<html lang="en">
<body>
<title>Home</title>
<%--<c:out value="${pageContext.request.contextPath}"/>--%>
<jsp:forward page="/login.jsp"/>
<%--adsddsdsd--%>
</body>
</html>