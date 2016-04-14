package com.luxoft.bankapp.appinterface;

import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.service.BankService;
import com.luxoft.bankapp.service.BankServiceImpl;
import com.luxoft.bankapp.scanner.BankScanner;

class BankCommander {
public static Bank currentBank = new Bank();
public static BankService bankService = new BankServiceImpl();
public static Client currentClient;
        
    static Command[] commands = {
        new FindClientCommand(bankService), // 1
        new AddAccountCommand(bankService),
        new GetAccountsCommand(bankService), // 2
        new WithdrawCommand(bankService),	//3
        new DepositCommand(bankService),	//4
        new TransferCommand(bankService),	//5
        new AddClientCommand(bankService),	//6
        new Command() { // 7 - Exit Command
            public void execute(Bank bank) {
            	BankScanner.closeScanner();
                System.exit(0);
            }
            public void printCommandInfo() {
                System.out.println("Exit");
            }
        }
    };
    
    public static void main(String args[]) {
    	Bank bank = new Bank();
            while (true) {
            	System.out.println("\n");
               for (int i=0;i<commands.length;i++) { // show menu
                     System.out.print(i+") ");
                     commands[i].printCommandInfo();
               }
               String commandString = BankScanner.getScanner().nextLine();
               int command = Integer.valueOf(commandString);
               commands[command].execute(bank);
            
    	}
    }
}
