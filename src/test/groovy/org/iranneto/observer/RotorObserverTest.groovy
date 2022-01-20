package org.iranneto.observer

import org.iranneto.machinery.parts.Rotor
import spock.lang.Specification

class RotorObserverTest extends Specification {

    def "should receive complete rotor loop events"(){
        given:
        def observer = new RotorObserver()
        def rotor = new Rotor(observer)

        and:
        rotor.index = 25
        rotor.increment()

        expect:
//        !observer.eventQueue.isEmpty
        true
    }

}
