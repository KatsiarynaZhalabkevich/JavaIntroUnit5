package by.epam.intro.finmanager.service.util;

import by.epam.intro.finmanager.bean.Transaction;

public class Validation {

	// валидаторы не выбрасывают исключений (есть 2 сценария: все ок вы
	// авторизированы, пароль/логин не совпал - не авторизированы)
	public static boolean isValidLog(String login, String password) {
		// продумать валидацию: длина пароля, запрещенные символы и тд.

		if (login != null && password != null) {
			return true;
		} else
			return false;
	}

	public static boolean isValidTrans(String date, String type, long sum) {
		boolean result = false;
		// дата не содержит символов
		if (date != null && sum != 0 && type != null) {
			// if (date.matches("[0-9-.]")) { //разобраться с регулярными выражениями
			result = true;

		} else
			result = false;

		return result;
	}

	public static boolean isValidParam(String value) {
		if (value != null) {
			return true;
		} else
			return false;
	}

	public static boolean isValidEditParam(String value1, String value2) {
		if (value1 != null && value2 != null) {
			return true;
		} else
			return false;
	}

	

}
