package com.asuper.abocha.cs_go.Managers;

import com.asuper.abocha.cs_go.Tacticks;

/**
 * Created by abakarmagomedov on 12.04.17.
 */

public class MyTransitionManager {

    private int lastTransition;
    private boolean smokes;
    private boolean flashbangs;
    private boolean molotovs;


    public int getLastTransition() {
        return lastTransition;
    }

    public void setLastTransition(int lastTransition) {
        this.lastTransition = lastTransition;
    }

    public void setTrueOneAndSetFalseAnothers(Tacticks tacticks){
        switch (tacticks){
            case SMOKES:
                smokes = true;
                flashbangs = false;
                molotovs = false;
                break;
            case FLASHBANGS:
                smokes = false;
                flashbangs = true;
                molotovs = false;
                break;
            case MOLOTOVS:
                smokes = false;
                flashbangs = false;
                molotovs = true;
                break;
        }
    }

    public Tacticks getActualTactick(){
        if(smokes) return Tacticks.SMOKES;
        if(flashbangs) return Tacticks.FLASHBANGS;
        if(molotovs) return Tacticks.MOLOTOVS;
        return null;
    }
}
