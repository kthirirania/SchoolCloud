package tn.isetrades.test10.api;

import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.openstack.OSFactory;


public class AuthenticationApiImpl implements AuthenticationApi {

    @Override
    public OSClient.OSClientV3 unsocpedAuth(String username, String password) {
        return OSFactory.builderV3()
                       .endpoint("http://41.229.118.249/identity/v3/")
                       .credentials(username,password, Identifier.byId("default"))
                       .authenticate();
    }

    @Override
    public OSClient.OSClientV3 scopedAuth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
