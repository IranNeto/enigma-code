package org.iranneto.machinery

import org.iranneto.machinery.Enigma
import spock.lang.Specification

class EnigmaTest extends Specification {

    def "Enigma should initiate successfully"() {
        given:
        def enigma = new Enigma()
        expect:
        enigma != null
    }

    def "Enigma has set its 3 rotors"() {
        given:
        def enigma = new Enigma()

        expect:
        !enigma.rotorMechanism.rotors.isEmpty()
        enigma.rotorMechanism.rotors.size() == 3
    }

    def "Enigma has set its 1 reflector"() {
        given:
        def enigma = new Enigma()

        expect:
        !enigma.reflector != null
    }

    def "Enigma has a plugboard"() {
        given:
        def enigma = new Enigma()

        expect:
        !enigma.plugBoard != null
    }

    def "Enigma should have a rotor mechanism"(){

    }
}
