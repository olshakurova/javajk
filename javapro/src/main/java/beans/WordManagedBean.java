package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Word;
import hibernateutil.HibernateUtil;

public class WordManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(WordManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	
	private String word;
    private String meaning;
    private String wnotice;
    private Timestamp wdate;
	
	public Timestamp getWdate() {
	    return wdate;
	}
	public void setWdate() {
		this.wdate = GetCurrentTimeStamp();
	}	
	
	public Timestamp GetCurrentTimeStamp()
	{

		 java.util.Date date= new java.util.Date();
		 Timestamp tmp = new Timestamp(date.getTime());
		 return tmp;
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
		
	public String wsave() {
		String result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Word word = new Word();
		word.setWord(this.getWord());
		word.setMeaning(this.getMeaning());
		word.setWnotice(this.getWnotice());
		word.setWdate(this.getWdate());

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(word);
			tx.commit();
			log.debug("New Record : " + word + ", wasCommitted : " + tx.wasCommitted());
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
	
	public List<Word> getWords() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Word>  wordList = session.createCriteria(Word.class).list();
		return wordList;
	}
	
	public void wreset() {
		this.setMeaning("");
		this.setWnotice("");
		this.setWord("");
	}	
}
