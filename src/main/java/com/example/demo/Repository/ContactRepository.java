package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{

}
