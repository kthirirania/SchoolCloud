package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.identity.v3.Group;
import org.openstack4j.model.identity.v3.User;
import org.openstack4j.openstack.OSFactory;

public class GroupApiImpl implements GroupApi {

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

    @Override
    public Group createGroup(String name, String description, String domainId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Group group = os.identity().groups().create(Builders.group()
                .name(name)
                .description(description)
                .domainId(domainId)
                .build());
        return group;
    }

    @Override
    public List<? extends Group> listGroups() {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Group> groupList = os.identity().groups().list();
        return groupList;
    }

    @Override
    public Group findGroupById(String groupId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Group group = os.identity().groups().get(groupId);
        return group;
    }

    @Override
    public List<? extends User> listGroupUsers(String groupId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends User> userGroupList = os.identity().groups().listGroupUsers(groupId);
        return userGroupList;
    }

    @Override
    public ActionResponse addUserToGroup(String groupId, String userId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse aR = os.identity().groups().addUserToGroup(groupId, userId);
        return aR;
    }

    @Override
    public ActionResponse checkUserInGroup(String groupId, String userId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse aR = os.identity().groups().checkGroupUser(groupId, userId);
        return aR;
    }

    @Override
    public ActionResponse removeUserFromGroup(String groupId, String userId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse aR = os.identity().groups().removeUserFromGroup(groupId, userId);
        return aR;
    }

    @Override
    public Group updateGroup(String groupId, String description) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Group group = os.identity().groups().get(groupId);
        if (group != null) {
            group = os.identity().groups().update(group.toBuilder().description(description).build());
        }
        return group;
    }

    @Override
    public ActionResponse deleteGroup(String groupId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse aR = os.identity().groups().delete(groupId);
        return aR;
    }
}
