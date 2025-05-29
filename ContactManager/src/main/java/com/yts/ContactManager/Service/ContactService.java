package com.yts.ContactManager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.yts.ContactManager.Entity.Contact;
import com.yts.ContactManager.Repository.ContactRepository;

@Service
public class ContactService {

	private final ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}
	// returns all contacts
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
	// creates new contact
	public void newContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	public boolean contactExistsByPhone(String phone) {
		return contactRepository.existsByPhone(phone);
	}
	
	// delete contact
	public void deleteContact(@PathVariable Long id) {
		contactRepository.deleteById(id);
	}
	
	// get a contact by its id
	public Contact getContactById( Long id) {
		Optional <Contact> result = contactRepository.findById(id);
		
		return result.orElse(null);
	}
	
	// searching a contact passing a query
	public List <Contact> Searching(String query){
		return contactRepository.findByNameContainingIgnoreCaseOrPhoneContaining(query , query);
	}
}
