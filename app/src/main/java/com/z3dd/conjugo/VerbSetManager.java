package com.z3dd.conjugo;

import java.util.Set;

/**
 * Created by EdanYachdav on 4/24/16.
 */
public class VerbSetManager {
    public static Set<Verb> getVerbSet() {
        return VerbSet.getInstance().verbSet();
    }
    public static void addVerb(Verb verb) {
        VerbSet.getInstance().add(verb);
    }
    public static void deleteVerb(Verb verb) {
        VerbSet.getInstance().delete(verb);
    }
    public static boolean setHasVerb(){
        return !VerbSet.getInstance().isEmpty();
    }
    public static void setSelectedVerb(Verb verb) {
        VerbSet.getInstance().setSelectedVerb(verb);
    }
    public static Verb getSelectedVerb() {
        return VerbSet.getInstance().selectedVerb();
    }
    public static Verb getRandomVerb() {
        return VerbSet.getInstance().randomVerb();
    }
    //TODO: Fix this, doesnt work properly
    public static boolean verbSetHasVerb() {
        return VerbSet.getInstance().isEmpty();
    }
}
