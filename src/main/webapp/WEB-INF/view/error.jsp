<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>에러 페이지</h2>
	<c:if test="${errors.hasFieldErrors('userid')}">
		<c:out value="${errors.getFieldError('userid').defaultMessage}"></c:out><br>
	</c:if>
	
	<c:if test="${errors.hasFieldErrors('code')}">
		<c:out value="${errors.getFieldError('code').defaultMessage}"></c:out><br>
	</c:if>	
</body>
</html>