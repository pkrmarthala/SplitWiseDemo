package com.pr.splitwisedemo.services;

import com.pr.splitwisedemo.models.Expense;
import com.pr.splitwisedemo.models.Group;
import com.pr.splitwisedemo.models.Transaction;
import com.pr.splitwisedemo.repositories.GroupRepository;
import com.pr.splitwisedemo.strategies.GeneralSettleUpStrategy;
import com.pr.splitwisedemo.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    private final GroupRepository groupRepository;
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    public SettleUpService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        this.settleUpStrategy = new GeneralSettleUpStrategy();
    }


    public List<Transaction> settleUpGroup(Long groupId) {
        // 1. Get the group
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()) {
            throw new RuntimeException("Group not found");
        }
        Group group = groupOptional.get();

        // 2. Get all the expenses from that group
        List<Expense> expenses = group.getExpenses();

        // 3. call the algorithm, pass the expenses to get the list of transactions
        // 4. send the list of transactions back to the controller.
        return settleUpStrategy.settleUp(expenses);
    }

    public List<Transaction> settleUpUser(Long groupId) {
        return null;
    }
}
