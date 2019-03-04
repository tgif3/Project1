package com.example.project1;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MemoryManager {
    private static final String KEY = "MANAGER";

    private static final String LAST = "LAST_KEY";
    private static final String NUMBERS = "NUMBERS_KEY";

    private MemoryManager() {
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    static int getLastNumber(Context context) {
        return getSharedPreferences(context).getInt(LAST, 0);
    }

    static void setLastNumber(Context context, int number) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(LAST, number);
        editor.apply();
    }

    static HashSet<String> getNumbers(Context context) {
        return (HashSet<String>) getSharedPreferences(context).getStringSet(NUMBERS, new HashSet<>());
    }

    static void addNumbers(Context context, HashSet<String> numbers) {
        Set<String> stringSet = getNumbers(context);
        stringSet.addAll(numbers);

        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putStringSet(NUMBERS, stringSet);
        editor.apply();
    }
}
