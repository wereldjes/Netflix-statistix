package datalayer;

import main.java.datalayerInterface.IAccount;
import main.java.model.Account;

import java.util.HashSet;

public class TestAccountDAO implements IAccount {

    private HashSet<Account> allAccounts = new HashSet();

    private static TestAccountDAO instance = null;

    public static TestAccountDAO getInstance(){
        if(instance == null) {
            instance = new TestAccountDAO();
        }
        return instance;
    }

    @Override
    public void createAccount(Account a) {
        allAccounts.add(a);
    }

    @Override
    public void updateAccount(Account a) {

    }

    @Override
    public void deleteAccount(Account a) {

    }

    @Override
    public Account getAccountByUsername(String username) {

        for(Account a : allAccounts ){
            if(a.getName().equals(username)){
                return a;
            }
        }
        return null;
    }
}
