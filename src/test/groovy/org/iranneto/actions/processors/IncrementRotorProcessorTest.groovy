package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import org.iranneto.machinery.Enigma
import spock.lang.Specification

import static org.iranneto.ObjectMother.*

class IncrementRotorProcessorTest extends Specification {

    def "process - Should increment the first rotor only"(){
        given:
        def enigma = new Enigma()
        enigma.rotorMechanism.rotors.forEach(rotor -> rotor.map = ROTOR_MAP)

        and:
        def incrementProcessor = new IncrementRotorProcessor()

        and:
        def encryptMessageRequest = new EncryptMessageRequest(enigma, 'MESSAGE')
        encryptMessageRequest.inputIndexes = INPUT_ARRAY_MESSAGE

        when:
        incrementProcessor.process(encryptMessageRequest)

        then:
        noExceptionThrown()
    }

}
