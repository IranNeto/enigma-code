package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import org.iranneto.machinery.Enigma
import spock.lang.Specification

import static org.iranneto.ObjectMother.*

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
        def expectedOutput = EXPECTED_OUTPUT
        plugBoardProcessor.process(encryptMessageRequest)

        expect:
        encryptMessageRequest.inputIndexes == expectedOutput
    }
}
