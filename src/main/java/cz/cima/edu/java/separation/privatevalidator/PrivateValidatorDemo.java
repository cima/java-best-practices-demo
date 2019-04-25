package cz.cima.edu.java.separation.privatevalidator;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import cz.cima.edu.java.separation.model.DemoDb;
import cz.cima.edu.java.separation.model.EmailMismatchException;

public class PrivateValidatorDemo {
	private DemoDb userDB;
	
	public String onRegistration(String username, String email, String displayName) throws EmailMismatchException {
		
		if(validateUserRecord(username, email, displayName)) {
			return userDB.createUser(username, email, displayName);
		} else {
			throw new EmailMismatchException();
		}
		
	}
	
	private boolean validateUserRecord(String username, String email, String displayName) {
		if( ! email.startsWith(username)) {
			return false;
		}
		
		if( ! displayName.replace(' ', '.').toLowerCase().equals(username)) {
			return false;
		}
		
		try {
			URL emailDomain = new URL("https://" + email.substring(email.indexOf("@")) + "/");
			
			HttpsURLConnection connection = (HttpsURLConnection)emailDomain.openConnection();	
			
			if(connection.getResponseCode() != 200) {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
