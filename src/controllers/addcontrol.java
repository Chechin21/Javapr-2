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
@RequestMapping(value = "/add")
public class addcontrol {
	private static PersonDAO personDAO=new PersonDAOImpl();
	private static Project_StuffDAO project_stuffDAO=new Project_StuffDAOImpl();
	private static PaymentDAO paymentDAO=new PaymentDAOImpl();
	private static PositionDAO positionDAO=new PositionDAOImpl();
	private static ProjectDAO projectDAO=new ProjectDAOImpl();
	private static SalaryDAO salaryDAO=new SalaryDAOImpl();
	private static CareerDAO careerDAO=new CareerDAOImpl();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showPage(Model model) {
		return "add.jsp";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String chooseForm(@RequestParam("type") int type, Model model) {
		model.addAttribute("type", type);
		return "add.jsp";
	}
	@RequestMapping(value = "/temp", method = RequestMethod.GET)
	public String addEntry(@RequestParam(value = "type") int type,
						   @RequestParam(value = "name", required = false) String name,
						   @RequestParam(value = "id", required = false) String id,
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
						   Model model) throws SQLException, ParseException {
		model.addAttribute("type", type);
		switch (type) {
		case 1:
			Person iperson=new Person();
			iperson.setAddress(address);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
			cal.setTime(sdf.parse(birth_date));
			iperson.setDate_of_birth(cal);
			iperson.setEducation(education);
			iperson.setExperience(Long.parseLong(experience));
			iperson.setFirst_name(first_name);
			iperson.setId(Long.parseLong(id));
			iperson.setLast_name(last_name);
			personDAO.addPerson(iperson);
			break;
		case 2:
			Project_Stuff ipr_st=new Project_Stuff();
			ipr_st.setFunction_id(Long.parseLong(function_id));
			ipr_st.setPerson_id(Long.parseLong(person_id));
			ipr_st.setProject_id(Long.parseLong(project_id));
			ipr_st.setProject_stuff_id(Long.parseLong(id));
			ipr_st.setSalary(Long.parseLong(salary));
			project_stuffDAO.addProject_Stuff(ipr_st);
			break;
		case 3:
			Payment ipayment=new Payment();
			Calendar cal2 = Calendar.getInstance();
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
			cal2.setTime(sdf2.parse(pay_date));
			ipayment.setPay_date(cal2);
			ipayment.setPayment_id(Long.parseLong(id));
			ipayment.setPerson_id(Long.parseLong(person_id));
			ipayment.setSum(Long.parseLong(sum));
			paymentDAO.addPayment(ipayment);
			break;
		case 4:
			Position iposition=new Position();
			iposition.setId(Long.parseLong(id));
			iposition.setName(name);
			positionDAO.addPosition(iposition);
			break;
		case 5:
			Project iproject=new Project();
			iproject.setId(Long.parseLong(id));
			iproject.setName(project_name);
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
			projectDAO.addProject(iproject);
			break;
		case 6:
			Salary isalary=new Salary();
			isalary.setSalary_id(Long.parseLong(id));
			isalary.setPosition_id(Long.parseLong(position));
			isalary.setSalary(Long.parseLong(salary));
			Calendar cal5 = Calendar.getInstance();
			SimpleDateFormat sdf5 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
			cal5.setTime(sdf5.parse(start_date));
			isalary.setStart_date(cal5);
			if (stop_date!=null){
				Calendar cal6 = Calendar.getInstance();
				SimpleDateFormat sdf6 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal6.setTime(sdf6.parse(stop_date));
				isalary.setEnd_date(cal6);
			}
			salaryDAO.addSalary(isalary);
			break;
		case 7:
			Career icareer=new Career();
			icareer.setCareer_id(Long.parseLong(id));
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
			careerDAO.addCareer(icareer);
			break;
		default:
		}
		return "/index.jsp";
	}
}


	
	
