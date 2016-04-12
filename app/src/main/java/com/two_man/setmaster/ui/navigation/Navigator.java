package com.two_man.setmaster.ui.navigation;

import android.support.v7.app.AppCompatActivity;

import com.two_man.setmaster.entity.Profile;
import com.two_man.setmaster.ui.screen.editprofile.EditProfileActivity;
import com.two_man.setmaster.ui.screen.main.MainActivity;
import com.two_man.setmaster.ui.screen.profile.ProfileActivity;

/**
 *
 */
public class Navigator {

    private AppCompatActivity activity;

    public Navigator(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void openMain() {
        MainActivity.start(activity);
    }

    public void openNewProfile() {
        EditProfileActivity.start(activity, null);
    }

    public void openProfile(Profile profile) {
        ProfileActivity.start(activity, profile);
    }

    public void openEditProfile(Profile profile) {
        EditProfileActivity.start(activity, profile);
    }
}
