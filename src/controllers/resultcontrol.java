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
import org.hibernate.mapping.Collection;
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
@RequestMapping(value = "/result")
public class resultcontrol {
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
	public String update(@RequestParam(value = "type") int type,
			   @RequestParam(value = "id", required = false) String id,
			   @RequestParam(value = "name", required = false) String name,
			   @RequestParam(value = "person_id", required = false) String person_id,
			   @RequestParam(value = "first_name", required = false) String first_name,
			   @RequestParam(value = "last_name", required = false) String last_name,
			   @RequestParam(value = "address", required = false) String address,
			   @RequestParam(value = "birth_date", required = false) String birth_date,
			   @RequestParam(value = "education", required = false) String education,
			   @RequestParam(value = "experience", required = false) String experience,
			   @RequestParam(value = "project_id", required = false) String project_id,
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
		model.addAttribute("type", type);
		switch (type){
		case 1:
			Position iposition = new Position();
			if (id != null && !id.isEmpty()) 
				iposition.setId(Long.parseLong(id));
			if (name != null && !name.isEmpty())
				iposition.setName(name);
			List<Position> positions =  (List<Position>) positionDAO.getPositionByFeature(iposition);
			model.addAttribute("result", positions);
			break;
		case 2:
			Salary isalary = new Salary();
			if (id != null && !id.isEmpty()) 
				isalary.setSalary_id(Long.parseLong(id));
			if (salary != null && !salary.isEmpty())
				isalary.setSalary(Long.parseLong(salary));
			if(position != null &&!position.isEmpty())
				isalary.setPosition_id(Long.parseLong(position));
			if(start_date !=null && !start_date.isEmpty()){
				Calendar cal3 = Calendar.getInstance();
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal3.setTime(sdf3.parse(start_date));
				isalary.setStart_date(cal3);
			}
			if(stop_date !=null && !stop_date.isEmpty()){
				Calendar cal4 = Calendar.getInstance();
				SimpleDateFormat sdf4 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal4.setTime(sdf4.parse(stop_date));
				isalary.setEnd_date(cal4);
			}
			List<Salary> salarys =  (List<Salary>) salaryDAO.getSalaryByFeature(isalary);
			model.addAttribute("result", salarys);
			break;
		case 3:
			Career icareer = new Career();
			if (id != null && !id.isEmpty()) 
				icareer.setCareer_id(Long.parseLong(id));
			if (person_id != null && !person_id.isEmpty())
				icareer.setPerson_id(Long.parseLong(person_id));
			if(position != null &&!position.isEmpty())
				icareer.setPosition_id(Long.parseLong(position));
			if(start_date !=null && !start_date.isEmpty()){
				Calendar cal3 = Calendar.getInstance();
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal3.setTime(sdf3.parse(start_date));
				icareer.setStart_date(cal3);
			}
			if(stop_date !=null && !stop_date.isEmpty()){
				Calendar cal4 = Calendar.getInstance();
				SimpleDateFormat sdf4 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal4.setTime(sdf4.parse(stop_date));
				icareer.setStop_date(cal4);
			}
			List<Career> careers =  (List<Career>) careerDAO.getCareerByFeature(icareer);
			model.addAttribute("result", careers);
			break;
			
		case 4:
			Project iproject = new Project();
			if (id != null && !id.isEmpty()) 
				iproject.setId(Long.parseLong(id));
			if (name != null && !name.isEmpty())
				iproject.setName(name);
			if(start_date !=null && !start_date.isEmpty()){
				Calendar cal3 = Calendar.getInstance();
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal3.setTime(sdf3.parse(start_date));
				iproject.setStart_date(cal3);
			}
			if(stop_date !=null && !stop_date.isEmpty()){
				Calendar cal4 = Calendar.getInstance();
				SimpleDateFormat sdf4 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal4.setTime(sdf4.parse(stop_date));
				iproject.setStop_date(cal4);
			}
			List<Project> projects =  (List<Project>) projectDAO.getProjectByFeature(iproject);
			model.addAttribute("result", projects);
			break;
		case 5:
			Person iperson = new Person();
			if (id != null && !id.isEmpty()) 
				iperson.setId(Long.parseLong(id));
			if (first_name != null && !first_name.isEmpty())
				iperson.setFirst_name(first_name);
			if (last_name != null && !last_name.isEmpty())
				iperson.setLast_name(last_name);
			if(birth_date !=null && !birth_date.isEmpty()){
				Calendar cal3 = Calendar.getInstance();
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal3.setTime(sdf3.parse(birth_date));
				iperson.setDate_of_birth(cal3);
			}
			if (address != null && !address.isEmpty())
				iperson.setFirst_name(address);
			if (education != null && !education.isEmpty())
				iperson.setFirst_name(education);
			if (experience != null && !experience.isEmpty())
				iperson.setExperience(Long.parseLong(experience));
			List<Person> persons =  (List<Person>) personDAO.getPersonByFeature(iperson);
			model.addAttribute("result", persons);
			break;
		case 6:
			Payment ipayment = new Payment();
			if (id != null && !id.isEmpty()) 
				ipayment.setPayment_id(Long.parseLong(id));
			if (person_id != null && !person_id.isEmpty())
				ipayment.setPerson_id(Long.parseLong(person_id));
			if (sum != null && !sum.isEmpty())
				ipayment.setSum(Long.parseLong(sum));
			if(pay_date !=null && !pay_date.isEmpty()){
				Calendar cal3 = Calendar.getInstance();
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				cal3.setTime(sdf3.parse(pay_date));
				ipayment.setPay_date(cal3);
			}
			List<Payment> payments =  (List<Payment>) paymentDAO.getPaymentByFeature(ipayment);
			model.addAttribute("result", payments);
			break;
		case 7:
			Experience iexperience = new Experience();
			if (experience != null && !experience.isEmpty()) 
				iexperience.setExp(Long.parseLong(experience));
			if (bonus != null && !bonus.isEmpty())
				iexperience.setBonus(Long.parseLong(bonus));
			List<Experience> experiences =  (List<Experience>) experienceDAO.getExperienceByFeature(iexperience);
			model.addAttribute("result", experiences);
			break;
		case 8:
			Project_Function iproject_function = new Project_Function();
			if (id != null && !id.isEmpty()) 
				iproject_function.setId(Long.parseLong(id));
			if (name != null && !name.isEmpty())
				iproject_function.setName(name);
			List<Project_Function> project_functions =  (List<Project_Function>) project_functionDAO.getProject_FunctionByFeature(iproject_function);
			model.addAttribute("result", project_functions);
			break;
		case 9:
			Project_Stuff iproject_stuff = new Project_Stuff();
			if (id != null && !id.isEmpty()) 
				iproject_stuff.setProject_stuff_id(Long.parseLong(id));
			if (person_id != null && !person_id.isEmpty())
				iproject_stuff.setPerson_id(Long.parseLong(person_id));
			if (salary != null && !salary.isEmpty())
				iproject_stuff.setSalary(Long.parseLong(salary));
			if (function_id != null && !function_id.isEmpty())
				iproject_stuff.setFunction_id(Long.parseLong(function_id));
			if (project_id != null && !project_id.isEmpty())
				iproject_stuff.setProject_id(Long.parseLong(project_id));
			List<Project_Stuff> project_stuffs =  (List<Project_Stuff>) project_stuffDAO.getProject_StuffByFeature(iproject_stuff);
			model.addAttribute("result", project_stuffs);
			break;
		default:
		}
		return "result.jsp";
	}
}