package com.pr.splitwisedemo.strategies;

import com.pr.splitwisedemo.models.Expense;
import com.pr.splitwisedemo.models.Transaction;

import java.util.List;

public class GeneralSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
