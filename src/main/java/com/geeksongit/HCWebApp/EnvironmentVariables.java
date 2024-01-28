package com.geeksongit.HCWebApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentVariables {

	@Value("${APP_USERNAME:#{null}}")
	private String appUsername;
	
	@Value("${APP_PASSWORD:#{null}}")
	private String AppPassword;
	
	public String getAppUsername() {
		return appUsername;
	}

	public void setAppUsername(String appUsername) {
		this.appUsername = appUsername;
	}

	public String getAppPassword() {
		return AppPassword;
	}

	public void setAppPassword(String appPassword) {
		AppPassword = appPassword;
	}

	
}
