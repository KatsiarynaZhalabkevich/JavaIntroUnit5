package by.epam.intro.finmanager.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.intro.finmanager.command.impl.AddTransactionCommand;
import by.epam.intro.finmanager.command.impl.AuthorizationCommand;
import by.epam.intro.finmanager.command.impl.DeleteTransactionCommand;
import by.epam.intro.finmanager.command.impl.EditTransactionCommand;
import by.epam.intro.finmanager.command.impl.FindTransactionCommand;

public class CommandProvider {
	private Map<String, Command> commands;
	
	public CommandProvider() {
		commands = new HashMap<String, Command>();
		commands.put("authorization", new AuthorizationCommand());
		commands.put("addTransaction", new AddTransactionCommand());
		commands.put("findTransaction", new FindTransactionCommand());
		commands.put("editTransaction", new EditTransactionCommand());
		commands.put("deleteTransaction", new DeleteTransactionCommand());
		
	}
	
	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
