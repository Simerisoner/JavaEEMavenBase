package mx.com.cinepolis.scheduler.service;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;

public interface GitHubService {
	GitHubUserTO getUsers(String login);
	boolean getValidateUser(String user, String pass);
	void setUser(GitHubUserTO userTO);
}
