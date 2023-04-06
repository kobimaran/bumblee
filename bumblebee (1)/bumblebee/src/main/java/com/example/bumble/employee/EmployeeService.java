package com.example.bumble.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

public class EmployeeService {
	 


	@Autowired
	    private EmployeeService service;
	 
	  
	    public String viewHomePage(Model model) {
	        List<Employee> listemployee = service.listAll();
	        ((Object) model).addAttribute("listemployee", listemployee);
	        System.out.print("Get / ");
	        return "index";
	    }
	 
	    private List<Employee> listAll() {
			// TODO Auto-generated method stub
			return null;
		}


	    public String add(Model model) {
	        ((Object) model).addAttribute("employee", new Employee());
	        return "new";
	    }
	 
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
	        service.save(emp);
	        return "redirect:/";
	    }
	 
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Employee emp = service.get(id);
	        mav.addObject("employee", emp);
	        return mav;
	        
	    }
	    private Employee get(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@RequestMapping("/delete/{id}")
	    public String deleteEmployeePage(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/";
	    }

		private void delete(int id) {
			// TODO Auto-generated method stub
			
		}

		public void save(Employee emp) {
			// TODO Auto-generated method stub
			
		}
	}
}
