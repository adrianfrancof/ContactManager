package com.edutecno.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.model.Contact;

@Service("contactService")
public class ContactServiceImp implements ContactService {

	@Autowired
	Contact contact;

	List<Contact> listaContacts;

	public ContactServiceImp() {
		listaContacts = new ArrayList<Contact>();
	}
	@Override
	public List<Contact> getContactList(){
		return listaContacts;
	}

	@Override
	public void addContact(Contact contact) {
		
		int idMayor = 0;
		for (Contact contactTemp : listaContacts) {
			if (contactTemp.getId() > idMayor) {
				idMayor = contactTemp.getId();
			}
		}
		contact.setId(idMayor+1);
		listaContacts.add(contact);
	}

	@Override
	public void deleteContact(int id) {

		List<Contact> listaTemp = new ArrayList<Contact>();
		listaTemp.addAll(listaContacts);
		
		if (!listaContacts.isEmpty()) {
			
			try {
				for (Contact contactTemp : listaTemp) {
					if (contactTemp.getId() == id) {
						listaContacts.remove(contactTemp);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
