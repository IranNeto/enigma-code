package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import org.iranneto.machinery.Enigma
import spock.lang.Specification

import static org.iranneto.ObjectMother.INPUT_ARRAY_MESSAGE
import static org.iranneto.ObjectMother.ROTOR_MAP

class SecondRotorProcessorTest extends Specification {
    def "process - Second rotor processor should encrypt index by backmapping using the 3 rotors"() {
        given: 'A enigma machine with 3 rotor with same maps'
        def enigma = new Enigma()
        enigma.rotorMechanism.rotors.forEach(rotor -> rotor.map = ROTOR_MAP)

        and: 'A encrypt message request with the enigma machine created and the message input'
        def secondRotorProcessor = new SecondRotorProcessor()
        def encryptMessageRequest = new EncryptMessageRequest(enigma, 'MESSAGE')
        encryptMessageRequest.inputIndexes = INPUT_ARRAY_MESSAGE

        and: 'First rotor processor processes it'
        secondRotorProcessor.process(encryptMessageRequest)

        expect: 'after should be expected'
        encryptMessageRequest.inputIndexes == enigma.rotorMechanism.rotors.get(0).backMapIndexArray(
                enigma.rotorMechanism.rotors.get(1).backMapIndexArray(
                        enigma.rotorMechanism.rotors.get(2).backMapIndexArray(INPUT_ARRAY_MESSAGE)
                )
        )
    }
}
