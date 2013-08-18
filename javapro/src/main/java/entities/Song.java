package entities;

import java.sql.Date;

public class Song {
	private String song;
    private String sauthor;
    private String singer;
    private String snotice;
    private Date sdate;
    
    
    public String getSong() {
            return song;
    }
    public void setSong(String song) {
            this.song = song;
    }
    
    public String getSnotice() {
        return snotice;
    }
    public void setSnotice(String snotice) {
            this.snotice = snotice;
    }
    
    public String getSinger() {
        return singer;
	}
	public void setSinger(String singer) {
	        this.singer = singer;
	}
	
	 public String getSauthor() {
	        return sauthor;
		}
		public void setSauthor(String sauthor) {
		        this.sauthor = sauthor;
		}
		
	public Date getSdate() {
        return sdate;
	}
	public void setSdate(Date sdate) {
	        this.sdate = sdate;
	}	
}
