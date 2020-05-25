package com.bmv.casestudycontact.service;

import com.bmv.casestudycontact.model.Contact;
import com.bmv.casestudycontact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> search(String name) {
        return contactRepository.findByNameContaining(name);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
