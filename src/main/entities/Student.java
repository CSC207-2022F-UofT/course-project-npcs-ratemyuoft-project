package entities;
public class Student extends User {

    public String major;

    public int startYearOfStudy;

    public int numberOfWarnings = 0;

    public Student(String userName,String password, String major, int startYearOfStudy){
        super(userName,password);
        this.major = major;
        this.startYearOfStudy = startYearOfStudy;
    }





        //Getters

    public String getMajor() {
        return this.major;
    }

    public int getNumberOfWarnings() {
        return this.numberOfWarnings;
    }

    public int getStartYearOfStudy(){
        return this.startYearOfStudy;
    }
        //Setters

    public void setMajor(String newMajor){
        this.major = newMajor;
    }

    public void setStartYearOfStudy(int newYearOfStudy){
        this.startYearOfStudy = newYearOfStudy;
    }

    public void setNumberOfWarnings(int newNumberOfWarnings){
        this.numberOfWarnings = newNumberOfWarnings;
    }

}
