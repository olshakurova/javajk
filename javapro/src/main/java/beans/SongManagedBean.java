package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Song;
import hibernateutil.HibernateUtil;

public class SongManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;//???
	private static Logger log = Logger.getLogger(WordManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	
	private String song;
    private String sauthor;
    private String singer;
    private String snotice;
    private Date sdate;
    private int id;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    
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
		
	public String save() {
		String result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Song s = new Song();
		s.setSauthor(this.getSauthor());
		s.setSinger(this.getSinger());
		s.setSnotice(this.getSnotice());
		s.setSong(this.getSong());
		s.setSdate(this.getSdate());
		
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			log.debug("New Record : " + s + ", wasCommitted : " + tx.wasCommitted());
			result = SUCCESS;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				result = ERROR;
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public List<Song> getQuotes() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Song>  songList = session.createCriteria(Song.class).list();
		return songList;
	}
	
	public void reset() {
		this.setSauthor("");
		this.setSinger("");
		this.setSnotice("");
		this.setSong("");

	}	

}
