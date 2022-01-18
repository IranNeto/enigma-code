package org.iranneto.actions.processors;

import org.iranneto.actions.EncryptMessageRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.iranneto.machinery.parts.Dictionary.dictionary;

public class PrepareInputProcessor implements MachineryPartProcessor {
    @Override
    public void process(EncryptMessageRequest encryptMessageRequest) {
        String inputText = encryptMessageRequest.getTextInput();

        int[] output = new int[inputText.length()];

        List<String> dictionaryList = Arrays.asList(dictionary);

        List<Integer> l = inputText.chars()
                .mapToObj(c -> dictionaryList.indexOf(String.valueOf((char) c)))
                .collect(Collectors.toList());

        for (int i = 0; i < l.size(); i++) {
            output[i] = l.get(i);
        }

        encryptMessageRequest.setInputIndexes(output.clone());
    }

}
