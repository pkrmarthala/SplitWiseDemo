package com.pr.splitwisedemo.DTOs;

import com.pr.splitwisedemo.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SettleUpGroupResponseDTO {
    private List<Transaction> transactions;
    private ResponseStatus responseStatus;
    private String message;
}


// from, to, amount