package ru.mitapp.intelligentia.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtils() {
    companion object{

        private lateinit var preferences: SharedPreferences

        val I  = 0
        private const val PREFERENCE_NAME = "ru.mitapp.APP_PREF"

        fun init(context: Context) {
            preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        }

        fun setIn(i: Int){
            preferences.edit().putInt("I", i).apply()
        }

        fun getIn(): Int{
            return preferences.getInt("I", 0)
        }

    }
}