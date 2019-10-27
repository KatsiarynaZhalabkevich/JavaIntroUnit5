package by.epam.intro.finmanager.service;

import by.epam.intro.finmanager.bean.User;

public interface UserService {
	boolean authorization(String login, String password) throws ServiceException;

	void registration(User user) throws ServiceException;

}
