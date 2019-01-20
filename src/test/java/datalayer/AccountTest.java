package datalayer;

import model.Account;
import model.Profile;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {

    @Test
    public void addAccountTest(){
        Account a = new Account("testName", "testStreetName", "test", "testResidence", "aa0000");

        if(AccountDAO.getInstance().getAccountByUsername(a.getName()) != null){
            AccountDAO.getInstance().deleteAccount(AccountDAO.getInstance().getAccountByUsername(a.getName()));
            AccountDAO.getInstance().createAccount(a);
        } else {
            AccountDAO.getInstance().createAccount(a);
        }

        assertEquals(a.getName() ,AccountDAO.getInstance().getAccountByUsername("testName").getName());
        AccountDAO.getInstance().deleteAccount(AccountDAO.getInstance().getAccountByUsername("testName"));
    }

    @Test
    public void getAccountsWithOneProfile(){
        Account a = new Account("testName", "testStreetName", "test", "testResidence", "aa0000");
        Account b = null;

        if(AccountDAO.getInstance().getAccountByUsername("testName") != null){
            AccountDAO.getInstance().deleteAccount(AccountDAO.getInstance().getAccountByUsername("testName"));
            AccountDAO.getInstance().createAccount(a);
        } else {
            AccountDAO.getInstance().createAccount(a);
        }

        Profile p = new Profile("testProfileName", LocalDate.now(), AccountDAO.getInstance().getAccountByUsername("testName").getAccountID());
        ProfileDAO.getInstance().createProfile(p);
        List<Account> list = AccountDAO.getInstance().getAccountsWithOneProfile();

        for(Account ac : list){
            if(ac.getName().equals(AccountDAO.getInstance().getAccountByUsername("testName").getName())){
                b = ac;
            }
        }

        assertEquals(a.getName(), b.getName());
        AccountDAO.getInstance().deleteAccount(AccountDAO.getInstance().getAccountByUsername("testName"));
    }
}
