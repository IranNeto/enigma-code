package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.machinery.parts.RotorMechanism;

public class FirstRotorProcessor implements MachineryPartProcessor {

    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        RotorMechanism rotorMechanism = encryptMessageRequest.getEnigma().getRotorMechanism();

        Integer[] output = rotorMechanism.mapIndexArray(
                rotorMechanism.mapIndexArray(
                        rotorMechanism.mapIndexArray(encryptMessageRequest.getInputIndexes(),
                                0),
                        1
                ),
                2
        );

        encryptMessageRequest.setInputIndexes(output);
    }

}
