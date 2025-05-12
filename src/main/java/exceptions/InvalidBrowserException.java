package exceptions;

public class InvalidBrowserException extends RuntimeException{
	
	public InvalidBrowserException()
	{
		super("Invalid browser choosen.. Please select correct browser");
	}

}
