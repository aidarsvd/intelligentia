package ru.mitapp.intelligentia.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtils() {
    companion object{

        private lateinit var preferences: SharedPreferences

        val QUERY = ""
        private const val PREFERENCE_NAME = "ru.mitapp.APP_PREF"

        fun init(context: Context) {
            preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        }

        fun setQuerry(query: String){
            preferences.edit().putString(QUERY, query).apply()
        }

        fun getQuerry(): String{
            return preferences.getString(QUERY, "")!!
        }

    }
}