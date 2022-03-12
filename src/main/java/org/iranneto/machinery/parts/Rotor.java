package org.iranneto.machinery.parts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Rotor {
    private int index;
    private Integer[] map = new Integer[26];
    private int order;
    public Rotor(int order) {
        this.order = order;
        configMap();
    }

    public int getIndex() {
        return index;
    }

    //TODO How to propagate to other rotors
    // When is the moment to really +1

    private void increment() {
//        if(this.index == 25) rotorMechanism.increment(this.index, this.order);
        this.index = this.index == 25 ? 0 : this.index + 1;
    }
    //TODO Only the rotor order == 1 that is supposed to increment when mapping an array everytime
    // Rotors 2 and 3 only increment after a loop of rotor 1

    public void setIndex(int index) {
        this.index = index;
    }

    private int mapIndex(int indexToBeMapped) {
        int indexWithOffset = (indexToBeMapped + this.index) <= 25 ? (indexToBeMapped + this.index) : 25 - (this.index + indexToBeMapped);                                                                                          ;
        return this.map[indexWithOffset];
    }

    public Integer[] mapIndexArray(Integer[] indexes) {
        Integer[] tempIndexes = new Integer[indexes.length];

        IntStream.range(0, indexes.length).forEach(i -> {
            tempIndexes[i] = mapIndex(indexes[i]);
        });

        System.out.println("[FIRST] Rotor " + order + " - Result: " + Arrays.toString(tempIndexes));
        return tempIndexes;
    }

    private int backMapIndex(int index){
        return Arrays.asList(map).indexOf(index);
    }

    public Integer[] backMapIndexArray(Integer[] indexes){
        Integer[] tempIndexes = new Integer[indexes.length];

        IntStream.range(0, indexes.length).forEach(i -> {
            tempIndexes[i] = backMapIndex(indexes[i]);
        });

        System.out.println("[SECOND] Rotor " + order + " - Result: " + Arrays.toString(tempIndexes));
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
