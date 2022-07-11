package com.secui.controllers;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.secui.models.NGFLoginParams;
import com.secui.services.NGFService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestHeader;

@Path("/auth")
public class AuthApi {

    @Inject
    @RestClient
    NGFService ngfService;

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(String data) throws JsonProcessingException {
        Jsonb jsonb = JsonbBuilder.create();
        NGFLoginParams oNGFLoginParams = jsonb.fromJson(data, NGFLoginParams.class);

        Response res = ngfService.callLoginNGF(oNGFLoginParams);

        return res;
    }

    @Path("/logout")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logout(@RestHeader("Authorization") String token) throws JsonProcessingException {
        Response res = ngfService.callLogoutNGF(token);
        return res;
    }
}