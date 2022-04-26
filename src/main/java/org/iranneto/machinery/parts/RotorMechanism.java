package org.iranneto.machinery.parts;

import java.util.ArrayList;
import java.util.Arrays;
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

    private int mapIndex(int indexToBeMapped, int inputPosition, int order) {
        if(order == 0) {
            int firstRotorIndex = this.rotors.get(0).getIndex();
            int indexWithOffset = (firstRotorIndex + inputPosition) % 26;
            int indexToBeMappedWithOffset = (indexToBeMapped + indexWithOffset) % 26;
            return this.getRotors().get(order).mapIndex(indexToBeMappedWithOffset);
        } else if (order == 1) {
            int firstRotorLap = 26 - rotors.get(0).getIndex();
            int offset =  inputPosition < firstRotorLap ? 0 : 1 + inputPosition / 26;
            int indexToBeMappedWithOffset = (indexToBeMapped + offset) % 26;
            return this.getRotors().get(order).mapIndex(indexToBeMappedWithOffset);
        } else {
            int secondRotorLap = 26 - rotors.get(1).getIndex();
            int offset = inputPosition < secondRotorLap ? 0 : 1 + inputPosition / 26;
            int indexToBeMappedWithOffset = (indexToBeMapped + offset) % 26;
            return this.getRotors().get(order).mapIndex(indexToBeMappedWithOffset);
        }
    }

    public Integer[] mapIndexArray(Integer[] indexes, int order) {
        Integer[] tempIndexes = new Integer[indexes.length];

        IntStream.range(0, indexes.length).forEach(i -> {
            tempIndexes[i] = mapIndex(indexes[i], i, order);
        });

        System.out.println("[FIRST] Rotor " + order + " - Result: " + Arrays.toString(tempIndexes));
        return tempIndexes;
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
}
