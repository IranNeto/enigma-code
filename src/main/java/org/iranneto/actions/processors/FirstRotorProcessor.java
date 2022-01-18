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
        int[] output = new int[encryptMessageRequest.getInputIndexes().length];

        for (int i = 0; i < encryptMessageRequest.getInputIndexes().length; i++) {
            //TODO This is ugly as hell - you should be ashamed!
            output[i] = rotors.get(2).mapIndex(
                    rotors.get(1).mapIndex(
                            rotors.get(0).mapIndex(encryptMessageRequest.getInputIndexes()[i])
                    )
            );
        }
    }

}
