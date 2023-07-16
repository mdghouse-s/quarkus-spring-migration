package com.learn.rest.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.learn.rest.dto.ContactDto;
import com.learn.rest.entiy.Contact;
import com.learn.rest.exception.ContactNotFoundException;
import com.learn.rest.mapper.ContactMapper;
import com.learn.rest.service.ContactService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class ContactController {

  
    private ContactService contactService;

    private ContactMapper contactMapper;

    @Inject
    public ContactController(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    
    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() throws UnknownHostException {
        final String lineSeparator = System.lineSeparator();
        final InetAddress localHost = InetAddress.getLocalHost();
        final String hostName = localHost.getHostName();
        final String hostAddress = localHost.getHostAddress();
        StringBuilder info = new StringBuilder();
        info.append("----------------------------------").append(lineSeparator);
        info.append("Contacts API by Quarkus : ").append("Version ").append("V2").append(lineSeparator);
        info.append("Host : ").append(hostName).append(lineSeparator);
        info.append("IP : ").append(hostAddress).append(lineSeparator);
        info.append("----------------------------------").append(lineSeparator);
        return info.toString();
     }

    @Path("/contacts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactDto> getContacts() {
        return contactMapper.contactsToContactDtos(contactService.getAllContacts());
    }

    @GET
    @Path("/contacts/{contactId}")
    public ContactDto getContactById(@PathParam("contactId") Integer contactId) throws ContactNotFoundException {
        return contactMapper.contactToContactDto(contactService.getContactById(contactId));
    }
    
    @POST
    @Path("/contacts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contact addContact(ContactDto contact) {
        return contactService.createContact(contactMapper.contactDtoToContact(contact));
    }

    @DELETE
    @Path("/contacts/{contactId}")
    public Response addContact(@PathParam("contactId") Integer contactId) throws ContactNotFoundException {
        contactService.deleteContact(contactId);
        return Response.ok().build();
    }

    @GET
    @Path("/contacts/group/{group}")
    public List<ContactDto> getContactsByGroup(@PathParam("group") String group) {
        return contactMapper.contactsToContactDtos(contactService.getContactsByGroup(group));
    }

    @GET
    @Path("/contacts/firstName/{firstName}")
    public List<ContactDto> getContactsByFirstName(@PathParam("firstName") String firstName) {
        return contactMapper.contactsToContactDtos(contactService.getContactsByFirstName(firstName));
    }

    @GET
    @Path("/contacts/lastName/{lastName}")
    public List<ContactDto> getContactsByLastName(@PathParam("lastName") String lastName) {
        return contactMapper.contactsToContactDtos(contactService.getContactsByLastName(lastName));
    }

    @GET
    @Path("/contacts/email/{email}")
    public ContactDto getContactByEmail(@PathParam("email") String email) {
        return contactMapper.contactToContactDto(contactService.getContactByEmail(email));
    }
}
