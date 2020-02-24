package tn.isetrades.test10.entity.service;

import java.util.List;
import tn.isetrades.test10.entity.dao.FlavorDao;
import tn.isetrades.test10.entity.model.Flavor;

/**
 *
 * @author Rania
 */
public class Flavorservice {
    
     FlavorDao flavorDAO = new FlavorDao();

    public Flavor createFlavor(Flavor r) {
        flavorDAO.addFlavor(r);
        return r;
    }

    public void updateFlavor(Integer id) {
        Flavor flavor = flavorDAO.findFlavorById(id);
        flavorDAO.updateFlavor(flavor);
    }

    public void deleteFlavor(Integer id) {
        flavorDAO.deleteFlavor(id);
    }

    public List<Flavor> getFlavorList() {
        return flavorDAO.listFlavor();
    }

    public Flavor getFlavor(Integer id) {
        return flavorDAO.findFlavorById(id);
    }
    
}
