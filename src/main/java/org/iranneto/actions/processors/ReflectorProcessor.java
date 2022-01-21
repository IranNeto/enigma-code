package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.machinery.parts.Reflector;

public class ReflectorProcessor implements MachineryPartProcessor {
    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        Reflector reflector = encryptMessageRequest.getEnigma().getReflector();
        int[] output = reflector.mapIndexArray(encryptMessageRequest.getInputIndexes());
        encryptMessageRequest.setInputIndexes(output);
    }

}
