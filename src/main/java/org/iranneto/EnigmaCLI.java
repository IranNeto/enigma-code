package org.iranneto;

import org.iranneto.actions.EncryptMessageRequest;
import org.iranneto.actions.EncryptMessageRunner;
import org.iranneto.machinery.Enigma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.iranneto.machinery.parts.Dictionary.dictionary;

public class EnigmaCLI {
    public static void main(String[] args) throws IOException {
        System.out.println("I'm foo");
//        Enigma enigma = new Enigma();
//        EncryptMessageRunner runner = new EncryptMessageRunner();
//        Path path = Paths.get("src/main/resources/performance.txt");
//        StringBuilder message = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            message.append(dictionary[(int) (Math.random() * 26)]);
//            EncryptMessageRequest request = new EncryptMessageRequest(enigma, message.toString());
//
//            long startTime = System.nanoTime();
//            runner.run(request);
//            long endTime = System.nanoTime() - startTime;
//
//            StringBuilder sb = new StringBuilder()
//                    .append("#")
//                    .append(i)
//                    .append(" running time: ")
//                    .append(endTime)
//                    .append("\n");
//
//            Files.writeString(path, sb, StandardOpenOption.APPEND);
//
//        }
    }
}
