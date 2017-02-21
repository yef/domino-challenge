<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:useBean id="bean" scope="page" class="com.yef.dominochallenge.bean.ChainmakerBean"/>
<jsp:setProperty name="bean" property="*"/>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Here you can generate one or more chains from your set of dominoes"/>
</jsp:include>

<h2>Step 2. Create Chain(s)</h2>

<p>Chainmaker page: parameter tilesetId = <c:out value="${bean.tilesetId}"/></p>

<jsp:include page="footer.jsp" />

