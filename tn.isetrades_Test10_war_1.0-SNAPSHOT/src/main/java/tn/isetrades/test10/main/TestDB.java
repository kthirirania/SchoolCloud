package tn.isetrades.test10.main;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tn.isetrades.test10.entity.model.Member;
import tn.isetrades.test10.entity.model.Role;
import tn.isetrades.test10.entity.utility.HibernateConnector;

/**
 *
 * @author Rania
 */
public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        session = HibernateConnector.getInstance().getSession();
        Query query = session.createQuery("from Role r where r.name = :name");
        query.setParameter("name", "Teacher");
        List queryList = query.list();
        Role role = (Role) queryList.get(0);

        Member member = new Member();
        member.setEmail("ok1");
        member.setFirstname("ok1");
        member.setLastname("ok1");
        member.setUsername("ok1");
        member.setPassword("ok1");
        member.setRole(role);

        session.save(member);
        transaction.commit();

    }

}
