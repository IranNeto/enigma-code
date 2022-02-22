package org.iranneto.machinery.parts

import org.iranneto.machinery.Enigma
import spock.lang.Ignore
import spock.lang.Specification

import static org.iranneto.ObjectMother.INPUT_ARRAY_MESSAGE
import static org.iranneto.ObjectMother.ROTOR_MAP

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
        def expectedOutput = [2, 25, 12, 12, 0, 7, 25] as int[]

        and:
        rotor.map = rotorMap

        expect:
        rotor.mapIndexArray(inputArray) == expectedOutput
    }

    //Test will be moved to RotorMechanismTest
    @Ignore
    def "increment - rotor index should be added +1 when index < 25"() {
        given:
        def rotor = new Rotor(0)
        rotor.index = inputTestIndex
        def expectedRotorIndex = rotor.index + 1

        and:
        rotor.increment()

        expect:
        rotor.index == expectedRotorIndex

        where:
        inputTestIndex << (0..24)
    }

    //Test will be moved to RotorMechanismTest
    @Ignore
    def "increment - rotor index should be back to 0 when index is 25"() {
        given:
        def rotor = new Rotor(0)
        rotor.index = 25
        def expectedRotorIndex = 0

        and:
        rotor.increment()

        expect:
        rotor.index == expectedRotorIndex
    }

    def "mapIndex - should map the right index"() {
        given:
        def rotor = new Rotor(0)
        rotor.map = ROTOR_MAP

        and:
        def indexAfterFirstMap = ROTOR_MAP[indexToBeMapped]
        def indexMapped = rotor.mapIndex(indexToBeMapped)

        expect:
        indexAfterFirstMap == indexMapped

        where:
        indexToBeMapped << 9
    }

    //TODO Remove Ignore after RotorMechanism has increment function
    @Ignore
    def "mapIndex - should increment rotor before mapping a index value"() {
        given:
        def enigma = new Enigma()
        def rotor = enigma.rotorMechanism.rotors.get(0)
        rotor.map = ROTOR_MAP

        and:
        def expectedIndex = ROTOR_MAP[indexToBeMapped + 1]

        expect:
        rotor.mapIndex(indexToBeMapped) == expectedIndex

        where:
        indexToBeMapped << (0..24)
    }

    //TODO Remove Ignore after RotorMechanism has increment function
    @Ignore
    def "backMapIndex - should backmap the right position"() {
        given:
        def rotor = new Rotor(0)
        rotor.map = ROTOR_MAP

        and:
        def postitionAfterFirstBackMap = List.of(ROTOR_MAP as Integer[]).indexOf(positionToBeMapped)
        def positionBackMapped = rotor.backMapIndex(positionToBeMapped)

        expect:
        postitionAfterFirstBackMap == positionBackMapped

        where:
        positionToBeMapped << 9
    }
}
