package by.epam.intro.finmanager.dao.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import by.epam.intro.finmanager.bean.Transaction;
import by.epam.intro.finmanager.dao.DAOException;
import by.epam.intro.finmanager.dao.TransactionDAO;
import by.epam.intro.finmanager.dao.util.ChangeTransParam;
import by.epam.intro.finmanager.dao.util.FileInfoReader;
import by.epam.intro.finmanager.dao.util.FileInfoWriter;

public class FileTransactionDAO implements TransactionDAO {

	private static final String TRANSACTION_SOURCE = "src\\by\\epam\\intro\\finmanager\\resource\\banking.txt";
	private static final String RESULT_SOURCE = "src\\by\\epam\\intro\\finmanager\\resource\\result.txt";

	@Override
	public boolean addTransaction(Transaction transaction) throws DAOException {

		String addTrans = " " + transaction.getId() + " " + transaction.getDate() + " " + transaction.getType() + " "
				+ transaction.getSum()+"\n";

		return FileInfoWriter.writeNote(TRANSACTION_SOURCE, addTrans);

	}

	@Override
	public boolean findTransaction(String value) throws DAOException {

		boolean result = false;

		List<String> lst = new ArrayList<>();
		List<String> lstFinal = new ArrayList<>();

		lst = FileInfoReader.readNote(TRANSACTION_SOURCE);

		for (String string : lst) {
			String[] params = string.split(" "); // разбиваем строку на куски

			for (String str : params) {
				if (value.equals(str)) // проверяем на соответствие и забираем в новый список
					lstFinal.add(string);
			}
		}

		for (String str : lstFinal) {
			str = str.concat("\n");
			FileInfoWriter.writeNote(RESULT_SOURCE, str);

		}
		result = true;

		return result;
	}

	@Override
	public boolean editTransaction(Transaction transaction, String value1, String value2) throws DAOException {
		boolean result = false;
		String trBefore;
		PrintWriter pw;
		List<String> lst;
		int i = -1;

		trBefore = " " + transaction.getId() + " " + transaction.getDate() + " " + transaction.getType() + " "
				+ transaction.getSum(); // исходная строка

		lst = FileInfoReader.readNote(TRANSACTION_SOURCE);

		i = lst.indexOf(trBefore);
		lst.remove(i);
		lst.add(i, ChangeTransParam.changeParam(transaction, value1, value2));

		try {
			pw = new PrintWriter(TRANSACTION_SOURCE);
			pw.close();
		} catch (FileNotFoundException e) {
			result = false;
			throw new DAOException(e);

		}

		for (String s : lst) {
			if (FileInfoWriter.writeNote(TRANSACTION_SOURCE, s.concat("\n")))
				result = true;
		}

		return result;
	}

	@Override
	public boolean deleteTransaction(Transaction transaction) throws DAOException {
		boolean result = false;
		String trDelete;
		PrintWriter pw;
		List<String> lst;
		int i = -1;
		trDelete = " " + transaction.getId() + " " + transaction.getDate() + " " + transaction.getType() + " "
				+ transaction.getSum(); // исходная строка

		lst = FileInfoReader.readNote(TRANSACTION_SOURCE);

		i = lst.indexOf(trDelete);
		lst.remove(i);
		

		try {
			pw = new PrintWriter(TRANSACTION_SOURCE);
			pw.close();
		} catch (FileNotFoundException e) {
			result = false;
			throw new DAOException(e);

		}

		for (String s : lst) {
			if (FileInfoWriter.writeNote(TRANSACTION_SOURCE, s.concat("\n")))
				result = true;
		}
		
		return result;
	}

}
