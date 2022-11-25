package entity;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username, String password, String major, int startyearOfStudy){
        return new CommonUser(username,password,major,startyearOfStudy);
    }

}
