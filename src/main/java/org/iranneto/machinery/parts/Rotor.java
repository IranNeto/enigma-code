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

    private void increment() {
        this.index = this.index == 25 ? 0 : this.index + 1;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int mapIndex(int position) {
        return this.map[position];
    }

    private int backMapIndex(int index, int offset){
        int indexWithOffset = (this.index + offset) % 26;
        return (Arrays.asList(map).indexOf(index) + indexWithOffset) % 26;
    }

    public Integer[] backMapIndexArray(Integer[] indexes){
        Integer[] tempIndexes = new Integer[indexes.length];

        IntStream.range(0, indexes.length).forEach(i -> {
            tempIndexes[i] = backMapIndex(indexes[i], i);
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
