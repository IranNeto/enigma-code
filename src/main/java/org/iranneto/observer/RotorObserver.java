package org.iranneto.observer;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class RotorObserver {

    //TODO 1 - How make an item in the set be consumed by the right rotor
    public Set<Integer> getRotorOrderIndexWithLoop() {
        return rotorOrderIndexWithLoop;
    }

    public void setRotorOrderIndexWithLoop(Set<Integer> rotorOrderIndexWithLoop) {
        this.rotorOrderIndexWithLoop = rotorOrderIndexWithLoop;
    }

    private Set<Integer> rotorOrderIndexWithLoop = new HashSet<>();

    public void saveLoopEnvet(int order) {

    }
}
