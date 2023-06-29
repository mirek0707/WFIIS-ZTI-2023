package zti.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean(name = "databaseBean")
@RequestScoped
public class Database {

    private Person person;
    private Connection conn = null;
    private PreparedStatement prestmt = null;
    private Statement stmt = null;
    private ResultSet rset = null;
    private List<Person> list = new ArrayList<Person>();

    public Database() {
        // System.out.println("Init managed Bean");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String url = "jdbc:postgresql://mouse.db.elephantsql.com:5432/tlzubtbb";
        String username = "tlzubtbb";
        String password = "3P_TmVOlgGSZqsJ5a9aoZazd5aACIcFs";
        try {
            conn = DriverManager.getConnection(url, username, password);
            // System.out.println("Connect to Database");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Person> getPersonList() {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM public.person ORDER BY lname";
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                person = new Person();
                person.setFname(rset.getString("fname"));
                person.setLname(rset.getString("lname"));
                person.setEmail(rset.getString("email"));
                person.setTel(rset.getString("tel"));
                person.setCity(rset.getString("city"));
                person.setUserType(rset.getString("userType"));
                person.setId(rset.getInt("id"));
                list.add(person);
            }
            rset.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (prestmt != null) {
                    prestmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
    public void createPerson(Person person) {
        try {
            prestmt = conn.prepareStatement("INSERT INTO person (fname, lname, email, city, userType, tel) VALUES (?,?,?,?,?::userType,?)");
            prestmt.setString(1, person.getFname());
            prestmt.setString(2, person.getLname());
            prestmt.setString(3, person.getEmail());
            prestmt.setString(4, person.getCity());
            prestmt.setString(5, person.getUserType());
            prestmt.setString(6, person.getTel());
            prestmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (prestmt != null) {
                    prestmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return;
    }
    public Person readPerson(String id) {
        try {
            Integer ident = Integer.parseInt(id);
            prestmt = conn.prepareStatement("SELECT * FROM person WHERE id = ? ");
            prestmt.setInt(1, ident);
            ResultSet rset = prestmt.executeQuery();
            person = new Person();
            while (rset.next()) {
                person.setFname(rset.getString("fname"));
                person.setLname(rset.getString("lname"));
                person.setEmail(rset.getString("email"));
                person.setTel(rset.getString("tel"));
                person.setCity(rset.getString("city"));
                person.setUserType(rset.getString("userType"));
                person.setId(rset.getInt("id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (prestmt != null) {
                    prestmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return person;
    }
    public void updatePerson(Person person) {
        try {
            // System.out.println("Deleted record" + person.getId());
            prestmt = conn.prepareStatement("UPDATE person SET fname=?,lname=?,email=?,city=?,tel=?, userType=?::userType  WHERE id = ?");
            prestmt.setString(1, person.getFname());
            prestmt.setString(2, person.getLname());
            prestmt.setString(3, person.getEmail());
            prestmt.setString(4, person.getCity());
            prestmt.setString(5, person.getTel());
            prestmt.setString(6, person.getUserType());
            prestmt.setInt(7, person.getId());
            prestmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (prestmt != null) {
                    prestmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return;
    }
    public void deletePerson(String id) {
        try {
            // System.out.println("Deleted record" + id);
            Integer ident = Integer.parseInt(id);
            prestmt = conn.prepareStatement("DELETE FROM person WHERE id = ?");
            prestmt.setInt(1, ident);
            prestmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (prestmt != null) {
                    prestmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return;
    }
}