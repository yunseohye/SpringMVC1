<%@page import="com.exe.springmvc.PersonDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

	//get방식으로 3개의 데이터를 넘긴다.
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	//PersonDTO의 데이터
	PersonDTO dto = (PersonDTO)request.getAttribute("dto");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Param Result</h2>
이름: <%=name %><br/>
전화: <%=phone %><br/>
이메일: <%=email %><br/>


<h2>Model And View</h2>
<%if(dto!=null) {%>
이름: <%=dto.getName() %><br/>
전화: <%=dto.getPhone() %><br/>
이메일: <%=dto.getEmail() %><br/>
<%} else { %>
데이터 없음<br/>
<%} %>





</body>
</html>