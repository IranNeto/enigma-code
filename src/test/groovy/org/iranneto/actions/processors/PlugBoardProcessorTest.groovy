package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import org.iranneto.machinery.Enigma
import spock.lang.Specification

import java.util.stream.IntStream

import static org.iranneto.ObjectMother.*
import static org.iranneto.ObjectMother.PLUGBOARD_MAP

class PlugBoardProcessorTest extends Specification {

    def "process - Plugboard should be able to map the index right"(){
        given:
        def enigma = new Enigma()
        enigma.plugBoard.map = PLUGBOARD_MAP

        and:
        def encryptMessageRequest = new EncryptMessageRequest(enigma, 'MESSAGE')
        encryptMessageRequest.inputIndexes = INPUT_ARRAY_MESSAGE

        and:
        def plugBoardProcessor = new PlugBoardProcessor()

        and:
        def expectedOutput = [12, 10, 18, 18, 0, 5, 10]
        plugBoardProcessor.process(encryptMessageRequest)

        expect:
        encryptMessageRequest.inputIndexes == expectedOutput
    }
}
