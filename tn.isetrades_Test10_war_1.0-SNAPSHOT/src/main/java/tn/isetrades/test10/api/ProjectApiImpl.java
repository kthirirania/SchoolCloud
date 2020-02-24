package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.identity.v3.Project;
import org.openstack4j.openstack.OSFactory;

public class ProjectApiImpl implements ProjectApi {

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

    public Project createProject(String name, String desc) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Project project = os.identity().projects().create(Builders.project()
                .name(name)
                .description(desc)
                .enabled(true)
                .build());

        return project;
    }

    public List<? extends Project> listprojects() {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Project> projectList = os.identity().projects().list();
        return projectList;
    }

    public Project findProjectByName(String name) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Project project = os.identity().projects().getByName(name, "default");
        return project;
    }

    public Project findProjectById(String id) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Project project = os.identity().projects().get(id);
        return project;
    }

    public Project updateProject(String id) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Project project = os.identity().projects().get(id);
        if (project != null) {
            project = os.identity().projects().update(project.toBuilder().enabled(false).build());
        }
        return project;
    }
    
    public ActionResponse deleteProject(String id){
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse aR = os.identity().projects().delete(id);
        return aR;
    }

}
