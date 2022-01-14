package com.trabeya.core_bank.endpoint;

import com.trabeya.core_bank.accounts.*;
import com.trabeya.core_bank.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//*
//Author: Harilojunan.N
//Date	: 13/January/2022
//*
@Endpoint
public class AccountEndpoint {

    @Autowired
    AccountServices accountServices = new AccountServices();

    // Get Account datas
    @PayloadRoot(namespace = "http://www.trabeya.com/core_bank/accounts", localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccountRequest(@RequestPayload GetAccountRequest request) {
        GetAccountResponse response = new GetAccountResponse();
        try {
            response.setAccount(accountServices.getAccountRequest(request.getAccountNo(),request.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    // Get Total Amount data using user_id
    @PayloadRoot(namespace = "http://www.trabeya.com/core_bank/accounts", localPart = "getTotalAmountRequest")
    @ResponsePayload
    public GetTotalAmountResponse getTotalAmountRequest(@RequestPayload GetTotalAmountRequest request) {
        GetTotalAmountResponse response = new GetTotalAmountResponse();
        try {
            response.setTotalAmount(accountServices.getTotal(request.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    // Own Account Fund Transfer
    @PayloadRoot(namespace = "http://www.trabeya.com/core_bank/accounts", localPart = "ownFundTransfer")
    @ResponsePayload
    public OwnFundTransferResponse ownFundTransfer(@RequestPayload OwnFundTransfer request) {
        OwnFundTransferResponse fd = null;
        try {
            fd = accountServices.ownFundTransfer(request.getOwnSourceUserId(),request.getOwnSourceAccountNo(),
                    request.getOwnDestinationAccountNo(),request.getTransferAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fd;
    }

    // Other Account Fund Transfer
    @PayloadRoot(namespace = "http://www.trabeya.com/core_bank/accounts", localPart = "otherFundTransfer")
    @ResponsePayload
    public OtherFundTransferResponse OtherFundTransfer(@RequestPayload OtherFundTransfer request) {
        OtherFundTransferResponse ofd = null;
        try {
            ofd = accountServices.otherFundTransfer(request.getSourceUserId(),
                    request.getSourceAccountNo(),request.getDestinationUserId(),
                    request.getDestinationAccountNo(),request.getTransferAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ofd;
    }
}
