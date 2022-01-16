package org.iranneto

import org.iranneto.parts.Rotor
import org.iranneto.util.RotorMappingCreator
import spock.lang.Specification;

class RotorMappingCreatorTest extends Specification {

    def "should return a LinkedHashMap"(){
        expect:
        RotorMappingCreator.create() instanceof LinkedHashMap<Integer, Integer>
    }

    def "should map 26 unique positions from 0 to 25"(){
        given:
        def mapping = RotorMappingCreator.create()

        expect:
        mapping.size() == 26
        mapping.keySet().toSorted().first() == 0
        mapping.keySet().toSorted().last() == 25
    }
}
