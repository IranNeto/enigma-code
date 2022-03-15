package org.iranneto.machinery.parts

import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.IntStream

import static org.iranneto.ObjectMother.*

class RotorMechanismTest extends Specification {

    @Unroll
    def "increment - should increment rotor index"() {
        given:
        def rotorMechanism = new RotorMechanism()
        rotorMechanism.rotors.forEach(rotor -> rotor.map = ROTOR_MAP)
        rotorMechanism.rotors.forEach(rotor -> rotor.index = inputTestIndex)

        when:
        rotorMechanism.increment()

        then:
        rotorMechanism.rotors.get(0).index == inputTestIndex + 1
        rotorMechanism.rotors.get(1).index == inputTestIndex
        rotorMechanism.rotors.get(2).index == inputTestIndex

        where:
        inputTestIndex << (0..24)
    }

    def "increment - should increment carry over rotor index"() {
        given:
        def rotorMechanism = new RotorMechanism()
        rotorMechanism.rotors.forEach(rotor -> rotor.map == ROTOR_MAP)
        rotorMechanism.rotors.forEach(rotor -> rotor.index = 25)

        when:
        rotorMechanism.increment()

        then:
        rotorMechanism.rotors.get(0).index == 0
        rotorMechanism.rotors.get(1).index == 0
        rotorMechanism.rotors.get(2).index == 0
    }

    @Unroll
    def "mapIndexArray - should encrypt input message with rotor order #order when all rotors have index = 0"() {
        given:
        def rotorMechanism = new RotorMechanism()
        rotorMechanism.rotors.forEach(rotor -> rotor.map = ROTOR_MAP)
        def inputArray = INPUT_ARRAY_MESSAGE

        expect:
        rotorMechanism.mapIndexArray(inputArray, order) == result

        where:
        order || result
        0     || EXPECTED_OUTPUT_ROTOR_0
        1     || EXPECTED_OUTPUT_ROTOR_1
        2     || EXPECTED_OUTPUT_ROTOR_2
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
