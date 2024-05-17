import java.util.ArrayList;
import java.util.List;

class Transaction {
    private String type;
    private double amount;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }


}

class Account {
    private int accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, "Deposit into account"));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount, "Withdrawal from account"));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void transfer(Account receiver, double amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.deposit(amount);
            transactions.add(new Transaction("Transfer", amount, "Transfer to account " + receiver.getAccountNumber()));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1;
    }

    public Account createAccount() {
        Account account = new Account(nextAccountNumber++);
        accounts.add(account);
        return account;
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

  
        Account account1 = bank.createAccount();
        Account account2 = bank.createAccount();

   
        account1.deposit(1000);
        account1.withdraw(200);

        account1.transfer(account2, 300);

     
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}
