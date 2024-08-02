package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Contact;
import com.example.demo.JpaRepository.ContactRepository;

@Service
public class ContactImpService implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override // SAVECONTACT
	public String saveContact(Contact contact) {
		contact = repo.save(contact);
		if (contact.getContactId() != null) {
			return "save contact";

		} else {
			return "not save";
		}

	}

	@Override // delete record
	public String deletecontactById(Integer contactId) {
		if (repo.existsById(contactId)) {
			repo.deleteById(contactId);
		}
		return "contact deleted";
	}

	@Override//UPDATE
	public String updatecontact(Contact contact) {
		if (repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "update save";
		} else {
			return "not record found";
		}

	}

	@Override // fin all record
	public List<Contact> getallcontact() {
		return repo.findAll();

	}

	@Override///find by id
	public Contact getcontactByid(Integer contactId) {
		Optional<Contact> byId = repo.findById(contactId);
		if (byId.isPresent()) {
		return	byId.get();

		}
		
		return null;

	}

}
