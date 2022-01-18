package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import spock.lang.Specification

class PrepareInputProcessorTest extends Specification {


    def "process - should turn String input into array of integers"(){
        given:
        def prepareInputProcessor = new PrepareInputProcessor();
        def encryptMessageRequest = new EncryptMessageRequest(null, "MESSAGE")
        def expectedInputIndexes = [12, 4, 18, 18, 0, 6, 4].toArray() as int[]

        and:
        prepareInputProcessor.process(encryptMessageRequest)

        expect:
        encryptMessageRequest.inputIndexes.length != 0
        encryptMessageRequest.inputIndexes == expectedInputIndexes

    }
}
