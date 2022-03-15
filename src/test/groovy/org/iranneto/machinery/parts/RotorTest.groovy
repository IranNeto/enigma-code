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

    def "mapIndexArray - should encrypt an input array"() {
        given:
        def rotor = new Rotor(0)
        def rotorMap = ROTOR_MAP
        def inputArray = INPUT_ARRAY_MESSAGE
        def expectedOutput = EXPECTED_OUTPUT

        and:
        rotor.map = rotorMap

        expect:
        rotor.mapIndexArray(inputArray) == expectedOutput
    }

    @Unroll
    def "mapIndex - should map the right index when #situation"() {
        given:
        def rotor = new Rotor(0)
        rotor.map = ROTOR_MAP
        rotor.index = rotorIndex

        when:
        def indexMapped = rotor.mapIndex(indexToBeMapped, offset)

        then:
        noExceptionThrown()
        indexMapped == result

        where:
        situation                    | indexToBeMapped | rotorIndex | offset || result
        "rotor index + offset <= 25" | 9               | 0          | 3      || 2
        "rotor index + offset > 25"  | 9               | 15         | 16     || 18
        "offset is a large number"   | 9               | 0          | 31980  || 11
    }

    def "backMapIndex - should backmap the right position"() {
        given:
        def rotor = new Rotor(0)
        rotor.map = ROTOR_MAP

        and:
        def positionToBeMapped = 9
        def postitionAfterFirstBackMap = List.of(ROTOR_MAP as Integer[]).indexOf(positionToBeMapped)
        def positionBackMapped = rotor.backMapIndex(positionToBeMapped, 0)

        expect:
        postitionAfterFirstBackMap == positionBackMapped
    }
}
