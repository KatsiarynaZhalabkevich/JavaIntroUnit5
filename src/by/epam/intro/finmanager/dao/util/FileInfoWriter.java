package by.epam.intro.finmanager.dao.util;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import by.epam.intro.finmanager.dao.DAOException;

public class FileInfoWriter implements Closeable{
	
	//метод записывает файл в конец по строкам
	public static boolean writeNote(String path, String note) throws DAOException {
		boolean result;
		try {
			Files.write(Paths.get(path), note.getBytes(), StandardOpenOption.APPEND);
			result= true;
		} catch (IOException e) {
			result = false;
			throw new DAOException(e);
			
		}
		return result;
	}
	
	
	
	

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
