package com.smarthouse.user;

import com.smarthouse.commonutil.TestObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        TestObject testObject = new TestObject(null);
        System.out.println(testObject.getName());
        System.out.println(TestObject.getHelloString());

        SpringApplication.run(UserApplication.class, args);
    }
}
