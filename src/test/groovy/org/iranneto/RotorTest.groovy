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

    def "Rotor should have a map"() {
        given:
        def rotor = new Rotor()

        expect:
        rotor.map != null
        rotor.map.size() == 26
    }

    def "configMap - Rotor should have a map"() {
        given:
        def rotor = new Rotor()
        rotor.configMap()

        expect:
        rotor.map != null
        rotor.map.size() == 26
    }
}
