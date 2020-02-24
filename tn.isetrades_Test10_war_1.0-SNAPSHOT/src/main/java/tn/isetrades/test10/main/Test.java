package tn.isetrades.test10.main;

import java.util.List;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

/**
 *
 * @author Rania
 */
public class Test {
 
    private OSClient.OSClientV3 createOSClientV3() {
        OSFactory.enableHttpLoggingFilter(true);
        Identifier domainIdentifier = Identifier.byId("default");

        OSClient.OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://41.229.118.249/identity/v3/")
                .credentials("admin", "secret", domainIdentifier)
                .scopeToProject(Identifier.byId("57cd7e934cf2446dbcc603a85541e896"))
                .authenticate();
        return os;
    }

    public List<? extends Flavor> listAllFlavors() {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Flavor> flavors = os.compute().flavors().list();
        return flavors;
    }
    
}
