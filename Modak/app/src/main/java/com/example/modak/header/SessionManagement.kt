package com.example.modak.header

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SessionManagement {

     var sharedPreferences : SharedPreferences
     var editor : SharedPreferences.Editor
    var SHARED_PREFERENCE_NAME : String= "session"
    var SESSION_KEY : String="session_user"
    @SuppressLint("CommitPrefEdits")

    constructor (context: Context)
    {
        sharedPreferences=context.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE)
        editor= sharedPreferences.edit()
    }

    public fun saveSession(user : User)
    {
        val id : Int= user.id
        editor.putInt(SESSION_KEY,id).commit()
    }

    public fun getSession() : Int
    {
      return  sharedPreferences.getInt(SESSION_KEY,-1)
    }

    public fun removeSession()
    {
        editor.putInt(SESSION_KEY,-1).commit()
    }
}