package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.SecGroupExtension.Rule.Group;
import org.openstack4j.model.identity.v3.Project;
import org.openstack4j.model.identity.v3.User;
import org.openstack4j.openstack.OSFactory;
import tn.isetrades.test10.entity.model.Role;

public class UserApiImpl implements UserApi {

    private OSClient.OSClientV3 createOSClientV3() {
        OSFactory.enableHttpLoggingFilter(true);
        Identifier domainIdentifier = Identifier.byId("default");
        OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://41.229.118.249/identity/v3")
                .credentials("admin", "secret", domainIdentifier)
                .scopeToProject(Identifier.byName("admin"), Identifier.byName("Default"))
                .authenticate();
        return os;
    }

    @Override
    public User createUser(String name, String description, String password, String email, String domainId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        User user = os.identity().users().create(Builders.user()
                .name(name)
                .description(description)
                .password(password)
                .email(email)
                .domainId(domainId)
                .build());
        return user;
    }

    @Override
    public List<? extends User> listUsers() {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends User> userList = os.identity().users().list();
        return userList;
    }

    @Override
    public User getuserById(String userId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        User user = os.identity().users().get(userId);
        return user;
    }

    @Override
    public User getUserByName(String name) {
        final OSClient.OSClientV3 os = createOSClientV3();
        User user = os.identity().users().getByName(name, "default");
        return user;
    }

    @Override
    public Role getUserRole(String userId, String projectId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Role> projectUserRolesList = (List<? extends Role>) os.identity().users().listProjectUserRoles(userId, projectId);
        Role role = projectUserRolesList.get(0);
        return role;

    }

    @Override
    public List<? extends Group> getUserGroups(String userId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Group> userGroupsList = (List<? extends Group>) os.identity().users().listUserGroups(userId);
        return userGroupsList;
    }

    @Override
    public List<? extends Project> getUserProjects(String userId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Project> userProjectsList = os.identity().users().listUserProjects(userId);
        return userProjectsList;
    }

    @Override
    public User updateUser(String userId, String email) {
        final OSClient.OSClientV3 os = createOSClientV3();
        User user = os.identity().users().get(userId);
        if (user != null) {
            user = os.identity().users().update(user.toBuilder().email(email).build());
        }
        return user;
    }

    @Override
    public ActionResponse deleteUser(String userId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse aR = os.identity().users().delete(userId);
        return aR;
    }
}
