package tn.isetrades.test10.entity.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tn.isetrades.test10.entity.model.Course;
import tn.isetrades.test10.entity.model.Member;
import tn.isetrades.test10.entity.utility.HibernateConnector;

/**
 *
 * @author Rania
 */
public class MemberDao {

    public List<Member> listMember() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Member");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<Member>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public Member findMemberById(int idMember) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Member r where r.idMember = :idMember");
            query.setParameter("idMember", idMember);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Member) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean getStatus(int idMember) {
        Session session = null;
        boolean result = false;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Member r where r.idMember = :idMember");
            Member m = (Member) query.setParameter("idMember", idMember).uniqueResult();
            result = m.isEnabled();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public void EnableOrDisableMember(int id, boolean result) {
        Member member = findMemberById(id);
        member.setEnabled(result);
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            session.saveOrUpdate(member);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateMember(Member member) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            session.saveOrUpdate(member);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Member addMember(Member member) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(member);
            transaction.commit();
            return member;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteMember(int idMember) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Member r where r.idMember =:idMember");
            createQuery.setParameter("idMember", idMember);
            createQuery.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addStudentToCourse(int idC, int idS) {
        Member member = findMemberById(idS);
        Course course = findCourseById(idC);
        Set<Course> courses = new HashSet();
        courses.add(course);
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            member.setCourses(courses);
            session.saveOrUpdate(member);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Course findCourseById(int idCourse) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Course r where r.idCourse = :idCourse");
            query.setParameter("idCourse", idCourse);
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Course) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
