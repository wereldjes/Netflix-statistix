package datalayerInterface;

import main.java.model.Account;

public interface IAccount {

    void createAccount(Account a);

    void updateAccount(Account a);

    void deleteAccount(Account a);

    Account getAccountByUsername(String username);
}
