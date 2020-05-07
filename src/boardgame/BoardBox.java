package boardgame;

public abstract class BoardBox {

	protected int caseNbr;
	protected String event;
	protected String type; 
	protected int value; 
	
	
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public BoardBox(int caseNbr, String event) {
		this.caseNbr = caseNbr;
		this.event = event;

		}


	/* ---------------------------Methods() ---------------------- */
	abstract public String toString();
	
	
	public int getCaseNbr() {
		return this.caseNbr;
	}
	public String getEvent() {
		return this.event;
	}
	public int getValue() {
		return value;
	}
	public String getType() {
		return type;
	}
	public void setCaseNbr(int caseNbr) {
		this.caseNbr = caseNbr;
	}
	public void setEvent(String event) {
		this.event = event;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public void setType(String type) {
		this.type = type;
	}

}
