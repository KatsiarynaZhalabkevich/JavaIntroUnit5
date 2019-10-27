package by.epam.intro.finmanager.service;

import java.util.List;

import by.epam.intro.finmanager.bean.Transaction;

public interface TransactionService {
	boolean addTransaction(Transaction transaction) throws ServiceException;

	boolean findTransaction(String value) throws ServiceException;

	boolean editTransaction(Transaction transaction, String value1, String value2) throws ServiceException;

	boolean deleteTransaction(Transaction transaction)throws ServiceException;

}
