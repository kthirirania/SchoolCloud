package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.identity.v3.Group;
import org.openstack4j.model.identity.v3.User;

/**
 *
 * @author Rania
 */
public interface GroupApi {

    Group createGroup(String name, String description, String domainId);

    List<? extends Group> listGroups();

    Group findGroupById(String groupId);

    List<? extends User> listGroupUsers(String groupId);

    ActionResponse addUserToGroup(String groupId, String userId);

    ActionResponse checkUserInGroup(String groupId, String userId);

    ActionResponse removeUserFromGroup(String groupId, String userId);

    Group updateGroup(String groupId, String description);

    ActionResponse deleteGroup(String groupId);
}
