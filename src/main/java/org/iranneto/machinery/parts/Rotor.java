package org.iranneto.machinery.parts;

import org.iranneto.observer.RotorObserver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Rotor {
    private int index;
    private int[] map = new int[26];
    private int order;
    private RotorObserver rotorObserver;

    public Rotor(RotorObserver rotorObserver){
        this.rotorObserver = rotorObserver;
    }

    public Rotor(int order, RotorObserver rotorObserver) {
        this.order = order;
        this.rotorObserver = rotorObserver;
        configMap();
    }

    public int getIndex() {
        return index;
    }

    //TODO How to propagate to other rotors
    private void increment() {
        if(this.index == 25) rotorObserver.saveLoopEnvet(this.order);
        this.index = this.index == 25 ? 0 : this.index + 1;
    }
    //TODO Only the rotor order == 1 that is supposed to increment when mapping an array everytime
    // Rotors 2 and 3 only increment after a loop of rotor 1
    private int mapIndex(int indexToBeMapped) {
        int indexWithOffset = (indexToBeMapped - this.index) >= 0 ? (indexToBeMapped - this.index) : (25 - this.index + indexToBeMapped) % 26;                                                                                          ;
        increment();
        return this.map[indexWithOffset];
    }

    public int[] mapIndexArray(int[] indexes) {
        int[] tempIndexes = new int[indexes.length];

        IntStream.range(0, indexes.length).forEach(i -> {
            tempIndexes[i] = mapIndex(indexes[i]);
        });

        System.out.println("Rotor " + order + " - Result: " + Arrays.toString(tempIndexes));
        return tempIndexes;
    }

    public void configMap() {
        Set<Integer> indexMapped = new HashSet<>();
        int index = 0;
        while (index != 26) {
            int result = (int) (Math.random() * Integer.MAX_VALUE) % 26;

            if (!indexMapped.contains(result)) {
                indexMapped.add(result);
                this.map[index] = result;
                index++;
            }
        }
    }

}
