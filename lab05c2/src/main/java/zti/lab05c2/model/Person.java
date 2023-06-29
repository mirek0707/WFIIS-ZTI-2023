package zti.lab05c2.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the person database table.
 *
 */
@Entity (name="person")
@Table (name="person", schema="public")

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