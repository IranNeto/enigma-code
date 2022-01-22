package org.iranneto.actions;

import org.iranneto.machinery.Enigma;

public class EncryptMessageRequest {

    private Enigma enigma;
    private String inputText;
    private String outputText;
    private Integer[] inputIndexes;

    public EncryptMessageRequest(Enigma enigma, String inputText) {
        this.enigma = enigma;
        this.inputText = inputText;
        this.inputIndexes = new Integer[inputText.length()];
    }

    public Enigma getEnigma() {
        return this.enigma;
    }

    public String getOutputText() {
        return outputText;
    }

    public Integer[] getInputIndexes() {
        return this.inputIndexes;
    }

    public void setInputIndexes(Integer[] inputIndexes) {
        this.inputIndexes = inputIndexes;
    }

    public String getInputText() {
        return this.inputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }
}
