package tn.isetrades.test10.api;

import org.openstack4j.api.types.ServiceType;
import org.openstack4j.model.identity.URLResolverParams;
import org.openstack4j.openstack.identity.internal.DefaultEndpointURLResolver;

/**
 *
 * @author Rania
 */
public class Auth extends DefaultEndpointURLResolver{
   @Override
   public String findURLV3(URLResolverParams p) {
        if (p.token != null && p.type == ServiceType.IDENTITY) {
            return "http://41.229.118.249/identity/v3";
        }
        return super.findURLV3(p);
    }
}
