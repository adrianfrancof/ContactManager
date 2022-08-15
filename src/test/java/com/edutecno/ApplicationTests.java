package com.edutecno;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.*; //obtener todas las librerias o assert

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.edutecno.model.Contact;
import com.edutecno.service.ContactService;
import com.edutecno.service.ContactServiceImp;

@SpringBootTest
class ApplicationTests {
	
	private static ContactService contactService;//declaracion de servicio que se instanciara en el metodo setUp
	private static Contact contact;//declaracion de contact que se instancia en el metodo setUp 
	
	//declaracion de una instancia para ejecutar logger de informacion
		private final static Logger logger = LoggerFactory.getLogger(ApplicationTests.class);
	
	//ejecuta la instancia de ContactService
	@BeforeAll
	public static void setUp() {	
		contactService = new ContactServiceImp();//se instancia el servicio
		contact = new Contact();//instancia de objeto Contact para usarlo
	}
	
	//metodo para verificar que la lista que se obtiene del servicio mediante el metodo .getContactList()
	@Test
	@DisplayName("testObtenerLista()")
	public void testObtenerLista() {
		
		logger.info("ejecutando testObtenerLista()");//mensajes de informacion
		assertEquals(new ArrayList<Contact>(), contactService.getContactList()); //assertEquals(valorEsperado,actual)
		assertTrue(contactService.getContactList().isEmpty());
	}
	
	//metodo para verificar que la lista que se obtiene del servicio mediante el metodo .getContactList() no retorne null
	@Test
	@DisplayName("testNotNull")
	public void testNotNull() {
		
		logger.info("ejecutando testNotNull()");//mensaje de informacion
		assertNotNull(contactService.getContactList());
	}
	
	//metodo para verificar que el metodo addContact del servicio esta agregando el contact
	//verifica que la lista existente y que persiste contenga el contact en la posición 0
	@Test
	@DisplayName("testAddContact()")
	public void testAddContact() {
		contact.setId(1);
		contact.setNombre("Fulanito");
		contact.setTelefono("+569990001");
		contact.setApellidoMaterno("Apellido Materno");
		contact.setApellidoPaterno("Apellido Paterno");
		contact.setDireccion("Santiago");
		
		contactService.addContact(contact);//añadiendo el contacto
		
		logger.info("ejecutando testAddContact()");//mensaje de informacion
		assertEquals(contact, contactService.getContactList().get(0));//verificando el contacto existente mediante posicion
		assertEquals(contact.getNombre(), contactService.getContactList().get(0).getNombre());
		assertTrue(contact.getId() == 1);
	}
	
	//metodo para verificar que el metodo deleteContact del servicio esta eliminando el contact
	//verifica que luego de la eliminación la lista que retorna el metodo servicio getContactList(), el size sea 0
	@AfterAll
	@Test
	@DisplayName("testDeleteContact()")
	public static void testDeleteContact() {
		
		contactService.deleteContact(contact.getId()); //se borra el objeto mediante el servicio utilizando el contact instanciado en setUp
		
		logger.info("ejecutando testDeleteContact");//mensaje de informacion
		assertEquals(0, contactService.getContactList().size()); //assertEquals(esperado,actual)
	}
}
