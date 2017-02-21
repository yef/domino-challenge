<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bean" scope="session" class="com.yef.dominochallenge.bean.BoneyardBean"/>
<jsp:setProperty name="bean" property="*"/>
<c:if test="${pageContext.request.method=='POST' and bean.done}">
    <c:if test="${not empty bean.redirectUrl}">
        <c:redirect url="${bean.redirectUrl}" />
    </c:if>
</c:if>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Create Tileset. Here you can create set of dominoes"/>
</jsp:include>

<h2>Step 1. Create Tileset</h2>

<c:if test="${not empty bean.errorMessage}">
    <table cellpadding="12" cellspacing="0" bgcolor="#F00000" width="100%">
        <tr>
            <td><c:out value="${bean.errorMessage}"/></td>
        </tr>
    </table>
</c:if>
<c:if test="${not empty bean.message}">
    <table cellpadding="12" cellspacing="0" bgcolor="#00F000" width="100%">
        <tr>
            <td><c:out value="${bean.message}"/></td>
        </tr>
    </table>
</c:if>

<p>Here is your Boneyard:</p>
<table cellpadding="2" cellspacing="0">
    <tr>
        <c:forEach var="tile" items="${bean.boneyard}">
            <td>
                <table cellpadding="10" cellspacing="2" bgcolor="#CCCCCC">
                    <tr>
                        <td bgcolor="#EEEEEE">
                            <c:out value="${tile.endTwo}"/>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#EEEEEE">
                            <c:out value="${tile.endOne}"/>
                        </td>
                    </tr>
                </table>
            </td>
        </c:forEach>
    </tr>
</table>

<p>Here is your Tileset:</p>

<table cellpadding="2" cellspacing="0">
    <tr>
        <c:forEach var="tile" items="${bean.tileSet}">
            <td>
                <table cellpadding="10" cellspacing="2" bgcolor="#CCCCCC">
                    <tr>
                        <td bgcolor="#EEEEEE">
                            <c:out value="${tile.endTwo}"/>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#EEEEEE">
                            <c:out value="${tile.endOne}"/>
                        </td>
                    </tr>
                </table>
            </td>
        </c:forEach>
    </tr>
</table>

<p>&nbsp;</p>

<form action="boneyard.jsp" method="post">
    <label for="tileNumber">Number of dominoes in set:</label>
    <input id="tileNumber" name="numberOfTiles" type="number" max="28" min="0" value="${bean.numberOfTiles}"/>
    <br/><br/>
    <button name="action" value="create-set" title="Create set">Create set</button> |
    <button name="action" value="save" title="Save and Create Chain">Save and Create Chain</button>
</form>

<jsp:include page="footer.jsp" />

</body>
</html>
