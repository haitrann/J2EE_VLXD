<%@page import="vlxd.dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%
	UserDTO loginedUser = (UserDTO) session.getAttribute("loginedUser");
%>

<c:set var = "loginedInfo" scope = "session" value = "<%=loginedUser%>"/>
<c:choose>
   <c:when test = "${loginedInfo == null}">
		<c:redirect url = "./GoPageLoginServlet"/>
   </c:when>
   
   <c:otherwise>
		<c:redirect url = "./Home"/>
   </c:otherwise>
</c:choose>