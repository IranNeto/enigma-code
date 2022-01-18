package org.iranneto.actions;

import org.iranneto.machinery.Enigma;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.iranneto.machinery.parts.Dictionary.dictionary;

public class EncryptMessageRequest {

    private Enigma enigma;
    private String textInput;
    private int[] inputIndexes;

    public EncryptMessageRequest(Enigma enigma, String textInput) {
        this.enigma = enigma;
        this.textInput = textInput;
        this.inputIndexes = new int[textInput.length()];
    }

    public Enigma getEnigma() {
        return this.enigma;
    }

    public int[] getInputIndexes() {
        return this.inputIndexes;
    }

    public void setInputIndexes(int[] inputIndexes) {
        this.inputIndexes = inputIndexes;
    }

    public String getTextInput() {
        return this.textInput;
    }
}
