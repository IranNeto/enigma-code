package org.iranneto.machinery;

import org.iranneto.machinery.parts.PlugBoard;
import org.iranneto.machinery.parts.Reflector;
import org.iranneto.machinery.parts.Rotor;
import org.iranneto.observer.RotorObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Enigma {

    private List<Rotor> rotors = new ArrayList<>();
    private Reflector reflector = new Reflector();
    private PlugBoard plugBoard = new PlugBoard();

    public Enigma(){
        RotorObserver rotorObserver = new RotorObserver();
        IntStream.range(0,3).forEach(i -> rotors.add(new Rotor(i, rotorObserver)));
    }

    public List<Rotor> getRotors() {
        return this.rotors;
    }
}
