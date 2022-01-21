package org.iranneto.actions.processors

import org.iranneto.actions.EncryptMessageRequest
import org.iranneto.machinery.Enigma
import spock.lang.Specification

import static org.iranneto.ObjectMother.randomRotorMap

class FirstRotorProcessorTest extends Specification {

    def "process - First rotor processor should encrypt index using the 3 rotors"() {
        given: 'A enigma machine with 3 rotor with same maps'
        def enigma = new Enigma()
        enigma.rotors.forEach(rotor -> rotor.map = randomRotorMap)

        and: 'A encrype message request with the enigma machine created and the message input'
        def firstRotorProcessor = new FirstRotorProcessor()
        def encryptMessageRequest = new EncryptMessageRequest(enigma, 'MESSAGE')
        def prepareInputProcessor = new PrepareInputProcessor()

        and: 'should prepare the message input'
        prepareInputProcessor.process(encryptMessageRequest)
        def originalInputIndexes = encryptMessageRequest.inputIndexes

        and: 'First rotor processor processes it'
        firstRotorProcessor.process(encryptMessageRequest)

        expect: 'should be expected'
        encryptMessageRequest.inputIndexes == enigma.rotors.get(2).mapIndexArray(
                enigma.rotors.get(1).mapIndexArray(
                        enigma.rotors.get(0).mapIndexArray(originalInputIndexes)
                )
        )
    }
}
