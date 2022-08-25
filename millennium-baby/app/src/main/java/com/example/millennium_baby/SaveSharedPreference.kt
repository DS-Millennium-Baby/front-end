package com.example.millennium_baby

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SaveSharedPreference {
    companion object{
        fun getSharedPreferences(ctx: Context): SharedPreferences? {
            return PreferenceManager.getDefaultSharedPreferences(ctx)
        }

        // User의 tested
        fun setUserTested(ctx: Context, tested: Boolean) {
            val editor = getSharedPreferences(ctx)!!.edit()
            editor.putBoolean("tested", tested)
            editor.commit()
        }
        fun getUserTested(ctx: Context?): Boolean? { return getSharedPreferences(ctx!!)!!.getBoolean("tested", false) }

        // User의 email
        fun setUserEmail(ctx: Context, email: String) {
            val editor = getSharedPreferences(ctx)!!.edit()
            editor.putString("useremail", email)
            editor.commit()
        }
        fun getUserEmail(ctx: Context?): String? { return getSharedPreferences(ctx!!)!!.getString("useremail", "") }

        // User의 name
        fun setUserName(ctx: Context, name: String) {
            val editor = getSharedPreferences(ctx)!!.edit()
            editor.putString("username", name)
            editor.commit()
        }
        fun getUserName(ctx: Context?): String? { return getSharedPreferences(ctx!!)!!.getString("username", "") }

        // User의 _id
        fun setUserID(ctx: Context, name: String) {
            val editor = getSharedPreferences(ctx)!!.edit()
            editor.putString("userID", name)
            editor.commit()
        }
        fun getUserID(ctx: Context?): String? { return getSharedPreferences(ctx!!)!!.getString("userID", "") }

        // firstMajor
        fun setFirstMajor(ctx: Context, name: String) {
            val editor = getSharedPreferences(ctx)!!.edit()
            editor.putString("firstMajor", name)
            editor.commit()
        }
        fun getFirstMajor(ctx: Context?): String? { return getSharedPreferences(ctx!!)!!.getString("firstMajor", "") }

        // secondMajor
        fun setSecondMajor(ctx: Context, name: String) {
            val editor = getSharedPreferences(ctx)!!.edit()
            editor.putString("secondMajor", name)
            editor.commit()
        }
        fun getSecondMajor(ctx: Context?): String? { return getSharedPreferences(ctx!!)!!.getString("secondMajor", "") }

        // 저장된 SharedPreference 값 전체 삭제
        fun clearAll(ctx: Context?) {
            val editor = getSharedPreferences(ctx!!)!!.edit()
            editor.clear()
            editor.commit()
        }

    }
}