package org.iranneto.actions;

import org.iranneto.actions.processors.*;

import java.util.ArrayList;
import java.util.List;

public class EncryptMessageRunner {

    private List<MachineryPartProcessor> processors = new ArrayList<>();

    public EncryptMessageRunner() {
        processors.add(new PrepareInputProcessor());
        processors.add(new FirstRotorProcessor());
        processors.add(new ReflectorProcessor());
        processors.add(new SecondRotorProcessor());
        processors.add(new PlugBoardProcessor());
        processors.add(new PrintMessageProcessor());

    }

    public String run(EncryptMessageRequest encryptMessageRequest) {

        for (MachineryPartProcessor processor : processors) {
            processor.process(encryptMessageRequest);
        }

        return encryptMessageRequest.getOutputText();
    }


}
