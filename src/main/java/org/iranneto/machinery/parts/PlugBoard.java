package org.iranneto.machinery.parts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PlugBoard {
    private int[] map = new int[26];

    public PlugBoard(){
        configMap();
    }

    public int mapIndex(int index){
        return this.map[index];
    }

    public void configMap() {
        IntStream.range(0,26).forEach(index -> this.map[index] = index);

        Set<Integer> indexMapped = new HashSet<>();
        int count = 0;
        while (count != 10) {
            int index = (int) (Math.random() * Integer.MAX_VALUE) % 26;
            int result = (int) (Math.random() * Integer.MAX_VALUE) % 26;

            if(!indexMapped.contains(result) && !indexMapped.contains(index) && result != index && this.map[index] == index){
                indexMapped.add(index);
                indexMapped.add(result);
                this.map[index] = result;
                this.map[result] = index;
                count++;
            }
        }
    }

    public Integer[] mapIndexArray(Integer[] indexes) {
        Integer[] tempIndexes = new Integer[indexes.length];

        IntStream.range(0, indexes.length).forEach(i -> {
            tempIndexes[i] = mapIndex(indexes[i]);
        });

        System.out.println("Plugboard - Result: " + Arrays.toString(tempIndexes));
        return tempIndexes;

    }
}
