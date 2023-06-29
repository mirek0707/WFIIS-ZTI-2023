package zti.javaClasses;

public class Person {

    private String lname ;
    private String fname ;
    private String city ;

    private Integer id;

    public Person() {}

    public Person(String lname, String fname, String city, Integer id){
        this.lname = lname;
        this.fname = fname;
        this.city = city;
        this.id = id;
    }

    public void setFname( String newValue ){ fname = newValue ; }
    public String getFname() { return fname ; }
    public void setLname ( String newValue ) { lname = newValue ; }
    public String getLname() { return lname ; }
    public void setCity ( String newValue ) { city = newValue ; }
    public String getCity() { return city ; }
    public void setId ( Integer newValue ) { id = newValue ; }
    public Integer getId() { return id ; }

}