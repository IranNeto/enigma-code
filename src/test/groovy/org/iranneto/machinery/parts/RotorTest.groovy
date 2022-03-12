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

    def "mapIndex - should map a value"() {
        given:
        def enigma = new Enigma()
        def rotor = enigma.rotorMechanism.rotors.get(0)
        rotor.map = ROTOR_MAP

        and:
        def expectedIndex = ROTOR_MAP[indexToBeMapped]

        expect:
        rotor.mapIndex(indexToBeMapped) == expectedIndex

        where:
        indexToBeMapped << (0..24)
    }

    //TODO Add Test a large size of Input array message
    //TODO Add a Test to validate the offset
    @Ignore
    def "mapIndex - should map a value with index != 0"() {
        given:
        def enigma = new Enigma()
        def rotor = enigma.rotorMechanism.rotors.get(0)
        def indexToBeMapped = 15
        rotor.index = 15
        rotor.map = ROTOR_MAP

        and:
        def expectedIndex = ROTOR_MAP[indexToBeMapped]

        expect:
        rotor.mapIndex(indexToBeMapped) == expectedIndex
    }

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
