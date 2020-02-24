package tn.isetrades.test10.api;

import java.util.List;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.compute.VNCConsole;

/**
 *
 * @author Rania
 */
public interface ServerApi {
    List<? extends Server> listAllServers();
    public ServerCreate createServer(String name, String flavorId, String imageId);
    public Server ServerBoot(ServerCreate sc);
    public ActionResponse ServerDelete(String serverId);
    public Server getServerById(String serverId);
    public String ServerConsoleOutput(String serverId, int linesNum);
    public VNCConsole ServerVNCConsole(String serverId);
    public ActionResponse ServerStop(String serverId);
    public ActionResponse ServerResume(String serverId);
    public ActionResponse ServerUnlock(String serverId);
    public ActionResponse ServerLock(String serverId);
    public ActionResponse ServerSuspend(String serverId);
    public ActionResponse ServerStart(String serverId);
    public ActionResponse ServerUnpause(String serverId);
    public ActionResponse ServerPause(String serverId);
    public String ServerCreateSnapshot(String serverId);
}
