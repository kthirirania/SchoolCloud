package tn.isetrades.test10.entity.service;

import java.util.List;
import tn.isetrades.test10.entity.dao.ServerDao;
import tn.isetrades.test10.entity.model.Server;

/**
 *
 * @author Rania
 */
public class ServerService {
    
     ServerDao serverDAO = new ServerDao();

    public Server createServer(Server r) {
        serverDAO.addServer(r);
        return r;
    }

    public void updateServer(Integer id) {
        Server server = serverDAO.findServerById(id);
        serverDAO.updateServer(server);
    }

    public void deleteServer(Integer id) {
        serverDAO.deleteServer(id);
    }

    public List<Server> getServerList() {
        return serverDAO.listServer();
    }

    public Server getServer(Integer id) {
        return serverDAO.findServerById(id);
    }
    
}
