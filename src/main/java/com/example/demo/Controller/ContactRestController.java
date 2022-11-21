package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;


@RestController
public class ContactRestController {


	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contact")
	
	ResponseEntity<String> contact (@RequestBody Contact contact){
	
		String status=contactService.upsert(contact);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/contacts")
	ResponseEntity<List<Contact>> getContact(){
	List<Contact> getAllContact=	contactService.getAllContacts();
	
	return new ResponseEntity<>(getAllContact,HttpStatus.OK);
	
	}
	
	@GetMapping("/contact/{id}")
	ResponseEntity<Contact>getContact(@PathVariable int cid){
		Contact contact= contactService.getContact(cid);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}
	
	@DeleteMapping("/contact/delete/{id}")
	ResponseEntity<String> deleteContact(@PathVariable int cid){
		String contact=contactService.deleteContact(cid);
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
