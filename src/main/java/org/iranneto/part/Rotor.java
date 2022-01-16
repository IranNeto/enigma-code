package org.iranneto.part;

import java.util.HashMap;

public class Rotor {
    private int index;
    private HashMap<Integer, Integer> wireMapping;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void increment(){
        this.index = this.index == 26 ? 1 : this.index + 1;
    }

    public HashMap<Integer, Integer> getWireMapping() {
        return wireMapping;
    }

    public void setWireMapping(HashMap<Integer, Integer> wireMapping) {
        this.wireMapping = wireMapping;
    }
}
