package io.react.realworld;

import com.github.javafaker.Faker;

public class UserData {
    public static User defaultUser() {
        return new User("testuser752", "testuser752@mail.com", "12345678");
    }

    public static User randomUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUserName(faker.name().username());
        user.setEmail(faker.name().username() + "@mail.com");
        user.setPassword("12345678");
        return user;
    }
}
