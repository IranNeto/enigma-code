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

        expect:
        rotorMechanism.mapIndexArray(INPUT_ARRAY_MESSAGE, order) == result

        where:
        order || result
        0     || EXPECTED_OUTPUT_ROTOR_0
        1     || EXPECTED_OUTPUT_ROTOR_1
        2     || EXPECTED_OUTPUT_ROTOR_2
    }

    def "mapIndexArray - should encrypt input message with rotor order #order when all rotors have index = 25"() {
        given:
        def rotorMechanism = new RotorMechanism()
        IntStream.range(0, 3).forEach(i -> {
            rotorMechanism.getRotors().get(i).index = 25
            rotorMechanism.getRotors().get(i).map = ROTOR_MAP
        })

        expect:
        rotorMechanism.mapIndexArray(INPUT_ARRAY_MESSAGE, order) == result

        where:
        order || result
        0     || [4, 25, 22, 3, 17, 5, 11] as Integer[]
        1     || [2, 10, 22, 22, 23, 24, 10] as Integer[]
        2     || [2, 10, 22, 22, 23, 24, 10] as Integer[]
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
