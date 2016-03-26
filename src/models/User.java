package models;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class User {
    public int userId;
    public char gender;
    public int age;
    public String occupation;
    public int zipCode;

    public User() {
    }

    public User(int userId, char gender, int age, String occupation, int zipCode) {
        this.userId = userId;
        this.gender = gender;
        this.age = ageGroup(age);
        this.occupation = occupation;
        this.zipCode = zipCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = ageGroup(age);
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public static int ageGroup(int age){
        if(age < 18) return 1;
        else if(age >= 18 && age <= 24) return 18;
        else if(age >= 25 && age <= 34) return 25;
        else if(age >= 35 && age <= 44) return 35;
        else if(age >= 45 && age <= 49) return 45;
        else if(age >= 50 && age <= 55) return 50;
        else return 56;
    }

}
