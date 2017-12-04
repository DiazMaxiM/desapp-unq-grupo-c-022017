package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import services.ScoreService;

public class ScoreRest {
	
	private ScoreService scoreService;
	
	public void setScoreService(final ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	
	@GET
	@Path("/scorePending/{idClient}")
	@Produces("application/json")
	public Response hasScorePending(@PathParam("idClient") final String idClient) {
		return Response.ok(scoreService.hasPendingScoreForClient(idClient)).build();
	}
	
	@GET
	@Path("/scoresClient/{idClient}")
	@Produces("application/json")
	public Response scores(@PathParam("idClient") final String idClient) {
		return Response.ok(scoreService.scores(idClient)).build();
	}

}
