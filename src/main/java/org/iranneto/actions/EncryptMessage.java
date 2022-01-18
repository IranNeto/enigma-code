package org.iranneto.actions;

import org.iranneto.machinery.Enigma;
import static org.iranneto.machinery.parts.Dictionary.dictionary;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EncryptMessage {

    private Enigma enigma;

    public EncryptMessage(Enigma enigma){
        this.enigma = enigma;
    }

    public String encryptMessage(String input){
        int[] inputIndexes = getInputIndexes(input);
        int[] inputAfterRotors = getOverRotors(inputIndexes);
        return null;
    }

    private int[] getInputIndexes(String input){
        int[] inputIndexes = new int[input.length()];

        List<String> dictionaryList = Arrays.asList(dictionary);

        List<Integer> l = Stream.of(input)
            .map(letter -> dictionaryList.indexOf(letter))
            .collect(Collectors.toList());

        for (int i = 0; i < l.size(); i++) {
            inputIndexes[i] = l.get(i);
        }

        return inputIndexes;
    }

    private int[] getOverRotors(int[] input){
        return null;
    }
}
