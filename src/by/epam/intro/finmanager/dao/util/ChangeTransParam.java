package by.epam.intro.finmanager.dao.util;

import by.epam.intro.finmanager.bean.Transaction;

public class ChangeTransParam {
	
	public static String changeParam(Transaction transaction, String value1, String value2) {
		String trAfter;
		if (value1.equals(String.valueOf(transaction.getId()))) {
			transaction.setId(Integer.parseInt(value2));
		}
		if (value1.equals(transaction.getDate())) {
			transaction.setDate(value2);
		}
		if (value1.equals(transaction.getType())) {
			transaction.setType(value2);
		}
		if (value1.equals(String.valueOf(transaction.getSum()))) {
			transaction.setSum(Long.parseLong(value2));
		}

		trAfter = " " + transaction.getId() + " " + transaction.getDate() + " " + transaction.getType() + " "
				+ transaction.getSum() + "\n"; // конечная строка
	
	return trAfter;
	}

}
