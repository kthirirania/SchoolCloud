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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Course
 */
@Entity
@Table(name = "course",
        catalog = "test10"
)
public class Course implements java.io.Serializable {

    private Integer idCourse;
    private String description;
    private boolean enabled;
    private String name;
    private Set<Server> servers = new HashSet<Server>(0);
    private Member member;

    public Course() {
    }

    public Course(String description, boolean enabled, String name, Member member) {
        this.description = description;
        this.enabled = enabled;
        this.name = name;
        this.member= member;
    }
    
    public Course(String description, boolean enabled, String name) {
        this.description = description;
        this.enabled = enabled;
        this.name = name;
    }

    public Course(String description, boolean enabled, String name, Set<Server> servers) {
        this.description = description;
        this.enabled = enabled;
        this.name = name;
        this.servers = servers;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_course", unique = true, nullable = false)
    public Integer getIdCourse() {
        return this.idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    @Column(name = "description", nullable = false, length = 200)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    public Set<Server> getServers() {
        return this.servers;
    }

    public void setServers(Set<Server> servers) {
        this.servers = servers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member", nullable = false)
    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
