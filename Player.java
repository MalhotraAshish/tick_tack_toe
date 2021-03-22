package tick_tack_toe;

public class Player {
	String name;
	int id;
	String mobileNumber;
	char symbol;

	public Player(String name, int id, String mobileNumber, char symbol) {
		super();
		this.name = name;
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

}
