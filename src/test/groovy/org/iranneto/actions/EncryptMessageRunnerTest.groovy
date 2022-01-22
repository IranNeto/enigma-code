package org.iranneto.actions

import static org.iranneto.ObjectMother.*
import org.iranneto.machinery.Enigma
import spock.lang.Specification

class EncryptMessageRunnerTest extends Specification {

    def "runner - "(){
        given:
        def enigma = new Enigma()
        enigma.rotors.forEach(rotor -> rotor.map = ROTOR_MAP)
        enigma.reflector.map = REFLECTOR_MAP
        enigma.plugBoard.map = PLUGBOARD_MAP

        and:
        def encryptMessageRequest = new EncryptMessageRequest(enigma, 'MESSAGE')
        def runner = new EncryptMessageRunner();

        expect:
        runner.run(encryptMessageRequest)
    }
}
