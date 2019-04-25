package cz.cima.edu.java.separation.objectvalidator;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class UserRegistrationValidator {

	public boolean validate(String username, String email, String displayName) {
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
