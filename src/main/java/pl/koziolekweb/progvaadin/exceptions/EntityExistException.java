package pl.koziolekweb.progvaadin.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public class EntityExistException extends RuntimeException{

	public EntityExistException() {
	}

	public EntityExistException(String message) {
		super(message);
	}

	public EntityExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityExistException(Throwable cause) {
		super(cause);
	}
}
