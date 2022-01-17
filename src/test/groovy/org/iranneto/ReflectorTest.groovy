package org.iranneto

import org.iranneto.parts.Reflector
import spock.lang.Specification

class ReflectorTest extends Specification {

    def "Reflector - should build successfully"(){
        given:
        def reflector = new Reflector()

        expect:
        reflector != null
    }

    def "buildMapping - should build default mapping"(){
        given:
        def reflector = new Reflector()

        expect:
        reflector.map[INDEX] == -1

        where:
        INDEX << (0..25)
    }

    def "configMapping - should have 26 mapped reflections"(){
        given:
        def reflector = new Reflector()
        reflector.configMapping()

        expect:
        reflector.map.size() == 26
        Arrays.asList(reflector.map).sort().first() == 0
        Arrays.asList(reflector.map).sort().last() == 25
    }

    def "reflect - mappings should reflect 13 bidirectional connections"(){
        given:
        def reflector = new Reflector()
        reflector.configMapping()

        expect:
        INDEX == reflector.mapIndex(reflector.mapIndex(INDEX))

        where:
        INDEX << (0..25)
    }
}
