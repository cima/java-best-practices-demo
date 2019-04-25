package cz.cima.edu.java.separation.factory;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import cz.cima.edu.java.separation.model.DemoDb;
import cz.cima.edu.java.separation.model.EmailMismatchException;
import cz.cima.edu.java.separation.model.UnknownUserException;
import cz.cima.edu.java.separation.model.User;

public class FactoryDemo {
	
	private DemoDb userDB;
	private UserFactory userFactory;
	
	public User onLogin(String username) throws UnknownUserException {
		final Map<String, String> userRecord = userDB.getUserRecord(username);
		
		if(Objects.isNull(userRecord)) {
			throw new UnknownUserException();
		}

		try {
			
			return userFactory.createUser(
					username,
					userRecord.get("email"),
					userRecord.get("displayname"),
					userRecord.get("id"));
			
		} catch (EmailMismatchException | IOException e) {
			
			throw new UnknownUserException(e);
			
		}
	}
}
