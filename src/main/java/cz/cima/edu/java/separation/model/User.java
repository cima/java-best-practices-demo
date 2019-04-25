package cz.cima.edu.java.separation.model;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class User {

	private String username;
	private String email;
	private String displayName;
	private String id;
	
	public User(String username, String email, String displayName, String id) throws EmailMismatchException, IOException {
		if( ! email.startsWith(username)) {
			throw new EmailMismatchException();
		}
		
		if( ! displayName.replace(' ', '.').toLowerCase().equals(username)) {
			throw new EmailMismatchException();
		}
		
		
		URL emailDomain = new URL("https://" + email.substring(email.indexOf("@")) + "/");
		
		HttpsURLConnection connection = (HttpsURLConnection)emailDomain.openConnection();	
		
		if(connection.getResponseCode() != 200) {
			throw new EmailMismatchException();
		}
		
		this.username = username;
		this.email = email;
		this.displayName = displayName;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
