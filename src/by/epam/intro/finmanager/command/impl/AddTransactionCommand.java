package by.epam.intro.finmanager.command.impl;

import by.epam.intro.finmanager.bean.Transaction;
import by.epam.intro.finmanager.command.Command;
import by.epam.intro.finmanager.service.ServiceException;
import by.epam.intro.finmanager.service.ServiceFactory;
import by.epam.intro.finmanager.service.TransactionService;

public class AddTransactionCommand implements Command{

	@Override
	public String execute(String request) {
		String [] params = request.split(" ");
		String date;
		String type;
		long sum;
		String response;
		//String request1 = "addTransaction date=05.10.2019 type=Booking.com sum=-600";
		//продумать вариант, если придет не полная информация
		
		date = params[1].split("=")[1];
		type = params[2].split("=")[1];
		sum = Long.parseLong(params[3].split("=")[1]);
		
		//bean контактируют со всеми слоями, к ним можно обращаться в любом слое
		Transaction transaction = new Transaction(date, type, sum);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		TransactionService transactionService = serviceFactory.getTransactionService();
		
		try {
			if(transactionService.addTransaction(transaction)) {
				response="Transaction was added successfull! ";
			}else response="Transaction was rejected!";
		} catch (ServiceException e) {
			System.err.println(e);
			response = "Please, try again letter!";
		}
		
		
		return response;
	}

}
