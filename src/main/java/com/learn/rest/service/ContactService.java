package com.learn.rest.service;

import java.util.List;

import com.learn.rest.entiy.Contact;

public interface ContactService {

    Contact createContact(Contact contact);

    Contact updateContact(Contact contact);

    Contact getContactById(Integer contactId);

    void deleteContact(Integer contactId);

    List<Contact> getAllContacts();

    List<Contact> getContactsByGroup(String group);

    List<Contact> getContactsByFirstName(String firstName);

    List<Contact> getContactsByLastName(String lastName);

    Contact getContactByEmail(String email);

}