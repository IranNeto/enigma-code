package org.iranneto.parts;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PlugBoard {
    private int[] map = new int[26];

    public PlugBoard(){
        IntStream.range(0,26).forEach(index -> this.map[index] = index);
    }

    public int mapIndex(int index){
        return this.map[index];
    }

    public void configMap() {
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
}
