package by.epam.intro.finmanager.service;

import by.epam.intro.finmanager.service.impl.TransactionSeviceImpl;
import by.epam.intro.finmanager.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	private UserService userService = new UserServiceImpl();
	private TransactionService transactionService = new TransactionSeviceImpl();

	public UserService getUserService() {
		return userService;
	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

}
