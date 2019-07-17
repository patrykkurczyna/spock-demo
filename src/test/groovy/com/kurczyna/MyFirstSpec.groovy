package com.kurczyna

import com.kurczyna.extension.EmptyH2
import spock.lang.Specification

@EmptyH2
class MyFirstSpec extends Specification {

    def "should add two numbers"() {
        given: 'Two numbers: 2 and 3'
        def a = 2
        def b = 3

        when: 'Numbers are added'
        def result = a + b

        then: 'The result is equal to 5'
        result == 5
    }

    def "should add two numbers - simplified"() {
        expect:
        2 + 3 == 5
    }

    def "should throw exception on division by zero"() {
        when:
        3 / 0

        then:
        def e = thrown(ArithmeticException)
        e.message == 'Division by zero'
    }


    def "groovy truth test"() {
        expect:
        // booleans
        2 + 3 == 5
        true
        !false

        // strings
        def s1 = ''
        def s2 = 'abc'
        !s1
        s2

        // numbers
        def n1 = 0
        def n2 = 42
        !n1
        n2

        // lists
        def l1 = []
        def l2 = [1, 3, 6]
        !l1
        l2

        // maps
        def m1 = [:]
        def m2 = ['key': 'value']
        !m1
        m2

        // objects
        def o1
        def o2 = new Expando(name: 'groovy')

        !o1
        assert o2

        // matchers:
        def ma1 = "groovy" =~ 'java'
        def ma2 = "groovy" =~ 'groovy'
        !ma1
        ma2
    }
}