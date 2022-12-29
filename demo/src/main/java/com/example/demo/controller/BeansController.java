package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.BeansEntity;
import com.example.demo.service.BeansService;


@Controller
public class BeansController {
	@Autowired
	private BeansService beansservice;

	
//	  @GetMapping("/learningReportList")
//	  public String showLearningList(Model model) {
//	    List<LearningReport> learningreport = learningListService.findAll();
//	    model.addAttribute("learningreport",learningreport);
//	    return "learningReportList";
//	  }

	  @GetMapping("/Beanslist")
	  public String showList(Model model) {
		  List<BeansEntity> BeansList = beansservice.findAll();
	    model.addAttribute("BeansList",BeansList);
	    return "List";
	  }
	  
	  @PostMapping(path = "Beanslist", params = "edit")
	  public String postLearningList(RedirectAttributes redirectAttributes,@RequestParam("id") Integer id, @ModelAttribute BeansEntity BeansList,Model model) {
		 
		  
		  redirectAttributes.addFlashAttribute("id", id);
//		  Optional<LearningReport> form = learningListService.selectById(rema);
//		  model.addAttribute("form", form);
		  return "redirect:/Update";
	  }
	  
	  @PostMapping(path = "Beanslist", params = "delete")
	  public String deleteLearningReport(@RequestParam Integer id) {
		  beansservice.delete(id);
		  return "redirect:/Beanslist";
	  }


	  @PostMapping(path = "Beanslist", params = "new")
	  public String redirectNew(Model model) {

		  return "redirect:/New";
	  }
	  
//	  @GetMapping("/Beanslist")
//	  public String redirectNew(Model model) {
//		  List<BeansEntity> BeansList = beansservice.findAll();
//	    model.addAttribute("BeansList",BeansList);
//	    return "List";
//	  }
	  
		@GetMapping("/New")
		public String  showNew(Model model ) {
			model.addAttribute("Beans",new BeansEntity());

			return "/New";
		}
	  
	  @PostMapping("/New")
		public String getleaningmewreport(@ModelAttribute @Validated BeansEntity Beans,BindingResult bindingResult, Model model) {

			if (bindingResult.hasErrors()) {
				List<String> errorList = new ArrayList<String>();
				for (ObjectError error : bindingResult.getAllErrors()) {
					errorList.add(error.getDefaultMessage());
				}
				model.addAttribute("Beans",Beans);
				model.addAttribute("validationError", errorList);

				return "/New";
			}
			beansservice.update(Beans);
			model.addAttribute("Beans", Beans);
			return "redirect:/Beanslist";
		}
		  @PostMapping(path = "/New", params = "back")
		  public String backNew() {
			  return "redirect:/Beanslist";
		  }
		
	  @GetMapping("/Update")
	  public String  showEdit( @ModelAttribute("id") Integer id, BeansEntity BeansList,Model model ) {
	    Optional<BeansEntity> Beans = beansservice.selectById(id);
	    model.addAttribute("Beans",Beans);
	    return "Update";
	  }
	  
	  
	  @PostMapping("/Update")
	  public String postLearningEdit(@ModelAttribute @Validated  BeansEntity Beans,BindingResult bindingResult, Model model) {
			
			if (bindingResult.hasErrors()) {
			       List<String> errorList = new ArrayList<String>();
		            for (ObjectError error : bindingResult.getAllErrors()) {
		                errorList.add(error.getDefaultMessage());
			}
		            model.addAttribute("validationError", errorList);
		            model.addAttribute("Beans",Beans);

		            return "/Update";
			}
		    
			beansservice.update(Beans);
			model.addAttribute("Beans",Beans);
			return "redirect:/Beanslist";
	  }

	  @PostMapping(path = "/Update", params = "back")
	  public String back() {
		  return "redirect:/Beanslist";
	  }
	
}

	  
	  
