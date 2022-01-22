package org.iranneto.machinery.parts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Reflector {
    private int[] map = new int[26];

    public Reflector() {
        configMapping();
    }

    public int mapIndex(int index){
        return this.map[index];
    }

    public Integer[] mapIndexArray(Integer[] indexes){
        Integer[] tempIndexes = new Integer[indexes.length];

        IntStream.range(0, indexes.length).forEach(i -> {
            tempIndexes[i] = mapIndex(indexes[i]);
        });

        System.out.println("Reflector - Result: " + Arrays.toString(tempIndexes));
        return tempIndexes;
    }

    public void configMapping() {
        IntStream.range(0, 26).forEach(index -> this.map[index] = -1);

        Set<Integer> indexMapped = new HashSet<>();
        int index = 0;
        while (index != 26) {
            if (this.map[index] != -1) index++;

            int result = (int) (Math.random() * Integer.MAX_VALUE) % 26;

            if(!indexMapped.contains(result) && result != index && this.map[index] == -1){
                indexMapped.add(index);
                indexMapped.add(result);
                this.map[index] = result;
                this.map[result] = index;
                index++;
            }
        }
    }
}
