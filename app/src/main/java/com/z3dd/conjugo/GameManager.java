package com.z3dd.conjugo;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by EdanYachdav on 5/11/16.
 */
public class GameManager {
    private static Verb currentVerb;

    public static String nextVerb() {
        currentVerb = VerbSet.getRandomVerb();
        return currentVerb.verbName();
    }

    public static boolean currentVerbMatches(Verb v) {
        boolean isMatch = true;
        ArrayList<String> userInput = new ArrayList<>(v.verbDetailSet());
        ArrayList<String> key = new ArrayList<>(currentVerb.verbDetailSet());

        for (int i = 1; i < key.size(); i++) {
            if (!userInput.get(i - 1).equalsIgnoreCase(key.get(i))) {
                isMatch = false;
                break;
            }
        }
        return isMatch;
    }
}
