package mx.com.cinepolis.scheduler.service.impl;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.service.GitHubService;

public class GitHubServiceImpl implements GitHubService{

	@Override
	public GitHubUserTO getUsers(String login) {
		GitHubUserTO gitHubUserTo = new GitHubUserTO();
		gitHubUserTo.setLogin(login);
		gitHubUserTo.setName("Alfredo"+login);
		gitHubUserTo.setAvatar_url("https://avatars1.githubusercontent.com/u/38266308?v=4");
		gitHubUserTo.setFollowers("3");
		gitHubUserTo.setFollowing("10");
		gitHubUserTo.setPassword("123");
		
		return gitHubUserTo;
	}

	@Override
	public boolean getValidateUser(String user, String pass) {
		return (this.getUsers(user).getPassword().equals(pass));
	}

	@Override
	public void setUser(GitHubUserTO userTO) {
		System.out.println(userTO.getLogin());
		System.out.println(userTO.getName());
		System.out.println(userTO.getPassword());
	}
}
