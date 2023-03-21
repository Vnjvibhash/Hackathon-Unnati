package com.found101.unnati.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME="session";
    String IS_LOGIN = "IsLoggedIn";
    String ROLE_TYPE="role";
    boolean CONTINUE = false;
    Context context;

    public Session(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(String roleType){
        editor.putBoolean(IS_LOGIN,true).commit();
        editor.putString(ROLE_TYPE, roleType).commit();
    }
//    public void setContinue(boolean Type){
//        editor.putBoolean(CONTINUE, Type).commit();
//    }

    public boolean getSession(){
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public String getRole(){
        return sharedPreferences.getString(ROLE_TYPE,null);
    }

    public void logoutUser(){
        editor.clear().commit();
    }
}
