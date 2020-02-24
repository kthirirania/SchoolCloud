package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.identity.v3.Project;
import org.openstack4j.model.identity.v3.User;
import org.openstack4j.openstack.OSFactory;


public class OSClientApiImpl implements OSClientApi {

    private OSClientV3 createOSClientV3() {
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
    public List<? extends User> listAllStudents() {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.identity().users().list();
    }

    @Override
    public OSClient.OSClientV3 findBYIdByStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActionResponse deleteStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
