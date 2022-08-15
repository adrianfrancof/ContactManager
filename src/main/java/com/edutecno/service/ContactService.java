package com.edutecno.service;

import java.util.List;

import com.edutecno.model.Contact;

public interface ContactService {
	
	public List<Contact> getContactList();
	public void addContact(Contact contacto);
	public void deleteContact(int id);

}
