package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;

import java.util.List;
import java.util.stream.Collectors;

import static org.iranneto.machinery.parts.Dictionary.dictionary;

public class PrintMessageProcessor implements MachineryPartProcessor {
    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        List<String> outputList = List.of(encryptMessageRequest.getInputIndexes())
                .stream().map(it -> dictionary[it]).collect(Collectors.toList());

        encryptMessageRequest.setOutputText(
                outputList.stream()
                        .reduce("", (subtotal, element) -> subtotal + element
                        )
        );

        System.out.println("Print message - Result: " + encryptMessageRequest.getOutputText());
    }

}
