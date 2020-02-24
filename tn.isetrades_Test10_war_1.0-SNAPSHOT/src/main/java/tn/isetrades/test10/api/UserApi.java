package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.compute.SecGroupExtension;
import org.openstack4j.model.identity.v3.Project;
import org.openstack4j.model.identity.v3.User;
import tn.isetrades.test10.entity.model.Role;

/**
 *
 * @author Rania
 */
public interface UserApi {

    User createUser(String name, String description, String password, String email, String domainId);
    List<? extends User> listUsers();
    User getuserById(String userId);
    User getUserByName(String name);
    Role getUserRole(String userId, String projectId);
    List<? extends SecGroupExtension.Rule.Group> getUserGroups(String userId);
    User updateUser(String userId, String email);
    ActionResponse deleteUser(String userId);
    List<? extends Project> getUserProjects(String userId);
}
