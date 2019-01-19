package datalayerInterface;

import model.Account;
import model.Profile;

import java.util.HashSet;

public interface IProfile {

    void createProfile(Profile p);

    void updateProfile(Profile p);

    void deleteProfile(Profile p);

    Profile getProfile(int id);

    HashSet<Profile> getProfilesByAccount(Account a);
}
