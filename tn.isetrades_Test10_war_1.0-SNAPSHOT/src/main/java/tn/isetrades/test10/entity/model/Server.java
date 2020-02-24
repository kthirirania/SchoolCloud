package tn.isetrades.test10.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Server
 */
@Entity
@Table(name = "server",
         catalog = "test10"
)
public class Server implements java.io.Serializable {

    private Integer idServer;
    private Course course;
    private Flavor flavor;
    private Image image;
    private Member member;
    private String name;
    private String personalisaton;

    public Server() {
    }

    public Server(Course course, Flavor flavor, Image image, Member member, String name, String personalisaton) {
        this.course = course;
        this.flavor = flavor;
        this.image = image;
        this.member = member;
        this.name = name;
        this.personalisaton = personalisaton;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_server", unique = true, nullable = false)
    public Integer getIdServer() {
        return this.idServer;
    }

    public void setIdServer(Integer idServer) {
        this.idServer = idServer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course", nullable = false)
    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_flavor", nullable = false)
    public Flavor getFlavor() {
        return this.flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_image", nullable = false)
    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member", nullable = false)
    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "personalisaton", nullable = false)
    public String getPersonalisaton() {
        return this.personalisaton;
    }

    public void setPersonalisaton(String personalisaton) {
        this.personalisaton = personalisaton;
    }

}
