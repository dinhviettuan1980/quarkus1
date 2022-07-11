package com.secui.controllers;

import com.secui.models.Person;
import com.secui.models.PersonRepository;
import com.secui.models.Status;
import com.secui.services.NGFService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestHeader;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.Month;

@Path("/person")
public class PersonApi {

    @Inject
    PersonRepository personRepository;

    @Path("/create")
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(String data) {
        Person person = new Person();
        person.setName("tuan1");
        person.setBirth(LocalDate.of(1910, Month.FEBRUARY, 1));
        person.setStatus(Status.Alive);

        // persist it
        personRepository.persist(person);
        return "ok";
    }

    @GET
    @Path("/count")
    public long count(){
        return personRepository.count();
    }

}
