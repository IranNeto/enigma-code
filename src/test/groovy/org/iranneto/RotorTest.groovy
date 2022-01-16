package org.iranneto

import org.iranneto.parts.Rotor
import spock.lang.Specification

class RotorTest extends Specification {

    def "Rotor should be created"() {
        given:
        def rotor = new Rotor()

        expect:
        rotor != null
    }

    def "Rotor should have a wireMapping"() {
        given:
        def rotor = new Rotor()

        expect:
        rotor.wireMapping != null
        rotor.wireMapping.size() == 26
    }
}
