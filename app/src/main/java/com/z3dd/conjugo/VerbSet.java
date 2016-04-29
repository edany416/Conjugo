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

    public boolean isEmpty() {
        return verbSet.isEmpty();
    }

    private void prepopulateVerbSet() {
        String[] sArray1 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] sArray2 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        String[] sArray3 = new String[]{"10", "20", "30", "40", "50", "60", "70", "80"};
        String[] sArray4 = new String[]{"100", "200", "300", "400", "500", "600", "700", "800"};
        String[] sArray5 = new String[]{"1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000"};
        String[] sArray6 = new String[]{"10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000"};

        Verb v1 = new Verb(sArray1);
        Verb v2 = new Verb(sArray2);
        Verb v3 = new Verb(sArray3);
        Verb v4 = new Verb(sArray4);
        Verb v5 = new Verb(sArray5);
        Verb v6 = new Verb(sArray6);

        verbSet.add(v1);
        verbSet.add(v2);
        verbSet.add(v3);
        verbSet.add(v4);
        verbSet.add(v5);
        verbSet.add(v6);
    }



}
