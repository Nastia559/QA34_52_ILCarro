package utils;

import dto.UserLombok;
import net.datafaker.Faker;

import static utils.PropertiesReader.getProperty;

public class UserFactory {
    static Faker faker = new Faker();

    public static UserLombok positiveUser(){
        UserLombok user = UserLombok.builder()
                .username(faker.internet().emailAddress())
                .password("Qwerty156!")
//                .password(getProperty("base.properties", "password"))
                .build();
        return user;
    }

    public static UserLombok registrationUser(){
        UserLombok user = UserLombok.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.internet().emailAddress())
//                .password("Qwerty156!")
                .password(getProperty("base.properties", "password"))
                .build();
        return user;
    }

}


