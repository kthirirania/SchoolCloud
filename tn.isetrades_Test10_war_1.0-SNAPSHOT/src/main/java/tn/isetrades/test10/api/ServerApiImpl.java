package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Action;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.compute.VNCConsole;
import org.openstack4j.model.compute.VNCConsole.Type;
import org.openstack4j.openstack.OSFactory;

public class ServerApiImpl implements ServerApi {

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

    @Override
    public Server getServerById(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().get(serverId);
    }

    @Override
    public List<? extends Server> listAllServers() {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().list();
    }

    @Override
    public ServerCreate createServer(String name, String flavorId, String imageId) {
        ServerCreate sc = Builders.server()
                .name(name)
                .flavor(flavorId)
                .image(imageId)
                .build();
        return sc;
    }

    @Override
    public Server ServerBoot(ServerCreate sc) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Server server = os.compute().servers().boot(sc);
        return server;
    }

    @Override
    public ActionResponse ServerDelete(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().delete(serverId);
    }

    @Override
    public String ServerConsoleOutput(String serverId, int linesNum) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().getConsoleOutput(serverId, linesNum);
    }

    @Override
    public VNCConsole ServerVNCConsole(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().getVNCConsole(serverId, Type.NOVNC);
    }

    @Override
    public ActionResponse ServerStart(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.START);
    }

    @Override
    public ActionResponse ServerStop(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.STOP);
    }

    @Override
    public ActionResponse ServerSuspend(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.SUSPEND);
    }

    @Override
    public ActionResponse ServerResume(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.RESUME);
    }

    @Override
    public ActionResponse ServerLock(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.LOCK);
    }

    @Override
    public ActionResponse ServerUnlock(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.UNLOCK);
    }

    @Override
    public ActionResponse ServerPause(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.PAUSE);
    }

    @Override
    public ActionResponse ServerUnpause(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().action(serverId, Action.UNPAUSE);
    }

    @Override
    public String ServerCreateSnapshot(String serverId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        return os.compute().servers().createSnapshot(serverId, "New clean snapshot");
    }

    public ActionResponse AssociateFloatingIp(Server server, String adress1, String adress2) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse r = os.compute().floatingIps().addFloatingIP(server, adress1, adress2);
        return r;
    }
}
