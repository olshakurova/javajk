package beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Quote;
import hibernateutil.HibernateUtil;

public class QuoteManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;//???
	private static Logger log = Logger.getLogger(QuoteManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	
	private String quote;
    private String qauthor;
    private String qnotice;
    private Timestamp qdate;
    private List<Quote>  quoteList;
    
	
	public Timestamp getQdate() {
	    return qdate;
	}
	public void setQdate() {
		this.qdate = GetCurrentTimeStamp();
	}	
	
	public Timestamp GetCurrentTimeStamp()
	{

		 java.util.Date date= new java.util.Date();
		 Timestamp tmp = new Timestamp(date.getTime());
		 return tmp;
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
	
	public String qsave() {
		String result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Quote q = new Quote();
		q.setQuote(this.getQuote());
		q.setQauthor(this.getQauthor());
		q.setQnotice(this.getQnotice());
		q.setQdate(this.getQdate());

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(q);
			tx.commit();
			log.debug("New Record : " + q + ", wasCommitted : " + tx.wasCommitted());
			result = SUCCESS;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				result = ERROR;
				e.printStackTrace();
			}
		} finally {
			this.setQuote("");
			this.setQauthor("");
			this.setQnotice("");
			session.close();
		}
		return result;
	}
	
	
	 public List<Quote> getQuoteList() {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
			this.quoteList = (session.createCriteria(Quote.class).list());
	        return quoteList;
	    }

	    public void setQuoteList(List<Quote> quoteList) {
	        this.quoteList = quoteList;
	    }    
	
	public void qreset() {
		this.setQuote("");
		this.setQauthor("");
		this.setQnotice("");
	}	

}
