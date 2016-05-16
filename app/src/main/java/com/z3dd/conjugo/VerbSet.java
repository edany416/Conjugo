package com.z3dd.conjugo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by EdanYachdav on 4/12/16.
 */
public class VerbSet {

    private static Set<Verb> verbSet;
    private static Verb selectedVerb;
    private static VerbSet vs = new VerbSet();

    private VerbSet() {
        if (verbSet == null) {
            verbSet = new LinkedHashSet<>();
        }
        prepopulateVerbSet();
    }

    public static VerbSet getInstance() {
        return vs;
    }

    public static Set<Verb> getVerbSet() {
        return getInstance().verbSet;
    }

    public static boolean add(Verb v) {
        return getInstance().verbSet.add(v);
    }

    public static void delete(Verb v) {
        getInstance().verbSet.remove(v);
    }

    public static boolean isEmpty() {
        return getInstance().verbSet.isEmpty();
    }

    public static void setSelectedVerb(Verb v) {
        getInstance().selectedVerb = v;
    }

    public static Verb getSelectedVerb() {
        return selectedVerb;
    }

    public static Verb getRandomVerb() {
        Verb[] verbArray = verbSet.toArray(new Verb[verbSet.size()]);
        Random randomIndex = new Random();
        int index = randomIndex.nextInt(verbArray.length);

        return verbArray[index];
    }

    public static boolean setHasVerb(){
        return !VerbSet.getInstance().isEmpty();
    }

    private void prepopulateVerbSet() {
        String[] sArray1 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] sArray2 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};

        Verb v1 = new Verb(sArray1);
        Verb v2 = new Verb(sArray2);

        verbSet.add(v1);
        verbSet.add(v2);

    }

}
