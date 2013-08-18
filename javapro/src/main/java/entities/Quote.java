package entities;

import java.sql.Timestamp;

public class Quote {
	private String quote;
    private String qauthor;
    private String qnotice;
    private Timestamp qdate;
    private int id;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getQuote() {
            return quote;
    }
    public void setQuote(String quote) {
            this.quote = quote;
    }
    
    public String getQnotice() {
        return qnotice;
    }
    public void setQnotice(String qnotice) {
            this.qnotice = qnotice;
    }
    
    public String getQauthor() {
        return qauthor;
	}
	public void setQauthor(String qauthor) {
	        this.qauthor = qauthor;
	}
	
	public Timestamp getQdate() {
	    return qdate;
	}
	public void setQdate(Timestamp date) {
		this.qdate = date;
	}	
}
