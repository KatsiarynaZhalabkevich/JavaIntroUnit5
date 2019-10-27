package by.epam.intro.finmanager.dao;

import by.epam.intro.finmanager.dao.impl.FileTransactionDAO;
import by.epam.intro.finmanager.dao.impl.FileUserDAO;

public class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();
	
	private DAOFactory() {}
	
	public static DAOFactory getInstance() {
		return instance;
	}

	private UserDAO userDao = new FileUserDAO();
	private TransactionDAO transactionDao = new FileTransactionDAO();

	public UserDAO getUserDao() {
		return userDao;
	}

	public TransactionDAO getTransactionDao() {
		return transactionDao;
	}

}
