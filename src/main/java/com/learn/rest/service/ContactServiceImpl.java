package com.learn.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.rest.entiy.Contact;
import com.learn.rest.exception.ContactExistException;
import com.learn.rest.exception.ContactNotFoundException;
import com.learn.rest.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {


    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) {
        if(contactRepository.findByEmail(contact.getEmail()) != null) {
            throw new ContactExistException("Contact with email " + contact.getEmail() + " already exist");
        }
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(Integer contactId) {
        if(!contactRepository.existsById(contactId)) {
            throw new ContactNotFoundException("Contact with id " + contactId + " not found")  ;
        }
        return contactRepository.findById(contactId).get();
    }

    @Override
    public void deleteContact(Integer contactId) {
        if(!contactRepository.existsById(contactId)) {
            throw new ContactNotFoundException("Contact with id " + contactId + " not found")  ;
        }
        contactRepository.deleteById(contactId);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getContactsByGroup(String group) {
       return contactRepository.findByContactGroup(group);
    }

    @Override
    public List<Contact> getContactsByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    public List<Contact> getContactsByLastName(String lastName) {
    
        return contactRepository.findByLastName(lastName);
    }

    @Override
    public Contact getContactByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

} 
