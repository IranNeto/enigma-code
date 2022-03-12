package org.iranneto.machinery.parts

import spock.lang.Specification
import spock.lang.Unroll

import static org.iranneto.ObjectMother.*

class RotorMechanismTest extends Specification {

    @Unroll
    def "increment - should increment rotor index"(){
        given:
        def rotorMechanism = new RotorMechanism()
        rotorMechanism.rotors.forEach(rotor -> rotor.map == ROTOR_MAP)
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

    def "increment - should increment carry over rotor index"(){
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
}
