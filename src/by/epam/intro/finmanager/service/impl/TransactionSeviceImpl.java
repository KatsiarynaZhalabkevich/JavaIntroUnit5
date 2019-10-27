package by.epam.intro.finmanager.service.impl;

import java.util.List;

import by.epam.intro.finmanager.bean.Transaction;
import by.epam.intro.finmanager.dao.DAOException;
import by.epam.intro.finmanager.dao.DAOFactory;
import by.epam.intro.finmanager.dao.TransactionDAO;
import by.epam.intro.finmanager.service.ServiceException;
import by.epam.intro.finmanager.service.TransactionService;
import by.epam.intro.finmanager.service.util.Validation;

public class TransactionSeviceImpl implements TransactionService {

	@Override
	public boolean addTransaction(Transaction transaction) throws ServiceException {

		String date = transaction.getDate();
		String type = transaction.getType();
		long sum = transaction.getSum();

		if (!Validation.isValidTrans(date, type, sum)) {
			throw new ServiceException("Transaction information is not valid! ");
		}

		DAOFactory factory = DAOFactory.getInstance();
		TransactionDAO transactionDAO = factory.getTransactionDao();

		try {
			if (transactionDAO.addTransaction(transaction)) {
				return true;
			} else
				return false;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean findTransaction(String value) throws ServiceException {
		if (!Validation.isValidParam(value)) {
			throw new ServiceException("Transaction parameter is not valid! ");
		}
		DAOFactory factory = DAOFactory.getInstance();
		TransactionDAO transactionDAO = factory.getTransactionDao();

		try {
			if (transactionDAO.findTransaction(value)) {
				return true;
			} else
				return false;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean editTransaction(Transaction transaction, String value1, String value2) throws ServiceException {
		if (!Validation.isValidEditParam(value1, value2)) {
			throw new ServiceException("Transaction parameters are not valid! ");
		}

		DAOFactory factory = DAOFactory.getInstance();
		TransactionDAO transactionDAO = factory.getTransactionDao();
		
		try {
			if (transactionDAO.editTransaction(transaction, value1, value2)) {
				return true;
			} else
				return false;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
	public boolean deleteTransaction(Transaction transaction) throws ServiceException {
		boolean result = false;
		//проверку транзакции не делаю, она ведь уже сформирована, а если ее не будет, то просто ничего не удалим
		
		DAOFactory factory = DAOFactory.getInstance();
		TransactionDAO transactionDAO = factory.getTransactionDao();
		
		try {
			if (transactionDAO.deleteTransaction(transaction)) {
				result = true;
			} else
				result = false;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return result;
	}

}
