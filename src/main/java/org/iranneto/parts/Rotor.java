package org.iranneto.parts;

import java.util.*;

public class Rotor {
    private int index;
    private int[] map = new int[26];

    public Rotor(){
        configMap();
    }

    public int getIndex() {
        return index;
    }

    public void increment(){
        this.index = this.index == 25 ? 0 : this.index + 1;
    }

    public int mapIndex(int index){
        return this.map[index];
    }

    public void configMap() {
        Set<Integer> indexMapped = new HashSet<>();
        int index = 0;
        while (index != 26) {
            int result = (int) (Math.random() * Integer.MAX_VALUE) % 26;

            if(!indexMapped.contains(result)){
                indexMapped.add(result);
                this.map[index] = result;
                index++;
            }
        }
    }
}
