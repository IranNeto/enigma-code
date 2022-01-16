package org.iranneto.parts;

import org.iranneto.util.RotorMappingCreator;

import java.util.Map;

public class Rotor {
    private int index;
    private Map<Integer, Integer> wireMapping = RotorMappingCreator.create();

    public Rotor(){
        this.wireMapping = RotorMappingCreator.create();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void increment(){
        this.index = this.index == 25 ? 0 : this.index + 1;
    }

    public Map<Integer, Integer> getWireMapping() {
        return wireMapping;
    }

    public void setWireMapping(Map<Integer, Integer> wireMapping) {
        this.wireMapping = wireMapping;
    }
}
