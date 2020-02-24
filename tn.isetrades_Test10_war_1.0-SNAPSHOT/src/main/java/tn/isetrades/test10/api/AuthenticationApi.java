package tn.isetrades.test10.api;

import org.openstack4j.api.OSClient;
import org.openstack4j.api.OSClient.OSClientV3;

/**
 *
 * @author Rania
 */
public interface AuthenticationApi {
    
    public OSClient.OSClientV3 unsocpedAuth(String username, String password);
    public OSClientV3 scopedAuth();
}
