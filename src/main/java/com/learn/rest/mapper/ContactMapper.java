package com.learn.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.learn.rest.dto.ContactDto;
import com.learn.rest.entiy.Contact;

import jakarta.enterprise.context.ApplicationScoped;

@Mapper
// @ApplicationScoped
public interface ContactMapper {

    Contact contactDtoToContact(ContactDto contactDto);

    ContactDto contactToContactDto(Contact contact);

    List<ContactDto> contactsToContactDtos(List<Contact> contacts);

    List<Contact> contactDtosToContacts(List<ContactDto> contactDtos);

}