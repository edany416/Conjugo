package com.z3dd.conjugo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by EdanYachdav on 4/12/16.
 */
public class VerbSet {

    private Set<Verb> verbSet;
    private Verb selectedVerb;
    private static VerbSet vs = new VerbSet();

    private VerbSet() {
        if (verbSet ==  null) {
            verbSet = new LinkedHashSet<>();
        }
        prepopulateVerbSet();
    }
    public static VerbSet getInstance() {
        return vs;
    }

    public Set<Verb> verbSet() {
        return verbSet;
    }

    public void add(Verb v) {
        verbSet.add(v);
    }

    public void delete(Verb v) {
        verbSet.remove(v);
    }

    public boolean isEmpty(){
        return verbSet.isEmpty();
    }

    public void setSelectedVerb (Verb v) {
        selectedVerb = v;
    }

    public Verb selectedVerb() {
        return selectedVerb;
    }

    public Verb randomVerb() {
        Verb[] verbArray = verbSet.toArray(new Verb[verbSet.size()]);
        Random randomIndex = new Random();
        int index = randomIndex.nextInt(verbArray.length);

        return verbArray[index];
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
