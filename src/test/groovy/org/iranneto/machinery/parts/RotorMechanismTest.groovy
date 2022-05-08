package org.iranneto.machinery.parts

import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.IntStream

import static org.iranneto.ObjectMother.*

class RotorMechanismTest extends Specification {

    def "increment - should increment rotor 1 index after message size == ROTOR_MAP size"() {
        given:
        def rotorMechanism = new RotorMechanism()

        when:
        rotorMechanism.increment(ROTOR_MAP.size())

        then:
        rotorMechanism.rotors.get(0).index == 0
        rotorMechanism.rotors.get(1).index == 1
        rotorMechanism.rotors.get(2).index == 0
    }

    def "increment - should increment rotor 2 index after message size == ROTOR_MAP size ^ 2"() {
        given:
        def rotorMechanism = new RotorMechanism()

        when:
        rotorMechanism.increment(ROTOR_MAP.size()*ROTOR_MAP.size())

        then:
        rotorMechanism.rotors.get(0).index == 0
        rotorMechanism.rotors.get(1).index == 0
        rotorMechanism.rotors.get(2).index == 1
    }

    @Unroll
    def "increment - should increment rotor 0 when message size less than ROTOR_MAP size"() {
        given:
        def rotorMechanism = new RotorMechanism()

        when:
        rotorMechanism.increment(messageSize)

        then:
        rotorMechanism.rotors.get(0).index == messageSize
        rotorMechanism.rotors.get(1).index == 0
        rotorMechanism.rotors.get(2).index == 0

        where:
        messageSize << (0..25)
    }


    def "increment - should increment rotor carry over to rotor"() {
        given:
        def rotorMechanism = new RotorMechanism()
        rotorMechanism.rotors.forEach(rotor -> rotor.map == ROTOR_MAP)
        rotorMechanism.rotors.forEach(rotor -> rotor.index = 25)

        when:
        rotorMechanism.increment(1)

        then:
        rotorMechanism.rotors.get(0).index == 0
        rotorMechanism.rotors.get(1).index == 0
        rotorMechanism.rotors.get(2).index == 0
    }

    def "getCompletedLaps - should give 0 laps completed when message size < ROTOR_MAP"(){
        given:
        def rotorMechanism = new RotorMechanism()
        def inputSize = ROTOR_MAP.size() - (ROTOR_MAP.size() * Math.random()) as int

        expect:
        rotorMechanism.getCompletedLaps(ROTOR_MAP.size(), inputSize, 0) == 0
    }

    def "getCompletedLaps - should give 1 laps completed when message size == ROTOR_MAP"(){
        given:
        def rotorMechanism = new RotorMechanism()
        def inputSize = ROTOR_MAP.size()

        expect:
        rotorMechanism.getCompletedLaps(ROTOR_MAP.size(), inputSize, 0) == 1
    }

    def "getCompletedLaps - should give n laps completed when message size > ROTOR_MAP"(){
        given:
        def rotorMechanism = new RotorMechanism()
        def inputSize = (10000 * Math.random()) as int

        expect:
        rotorMechanism.getCompletedLaps(ROTOR_MAP.size(), inputSize, 1) == inputSize / ROTOR_MAP.size() as int
        rotorMechanism.getCompletedLaps(ROTOR_MAP.size(), inputSize, 2) == inputSize / Math.pow(ROTOR_MAP.size(),2) as int

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

//    def "mapIndexArray - should encrypt input message with rotor order #order when all rotors have index = 25"() {
//        given:
//        def rotorMechanism = new RotorMechanism()
//        IntStream.range(0, 3).forEach(i -> {
//            rotorMechanism.getRotors().get(i).index = 25
//            rotorMechanism.getRotors().get(i).map = ROTOR_MAP
//        })
//
//        expect:
//        rotorMechanism.mapIndexArray(INPUT_ARRAY_MESSAGE, order) == result
//
//        where:
//        order || result
//        0     || [4, 25, 22, 3, 17, 5, 11] as Integer[]
//        1     || [2, 10, 22, 22, 23, 24, 10] as Integer[]
//        2     || [2, 10, 22, 22, 23, 24, 10] as Integer[]
//    }

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
