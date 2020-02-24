package tn.isetrades.test10.entity.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role
 */
@Entity
@Table(name = "role",
        catalog = "test10"
)
public class Role implements java.io.Serializable {

    private Integer idRole;
    private String name;
    private Set<Member> members = new HashSet<Member>(0);

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(int id) {
        this.idRole = id;
    }

    public Role(String name, Set<Member> members) {
        this.name = name;
        this.members = members;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_role", unique = true, nullable = false)
    public Integer getIdRole() {
        return this.idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<Member> getMembers() {
        return this.members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

}
