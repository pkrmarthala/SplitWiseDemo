package com.pr.splitwisedemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;
    private double amount;

    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
}
