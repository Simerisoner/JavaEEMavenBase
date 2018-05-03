package mx.com.cinepolis.schedule.rest;

import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.StatusLoginTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;
import mx.com.cinepolis.scheduler.facade.CatalogFacadeEJB;
import mx.com.cinepolis.scheduler.facade.GitHubFacadeEJB;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author jrodriguez
 */
@Path("/catalog")
public class CatalogRest {

    @EJB
    private CatalogFacadeEJB catalogFacadeEJB;
    @EJB
    private GitHubFacadeEJB gitHubFacadeEJB;


    @GET
    @Produces("application/json")
    @Path("/user")
    public Response getSimpleCatalog()
    {
        UserTO userTO = catalogFacadeEJB.getSimpleUser();
        return Response.ok().entity(userTO).build();
    }
    
    @GET
	@Produces("application/json")
	@Path("/country")
    //country?pais=Mexico
	public Response getEstados(@Context UriInfo ui){
    	
    	MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
    	String pais = queryParams.getFirst("pais");
    	
		List<CatalogsTO> catalogsTOList = catalogFacadeEJB.getEstadosList(pais);
		GenericEntity<List<CatalogsTO>> entity = new GenericEntity<List<CatalogsTO>>(catalogsTOList) {};
		return Response.ok().entity(entity).build();
	}
    
    @GET
    @Produces("application/json")
    @Path("/users")
    public Response getSimpleUser(@Context UriInfo ui) {
    	MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
    	String login = queryParams.getFirst("login");
    	GitHubUserTO gitHubUsersTO = gitHubFacadeEJB.getSimpleUser(login);
    	
		return Response.ok().entity(gitHubUsersTO).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/login")
    public Response validateUser(@Context UriInfo ui) {
    	MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
    	String user = queryParams.getFirst("user");
    	String pass = queryParams.getFirst("pass");
    	Boolean gitHubUseTo = gitHubFacadeEJB.getValidateUser(user, pass);
    	
    	StatusLoginTO login = new StatusLoginTO();
    	login.setStatus(gitHubUseTo);
    	
    	return Response.ok().entity(login).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/alta")
    public void setAlta(GitHubUserTO gitHubUserTO) {
    	gitHubFacadeEJB.setUser(gitHubUserTO);
    }
    
//	@GET
//	@Produces("application/json")
//	@Path("/country/{pais}")
//	public Response getEstados(@PathParam("pais") String pais)
//	{
//		List<CatalogsTO> catalogsTOList = catalogFacadeEJB.getEstadosList(pais);
//		GenericEntity<List<CatalogsTO>> entity = new GenericEntity<List<CatalogsTO>>(catalogsTOList) {};
//		return Response.ok().entity(entity).build();
//	}
}
