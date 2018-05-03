package mx.com.cinepolis.scheduler.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.service.GitHubService;


@Stateless
@LocalBean
public class GitHubFacadeEJB {
	
	@Inject
	GitHubService gitHubService;
	
	public GitHubUserTO getSimpleUser(String login) {
		return gitHubService.getUsers(login);
	}
	
	public boolean getValidateUser(String user, String pass) {
		return gitHubService.getValidateUser(user, pass);
	}
	public void setUser(GitHubUserTO userTO) {
		gitHubService.setUser(userTO);
	}
}
