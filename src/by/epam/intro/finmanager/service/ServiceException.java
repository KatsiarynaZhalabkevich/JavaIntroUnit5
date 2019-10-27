package by.epam.intro.finmanager.service;

public class ServiceException extends Exception {

	static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String m) {
		super(m);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String m, Exception e) {
		super(m, e);
	}
}
