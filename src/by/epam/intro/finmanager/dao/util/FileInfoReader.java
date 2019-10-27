package by.epam.intro.finmanager.dao.util;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import by.epam.intro.finmanager.dao.DAOException;

public class FileInfoReader implements Closeable{
	
	public static List<String> readNote(String path) throws DAOException {
	List <String> lst = new ArrayList<>();
	
	try {
		lst =	Files.readAllLines(Paths.get(path));
	} catch (IOException e) {
		throw new DAOException(e);
	}
		return lst;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
