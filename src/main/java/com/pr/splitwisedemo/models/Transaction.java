package com.pr.splitwisedemo.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Transaction {
    private User from;
    private User to;
    private double amount;
}

// this will be sent as response from the SettleUpResponseDTO.