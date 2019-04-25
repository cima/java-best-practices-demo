package cz.cima.edu.java.separation.model;

public class UnknownUserException extends Exception {

	private static final long serialVersionUID = -7447716600935846562L;

	private Exception cause;
	
	public UnknownUserException(Exception cause) {
		this.setCause(cause);
	}

	public UnknownUserException() {
	}

	public Exception getCause() {
		return cause;
	}

	public void setCause(Exception cause) {
		this.cause = cause;
	}

}
