package com.example.instagramcustom;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("F8iNvpJuD1mkfH3H9Ign3M02UaYfcI5bH6j9OvNc")
                .clientKey("NB2XFaQCkVotg38MwEM9516dGvPTcQ0LLhoYU9mK")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
