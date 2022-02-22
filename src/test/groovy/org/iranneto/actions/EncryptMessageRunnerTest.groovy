package org.iranneto.actions

import static org.iranneto.ObjectMother.*
import org.iranneto.machinery.Enigma
import spock.lang.Specification

class EncryptMessageRunnerTest extends Specification {

    def "runner - should run all processors successfully"(){
        given:
        def enigma = new Enigma()
        enigma.rotorMechanism.rotors.forEach(rotor -> rotor.map = ROTOR_MAP)
        enigma.reflector.map = REFLECTOR_MAP
        enigma.plugBoard.map = PLUGBOARD_MAP

        when:
        def encryptMessageRequest = new EncryptMessageRequest(enigma,
                'MESSAGE')
        def runner = new EncryptMessageRunner()
        runner.run(encryptMessageRequest)

        then:
        noExceptionThrown()

    }
}
