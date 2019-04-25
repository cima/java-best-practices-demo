package cz.cima.edu.java.separation.objectvalidator;

import cz.cima.edu.java.separation.model.DemoDb;
import cz.cima.edu.java.separation.model.EmailMismatchException;

public class ObjectValidatorDemo {
	private DemoDb userDB;
	private UserRegistrationValidator userRegistrationValidator;
	
	public String onRegistration(String username, String email, String displayName) throws EmailMismatchException {
		
		if(userRegistrationValidator.validate(username, email, displayName)) {
			return userDB.createUser(username, email, displayName);
		} else {
			throw new EmailMismatchException();
		}
		
	}
}
