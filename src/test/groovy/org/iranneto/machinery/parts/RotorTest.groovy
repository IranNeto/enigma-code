package org.iranneto.machinery.parts

import spock.lang.Specification
import spock.lang.Unroll

import static org.iranneto.ObjectMother.*

class RotorTest extends Specification {

    def "Rotor should be created"() {
        given:
        def rotor = new Rotor(0)

        expect:
        rotor != null
    }

    def "configMap - Rotor should have a map"() {
        given:
        def rotor = new Rotor(0)
        rotor.configMap()

        expect:
        rotor.map != null
        rotor.map.size() == 26
        rotor.order == 0
    }
}
