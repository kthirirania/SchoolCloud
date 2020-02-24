package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.identity.v3.Role;
import org.openstack4j.openstack.OSFactory;

public class RoleAPiImpl implements RoleAPi {

    private OSClient.OSClientV3 createOSClientV3() {
        OSFactory.enableHttpLoggingFilter(true);
        Identifier domainIdentifier = Identifier.byId("default");
       OSClient.OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://41.229.118.249/identity/v3")
                .credentials("admin", "secret", domainIdentifier)
                .scopeToProject(Identifier.byName("admin"), Identifier.byName("Default"))
                .authenticate();
        return os;
    }

    public Role createRole(String name) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Role role = os.identity().roles().create(Builders.role()
                .name(name)
                .build());
        return role;
    }

    public List<? extends Role> listRoles() {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Role> roleList = os.identity().roles().list();
        return roleList;
    }

    public Role findRoleById(String roleId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Role role = os.identity().roles().get(roleId);
        return role;
    }

    public ActionResponse grantRoleToUser(String userId, String roleId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse grantProjectRole = os.identity().roles().grantDomainUserRole("default", userId, roleId);
        return grantProjectRole;
    }

    public ActionResponse checkUserRole(String userId, String roleId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse grantProjectRole = os.identity().roles().checkDomainUserRole("default", userId, roleId);
        return grantProjectRole;
    }

    public ActionResponse revokeUserRole(String userId, String roleId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse grantProjectRole = os.identity().roles().revokeDomainUserRole("default", userId, roleId);
        return grantProjectRole;
    }

    public ActionResponse grantRoleToUserInproject(String projectId, String userId, String roleId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse grantProjectRole = os.identity().roles().grantProjectUserRole(projectId, userId, roleId);
        return grantProjectRole;
    }

    public ActionResponse checkUserRoleInProject(String projectId, String userId, String roleId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse grantProjectRole = os.identity().roles().checkProjectUserRole(projectId, userId, roleId);
        return grantProjectRole;
    }

    public ActionResponse revokeUserRoleInProject(String projectId, String userId, String roleId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse grantProjectRole = os.identity().roles().revokeProjectUserRole(projectId, userId, roleId);
        return grantProjectRole;
    }

}
