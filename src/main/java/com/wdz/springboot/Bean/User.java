package com.wdz.springboot.Bean;

import javax.validation.constraints.*;

/**
 * 需要验证值的类。
 */
public class User {
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message ="Name cannot be empty")
    private String name;

    @AssertTrue
    private Boolean isWorking;

    @Size(min=10, max = 200, message = "About Me must be between 10 and 200 character")
    private String abouleMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private Integer age;

    @Email(message = "Email should be valid")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    public String getAbouleMe() {
        return abouleMe;
    }

    public void setAbouleMe(String abouleMe) {
        this.abouleMe = abouleMe;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
