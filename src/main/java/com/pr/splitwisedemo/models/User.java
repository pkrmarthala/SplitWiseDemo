package com.pr.splitwisedemo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity(name = "users")
public class User extends BaseModel {
    private String name;
    private String password;
    private String phoneNumber;

    // private List<Group> groups;
}
