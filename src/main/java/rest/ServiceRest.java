package rest;

import javax.ws.rs.Path;

import services.ServiceService;

@Path("/")
public class ServiceRest {

	public static final int NUMBER_OF_POST = 1;

	public ServiceService serviceService;

	public void setServiceService(final ServiceService serviceService) {
		this.serviceService = serviceService;
	}

}
