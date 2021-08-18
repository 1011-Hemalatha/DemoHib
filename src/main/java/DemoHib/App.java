package DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

	public static void main(String[] args)
	{
		AlienName on = new AlienName();
		on.setFname("Hariprasath");
		on.setLname("Kumar");
		on.setMname("Ravi");
		
		Alien telusko = new Alien();
		telusko.setAid(101);
		telusko.setColor("Black");
		telusko.setAname(on);
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf= con.buildSessionFactory(reg);
		
		Session session= sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
	    session.save(telusko);
	    
	    tx.commit();
		
	    System.out.println(telusko);
		}

}
