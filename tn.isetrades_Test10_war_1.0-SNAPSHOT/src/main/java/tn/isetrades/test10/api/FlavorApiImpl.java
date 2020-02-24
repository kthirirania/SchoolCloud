package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

/**
 *
 * @author Rania
 */
public class FlavorApiImpl implements FlavorApi {

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
    public Flavor createFlavor(String name, int ram, int vcpus, int disk, int ephemeral, int swap, float rxtxFactor, boolean isPublic) {
        final OSClientV3 os = createOSClientV3();
        return os.compute().flavors()
                .create(name, ram, vcpus, disk, ephemeral, swap, rxtxFactor, isPublic);
    }

    public List<? extends Flavor> listAllFlavors() {
        final OSClientV3 os = createOSClientV3();
        List<? extends Flavor> flavors = os.compute().flavors().list();
        return flavors;
    }

    public Flavor findBYIdByFlavor(String flavorId) {
        final OSClientV3 os = createOSClientV3();
        Flavor flavor = os.compute().flavors().get(flavorId);
        return flavor;
    }

    public ActionResponse deleteFlavor(String flavorId) {
        final OSClientV3 os = createOSClientV3();
        ActionResponse aR = os.compute().flavors().delete(flavorId);
        return aR;
    }
}
