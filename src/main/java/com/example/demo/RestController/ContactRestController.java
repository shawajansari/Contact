package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Contact;
import com.example.demo.Service.ContactImpService;

@RestController
public class ContactRestController {
	@Autowired
	private ContactImpService ser;

	@PostMapping("/contact")
	public String createConttact(@RequestBody Contact contact) {
		String status = ser.saveContact(contact);
		return status;

	}

	@GetMapping("/contacts")
	public List<Contact> getAllRecord() {
		return ser.getallcontact();
	}

	@GetMapping("contact/{contactId}")
	public Contact getById(@PathVariable Integer contactId) {
		return ser.getcontactByid(contactId);

	}

	@PutMapping("/contact")
	public String UpdateRecort(@RequestBody Contact contact) {
		return ser.updatecontact(contact);
	}

	@DeleteMapping("/contact/{contactId}")
	public String deleterecord(@PathVariable Integer contactId) {
		return ser.deletecontactById(contactId);
	}

}
