package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Poem;
import hibernateutil.HibernateUtil;

public class PoemManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;//???
	private static Logger log = Logger.getLogger(WordManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	
	private String poem;
    private String pauthor;
    private String pnotice;
    private Date pdate;
    
    
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
		
	public String save() {
		String result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Poem p = new Poem();
		p.setPauthor(this.getPauthor());
		p.setPnotice(this.getPnotice());
		p.setPoem(this.getPoem());
		p.setPdate(this.getPdate());

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(p);
			tx.commit();
			log.debug("New Record : " + p + ", wasCommitted : " + tx.wasCommitted());
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
	
	public List<Poem> getQuotes() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Poem>  poemList = session.createCriteria(Poem.class).list();
		return poemList;
	}
	
	public void reset() {
		this.setPauthor("");
		this.setPnotice("");
		this.setPoem("");
	}	


}
