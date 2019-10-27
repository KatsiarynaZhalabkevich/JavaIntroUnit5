package by.epam.intro.finmanager.command.impl;

import java.util.List;

import by.epam.intro.finmanager.bean.Transaction;
import by.epam.intro.finmanager.command.Command;
import by.epam.intro.finmanager.service.ServiceException;
import by.epam.intro.finmanager.service.ServiceFactory;
import by.epam.intro.finmanager.service.TransactionService;

public class FindTransactionCommand implements Command {

	@Override
	public String execute(String request) {

		String[] params = request.split(" ");
		String parameter;
		String value;

		List<Transaction> lst;

		long sum;
		String response;
		// String request1 = "addTransaction date=05.10.2019 type=Booking.com sum=-600";
		// продумать вариант, если придет не полная информация

		parameter = params[1].split("=")[0]; // вид параметра для поиска
		value = params[1].split("=")[1]; // значение параметра для поиска

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		TransactionService transactionService = serviceFactory.getTransactionService();

		try {
			if (transactionService.findTransaction(value)) {

				response = "Transaction(s) found! Information is in file result.txt";
			} else
				response = "No transaction with such parametr!";
		} catch (ServiceException e) {
			System.err.println(e);
			response = "Please, try again letter!";
		}

		return response;

	}

}
