package com.edutecno.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.model.Contact;
import com.edutecno.service.ContactService;


@Controller
@RequestMapping(value = "/contactManager", method = RequestMethod.GET)
public class ContactController {
	
	//declaracion de una instancia para ejecutar logger de informacion
	private final static Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getContactList(ModelMap model) {

		model.addAttribute("listaContact", contactService.getContactList());
		//ejecutando salida de informacion medediante logger
		logger.info("ejecutando getContactList() en el controlador");
		return "contactManager";
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute ("contact") Contact contacto) {

		contactService.addContact(contacto);
		model.addAttribute("listaContact", contactService.getContactList());
		
		//ejecutando salida de informacion medediante logger
		logger.info("ejecutando addContact() en el controlador");
		//return "contactManager";
		return "redirect:" + "/contactManager/";//se redirige a una direccion (mapping) del proyecto
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
	public String deleteContact(ModelMap model, @RequestParam("id") int id) {
		
		contactService.deleteContact(id);
		model.addAttribute("listaContact", contactService.getContactList());
		
		//ejecutando salida de informacion medediante logger
		logger.info("ejecutando deleteContact() en el controlador");
		//return "contactManager";
		return "redirect:" + "/contactManager/";//se redirige hacia la entrada de controlador ContactController y al metodo getContactList()	
	}
}
 