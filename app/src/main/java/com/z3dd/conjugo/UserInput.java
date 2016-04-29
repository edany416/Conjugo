package com.z3dd.conjugo;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by EdanYachdav on 4/2/16.
 */
public class UserInput {
    Set<String> userInputSet;

    UserInput(EditText[] array) {
        userInputSet = new LinkedHashSet<>();
        for (EditText et : array) {
            userInputSet.add(et.getText().toString());
        }
    }

    public boolean equalsCurrentVerb(Verb v) {
        boolean isEqual = true;
        ArrayList<String> input = new ArrayList<>(userInputSet);
        ArrayList<String> key = new ArrayList<>(v.verbDetailSet());

        for (int i = 1; i < key.size(); i++) {
            if (!input.get(i-1).equalsIgnoreCase(key.get(i))) {
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }
}

