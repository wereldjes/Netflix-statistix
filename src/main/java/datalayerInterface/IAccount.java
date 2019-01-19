package datalayerInterface;

import model.Account;

import java.util.List;

public interface IAccount {

    void createAccount(Account a);

    void updateAccount(Account a);

    void deleteAccount(Account a);

    Account getAccountByUsername(String username);

    List<Account> getAccountsWithOneProfile();
}
