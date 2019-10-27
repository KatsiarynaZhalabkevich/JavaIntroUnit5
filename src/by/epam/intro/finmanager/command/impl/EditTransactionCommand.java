package by.epam.intro.finmanager.command.impl;

import by.epam.intro.finmanager.bean.Transaction;
import by.epam.intro.finmanager.command.Command;
import by.epam.intro.finmanager.service.ServiceException;
import by.epam.intro.finmanager.service.ServiceFactory;
import by.epam.intro.finmanager.service.TransactionService;

public class EditTransactionCommand implements Command {

	@Override
	public String execute(String request) {
		request = "editTransaction 3 10.10.2019 Booking.com -600 sum=-600 sum=-900";
		String[] params = request.split(" ");
		int id;
		String date;
		String type;
		long sum;
		String value1;
		String value2;
		String response;
		
		
		id = Integer.parseInt(params[1]);
		date = params[2];
		type = params[3];
		sum = Long.parseLong(params[4]);
		value1=params[5].split("=")[1];
		value2=params[6].split("=")[1];
		

		Transaction transaction = new Transaction(date, type, sum);
		transaction.setId(id);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		TransactionService transactionService = serviceFactory.getTransactionService();
		
		try {
			if(transactionService.editTransaction(transaction, value1, value2)) {
				response="Transaction was updated successfull! ";
			}else response="Update was rejected!";
		} catch (ServiceException e) {
			System.err.println(e);
			response = "Please, try again letter!";
		}
		return response;
	}

}
