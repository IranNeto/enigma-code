package org.iranneto.machinery.parts

import org.iranneto.observer.RotorObserver
import spock.lang.Specification

import static org.iranneto.ObjectMother.MESSAGE_AS_INPUT_ARRAY
import static org.iranneto.ObjectMother.randomRotorMap

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
        def rotorMap = randomRotorMap
        //MESSAGE as inputArray
        def inputArray = MESSAGE_AS_INPUT_ARRAY
        def expectedOutput = [2, 17, 8, 1, 13, 23, 19] as int[]

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

    def "mapIndex - should increment a position after map an index"() {
        given:
        def rotor = new Rotor(defaultRotorObserver)
        def indexBeforeMapIndex = rotor.index
        rotor.map = randomRotorMap

        and:
        def indexAfterFirstMap = randomRotorMap[indexToBeMapped]
        def indexMapped = rotor.mapIndex(indexToBeMapped)

        expect:
        rotor.index == indexBeforeMapIndex + 1;
        indexAfterFirstMap == indexMapped

        where:
        indexToBeMapped << 9
    }
}
