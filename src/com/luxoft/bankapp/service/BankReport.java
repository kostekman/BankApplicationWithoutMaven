package com.luxoft.bankapp.service;

import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

/**
 * Created by Adam on 14.04.2016.
 */
public class BankReport {
    public void getNumberOfClients(Bank bank){
        System.out.println("Total number of clients for bank is: " + bank.getClients().size());
    }

    public void getAccountsNumber(Bank bank){
        long amountOfAccounts = 0;
        for(Client client : bank.getClients()){
            amountOfAccounts += client.getAccounts().size();
        }
        System.out.println("Total number of accounts for bank is: " + amountOfAccounts);
    }

    public void getClientsSorted(Bank bank){

    }

    public void getBankCreditSum(Bank bank){}

    public void getClientsByCity(Bank bank){}
}
