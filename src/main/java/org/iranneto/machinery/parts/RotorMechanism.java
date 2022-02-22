package org.iranneto.machinery.parts;

import java.util.List;

public class RotorMechanism {

    public List<Rotor> getRotors() { return rotors; }

    private List<Rotor> rotors;

    public RotorMechanism() {}

    public RotorMechanism(List<Rotor> rotors) {
        this.rotors = rotors;
    }

    public void increment(int index, int order) {
//        if(index == 25) rotorObserver.increment(.order);
        index = index == 25 ? 0 : index + 1;
    }

    public void setRotors(List<Rotor> rotors) { this.rotors = rotors; }
}
