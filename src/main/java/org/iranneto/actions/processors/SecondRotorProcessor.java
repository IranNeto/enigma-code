package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.machinery.parts.Rotor;

import java.util.List;

public class SecondRotorProcessor implements MachineryPartProcessor {

    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        List<Rotor> rotors = encryptMessageRequest.getEnigma().getRotors();

        Integer[] output = rotors.get(0).backMapIndexArray(
                rotors.get(1).backMapIndexArray(
                        rotors.get(2).backMapIndexArray(encryptMessageRequest.getInputIndexes())
                )
        );

        encryptMessageRequest.setInputIndexes(output);
    }

}
