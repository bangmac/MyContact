package com.bmv.casestudycontact.repository;

import com.bmv.casestudycontact.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    List<Contact> findByNameContaining(String name);
}
