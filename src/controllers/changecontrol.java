package controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import classes.*;
import classesImpl.*;
import tables.*;

@Controller
@RequestMapping(value = "/change")
public class changecontrol {
	private static PersonDAO personDAO=new PersonDAOImpl();
	private static Project_StuffDAO project_stuffDAO=new Project_StuffDAOImpl();
	private static PaymentDAO paymentDAO=new PaymentDAOImpl();
	private static PositionDAO positionDAO=new PositionDAOImpl();
	private static ProjectDAO projectDAO=new ProjectDAOImpl();
	private static SalaryDAO salaryDAO=new SalaryDAOImpl();
	private static CareerDAO careerDAO=new CareerDAOImpl();
	private static ExperienceDAO experienceDAO=new ExperienceDAOImpl();
	private static Project_FunctionDAO project_functionDAO=new Project_FunctionDAOImpl();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showPage(Model model) {
		return "change.jsp";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String chooseForm(@RequestParam("type") int type,
							 @RequestParam("id") String id,
							 Model model) throws SQLException {
		switch (type) {
		case 1:
			Position position;
			try {
				position = positionDAO.getPositionById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", position);
			break;
		case 2:
			Salary salary;
			try {
				salary = salaryDAO.getSalaryById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", salary);
			break;
		case 3:
			Career career;
			try {
				career = careerDAO.getCareerById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", career);
			break;
		case 4:
			Project project;
			try {
				project = projectDAO.getProjectById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", project);
			break;
		case 5:
			Person person;
			try {
				person = personDAO.getPersonById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", person);
			break;
		case 6:
			Payment payment;
			try {
				payment = paymentDAO.getPaymentById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", payment);
			break;
		case 7:
			Experience experience;
			try {
				experience = experienceDAO.getExperienceById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", experience);
			break;
		case 8:
			Project_Function project_function;
			try {
				project_function = project_functionDAO.getProject_FunctionById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", project_function);
			break;
		case 9:
			Project_Stuff project_stuff;
			try {
				project_stuff = project_stuffDAO.getProject_StuffById(Long.parseLong(id));
			} catch (NumberFormatException e) {
				model.addAttribute("error", 0);
				return "change.jsp";
			}
			model.addAttribute("type", type);
			model.addAttribute("result", project_stuff);
			break;
		default:
			model.addAttribute("type",0);
		}
		return "change.jsp"	;
			
	}
	@RequestMapping(value = "/temp", method = RequestMethod.GET)
	public String update(@RequestParam(value = "type") int type,
			   @RequestParam(value = "id", required = false) int id,
			   @RequestParam(value = "action") int action,
			   @RequestParam(value = "name", required = false) String name,
			   @RequestParam(value = "first_name", required = false) String first_name,
			   @RequestParam(value = "last_name", required = false) String last_name,
			   @RequestParam(value = "address", required = false) String address,
			   @RequestParam(value = "birth_date", required = false) String birth_date,
			   @RequestParam(value = "education", required = false) String education,
			   @RequestParam(value = "experience", required = false) String experience,
			   @RequestParam(value = "project_id", required = false) String project_id,
			   @RequestParam(value = "person_id", required = false) String person_id,
			   @RequestParam(value = "function_id", required = false) String function_id,
			   @RequestParam(value = "salary", required = false) String salary,
			   @RequestParam(value = "pay_date", required = false) String pay_date,
			   @RequestParam(value = "sum", required = false) String sum,
			   @RequestParam(value = "project_name", required = false) String project_name,
			   @RequestParam(value = "start_date", required = false) String start_date,
			   @RequestParam(value = "stop_date", required = false) String stop_date,
			   @RequestParam(value = "position", required = false) String position,
			   @RequestParam(value = "project_stuff", required = false) String project_stuff,
			   @RequestParam(value = "bonus", required = false) String bonus,
			   Model model) throws SQLException, ParseException {
		if (action == 0) {
			model.addAttribute("type", type);
			switch (type) {
			case 1:
				Position iposition=new Position();
				iposition.setId((long) id);
				if (name != null && !name.isEmpty())
					iposition.setName(name);
				positionDAO.updatePosition(null, iposition);
				break;
			case 2:
				Salary isalary=new Salary();
				isalary.setSalary_id((long) id);
				if (position != null && !position.isEmpty())
					isalary.setPosition_id(Long.parseLong(position));
				if (salary != null && !salary.isEmpty())
					isalary.setSalary(Long.parseLong(salary));
				if (start_date != null && !start_date.isEmpty()){
					Calendar cal7 = Calendar.getInstance();
					SimpleDateFormat sdf7 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
					cal7.setTime(sdf7.parse(start_date));
					isalary.setStart_date(cal7);
				}
				if (stop_date != null && !stop_date.isEmpty()){
					Calendar cal8 = Calendar.getInstance();
					SimpleDateFormat sdf8 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
					cal8.setTime(sdf8.parse(stop_date));
					isalary.setEnd_date(cal8);;
				
				}
				
				salaryDAO.updateSalary(null, isalary);
				break;
			case 3:
				Career icareer=new Career();
				icareer.setCareer_id((long) id);
				icareer.setPerson_id(Long.parseLong(person_id));
				icareer.setPosition_id(Long.parseLong(position));
				Calendar cal7 = Calendar.getInstance();
				SimpleDateFormat sdf7 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal7.setTime(sdf7.parse(start_date));
				icareer.setStart_date(cal7);
				if (stop_date!=null){
					Calendar cal8 = Calendar.getInstance();
					SimpleDateFormat sdf8 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
					cal8.setTime(sdf8.parse(stop_date));
					icareer.setStop_date(cal8);
				}
				careerDAO.updateCareer(null,icareer);
				break;
			case 4:
				Project iproject=new Project();
				iproject.setId((long) id);
				iproject.setName(name);
				if (start_date!=null){
					Calendar cal3 = Calendar.getInstance();
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
					cal3.setTime(sdf3.parse(start_date));
					iproject.setStart_date(cal3);
				}
				if (stop_date!=null){
					Calendar cal4 = Calendar.getInstance();
					SimpleDateFormat sdf4 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
					cal4.setTime(sdf4.parse(stop_date));
					iproject.setStop_date(cal4);
				}
				projectDAO.updateProject(null,iproject);
				break;
			case 5:
				Person iperson=new Person();
				iperson.setId((long) id);
				iperson.setAddress(address);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal.setTime(sdf.parse(birth_date));
				iperson.setDate_of_birth(cal);
				iperson.setEducation(education);
				iperson.setExperience(Long.parseLong(experience));
				iperson.setFirst_name(first_name);
				iperson.setLast_name(last_name);
				personDAO.updatePerson(null,iperson);
				break;
			case 6:
				Payment ipayment=new Payment();
				ipayment.setPayment_id((long) id);
				Calendar cal2 = Calendar.getInstance();
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal2.setTime(sdf2.parse(pay_date));
				ipayment.setPay_date(cal2);
				ipayment.setPerson_id(Long.parseLong(person_id));
				ipayment.setSum(Long.parseLong(sum));
				paymentDAO.updatePayment(null,ipayment);
				break;
			case 7:
				Experience iexperience = new Experience();
				iexperience.setExp((long) id);
				iexperience.setBonus(Long.parseLong(bonus));
				experienceDAO.updateExperience(null, iexperience);
				break;
			case 8:
				Project_Function iproject_function = new Project_Function();
				iproject_function.setId((long) id);
				iproject_function.setName(name);
				project_functionDAO.updateProject_Function(null, iproject_function);
				break;
			case 9:
				Project_Stuff ipr_st=new Project_Stuff();
				ipr_st.setProject_stuff_id((long) id);
				ipr_st.setFunction_id(Long.parseLong(function_id));
				ipr_st.setPerson_id(Long.parseLong(person_id));
				ipr_st.setProject_id(Long.parseLong(project_id));
				
				ipr_st.setSalary(Long.parseLong(salary));
				project_stuffDAO.updateProject_Stuff(null,ipr_st);
				break;
			default:
			}
			return "/index.jsp";
		} else if (action == 1) {
			switch (type) {
			case 1:
				Position a=new Position();
				a.setId((long) id);
				positionDAO.deletePosition(a);
				break;
			case 2:
				Salary b=new Salary();
				b.setSalary_id((long) id);;
				salaryDAO.deleteSalary(b);
				break;
			case 3:
				Career a1=new Career();
				a1.setCareer_id((long) id);
				careerDAO.deleteCareer(a1);
				break;
			case 4:
				Project a2=new Project();
				a2.setId((long) id);
				projectDAO.deleteProject(a2);
				break;
			case 5:
				Person a3=new Person();
				a3.setId((long) id);
				personDAO.deletePerson(a3);
				break;
			case 6:
				Payment a4=new Payment();
				a4.setPayment_id((long) id);
				paymentDAO.deletePayment(a4);
				break;
			case 7:
				Experience a5=new Experience();
				a5.setExp((long) id);
				experienceDAO.deleteExperience(a5);
				break;
			case 8:
				Project_Function a6=new Project_Function();
				a6.setId((long) id);
				project_functionDAO.deleteProject_Function(a6);
				break;
			case 9:
				Project_Stuff a7=new Project_Stuff();
				a7.setProject_stuff_id((long) id);
				project_stuffDAO.deleteProject_Stuff(a7);
				break;
			default:
			}
			return "/index.jsp";
		}
		return "/index.jsp";
	}
}