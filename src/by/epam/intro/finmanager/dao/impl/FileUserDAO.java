package by.epam.intro.finmanager.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.epam.intro.finmanager.bean.User;
import by.epam.intro.finmanager.dao.DAOException;
import by.epam.intro.finmanager.dao.UserDAO;

public class FileUserDAO implements UserDAO {

	private static final String USER_SOURCE = "src\\by\\epam\\intro\\finmanager\\resource\\authInfo.txt"; // закинуть в
																											// энам

	@Override
	public boolean authorization(String login, String password) throws DAOException {

		String logPas = login.concat(" ").concat(password);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(USER_SOURCE));
			String userInfo = reader.readLine();
			if (logPas.equals(userInfo)) {
				return true;
			}
			return false;

		} catch (FileNotFoundException e) {
			throw new DAOException(e);

		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {

				throw new DAOException(e);
			}
		}

		// описать то, что мы ищем и делаем

	}

	@Override
	public void registration(User user) {
		// TODO Auto-generated method stub

	}

}
