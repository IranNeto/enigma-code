package org.iranneto.machinery.parts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Rotor {
    private int index;
    private int[] map = new int[26];
    private int order;

    public Rotor(){}

    public Rotor(int order) {
        this.order = order;
        configMap();
    }

    public int getIndex() {
        return index;
    }

    //TODO How add feature for increment rotor
    //LinkedList?
    //How to propagate to other rotors
    public void increment() {
        this.index = this.index == 25 ? 0 : this.index + 1;
    }

    private int mapIndex(int index) {
        return this.map[index];
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
