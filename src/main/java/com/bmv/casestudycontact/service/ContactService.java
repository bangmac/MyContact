package com.bmv.casestudycontact.service;

import com.bmv.casestudycontact.model.Contact;

import java.util.List;

public interface ContactService {

    Iterable<Contact> findAll();

    List<Contact> search(String name);

    Contact findById(Integer id);

    void save(Contact contact);

    void delete(Integer id);
}
