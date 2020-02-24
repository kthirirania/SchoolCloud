package tn.isetrades.test10.entity.service;

import java.util.List;
import tn.isetrades.test10.entity.dao.RoleDao;
import tn.isetrades.test10.entity.model.Role;

/**
 *
 * @author Rania
 */
public class RoleService {

    RoleDao roleDAO = new RoleDao();

    public Role createRole(Role r) {
        roleDAO.addRole(r);
        return r;
    }

    public void updateRole(Integer id, String name) {
        Role role = roleDAO.findRoleById(id);
        role.setName(name);
        roleDAO.updateRole(role);
    }

    public void deleteRole(Integer id) {
        roleDAO.deleteRole(id);
    }

    public List<Role> getRoleList() {
        return roleDAO.listRole();
    }

    public Role getRole(Integer id) {
        return roleDAO.findRoleById(id);
    }
    
    public Role getRoleByName(String name){
        return roleDAO.findRoleByName(name);
    }

}
