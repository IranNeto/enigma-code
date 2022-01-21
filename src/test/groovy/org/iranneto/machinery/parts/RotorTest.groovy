package org.iranneto.machinery.parts

import org.iranneto.observer.RotorObserver
import spock.lang.Specification

import static org.iranneto.ObjectMother.INPUT_ARRAY_MESSAGE
import static org.iranneto.ObjectMother.ROTOR_MAP

class RotorTest extends Specification {

    def defaultRotorObserver = new RotorObserver()

    def "Rotor should be created"() {
        given:
        def rotor = new Rotor(defaultRotorObserver)

        expect:
        rotor != null
    }

    def "configMap - Rotor should have a map"() {
        given:
        def rotor = new Rotor(defaultRotorObserver)
        rotor.configMap()

        expect:
        rotor.map != null
        rotor.map.size() == 26
        rotor.order == 0
    }

    def "mapIndexArray - should encrypt an input array"() {
        given:
        def rotor = new Rotor(defaultRotorObserver)
        def rotorMap = ROTOR_MAP
        //MESSAGE as inputArray
        def inputArray = INPUT_ARRAY_MESSAGE
        def expectedOutput = [2, 25, 12, 12, 0, 7, 25] as int[]

        and:
        rotor.map = rotorMap

        expect:
        rotor.mapIndexArray(inputArray) == expectedOutput
    }

    def "increment - rotor index should be added +1 when index < 25"() {
        given:
        def rotor = new Rotor(defaultRotorObserver)
        rotor.index = inputTestIndex
        def expectedRotorIndex = rotor.index + 1

        and:
        rotor.increment()

        expect:
        rotor.index == expectedRotorIndex

        where:
        inputTestIndex << (0..24)
    }

    def "increment - rotor index should be back to 0 when index is 25"() {
        given:
        def rotor = new Rotor(defaultRotorObserver)
        rotor.index = 25
        def expectedRotorIndex = 0

        and:
        rotor.increment()

        expect:
        rotor.index == expectedRotorIndex
    }

    def "mapIndex - should map the right index"() {
        given:
        def rotor = new Rotor(defaultRotorObserver)
        rotor.map = ROTOR_MAP

        and:
        def indexAfterFirstMap = ROTOR_MAP[indexToBeMapped]
        def indexMapped = rotor.mapIndex(indexToBeMapped)

        expect:
        indexAfterFirstMap == indexMapped

        where:
        indexToBeMapped << 9
    }
}
