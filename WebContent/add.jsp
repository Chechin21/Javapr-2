<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add</title>
	</head>
	<body>
		<h3>Select entry type</h3>
		<form action="/Javapr/add.x" method="post">
			<select name="type">
  				<option value=0>-----</option>
 				<option value=1>Person</option>
  				<option value=2>Project_staff</option>
  				<option value=3>Payment</option>
  				<option value=4>Position</option>
  				<option value=5>Project</option>
  				<option value=6>Salary</option>
  				<option value=7>Career</option>
			</select><br><br>
			<button type="submit">go</button><br><br>
		</form>
		<form action="/Javapr/add/temp.x">
			<%
			Integer type = (Integer) request.getAttribute("type");
			if (type != null) switch(type) {
			case 1:
				%>
				<input type="hidden" name="type" value=1>
				Person_id<br>
				<input type='text' name='id' required><br>
				First_name<br>
				<input type='text' name='first_name' required><br>
				Last_name<br>
				<input type='text' name='last_name' required><br>
				Address<br>
				<input type='text' name='address' required><br>
				Birth_date<br>
				<input type='text' name='birth_date' required><br>
				Education<br>
				<input type='text' name='education' required><br>
				Experience<br>
				<input type='text' name='experience' required><br>
				<br><button type="submit">add</button><br>
				<%
				break;
			case 2:
				%>
				<input type="hidden" name="type" value=2>
				Project_staff_id<br>
				<input type='text' name='id' required><br>
				Project_id<br>
				<input type='text' name='project_id' required><br>
				Person_id<br>
				<input type='text' name='person_id' required><br>
				Function_id<br>
				<input type='text' name='function_id' required><br>
				Salary<br>
				<input type='text' name='salary' required><br>
				<br><button type="submit">add</button><br>
				<%
				break;
			case 3:
				%>
				<input type="hidden" name="type" value=3>
				Payment_id<br>
				<input type='text' name='id' required><br>
				Pay_date<br>
				<input type='text' name='pay_date' required><br>
				Person_id<br>
				<input type='text' name='person_id' required><br>
				Sum<br>
				<input type='text' name='sum' required ><br>
				<br><button type="submit">add</button><br>
				<%
				break;
			case 4:
				%>
				<input type="hidden" name="type" value=4>
				Position_id<br>
				<input type='text' name='id' required><br>
				Name<br>
				<input type='text' name='name' required><br>
				<br><button type="submit">add</button><br>
				<%
				break;
			case 5:
				%>
				<input type="hidden" name="type" value=5>
				Project_id<br>
				<input type='text' name='id' required><br>
				Name<br>
				<input type='text' name='project_name' required><br>
				Start_date<br>
				<input type='text' name='start_date'><br>
				Stop_date<br>
				<input type='text' name='stop_date'><br>
				<br><button type="submit">add</button><br>
				<%
				break;
			case 6:
				%>
				<input type="hidden" name="type" value=6>
				Salary_id<br>
				<input type='text' name='id' required><br>
				Salary<br>
				<input type='text' name='salary' required><br>
				Position<br>
				<input type='text' name='position' required><br>
				Start_date<br>
				<input type='text' name='start_date' required><br>
				Stop_date<br>
				<input type='text' name='stop_date' ><br>
				<br><button type="submit">add</button><br>
				<%
				break;
			case 7:
				%>
				<input type="hidden" name="type" value=7>
				Career_id<br>
				<input type='text' name='id' required><br>
				Position<br>
				<input type='text' name='position' required><br>
				Person_id<br>
				<input type='text' name='person_id' required><br>
				Start_date<br>
				<input type='text' name='start_date' required><br>
				Stop_date<br>
				<input type='text' name='stop_date' ><br>
				<br><button type="submit">add</button><br>
				<%
				break;
			default:
			}
			%><br>
		</form>
		<a href="/Javapr/index.jsp">Home</a>
	</body>
</html>			
			
			
			
			
			
			
			
				