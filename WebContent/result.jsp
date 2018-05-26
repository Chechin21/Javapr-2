<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Results</title>
	</head>
	<body>
		<%@ page import="tables.Person,tables.Career,tables.Experience,java.util.List,tables.Payment,tables.Position,tables.Project_Function,tables.Project_Stuff,tables.Project,tables.Salary" %>
		<%
		Integer type = (Integer) request.getAttribute("type");
		switch(type) {
		case 1:
			%>
			<h3>Found positions (id | name):</h3>
			<%
			List<Position> positions = (List<Position>) request.getAttribute("result");
			if (positions == null || positions.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Position position : positions) {
				out.print(position.getId() + " | ");
				out.print(position.getName() + " | ");
				out.print("<br>");
			}
			break;
		case 2:
			%>
			<h3>Found Salarys (id | salary | position | start date | stop date):</h3>
			<%
			List<Salary> salarys = (List<Salary>) request.getAttribute("result");
			if (salarys == null || salarys.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Salary salary : salarys) {
				out.print(salary.getSalary_id() + " | ");
				out.print(salary.getSalary() + " | ");
				out.print(salary.getPosition_id() + " | ");
				out.print("\"" + salary.getStart_date().getTime().getDate()+'.'+(salary.getStart_date().getTime().getMonth()+1) +'.'+(salary.getStart_date().getTime().getYear()+1900) + "\""+ "|");
				out.print("\"" + salary.getEnd_date().getTime().getDate()+'.'+(salary.getEnd_date().getTime().getMonth()+1) +'.'+(salary.getEnd_date().getTime().getYear()+1900) + "\""+ "|");
				out.print("<br>");
			}
			break;
		case 3:
			%>
			<h3>Found Careers (id | person_id | position_id | start date | stop date):</h3>
			<%
			List<Career> careers = (List<Career>) request.getAttribute("result");
			if (careers == null || careers.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Career career : careers) {
				out.print(career.getCareer_id() + " | ");
				out.print(career.getPerson_id() + " | ");
				out.print(career.getPosition_id() + " | ");
				out.print("\"" + career.getStart_date().getTime().getDate()+'.'+(career.getStart_date().getTime().getMonth()+1) +'.'+(career.getStart_date().getTime().getYear()+1900) + "\"" + "|");
				out.print("\"" + career.getStop_date().getTime().getDate()+'.'+(career.getStop_date().getTime().getMonth()+1) +'.'+(career.getStop_date().getTime().getYear()+1900) + "\"" + "|");
				out.print("<br>");
			}
			break;
		case 4:
			%>
			<h3>Found Projects (id | name | start date | stop date):</h3>
			<%
			List<Project> projects = (List<Project>) request.getAttribute("result");
			if (projects == null || projects.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Project project : projects) {
				out.print(project.getId() + " | ");
				out.print(project.getName() + " | ");
				out.print("\"" + project.getStart_date().getTime().getDate()+'.'+(project.getStart_date().getTime().getMonth()+1) +'.'+(project.getStart_date().getTime().getYear()+1900) + "\"" + " | ");
				out.print("\"" + project.getStop_date().getTime().getDate()+'.'+(project.getStop_date().getTime().getMonth()+1) +'.'+(project.getStop_date().getTime().getYear()+1900) + "\"" + " | ");
				out.print("<br>");
			}
			break;
		case 5:
			%>
			<h3>Found Persons (id | name | surname | education | experience | address | birth_date ):</h3>
			<%
			List<Person> persons = (List<Person>) request.getAttribute("result");
			if (persons == null || persons.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Person person : persons) {
				out.print(person.getId() + " | ");
				out.print(person.getFirst_name() + " | ");
				out.print(person.getLast_name() + " | ");
				out.print(person.getEducation() + " | ");
				out.print(person.getExperience() + " | ");
				out.print(person.getAddress() + " | ");
				out.print("\"" + person.getDate_of_birth().getTime().getDate()+'.'+(person.getDate_of_birth().getTime().getMonth()+1) +'.'+(person.getDate_of_birth().getTime().getYear()+1900) + "\"" + " | ");
				out.print("<br>");
			}
			break;
		case 6:
			%>
			<h3>Found Payments (id | person_id | sum | pay_date ):</h3>
			<%
			List<Payment> payments = (List<Payment>) request.getAttribute("result");
			if (payments == null || payments.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Payment payment : payments) {
				out.print(payment.getPayment_id() + " | ");
				out.print(payment.getPerson_id() + " | ");
				out.print(payment.getSum() + " | ");
				out.print("\"" + payment.getPay_date().getTime().getDate()+'.'+(payment.getPay_date().getTime().getMonth()+1) +'.'+(payment.getPay_date().getTime().getYear()+1900) + "\"" + " | ");
			}
			break;
		case 7:
			%>
			<h3>Found experiences (year | bonus):</h3>
			<%
			List<Experience> experiences = (List<Experience>) request.getAttribute("result");
			if (experiences == null || experiences.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Experience experience : experiences) {
				out.print(experience.getExp() + " | ");
				out.print(experience.getBonus() + " | ");
				out.print("<br>");
			}
			break;
		case 8:
			%>
			<h3>Found project_functions (id | name):</h3>
			<%
			List<Project_Function> project_functions = (List<Project_Function>) request.getAttribute("result");
			if (project_functions == null || project_functions.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Project_Function project_function : project_functions) {
				out.print(project_function.getId() + " | ");
				out.print(project_function.getName() + " | ");
				out.print("<br>");
			}
			break;
		case 9:
			%>
			<h3>Found Project_Stuffs (id | person_id | project_id | function | salary):</h3>
			<%
			List<Project_Stuff> project_stuffs = (List<Project_Stuff>) request.getAttribute("result");
			if (project_stuffs == null || project_stuffs.isEmpty()) {
				out.print("No entries found!");
			} else
			for (Project_Stuff project_stuff : project_stuffs) {
				out.print(project_stuff.getProject_stuff_id() + " | ");
				out.print(project_stuff.getPerson_id() + " | ");
				out.print(project_stuff.getProject_id() + " | ");
				out.print(project_stuff.getFunction_id() + " | ");
				out.print(project_stuff.getSalary() + " | ");
				out.print("<br>");
			}
			break;
		default:
		}

	%><br><br>
	<a href="/Javapr/index.jsp">Home</a>
</body>
</html>
			