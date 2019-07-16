package com.kurczyna

import spock.lang.Specification
import spock.lang.Unroll

class ParameterizedSpec extends Specification {

    def "should add two numbers"() {
        expect:
        a + b == result

        where:
        a  | b  || result
        2  | 3  || 5
        3  | 11 || 14
        21 | 0  || 21
    }

    @Unroll
    def "adding #a to #b should result with #result"() {
        expect:
        a + b == result

        where:
        a  | b  || result
        2  | 3  || 5
        3  | 11 || 14
        21 | 0  || 21
    }

    @Unroll
    def "should return itself on #method"() {
        given:
        def number = 12.0

        expect:
        number."$method"() == 12

        where:
        method << ['toInteger', 'intValue']
    }
}
