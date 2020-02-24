package tn.isetrades.test10.entity.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Set;
import tn.isetrades.test10.entity.model.Course;
import tn.isetrades.test10.entity.model.Member;
import tn.isetrades.test10.entity.utility.HibernateConnector;

/**
 *
 * @author Rania
 */
public class CourseDao {

    public List<Course> listCourse() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Course");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<Course>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public Member getCourseMember(int idCourse) {
        Course course = findCourseById(idCourse);
        Session session = null;
        try {
            Member member = course.getMember();
            if (member != null) {
                return null;
            } else {
                return member;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    public boolean getStatus(int idCourse) {
        Session session = null;
        boolean result = false;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Course r where r.idCourse = :idCourse");
            Course c = (Course) query.setParameter("idCourse", idCourse).uniqueResult();
            result = c.isEnabled();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public void updateCourse(Course course) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            session.saveOrUpdate(course);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void EnableOrDisableCourse(int id, boolean result) {
        Course course = findCourseById(id);
        course.setEnabled(result);
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            session.saveOrUpdate(course);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Course addCourse(Course course) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : " + session);
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteCourse(int idCourse) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Course r where r.idCourse =:idCourse");
            createQuery.setParameter("idCourse", idCourse);
            createQuery.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
