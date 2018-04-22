package com.cch.processrecipes.processemployeemapping;

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

import com.cch.processrecipes.processemployeemapping.ProcessEmpMappingFormValidator;


/**
 * @author Sagar Mali,Dada Gaikvad
 *
 */

@Controller
public class ProcessEmpMappingControllers
{
	@Autowired
	private ProcessEmpMappingDAO processEmpMappingDAO;
	
	@Autowired
	private ProcessEmpMappingFormValidator validator;
	
	@RequestMapping("/homeProcessEmpMapping")
	public String home()
	{
		return "homeProcessEmpMapping";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
		
	@RequestMapping("/searchProcessEmpMapping")
	public ModelAndView searchProcessEmpMapping(@RequestParam(required= false, defaultValue="") String empId)
	{
		ModelAndView mav = new ModelAndView("showProcessEmpMapping");
		try{
		List<ProcessEmpMapping> process = processEmpMappingDAO.searchProcessEmpMapping(Integer.parseInt(empId));
		mav.addObject("SEARCH_PROSESS_EMP_MAPPING_RESULTS_KEY", process);
		}catch(NumberFormatException ex){ // handle your exception
			  
			}
		return mav;
	}
	
	@RequestMapping("/viewAllProcessEmpMapping")
	public ModelAndView getAllProcess(HttpServletRequest re)
	{
		System.out.println("GET CON");
		System.out.println(re.getServletContext().getAttribute("sagar"));
		ModelAndView mav = new ModelAndView("showProcessEmpMapping");
		List<ProcessEmpMapping> process = processEmpMappingDAO.getAllProcessEmpMapping();
		mav.addObject("SEARCH_PROSESS_EMP_MAPPING_RESULTS_KEY", process);
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/saveProcesEmpMapping", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("newProcesEmpMapping");
		ProcessEmpMapping proces = new ProcessEmpMapping();
		mav.getModelMap().put("newProcesEmpMapping", proces);
		return mav;
	}
	
	@RequestMapping(value="/saveProcesEmpMapping", method=RequestMethod.POST)
	public String create(@ModelAttribute("newProcesEmpMapping")ProcessEmpMapping proces, BindingResult result, SessionStatus status)
	{
		validator.validate(proces, result);
		if (result.hasErrors()) 
		{				
			return "newProcesEmpMapping";
		}
		processEmpMappingDAO.save(proces);
		status.setComplete();
		return "redirect:viewAllProcessEmpMapping.do";
	}
	
	@RequestMapping(value="/updateProcesEmpMapping", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editProcesEmpMapping");
		ProcessEmpMapping proces = processEmpMappingDAO.getById(id);
		mav.addObject("editProcesEmpMapping", proces);
		return mav;
	}
	
	@RequestMapping(value="/updateProcesEmpMapping", method=RequestMethod.POST)
	public String update(@ModelAttribute("editProcesEmpMapping") ProcessEmpMapping proces, BindingResult result, SessionStatus status)
	{
		validator.validate(proces, result);
		if (result.hasErrors()) {
			return "editProcesEmpMapping";
		}
		processEmpMappingDAO.update(proces);
		status.setComplete();
		return "redirect:viewAllProcessEmpMapping.do";
	}
	
	
	@RequestMapping("deleteProcesEmpMapping")
	public ModelAndView delete(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("redirect:viewAllProcessEmpMapping.do");
		processEmpMappingDAO.delete(id);
		return mav;
	}
	
}
