package entities;

import java.sql.Date;

public class Poem {
	
	private String poem;
    private String pauthor;
    private String pnotice;
    private Date pdate;
    private int id;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPoem() {
            return poem;
    }
    public void setPoem(String poem) {
            this.poem = poem;
    }
    
    public String getPnotice() {
        return pnotice;
    }
    public void setPnotice(String pnotice) {
            this.pnotice = pnotice;
    }
    
    public String getPauthor() {
        return pauthor;
	}
	public void setPauthor(String pauthor) {
	        this.pauthor = pauthor;
	}
	
	public Date getPdate() {
        return pdate;
	}
	public void setPdate(Date pdate) {
	        this.pdate = pdate;
	}	

}
