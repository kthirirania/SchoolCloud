package tn.isetrades.test10.api;

import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.ext.DNSEntry;
import org.openstack4j.model.compute.ext.DNSRecordType;
import org.openstack4j.openstack.OSFactory;

public class FloatingApiImpl implements FloatingApi {

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
    
    public DNSEntry createDNSEntry(String domainId, String name, String address ) {
        final OSClient.OSClientV3 os = createOSClientV3();
        DNSEntry entry = os.compute().floatingIPDNS()
                .entries()
                .create(domainId, name, address, DNSRecordType.A);
        return entry;
    }

}
