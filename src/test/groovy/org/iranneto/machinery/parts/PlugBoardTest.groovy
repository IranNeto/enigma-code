package org.iranneto.machinery.parts


import spock.lang.Specification

class PlugBoardTest extends Specification {
    def "PlugBoard should be created"() {
        given:
        def plugBoard = new PlugBoard()

        expect:
        plugBoard != null
    }

    def "PlugBoard should have a map size 26 and 6 values corresponding to the index"() {
        given:
        def plugBoard = new PlugBoard()

        expect:
        plugBoard.map != null
        plugBoard.map.size() == 26
        plugBoard.map.findAll ( it -> it == plugBoard.map[it]).size() == 6
    }
}
