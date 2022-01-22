package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.machinery.parts.PlugBoard;

public class PlugBoardProcessor implements MachineryPartProcessor {
    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        PlugBoard plugBoard = encryptMessageRequest.getEnigma().getPlugBoard();
        Integer[] output = plugBoard.mapIndexArray(encryptMessageRequest.getInputIndexes());
        encryptMessageRequest.setInputIndexes(output);
    }

}
