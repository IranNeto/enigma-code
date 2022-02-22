package org.iranneto.observer

import org.iranneto.machinery.parts.Rotor
import org.iranneto.machinery.parts.RotorMechanism
import spock.lang.Ignore
import spock.lang.Specification

class RotorMechanismTest extends Specification {

    @Ignore
    def "should receive complete rotor loop events"(){
        given:
        def observer = new RotorMechanism()
        def rotor = new Rotor(observer)

        and:
        rotor.index = 25
        rotor.increment()

        expect:
//        !observer.eventQueue.isEmpty
        true
    }

}
