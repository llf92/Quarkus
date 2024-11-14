package uk.ac.newcastle.enterprisemiddleware.commodity;

import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;


/**
 * <p>This class produces a RESTful service exposing the functionality of {@link CommodityService}.</p>
 *
 * <p>The Path annotation defines this as a REST Web Service using JAX-RS.</p>
 *
 * <p>By placing the Consumes and Produces annotations at the class level the methods all default to JSON.  However, they
 * can be overriden by adding the Consumes or Produces annotations to the individual methods.</p>
 *
 * <p>It is Stateless to "inform the container that this RESTful web service should also be treated as an EJB and allow
 * transaction demarcation when accessing the database." - Antonio Goncalves</p>
 *
 * <p>The full path for accessing endpoints defined herein is: api/contacts/*</p>
 *
 * @author Joshua Wilson
 * @see CommodityService
 * @see Response
 */
@Path("/commodity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommodityRestService {
    @Inject
    @Named("logger")
    Logger log;

    @Inject
    private CommodityService service;

    @GET
    @Path("/taxis")
    @Operation(summary = "Fetch all Taxis", description = "Returns a JSON array of all stored Taxis objects.")
    public Response findAllTaxis() {

        return Response.ok(service.findAllTaxis()).build();
    }


}