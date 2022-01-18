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
        !enigma.rotors.isEmpty()
        enigma.rotors.size() == 3
    }
}
