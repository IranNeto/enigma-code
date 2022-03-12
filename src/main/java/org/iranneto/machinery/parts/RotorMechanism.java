package org.iranneto.machinery.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RotorMechanism {

    public List<Rotor> getRotors() {
        return rotors;
    }

    private List<Rotor> rotors;

    public RotorMechanism() {
        List<Rotor> rotors = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> rotors.add(new Rotor(i)));
        this.rotors = rotors;
    }

    public void increment() {
        boolean carry = false;
        for (int i = 0; i < 3; i++) {
            int currentIndex = rotors.get(i).getIndex();
            if (currentIndex == 25) {
                carry = true;
                rotors.get(i).setIndex(0);
            } else {
                rotors.get(i).setIndex(carry || i == 0? currentIndex + 1 : currentIndex);
            }
        }
    }

    public void setRotors(List<Rotor> rotors) {
        this.rotors = rotors;
    }
}
