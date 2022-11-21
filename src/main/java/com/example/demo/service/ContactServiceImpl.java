package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ContactRepository;
import com.example.demo.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String upsert(Contact contact) {
		contact.setActiveSw("Y");
		Contact save = contactRepository.save(contact);
		return "success";
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return (List<Contact>) contactRepository.findAll();
	}

	@Override
	public Contact getContact(int cid) {
		Optional<Contact> findById = contactRepository.findById(cid);
		if (findById.isPresent()) {

			return findById.get();
		}
		return null;
	}

	@Override
	public String deleteContact(int cid) {
		Optional<Contact> findById = contactRepository.findById(cid);
		if (findById.isPresent()) {

		Contact contact=	findById.get();
		contact.setActiveSw("N");
		contactRepository.save(contact);
		}
	//	contactRepository.deleteById(cid);
		return "success";
	}

}
