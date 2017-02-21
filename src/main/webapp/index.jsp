<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yef.dominochallenge.Constants" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Domino Challenge Home page"/>
</jsp:include>

<h2>Domino Challenge</h2>

<a>Welcome to Domino Chellenge page! Here you can <a href='<c:out value="${Constants.BONEYARD_PAGE}"/>'/>create</a> tileset
and then <a href='<c:out value="${Constants.CHAINMAKER_PAGE}"/>'/>make</a> from it the longest chain
or even all possible chains.</p>

<jsp:include page="footer.jsp" />
