/*
 *
 *   Created by VnjVibhash on 2/22/24, 1:50 AM
 *   Copyright Ⓒ 2024. All rights reserved Ⓒ 2024 http://vivekajee.in/
 *   Last modified: 2/21/24, 10:44 AM
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

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
