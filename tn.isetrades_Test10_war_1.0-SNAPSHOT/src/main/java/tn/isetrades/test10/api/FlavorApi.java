package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.compute.Flavor;

/**
 *
 * @author Rania
 */
public interface FlavorApi {

    public Flavor createFlavor(String name, int ram, int vcpus, int disk, int ephemeral, int swap, float rxtxFactor, boolean isPublic);

    public List<? extends Flavor> listAllFlavors();

    public Flavor findBYIdByFlavor(String flavorId);

    public ActionResponse deleteFlavor(String flavorId);

}
