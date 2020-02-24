package tn.isetrades.test10.main;

import java.util.List;
import static jdk.nashorn.internal.runtime.Context.DEBUG;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.OSClient.OSClientV2;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.api.identity.v3.CredentialService;
import org.openstack4j.api.identity.v3.TokenService;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ext.DNSEntry;
import org.openstack4j.model.identity.v3.Project;
import org.openstack4j.model.identity.v3.Role;
import org.openstack4j.model.identity.v3.Service;
import org.openstack4j.model.identity.v3.User;
import org.openstack4j.model.image.v2.DiskFormat;
import org.openstack4j.model.image.v2.Image;
import org.openstack4j.openstack.OSFactory;
import tn.isetrades.test10.api.ImageApiImpl;
import tn.isetrades.test10.api.OSClientApiImpl;
import tn.isetrades.test10.api.ServerApiImpl;
import tn.isetrades.test10.api.Auth;
import org.openstack4j.openstack.identity.internal.DefaultEndpointURLResolver;
import sun.util.logging.resources.logging;
import tn.isetrades.test10.api.RoleAPiImpl;
import tn.isetrades.test10.entity.service.RoleService;

/**
 *
 * @author Rania
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Test t = new Test();
        //FlavorApiImpl tt = new FlavorApiImpl();
        //List<? extends Flavor> ff = tt.listAllFlavors();
        /* for (Flavor flavor : ff) {
        System.out.format("Flavor id: %s, Flavor name: %s; vCPUs: %d; Local disk size: %d;GB Ram: %dMB \n",
        flavor.getId(), flavor.getName(), flavor.getVcpus(), flavor.getDisk(), flavor.getRam());
        }*/
        System.out.println("Hello1");
        /*ImageApiImpl imageApi = new ImageApiImpl();
        List<? extends Image> images = imageApi.listAllImages();
        for (Image image : images) {
        System.out.format("Image id: %s, Flavor name: %s; Size: %d; Status: %s\n",
        image.getId(), image.getName(),  image.getSize(), image.getStatus());
        }*/

 /*ServerApiImpl serverApi = new ServerApiImpl();
        List<? extends Server> servers = serverApi.listAllServers();
        for (Server srv : servers) {
        System.out.format("Instance id: %s, Status: %s;Instance name: %s, Flavor id: %s \n", srv.getId(),
        srv.getStatus(), srv.getName(), srv.getFlavorId());
        }*/
 /*   OSFactory.enableHttpLoggingFilter(true);
 Identifier domainIdentifier = Identifier.byId("default");
 
 OSClientV3 os = OSFactory.builderV3()
 .endpoint("http://41.229.118.249/identity/v3")
 .credentials("kthiri", "kthiri", domainIdentifier)
 .scopeToProject(Identifier.byName("admin"), Identifier.byName("Default"))
 .authenticate();
 
 System.out.println(os.getEndpoint());
 
 System.out.println("ROLES");
 System.out.println(os.getToken().getRoles());
 os.getToken().getId();
 if (os != null) {
 try {
 List<? extends Project> projectList = os.identity().projects().list();
 } catch (Exception ex) {
 System.out.println(ex.getMessage());
 }
 }*/
 /* ServerApiImpl sAI = new ServerApiImpl();
        String result = sAI.ServerConsoleOutput("07b26e92-64d3-445d-b642-2d5ce89921ca", 50);
        System.out.println(result);*/
 /*DiskFormat dd = DiskFormat.ISO;
        for(DiskFormat dF : DiskFormat.values()){
        System.out.println(dF.name());
        System.out.println(dF.getDeclaringClass());
        
        }*/
 /*for (DiskFormat dF : DiskFormat.values()) {
 System.out.println("value = " + dF.value() + " Name= " + dF.name());
 }
 System.out.println(
 DiskFormat.AKI.toString()
 + DiskFormat.AMI.toString()
 + DiskFormat.ARI.toString()
 + DiskFormat.ISO.toString()
 + DiskFormat.QCOW2.toString()
 + DiskFormat.RAW.toString()
 + DiskFormat.UNRECOGNIZED.toString()
 + DiskFormat.VDI.toString()
 + DiskFormat.VHD.toString()
 + DiskFormat.VHDX.toString()
 + DiskFormat.VMDK.toString()
 );*/
        OSFactory.enableHttpLoggingFilter(true);
        Identifier domainIdentifier = Identifier.byId("default");

        OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://41.229.118.249/identity/v3")
                .credentials("admin", "secret", domainIdentifier)
                .scopeToProject(Identifier.byName("admin"), Identifier.byName("Default"))
                .authenticate();
        
        List<? extends Project> projectList = os.identity().projects().list();
        
    }
}
