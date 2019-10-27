package by.epam.intro.finmanager.dao;

import by.epam.intro.finmanager.bean.User;

public interface UserDAO {

	boolean authorization(String login, String password) throws DAOException;

	void registration(User user) throws DAOException;

}
