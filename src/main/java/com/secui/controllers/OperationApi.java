package com.secui.controllers;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.secui.services.NGFService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestHeader;

@Path("/operation")
public class OperationApi {

    @Inject
    @RestClient
    NGFService ngfService;

    @Path("/info")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response operationInfo(@RestHeader("Authorization") String token) {
        Response res = ngfService.callOperationInfoNGF(token);
        return res;
    }

}
