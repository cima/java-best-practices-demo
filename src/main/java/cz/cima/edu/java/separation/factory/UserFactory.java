package cz.cima.edu.java.separation.factory;

import java.io.IOException;

import cz.cima.edu.java.separation.model.EmailMismatchException;
import cz.cima.edu.java.separation.model.User;

public class UserFactory {

	public User createUser(String username, String email, String displayName, String id) throws EmailMismatchException, IOException {
		return new User(username, email, displayName, id);
	}

}
