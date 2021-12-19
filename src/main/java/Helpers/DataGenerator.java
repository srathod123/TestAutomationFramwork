package Helpers;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class DataGenerator {
    public static String getUsername(){
        return new Faker().name().username();
    }
    public static String getPassword(){
        return Faker.instance().internet().password();
    }
    public static String getEmailAddress(){
        return Faker.instance().internet().emailAddress();
    }
    public static String getFirstname(){
        return new Faker().name().firstName();
    }
    public static String getLastname(){
        return new Faker().name().lastName();
    }
    public static String getFullname(){
        return new Faker().name().fullName();
    }
    public static String getPhonenumber(){
        return Faker.instance().phoneNumber().cellPhone();
    }
}
