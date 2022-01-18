package org.iranneto.actions

import org.iranneto.machinery.Enigma
import spock.lang.Specification

class EncryptMessageRequestTest extends Specification {

    def "should build DecryptMessage with valid Enigma and textInput"(){
        given:
        def enigma = new Enigma()
        def em = new EncryptMessageRequest(enigma, "text")

        expect:
        em.enigma != null
        em.textInput != null
        !em.textInput.isEmpty()
    }

}
