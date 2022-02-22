package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.machinery.parts.Rotor;

import java.util.List;

public class FirstRotorProcessor implements MachineryPartProcessor {

    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        List<Rotor> rotors = encryptMessageRequest.getEnigma().getRotorMechanism().getRotors();

        Integer[] output = rotors.get(2).mapIndexArray(
                rotors.get(1).mapIndexArray(
                        rotors.get(0).mapIndexArray(encryptMessageRequest.getInputIndexes())
                )
        );

        encryptMessageRequest.setInputIndexes(output);
    }

}
