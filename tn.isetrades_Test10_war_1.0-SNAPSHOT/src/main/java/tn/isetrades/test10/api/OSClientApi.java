package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.identity.v3.User;

/**
 *
 * @author Rania
 */
public interface OSClientApi {

    public List<? extends User> listAllStudents();

    public OSClientV3 findBYIdByStudent(String studentId);

    public ActionResponse deleteStudent(String studentId);

}
