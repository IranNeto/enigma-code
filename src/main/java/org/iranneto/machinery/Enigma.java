package org.iranneto.machinery;

import org.iranneto.machinery.parts.PlugBoard;
import org.iranneto.machinery.parts.Reflector;
import org.iranneto.machinery.parts.Rotor;
import org.iranneto.machinery.parts.RotorMechanism;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Enigma {

    private RotorMechanism rotorMechanism = new RotorMechanism();

    private Reflector reflector = new Reflector();

    private PlugBoard plugBoard = new PlugBoard();

    public Reflector getReflector() {
        return reflector;
    }

    public RotorMechanism getRotorMechanism() {
        return rotorMechanism;
    }

    public PlugBoard getPlugBoard() {
        return plugBoard;
    }
}
