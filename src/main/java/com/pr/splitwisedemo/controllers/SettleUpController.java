package com.pr.splitwisedemo.controllers;

import com.pr.splitwisedemo.DTOs.*;
import com.pr.splitwisedemo.models.Transaction;
import com.pr.splitwisedemo.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private final SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO request) {
        SettleUpGroupResponseDTO response = new SettleUpGroupResponseDTO();
        try {
            List<Transaction> transactions = settleUpService.settleUpGroup(request.getGroupId());
            response.setTransactions(transactions);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("Pay the mentioned transactions to Settle up the group.");
        } catch(Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO request) {
        return null;
    }
}
