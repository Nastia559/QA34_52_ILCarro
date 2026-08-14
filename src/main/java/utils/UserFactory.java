package utils;

import dto.UserLombok;
import net.datafaker.Faker;

public class UserFactory {
    static Faker faker = new Faker();

    public static UserLombok positiveUser(){
        UserLombok user = UserLombok.builder()
                .username("nastyushas18.93@gmail.com")
                .password("Qwerty156!")
                .build();
        return user;
    }
    public static UserLombok positiveUser1(){
        UserLombok user = UserLombok.builder()
                .username(faker.internet().emailAddress())
                .password("Qwerty156!")
                .build();
        return user;
    }
}


