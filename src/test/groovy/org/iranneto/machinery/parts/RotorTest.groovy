package org.iranneto.machinery.parts


import spock.lang.Specification
import static org.iranneto.ObjectMother.*

class RotorTest extends Specification {

    def "Rotor should be created"() {
        given:
        def rotor = new Rotor()

        expect:
        rotor != null
    }

    def "configMap - Rotor should have a map"() {
        given:
        def rotor = new Rotor()
        rotor.configMap()

        expect:
        rotor.map != null
        rotor.map.size() == 26
        rotor.order == 0
    }

    def "mapIndexArray - should encrypt an input array"(){
        given:
        def rotor = new Rotor()
        def rotorMap = randomRotorMap
        //MESSAGE as inputArray
        def inputArray = MESSAGE_AS_INPUT_ARRAY
        def expectedOutput = [2, 25, 12, 12, 0, 7, 25] as int[]

        and:
        rotor.map = rotorMap

        expect:
        rotor.mapIndexArray(inputArray) == expectedOutput
    }

}
