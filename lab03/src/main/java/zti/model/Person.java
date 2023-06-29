package zti.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the person database table.
 *
 */
@Entity (name="person")
@Table (name="person", schema="public")
@NamedNativeQueries({
        @NamedNativeQuery(name="findAll", query="SELECT p.id as ID, p.fname, p.lname, p.email, p.city, p.tel FROM person p ORDER BY p.lname", resultClass = Person.class),
        @NamedNativeQuery(name="findByLastnameOrEmail", query="SELECT p.id as ID, p.fname, p.lname, p.email, p.city, p.tel FROM public.person p WHERE position(LOWER(?1) in LOWER(p.lname))>0 OR position(LOWER(?1) in LOWER(p.email))>0 ORDER BY p.lname", resultClass = Person.class)
})


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String city;
    private String email;
    private String fname;
    private String lname;
    private String tel;

    public Person() {
    }


    @Id
    //@SequenceGenerator(name="PERSON_ID_GENERATOR" )
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_ID_GENERATOR")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}