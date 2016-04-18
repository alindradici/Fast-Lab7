/**
 * Created by alin on 4/18/2016.
 */
public class Person {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String name;
    private String phone;

    public Person(String n,String p){

        name =n;
        phone = p;

    }
}
