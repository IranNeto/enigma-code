package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import org.iranneto.machinery.Enigma
import spock.lang.Specification
import static org.iranneto.ObjectMother.*

class PrintMessageTest extends Specification {

    def "process - should return the message encrypted"(){
        given:
        def enigma = new Enigma()
        def encrypedMessageRequest = new EncryptMessageRequest(enigma, 'MESSAGE')

        and:
        encrypedMessageRequest.inputIndexes = INPUT_ARRAY_MESSAGE

        and:
        def printMessageProcessor = new PrintMessageProcessor()
        printMessageProcessor.process(encrypedMessageRequest)

        expect:
        encrypedMessageRequest.outputText == 'MESSAGE'
    }
}
