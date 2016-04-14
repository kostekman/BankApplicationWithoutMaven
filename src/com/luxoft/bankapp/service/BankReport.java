package com.luxoft.bankapp.service;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.model.SavingAccount;

import java.util.*;

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
        System.out.println("Sorted clients: ");
        for(Client client : bank.getClients()){
            System.out.println(client.getName());
        }
    }

    public void getBankCreditSum(Bank bank){
        float amountOfCredit = 0;
        for(Client client : bank.getClients()){
            for(Account account : client.getAccounts()){
                if(account instanceof SavingAccount && account.getBalance() < 0){
                    amountOfCredit -= account.getBalance();
                }
            }
        }
        System.out.println("Total credit in bank is: " + amountOfCredit);
    }

    public void getClientsByCity(Bank bank){
        Map<Client, String> clientMap = new TreeMap<Client, String>();

        for(Client client : bank.getClients()){
            clientMap.put(client, client.getCity());
        }

        Map<String, Set<Client>> cityMap = new TreeMap<String, Set<Client>>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


        System.out.println("Clients sorted by city");


    }
}
