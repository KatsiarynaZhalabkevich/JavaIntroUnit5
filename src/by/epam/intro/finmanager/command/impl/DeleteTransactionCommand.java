package by.epam.intro.finmanager.command.impl;

import by.epam.intro.finmanager.bean.Transaction;
import by.epam.intro.finmanager.command.Command;
import by.epam.intro.finmanager.service.ServiceException;
import by.epam.intro.finmanager.service.ServiceFactory;
import by.epam.intro.finmanager.service.TransactionService;

public class DeleteTransactionCommand implements Command {

	@Override
	public String execute(String request) {
		String[] params = request.split(" ");
		int id;
		String date;
		String type;
		long sum;
		String response;
		
		id = Integer.parseInt(params[1]);
		date = params[2];
		type = params[3];
		sum = Long.parseLong(params[4]);
		
		Transaction transaction = new Transaction(date, type, sum);
		transaction.setId(id);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		TransactionService transactionService = serviceFactory.getTransactionService();
		
		try {
			if(transactionService.deleteTransaction(transaction)) {
				response="Transaction was deleted successfull! ";
			}else response="Operation 'Delete' was rejected!";
		} catch (ServiceException e) {
			System.err.println(e);
			response = "Please, try again letter!";
		}
		
		return response;
	}

}
