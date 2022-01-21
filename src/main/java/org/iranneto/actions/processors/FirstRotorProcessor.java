package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.machinery.Enigma;
import org.iranneto.machinery.parts.Rotor;

import java.util.List;

public class FirstRotorProcessor implements MachineryPartProcessor {

    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        Enigma enigma = encryptMessageRequest.getEnigma();
        List<Rotor> rotors = enigma.getRotors();

        int[] output = rotors.get(2).mapIndexArray(
                rotors.get(1).mapIndexArray(
                        rotors.get(0).mapIndexArray(encryptMessageRequest.getInputIndexes())
                )
        );

        encryptMessageRequest.setInputIndexes(output);
    }

}
