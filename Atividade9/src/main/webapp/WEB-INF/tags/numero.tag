<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="value" required="true" %>

<h3>
	<span class="label label-default">
		<fmt:formatNumber type="number" minIntegerDigits="2" value="${value}" />
	</span>
</h3>
