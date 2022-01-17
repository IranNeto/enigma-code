package org.iranneto.parts;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Reflector {
    private int[] map = new int[26];

    public Reflector() {
        buildMapping();
    }

    public int mapIndex(int index){
        return this.map[index];
    }

    private void buildMapping() {
        IntStream.range(0, 26).forEach(index -> this.map[index] = -1);
    }

    public void configMapping() {
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
