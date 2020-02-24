package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.identity.v3.Project;

/**
 *
 * @author Rania
 */
public interface ProjectApi {

    Project createProject(String name, String desc);

    List<? extends Project> listprojects();

    Project findProjectByName(String name);

    Project findProjectById(String id);

    Project updateProject(String id);

    ActionResponse deleteProject(String id);

}
