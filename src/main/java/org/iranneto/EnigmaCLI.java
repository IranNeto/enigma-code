package org.iranneto;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.actions.EncryptMessageRunner;
import org.iranneto.machinery.Enigma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EnigmaCLI {
    public static void main(String[] args) throws IOException {
        Enigma enigma = new Enigma();
        EncryptMessageRunner runner = new EncryptMessageRunner();
        Path path = Paths.get("src/main/resources/performance.txt");
        EncryptMessageRequest request = new EncryptMessageRequest(enigma, "TEST");

        long startTime = System.nanoTime();
        runner.run(request);
        long endTime = System.nanoTime() - startTime;

        StringBuilder sb = new StringBuilder()
                .append("#")
                .append(" running time: ")
                .append(endTime)
                .append("\n");
        Files.writeString(path, sb, StandardOpenOption.APPEND);
    }
}
