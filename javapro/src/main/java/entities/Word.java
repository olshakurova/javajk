package entities;

import java.sql.Timestamp;

public class Word {
	 	private String word;
	    private String meaning;
	    private String wnotice;
	    private int id;
	    private Timestamp wdate;
		
		public Timestamp getWdate() {
		    return wdate;
		}
		public void setWdate(Timestamp date) {
			this.wdate = date;
		}	
	    
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    public String getWord() {
	            return word;
	    }
	    public void setWord(String word) {
	            this.word = word;
	    }
	    
	    public String getWnotice() {
            return wnotice;
	    }
	    public void setWnotice(String wnotice) {
	            this.wnotice = wnotice;
	    }
	    public String getMeaning() {
	        return meaning;
		}
		public void setMeaning(String meaning) {
		        this.meaning = meaning;
		}
		
}
