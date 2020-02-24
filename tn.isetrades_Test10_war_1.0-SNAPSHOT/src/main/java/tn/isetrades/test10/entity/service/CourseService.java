package tn.isetrades.test10.entity.service;

import java.util.List;
import tn.isetrades.test10.entity.dao.CourseDao;
import tn.isetrades.test10.entity.model.Course;
import tn.isetrades.test10.entity.model.Member;

/**
 *
 * @author Rania
 */
public class CourseService {

    CourseDao courseDAO = new CourseDao();

    public Course createCourse(Course r) {
        courseDAO.addCourse(r);
        return r;
    }

    public void updateCourse(Integer id) {
        Course course = courseDAO.findCourseById(id);
        courseDAO.updateCourse(course);
    }

    public void deleteCourse(Integer id) {
        courseDAO.deleteCourse(id);
    }

    public List<Course> getCourseList() {
        return courseDAO.listCourse();
    }

    public Course getCourse(Integer id) {
        return courseDAO.findCourseById(id);
    }

    public void enableorDisableCourse(int id, boolean res) {
        courseDAO.EnableOrDisableCourse(id, res);
    }

    public boolean getStatus(int id) {
        return courseDAO.getStatus(id);
    }

    public Member getCourseMember(int id) {
        return courseDAO.getCourseMember(id);
    }
}
