package com.bmv.casestudycontact.service;

import com.bmv.casestudycontact.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {

    Page<Contact> findAll(Pageable pageable);

//    Iterable<Contact> findAll();

    Page<Contact> findAllByNameContaining(String name, Pageable pageable);

//    List<Contact> search(String name);

    Contact findById(Long id);

    void save(Contact contact);

    void delete(Long id);
}
