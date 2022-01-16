package org.iranneto.util;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class RotorMappingCreator {

    public static HashMap<Integer, Integer> create() {
        HashMap<Integer, Integer> mapping = new LinkedHashMap<>();
        while (mapping.size() != 26) {
            mapping.put(
                    (int) Math.floor(Math.random() * Integer.MAX_VALUE) % 26,
                    (int) Math.floor(Math.random() * Integer.MAX_VALUE) % 26
            );
        }
        return mapping;
    }

}
