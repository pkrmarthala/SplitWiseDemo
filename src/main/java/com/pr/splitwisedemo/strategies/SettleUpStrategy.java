package com.pr.splitwisedemo.strategies;

import com.pr.splitwisedemo.models.Expense;
import com.pr.splitwisedemo.models.Transaction;
import com.pr.splitwisedemo.models.User;

import java.util.HashMap;
import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);

    static HashMap<User, Double> findNetAmount(List<Expense> expenses) {
        return null;
    }
}
