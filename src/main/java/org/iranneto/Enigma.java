package org.iranneto;

import org.iranneto.part.Rotor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Enigma {

    private List<Rotor> rotors = new ArrayList<>();

    public Enigma(){
        IntStream.range(0,3).forEach(loop -> rotors.add(new Rotor()));
    }

    public static void main(String[] args) {

    }
}
