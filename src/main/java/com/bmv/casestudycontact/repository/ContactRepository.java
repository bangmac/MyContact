package com.bmv.casestudycontact.repository;

import com.bmv.casestudycontact.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
//    List<Contact> findByNameContaining(String name);
    Page<Contact> findAllByNameContaining(String name, Pageable pageable);

}
