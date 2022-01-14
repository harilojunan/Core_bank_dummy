package com.trabeya.core_bank.services;

import com.trabeya.core_bank.accounts.Account;
import com.trabeya.core_bank.accounts.OtherFundTransferResponse;
import com.trabeya.core_bank.accounts.OwnFundTransferResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class AccountServices {

    private static final Map<String, ArrayList<Account>> accounts = new HashMap<>();

    @PostConstruct
    public void initialize() {

        Account account1 = new Account();
        account1.setUserId("001001");
        account1.setAccountNo("a001");
        account1.setBalance(75000.00);

        Account account2 = new Account();
        account2.setUserId("001002");
        account2.setAccountNo("a002");
        account2.setBalance(65000.00);

        Account account3 = new Account();
        account3.setUserId("001003");
        account3.setAccountNo("a003");
        account3.setBalance(35000.00);

        Account account4 = new Account();
        account4.setUserId("001004");
        account4.setAccountNo("a004");
        account4.setBalance(55000.00);

        Account account5 = new Account();
        account5.setUserId("001005");
        account5.setAccountNo("a005");
        account5.setBalance(25000.00);

        Account account6 = new Account();
        account6.setUserId("001006");
        account6.setAccountNo("a006");
        account6.setBalance(45000.00);

        ArrayList<Account> multipleAccounts_account1 = new ArrayList<Account>();
        multipleAccounts_account1.add(account1);
        multipleAccounts_account1.add(account2);

        ArrayList<Account> multipleAccounts_account2 = new ArrayList<Account>();
        multipleAccounts_account2.add(account3);

        ArrayList<Account> multipleAccounts_account3 = new ArrayList<Account>();
        multipleAccounts_account3.add(account4);

        ArrayList<Account> multipleAccounts_account4 = new ArrayList<Account>();
        multipleAccounts_account4.add(account5);
        multipleAccounts_account4.add(account6);

        accounts.put("001001",multipleAccounts_account1);
        accounts.put("001002",multipleAccounts_account2);
        accounts.put("001003",multipleAccounts_account3);
        accounts.put("001004",multipleAccounts_account4);

    }

    public Account getAccountRequest(String account_no, String user_id) {
        ArrayList<Account> listOfValues = accounts.get(user_id);
        for (Account ac : listOfValues) {
            if (ac.getAccountNo().equals(account_no)) {
                return ac;
            }
        }
        return null;
    }

    public double getTotal(String user_id) {
        double total = 0;
        ArrayList<Account> listOfValues = accounts.get(user_id);
        for (Account ac : listOfValues) {
            total += ac.getBalance();
        }
        return total;
    }

    public OwnFundTransferResponse ownFundTransfer(String ownSourceUserId, String ownSourceAccountNo,
                                                   String ownDestinationAccountNo, double transferAmount) {
        Account sourceAccount = null;
        Account destinationAccount = null;
        ArrayList<Account> listOfValues = accounts.get(ownSourceUserId);
        for (Account ac : listOfValues) {
            String currentAccountNo = ac.getAccountNo();
            if (currentAccountNo.equals(ownSourceAccountNo)) {
                sourceAccount = ac;
            } else if (currentAccountNo.equals(ownDestinationAccountNo)) {
                destinationAccount = ac;
            }
        }
        double sourceAccountBalance = sourceAccount.getBalance();
        double sourceAccountFinalBalance = sourceAccountBalance - transferAmount;
        if (sourceAccountFinalBalance >= 0) {
            sourceAccount.setBalance(sourceAccountFinalBalance);
            destinationAccount.setBalance(destinationAccount.getBalance() + transferAmount);
        } else {
            System.out.println("Source Account cant able to transfer");
        }
        OwnFundTransferResponse fundTransfer = new OwnFundTransferResponse();
        fundTransfer.setInitialAccountBalance(sourceAccountBalance);
        fundTransfer.setFinalAccountBalance(sourceAccountFinalBalance);
        fundTransfer.setOurAccountNo(ownSourceAccountNo);
        fundTransfer.setOurUserId(ownSourceUserId);
        return fundTransfer;
    }

    public OtherFundTransferResponse otherFundTransfer(String sourceUserId, String sourceAccountNo, String destinationUserId,
                                     String destinationAccountNo, double transferAmount) {
        Account sourceAccount = null;
        Account destinationAccount = null;
        ArrayList<Account> listOfValues = accounts.get(sourceUserId);
        for (Account ac : listOfValues) {
            String currentAccountNo = ac.getAccountNo();
            if (!currentAccountNo.equals(sourceAccountNo)) {
                sourceAccount = ac;
            }
        }
        ArrayList<Account> listOfValuesdestination = accounts.get(destinationUserId);
        for (Account ac1 : listOfValuesdestination) {
            String currentAccountNo1 = ac1.getAccountNo();
            if (!currentAccountNo1.equals(destinationAccountNo)) {
                destinationAccount = ac1;
            }
        }
        double sourceAccountBalance = sourceAccount.getBalance();
        double sourceAccountFinalBalance = sourceAccountBalance - transferAmount;
        if (sourceAccountFinalBalance >= 0) {
            sourceAccount.setBalance(sourceAccountFinalBalance);
            destinationAccount.setBalance(destinationAccount.getBalance() + transferAmount);
        } else {
            System.out.println("Source Account cant able to transfer");
        }
        OtherFundTransferResponse fundTransferOther = new OtherFundTransferResponse();
        fundTransferOther.setOurAccountNo(sourceAccountNo);
        fundTransferOther.setOurUserId(sourceUserId);
        fundTransferOther.setInitialAccountBalance(sourceAccountBalance);
        fundTransferOther.setFinalAccountBalance(sourceAccountFinalBalance);
        return fundTransferOther;
    }
}
