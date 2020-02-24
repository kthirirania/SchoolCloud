package tn.isetrades.test10.entity.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Member
 */
@Entity
@Table(name = "member",
        catalog = "test10"
)
public class Member implements java.io.Serializable {

    private Integer idMember;
    private Role role;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String username;
    private boolean enabled;
    private Set<Course> courses = new HashSet<Course>(0);
    private Set<Server> servers = new HashSet<Server>(0);

    public Member() {
    }

    public Member(Role role, String email, String firstname, String lastname, String password, String username, boolean enabled) {
        this.role = role;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.enabled = enabled;
    }

    public Member(Role role, String email, String firstname, String lastname, String password, String username, boolean enabled, Set<Course> courses) {
        this.role = role;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.enabled = enabled;
        this.courses = courses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_member", unique = true, nullable = false)
    public Integer getIdMember() {
        return this.idMember;
    }

    public void setIdMember(Integer idMember) {
        this.idMember = idMember;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", nullable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "firstname", nullable = false, length = 50)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = false, length = 50)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    public Set<Server> getServers() {
        return this.servers;
    }

    public void setServers(Set<Server> servers) {
        this.servers = servers;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

}
