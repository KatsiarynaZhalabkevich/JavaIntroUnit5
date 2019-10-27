package by.epam.intro.finmanager.dao;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TransactionInfoReader implements Closeable {	
	private static final String TRANSACTION_SOURCE = "src\\by\\epam\\intro\\finmanager\\resource\\banking.txt";
	


String readNote() {
	try {
		Reader reader = new FileReader(TRANSACTION_SOURCE );
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return null;
}
/*try {
		reader = new FileReader(TRANSACTION_SOURCE );
		
	} catch (FileNotFoundException e) {
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
	}*/
	@Override
	public void close() throws IOException {
	//	reader.close();
		
	}

}
