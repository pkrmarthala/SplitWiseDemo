package com.pr.splitwisedemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity(name = "user_groups") // group & groups are both reserved words. hence used user_groups
public class Group extends BaseModel {
    private String name;
    private String description;

    @ManyToMany
    private List<User> members;

    @ManyToOne
    private User admin;

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
