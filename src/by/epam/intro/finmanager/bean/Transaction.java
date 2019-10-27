package by.epam.intro.finmanager.bean;

import java.io.Serializable;

public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;

	{
		++idGenerator;  //это антипаттерн, надо реализовать это иначе
	}

	private static int idGenerator = 0;
	private int id = idGenerator;
	private long amount;
	private String date;
	private String type;
	private long sum;

	public Transaction( String date, String type, long sum) {

		
		this.date = date;
		this.type = type;
		this.sum = sum;
	}

	
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (sum ^ (sum >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (sum != other.sum)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction id= "+ id+", amount=" + amount + ", date=" + date + ", type=" + type + ", sum=" + sum ;
	}

}
