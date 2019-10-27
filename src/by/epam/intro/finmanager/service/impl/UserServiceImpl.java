package by.epam.intro.finmanager.service.impl;

import by.epam.intro.finmanager.bean.User;
import by.epam.intro.finmanager.dao.DAOException;
import by.epam.intro.finmanager.dao.DAOFactory;
import by.epam.intro.finmanager.dao.UserDAO;
import by.epam.intro.finmanager.dao.impl.FileUserDAO;
import by.epam.intro.finmanager.service.ServiceException;
import by.epam.intro.finmanager.service.UserService;
import by.epam.intro.finmanager.service.util.Validation;

public class UserServiceImpl implements UserService {

	@Override
	public boolean authorization(String login, String password) throws ServiceException {
		// проверить логин и пароль ВСЕГДА ОБЯЗАТЕЛЬНО
		// всегда валидируют пришедшие им данные: что они даны, что они правильные, что
		// не используются запрещенные символы

		if (!Validation.isValidLog(login, password)) {
			throw new ServiceException("Wrong login or password!");
		}

		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDao();

		try {
			if (userDAO.authorization(login, password)) {
				return true;
			} else
				return false;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void registration(User user) {
		// TODO Auto-generated method stub

	}

}
