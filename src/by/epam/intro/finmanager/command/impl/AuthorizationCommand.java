package by.epam.intro.finmanager.command.impl;

import by.epam.intro.finmanager.command.Command;
import by.epam.intro.finmanager.service.ServiceException;
import by.epam.intro.finmanager.service.ServiceFactory;
import by.epam.intro.finmanager.service.UserService;

public class AuthorizationCommand implements Command {

	@Override
	public String execute(String request) {
		String[] params = request.split(" ");
		String login;
		String password;
		String response;

		login = params[1].split("=")[1];
		password = params[2].split("=")[1];

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			if (userService.authorization(login, password)) {
				response = "Welcome, user!";
			}else response = "Wrong login or password!";
		} catch (ServiceException e) {
			e.printStackTrace();
			System.err.println(e);
			response = "Please, try again letter!";
		}

		return response;

	}

}
