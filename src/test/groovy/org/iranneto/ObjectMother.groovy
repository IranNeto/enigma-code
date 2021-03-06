package org.iranneto

class ObjectMother {
    def static ROTOR_MAP = [0, 23, 6, 17, 25, 10, 7, 24, 20, 11,
                            5, 4, 2, 14, 18, 1, 8, 16, 12, 22,
                            3, 13, 9, 19, 15, 21] as Integer[]

    def static INPUT_ARRAY_MESSAGE = [12, 4, 18, 18, 0, 6, 4] as Integer[]

    def static REFLECTOR_MAP = [18, 15, 21, 9, 17, 25, 11, 12, 23, 3,
                                19, 6, 7, 22, 16, 1, 14, 4, 0, 10,
                                24, 2, 13, 8, 20, 5] as Integer[]

    def static PLUGBOARD_MAP = [0, 1, 3, 2, 10, 6, 5, 17, 11, 9,
                                4, 8, 12, 25, 20, 22, 21, 7, 18, 23,
                                14, 16, 15, 19, 24, 13] as Integer[]

    def static EXPECTED_OUTPUT_ROTOR_0 = [2, 10, 3, 13, 25, 4, 5] as Integer[]
    def static EXPECTED_OUTPUT_ROTOR_1 = [2, 25, 12, 12, 0, 7, 25] as Integer[]
    def static EXPECTED_OUTPUT_ROTOR_2 = [2, 25, 12, 12, 0, 7, 25] as Integer[]

    def static EXPECTED_OUTPUT_AFTER_3_ROTORS = [7, 10, 16, 18, 13, 21, 5] as Integer[]
}
