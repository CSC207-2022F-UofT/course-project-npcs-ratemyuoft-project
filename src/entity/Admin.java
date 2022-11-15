package entity;
public class Admin extends User{

    public boolean isCool = true;

    public Admin(String username, String password){
        super(username, password);
    }
}
