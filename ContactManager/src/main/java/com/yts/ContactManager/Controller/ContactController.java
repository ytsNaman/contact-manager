package com.yts.ContactManager.Controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yts.ContactManager.Entity.Contact;
import com.yts.ContactManager.Repository.ContactRepository;
import com.yts.ContactManager.Service.ContactService;

import jakarta.validation.Valid;

@Controller
public class ContactController {

	private final ContactService contactService;

	public ContactController(ContactService contactService) {
		super();

		this.contactService = contactService;
	}
 // home page listing all contacts
	@GetMapping("/contacts")
	public String viewAllContacts(Model model) {
		List<Contact> contacts = contactService.getAllContacts();

		model.addAttribute("contacts", contacts);
		return "list";
	}

	// searching contact
	@GetMapping("/search")
	public String Searching(@RequestParam("query") String query, Model model) {
		List<Contact> results = contactService.Searching(query);
		model.addAttribute("contacts", results);
		model.addAttribute("query", query);
		return "list";
	}

	// add contact form
	@GetMapping("/add")
	public String newContactForm(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("contact", new Contact());
		redirectAttributes.addFlashAttribute("message", "Contact added Succesfully");
		return "add";
	}

	// handler method for add contact form

	@PostMapping("/add")
	public String newContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {

			return "add";
		}
		if(contactService.contactExistsByPhone(contact.getPhone())) {
			model.addAttribute("errorMessage", "Contact with this phone number already exists!" );
			return "add";
		}
		contactService.newContact(contact);
		redirectAttributes.addFlashAttribute("message", "Contact added Succesfully");
		return "redirect:/contacts";
	}
	
 // delete contact with id
	@GetMapping("/delete/{id}")
	public String deleteContact(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		contactService.deleteContact(id);
		redirectAttributes.addFlashAttribute("message", "Contact Deleted Succesfully");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		return "redirect:/contacts";
	}

	// show edit contact form
	@GetMapping("/edit/{id}")
	public String updateContactForm(@PathVariable Long id, Model model) {

		Contact contact = contactService.getContactById(id);

		model.addAttribute("contact", contact);

		return "edit";
	}

	// handler method for editing contact
	@PostMapping("/update")
	public String updateContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("contact", contact);
			return "edit";
		}
		contactService.newContact(contact);
		redirectAttributes.addFlashAttribute("message", "Contact edited succesfully");
		return "redirect:/contacts";
	}

}
