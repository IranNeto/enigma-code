package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import org.iranneto.machinery.Enigma
import spock.lang.Specification
import static org.iranneto.ObjectMother.*

class ReflectorProcessorTest extends Specification {

    def "process - Reflector processor should encrypt input index"() {
        given: 'A enigma machine with a specific reflector map'
        def enigma = new Enigma()
        enigma.reflector.map = REFLECTOR_MAP
        and: 'A encrypt message request with the enigma machine created and the message input'
        def reflectorProcessor = new ReflectorProcessor()
        def encryptMessageRequest = new EncryptMessageRequest(enigma, 'MESSAGE')

        and: 'should prepare the message input'
        encryptMessageRequest.inputIndexes = INPUT_ARRAY_MESSAGE

        and: 'ignoring the outcome of first rotor process and reflecting the input index'
        reflectorProcessor.process(encryptMessageRequest)

        expect: 'should be expected'
        encryptMessageRequest.inputIndexes == enigma.reflector.mapIndexArray(INPUT_ARRAY_MESSAGE)
    }
}
