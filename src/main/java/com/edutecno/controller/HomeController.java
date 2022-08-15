package com.edutecno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controlador opcional a DefaultViewConfig
//si no se quiere configurar la vista principal se declara un controlador para despliegue de home page
@Controller
public class HomeController {
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		
		//redirigiendo la solicitud hacia el controlador ContactController("/contactManager")
		//y al metodo getContactList("/")
		return "redirect:"+"/contactManager/";
	}
	
}
