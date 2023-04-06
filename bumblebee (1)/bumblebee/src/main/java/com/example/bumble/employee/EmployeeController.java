package com.example.bumble.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.core.model.Model;

@Controller
public class EmployeeController {
@Autowired
   private EmployeeService service;


   public String viewHomePage(Model model) {
       List<Employee> listemployee = service.listAll();
       model.addAttribute("listemployee", listemployee);
       System.out.print("Get / ");
       return "index";
   }

   @GetMapping("/new")
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
   @RequestMapping("/delete/{id}")
   public String deleteEmployeePage(@PathVariable(name = "id") int id) {
       service.delete(id);
       return "redirect:/";
   }

}