package by.epam.intro.finmanager.controller;

import by.epam.intro.finmanager.command.Command;
import by.epam.intro.finmanager.command.CommandProvider;


public class Controller {

	public String doAction(String request) {
		// строка запроса, где известно на каких местах лежа нобходимые параметры
		final CommandProvider commandProvider = new CommandProvider();
		String commandName;
		String response;
		Command command;
		
		commandName = request.split(" ")[0]; // 0-ой элемент массива
		command = commandProvider.getCommand(commandName);
		response = command.execute(request);
		
		return response;
	}

}
