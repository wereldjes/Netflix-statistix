package datalayerInterface;

import model.Profile;

public interface IProfile {

    void createProfile(Profile p);

    void updateProfile(Profile p);

    void deleteProfile(Profile p);

    Profile getProfile(int id);
}
