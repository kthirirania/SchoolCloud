package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.identity.v3.Role;

/**
 *
 * @author Rania
 */
public interface RoleAPi {

    Role createRole(String name);

    List<? extends Role> listRoles();

    Role findRoleById(String roleId);

    ActionResponse grantRoleToUser(String userId, String roleId);

    ActionResponse checkUserRole(String userId, String roleId);

    ActionResponse revokeUserRole(String userId, String roleId);

    ActionResponse grantRoleToUserInproject(String projectId, String userId, String roleId);

    ActionResponse checkUserRoleInProject(String projectId, String userId, String roleId);

    ActionResponse revokeUserRoleInProject(String projectId, String userId, String roleId);

}
