package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Contact;

public interface ContactService {

	public String saveContact(Contact contact);
	public String deletecontactById(Integer contactId);
	public String updatecontact(Contact contact);
	public List<Contact> getallcontact();
	public Contact getcontactByid(Integer contactId);

}
