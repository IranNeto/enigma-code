package org.iranneto.machinery;

import org.iranneto.machinery.parts.PlugBoard;
import org.iranneto.machinery.parts.Reflector;
import org.iranneto.machinery.parts.Rotor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Enigma {

    private List<Rotor> rotors = new ArrayList<>();
    private Reflector reflector = new Reflector();
    private PlugBoard plugBoard = new PlugBoard();

    public Enigma(){
        IntStream.range(0,3).forEach(loop -> rotors.add(new Rotor()));
    }

    public List<Rotor> getRotors() {
        return this.rotors;
    }
}
