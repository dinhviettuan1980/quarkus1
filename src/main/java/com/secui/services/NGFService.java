package com.secui.services;

import com.secui.models.NGFLoginParams;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

//@Path("/api")
@RegisterRestClient
public interface NGFService{

    @POST
    @Path("/au/external/login")
    Response callLoginNGF(NGFLoginParams payloadToSend);

    @DELETE
    @Path("/au/external/logout")
    Response callLogoutNGF(@HeaderParam("Authorization") String token);

    @Path("/sm/info/operation")
    @GET
    Response callOperationInfoNGF(@HeaderParam("Authorization") String token);
}
