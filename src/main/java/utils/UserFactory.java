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
}
