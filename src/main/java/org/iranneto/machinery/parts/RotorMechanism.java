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

    /*
    * 1. Calcule in how many shifts the previous rotor need to complete one lap (only rotor 1 and 2)
    * 2. Comparing the number above with the input position we can shift 1 position to
         the current rotor because it moved 1 position. What happens if the previous rotor
         had given 2 laps? R: Then the inputPosition/26 would be responsible to sum this value.
    * 3. In the end, sum the shifts to the index position to be mapped and return the result
    */
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
        //TODO Calcule the index after rotor process
//        boolean carry = false;
//        for (int i = 0; i < 3; i++) {
//            int currentIndex = rotors.get(i).getIndex();
//            if (currentIndex == 25) {
//                carry = true;
//                rotors.get(i).setIndex(0);
//            } else {
//                rotors.get(i).setIndex(carry || i == 0? currentIndex + 1 : currentIndex);
//            }
//        }
    }
}
