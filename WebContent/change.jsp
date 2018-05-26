<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Change</title>
	</head>
	<body>
		<h3>Select entry type</h3>
		<form action="/Javapr/change.x" method="post">
			<select required name="type">
				<option value=0>-----</option>
 				<option value=1>Position</option>
  				<option value=2>Salary</option>
  				<option value=3>Career</option>
  				<option value=4>Project</option>
  				<option value=5>Person</option>
  				<option value=6>Payment</option>
  				<option value=7>Experience</option>
  				<option value=8>Project_Function</option>
  				<option value=9>Project_Staff</option>
  			</select><br>
			Enter entry ID<br>
			<input type="text" name="id" required><br><br>
			<button type="submit">go</button><br><br>
		</form>
		<% 
		if (request.getAttribute("error") != null && (Integer)request.getAttribute("error") == 0) {
		%>
			<font color="red">you must enter an id number</font>
		<%
		}
		%>
		<%@ page import="tables.Person,tables.Career,tables.Experience,tables.Payment,tables.Position,tables.Project_Function,tables.Project_Stuff,tables.Project,tables.Salary" %>
		<form action="/Javapr/change/temp.x">
			<%
			Integer type = (Integer) request.getAttribute("type");
			if (type != null)
				if (request.getAttribute("result") == null) {
					%>
					<font color="red">no entities with such id found!</font>
					<%
				} else switch(type) {
				case 1:
					Position position = (Position) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=1>
					<input type="hidden" name="id" value=<%= position.getId()%>>
					Name<br>
					<input required type="text" name="name" value=<% out.print("\"" + position.getName() + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 2:
					Salary salary = (Salary) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=2>
					<input type="hidden" name="id" value=<%= salary.getSalary_id()%>>
					Position<br>
					<input required type="text" name="position" value=<% out.print("\"" + salary.getPosition_id() + "\""); %>><br>
					Salary<br>
					<input required type="text" name="salary" value=<% out.print("\"" + salary.getSalary() + "\""); %>><br>
					Start_date<br>
					<input required type="text" name="start_date" value=<% out.print("\"" + salary.getStart_date().getTime().getDate()+'.'+(salary.getStart_date().getTime().getMonth()+1) +'.'+(salary.getStart_date().getTime().getYear()+1900)+ "\""); %>><br>
					Stop_date<br>
					<input required type="text" name="stop_date" value=<% out.print("\"" + salary.getEnd_date().getTime().getDate()+'.'+(salary.getEnd_date().getTime().getMonth()+1) +'.'+(salary.getEnd_date().getTime().getYear()+1900)+ "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 3:
					Career career = (Career) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=3>
					<input type="hidden" name="id" value=<%= career.getCareer_id()%>>
					Person<br>
					<input required type="text" name="person_id" value=<% out.print("\"" + career.getPerson_id() + "\""); %>><br>
					Position<br>
					<input required type="text" name="position" value=<% out.print("\"" + career.getPosition_id() + "\""); %>><br>
					Start_date<br>
					<input required type="text" name="start_date" value=<% out.print("\"" + career.getStart_date().getTime().getDate()+'.'+(career.getStart_date().getTime().getMonth()+1) +'.'+(career.getStart_date().getTime().getYear()+1900) + "\""); %>><br>
					Stop_date<br>
					<input required type="text" name="stop_date" value=<% out.print("\"" + career.getStop_date().getTime().getDate()+'.'+(career.getStop_date().getTime().getMonth()+1) +'.'+(career.getStop_date().getTime().getYear()+1900) + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 4:
					Project project = (Project) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=4>
					<input type="hidden" name="id" value=<%= project.getId()%>>
					Name<br>
					<input required type="text" name="name" value=<% out.print("\"" + project.getName() + "\""); %>><br>
					Start_date<br>
					<input required type="text" name="start_date" value=<% out.print("\"" + project.getStart_date().getTime().getDate()+'.'+(project.getStart_date().getTime().getMonth()+1) +'.'+(project.getStart_date().getTime().getYear()+1900) + "\""); %>><br>
					Stop_date<br>
					<input required type="text" name="stop_date" value=<% out.print("\"" + project.getStop_date().getTime().getDate()+'.'+(project.getStop_date().getTime().getMonth()+1) +'.'+(project.getStop_date().getTime().getYear()+1900) + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 5:
					Person person = (Person) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=5>
					<input type="hidden" name="id" value=<%= person.getId()%>>
					First_name<br>
					<input required type="text" name="first_name" value=<% out.print("\"" + person.getFirst_name() + "\""); %>><br>
					Last_name<br>
					<input required type="text" name="last_name" value=<% out.print("\"" + person.getLast_name() + "\""); %>><br>
					Birth_date<br>
					<input required type="text" name="birth_date" value=<% out.print("\"" + person.getDate_of_birth().getTime().getDate()+'.'+(person.getDate_of_birth().getTime().getMonth()+1) +'.'+(person.getDate_of_birth().getTime().getYear()+1900) + "\""); %>><br>
					Address<br>
					<input required type="text" name="address" value=<% out.print("\"" + person.getAddress() + "\""); %>><br>
					Education<br>
					<input required type="text" name="education" value=<% out.print("\"" + person.getEducation() + "\""); %>><br>
					Experience<br>
					<input required type="text" name="experience" value=<% out.print("\"" + person.getExperience() + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 6:
					Payment payment = (Payment) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=6>
					<input type="hidden" name="id" value=<%= payment.getPayment_id()%>>
					Person_id<br>
					<input required type="text" name="person_id" value=<% out.print("\"" + payment.getPerson_id() + "\""); %>><br>
					Sum<br>
					<input required type="text" name="sum" value=<% out.print("\"" + payment.getSum() + "\""); %>><br>
					Pay_date<br>
					<input required type="text" name="pay_date" value=<% out.print("\"" + payment.getPay_date().getTime().getDate()+'.'+(payment.getPay_date().getTime().getMonth()+1) +'.'+(payment.getPay_date().getTime().getYear()+1900) + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 7:
					Experience experience = (Experience) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=7>
					<input type="hidden" name="id" value=<%= experience.getExp()%>>
					Bonus<br>
					<input required type="text" name="bonus" value=<% out.print("\"" + experience.getBonus() + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 8:
					Project_Function project_function = (Project_Function) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=8>
					<input type="hidden" name="id" value=<%= project_function.getId()%>>
					Name<br>
					<input required type="text" name="name" value=<% out.print("\"" + project_function.getName() + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				case 9:
					Project_Stuff project_stuff = (Project_Stuff) request.getAttribute("result");
					%>
					<input type="hidden" name="type" value=9>
					<input type="hidden" name="id" value=<%= project_stuff.getProject_stuff_id()%>>
					Project<br>
					<input required type="text" name="project_id" value=<% out.print("\"" + project_stuff.getProject_id() + "\""); %>><br>
					Person<br>
					<input required type="text" name="person_id" value=<% out.print("\"" + project_stuff.getPerson_id() + "\""); %>><br>
					Project_Function<br>
					<input required type="text" name="function_id" value=<% out.print("\"" + project_stuff.getFunction_id() + "\""); %>><br>
					Salary<br>
					<input required type="text" name="salary" value=<% out.print("\"" + project_stuff.getSalary() + "\""); %>><br>
					<br><button type="submit" name="action" value=0>change</button>
					<button type="submit" name="action" value=1>delete</button><br>
					<%
					break;
				default:
				}
			else {}
			%><br>
		</form>
		<a href="/Javapr/index.jsp">Home</a>
	</body>
</html>