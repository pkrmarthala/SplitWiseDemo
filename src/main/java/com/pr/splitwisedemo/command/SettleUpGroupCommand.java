package com.pr.splitwisedemo.command;

import com.pr.splitwisedemo.DTOs.ResponseStatus;
import com.pr.splitwisedemo.DTOs.SettleUpGroupRequestDTO;
import com.pr.splitwisedemo.DTOs.SettleUpGroupResponseDTO;
import com.pr.splitwisedemo.controllers.SettleUpController;
import com.pr.splitwisedemo.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // since we cannot use @Autowired in non-bean (plain object) class
public class SettleUpGroupCommand implements Command {
    @Autowired
    private SettleUpController settleUpController;

    @Override
    public boolean matches(String cmd) {
        // "SettleUpGroup 3"
        // Convert the complete command into list of words
        List<String> words = List.of(cmd.split(" "));
        if(words.size() == 2 && words.get(0).equals("SettleUpGroup")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String cmd) {
        List<String> words = List.of(cmd.split(" "));
        Long groupId = Long.parseLong(words.get(1));

        SettleUpGroupRequestDTO requestDTO = new SettleUpGroupRequestDTO();
        requestDTO.setGroupId(groupId);

        SettleUpGroupResponseDTO responseDTO = settleUpController.settleUpGroup(requestDTO);
        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println(responseDTO.getMessage());
            for(Transaction transaction : responseDTO.getTransactions()) {
                System.out.println(transaction.getFrom().getName() + " should pay " + transaction.getAmount() + " to " + transaction.getTo().getName() + ".");
            }
        } else {
            System.out.println(responseDTO.getMessage());
        }
    }
}
