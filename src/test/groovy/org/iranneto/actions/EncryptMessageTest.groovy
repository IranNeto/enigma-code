package org.iranneto.actions

import org.iranneto.machinery.Enigma
import spock.lang.Specification

class EncryptMessageTest extends Specification {

    def emMock = Mock(EncryptMessage.class)

    def "should build DecryptMessage with valid Enigma"(){
        given:
        def enigma = new Enigma()
        def em = new EncryptMessage(enigma)

        expect:
        em.enigma != null
    }

    def "encryptMessage - should return String answer"(){
        given:
        def enigma = new Enigma()
        def em = new EncryptMessage(enigma)

        and:
        def encryptedMessage = em.encryptMessage('ANYTHING')

        expect:
        encryptedMessage != null
        encryptedMessage instanceof String
        encryptedMessage.size() != 0
    }

}
