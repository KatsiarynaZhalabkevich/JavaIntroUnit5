package by.epam.intro.finmanager.dao;


import by.epam.intro.finmanager.bean.Transaction;

public interface TransactionDAO {

	boolean addTransaction(Transaction transaction) throws DAOException;

	boolean editTransaction(Transaction transaction, String value1, String value2) throws DAOException;
	
	boolean deleteTransaction(Transaction transaction) throws DAOException;

	boolean findTransaction(String value) throws DAOException;
}
