package com.learn.rest.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.enterprise.context.ApplicationScoped;

import com.learn.rest.entiy.Contact;



@ApplicationScoped
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByContactGroup(String group);

    List<Contact> findByFirstName(String firstName);

    List<Contact> findByLastName(String lastName);

    Contact findByEmail(String email);



}
