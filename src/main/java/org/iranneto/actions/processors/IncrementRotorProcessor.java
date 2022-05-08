package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.machinery.parts.RotorMechanism;


public class IncrementRotorProcessor implements MachineryPartProcessor {

    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        RotorMechanism rotorMechanism = encryptMessageRequest.getEnigma().getRotorMechanism();
        rotorMechanism.increment(encryptMessageRequest.getInputIndexes().length);
    }
}
