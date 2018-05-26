<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Find</title>
	</head>
	<body>
		<h3>Select entry type</h3>
		<form action="/Javapr/find.x" method="post">
			<select name="type">
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
  			</select><br><br>
  			<button type="submit">go</button><br><br>
		</form>
		<form action="/Javapr/result.x">
			<%
			Integer type = (Integer) request.getAttribute("type");
			if (type != null) switch(type) {
			case 1:
				%>
				<input type="hidden" name="type" value=1>
				Position_id<br>
				<input type='text' name='id' ><br>
				Name<br>
				<input type='text' name='name' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 2:
				%>
				<input type="hidden" name="type" value=2>
				Salary_id<br>
				<input type='text' name='id' ><br>
				Salary<br>
				<input type='text' name='salary' ><br>
				Position<br>
				<input type='text' name='position' ><br>
				Start_date<br>
				<input type='text' name='start_date' ><br>
				Stop_date<br>
				<input type='text' name='stop_date' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 3:
				%>
				<input type="hidden" name="type" value=3>
				Career_id<br>
				<input type='text' name='id' ><br>
				Position<br>
				<input type='text' name='position' ><br>
				Person_id<br>
				<input type='text' name='person_id' ><br>
				Start_date<br>
				<input type='text' name='start_date' ><br>
				Stop_date<br>
				<input type='text' name='stop_date' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 4:
				%>
				<input type="hidden" name="type" value=4>
				Project_id<br>
				<input type='text' name='id' ><br>
				Name<br>
				<input type='text' name='project_name' ><br>
				Start_date<br>
				<input type='text' name='start_date'><br>
				Stop_date<br>
				<input type='text' name='stop_date'><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 5:
				%>
				<input type="hidden" name="type" value=5>
				Person_id<br>
				<input type='text' name='id' ><br>
				First_name<br>
				<input type='text' name='first_name' ><br>
				Last_name<br>
				<input type='text' name='last_name' ><br>
				Address<br>
				<input type='text' name='address' ><br>
				Birth_date<br>
				<input type='text' name='birth_date' ><br>
				Education<br>
				<input type='text' name='education' ><br>
				Experience<br>
				<input type='text' name='experience' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 6:
				%>
				<input type="hidden" name="type" value=6>
				Payment_id<br>
				<input type='text' name='id' ><br>
				Pay_date<br>
				<input type='text' name='pay_date' ><br>
				Person_id<br>
				<input type='text' name='person_id' ><br>
				Sum<br>
				<input type='text' name='sum' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 7:
				%>
				<input type="hidden" name="type" value=7>
				Experience<br>
				<input type='text' name='experience' ><br>
				Bonus<br>
				<input type='text' name='bonus' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 8:
				%>
				<input type="hidden" name="type" value=8>
				Project_Function_id<br>
				<input type='text' name='id' ><br>
				Name<br>
				<input type='text' name='name' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			case 9:
				%>
				<input type="hidden" name="type" value=9>
				Project_staff_id<br>
				<input type='text' name='id' ><br>
				Project_id<br>
				<input type='text' name='project_id' ><br>
				Person_id<br>
				<input type='text' name='person_id' ><br>
				Function_id<br>
				<input type='text' name='function_id' ><br>
				Salary<br>
				<input type='text' name='salary' ><br>
				<br><button type="submit">find</button><br>
				<%
				break;
			default:
			}
			%><br>
		</form>
		<a href="/Javapr/index.jsp">Home</a>
	</body>
</html>