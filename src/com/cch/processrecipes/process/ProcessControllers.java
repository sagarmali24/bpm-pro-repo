package com.cch.processrecipes.process;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cch.processrecipes.process.ProcessFormValidator;


/**
 * @author Sagar Mali,Dada Gaikvad
 *
 */

@Controller
public class ProcessControllers
{
	@Autowired
	private ProcessDAO processDAO;
	
	@Autowired
	private ProcessFormValidator validator;
	
	@RequestMapping("/homeProcess")
	public String home()
	{
		return "homeProcess";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
		
	@RequestMapping("/searchProcess")
	public ModelAndView searchProcess(@RequestParam(required= false, defaultValue="") String name)
	{
		ModelAndView mav = new ModelAndView("showProcess");
		List<Process> process = processDAO.searchProcess(name.trim());
		mav.addObject("SEARCH_PROSESS_RESULTS_KEY", process);
		return mav;
	}
	
	@RequestMapping("/viewAllProcess")
	public ModelAndView getAllProcess(HttpServletRequest re)
	{
		System.out.println("GET CON");
		System.out.println(re.getServletContext().getAttribute("sagar"));
		ModelAndView mav = new ModelAndView("showProcess");
		List<Process> process = processDAO.getAllProcess();
		mav.addObject("SEARCH_PROCESS_RESULTS_KEY", process);
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/saveProces", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("newProces");
		Process proces = new Process();
		mav.getModelMap().put("newProces", proces);
		return mav;
	}
	
	@RequestMapping(value="/saveProces", method=RequestMethod.POST)
	public String create(@ModelAttribute("newProces")Process proces, BindingResult result, SessionStatus status)
	{
		validator.validate(proces, result);
		if (result.hasErrors()) 
		{				
			return "newProces";
		}
		processDAO.save(proces);
		status.setComplete();
		return "redirect:viewAllProcess.do";
	}
	
	@RequestMapping(value="/updateProces", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editProces");
		Process proces = processDAO.getById(id);
		mav.addObject("editProces", proces);
		return mav;
	}
	
	@RequestMapping(value="/updateProces", method=RequestMethod.POST)
	public String update(@ModelAttribute("editProces") Process proces, BindingResult result, SessionStatus status)
	{
		validator.validate(proces, result);
		if (result.hasErrors()) {
			return "editProces";
		}
		processDAO.update(proces);
		status.setComplete();
		return "redirect:viewAllProcess.do";
	}
	
	
	@RequestMapping("deleteProces")
	public ModelAndView delete(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("redirect:viewAllProcess.do");
		processDAO.delete(id);
		return mav;
	}
	
}
