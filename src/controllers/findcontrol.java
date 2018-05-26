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
@RequestMapping(value = "/find")
public class findcontrol {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showPage(Model model) {
		return "find.jsp";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String chooseForm(@RequestParam("type") int type, Model model) {
		model.addAttribute("type", type);
		return "find.jsp";
	}
}
