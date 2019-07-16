package com.kurczyna

import spock.lang.Specification

class AnimalsSpec extends Specification {

    Zoo zoo = new Zoo()

    def "should find animal by name"() {
        when:
        def animal = zoo.findAnimal('bono')

        then:
        animal instanceof Monkey
        animal.height == 154
        animal.weight == 93
        animal.name == 'bono'
    }

    def "should find animal by name - improved"() {
        when:
        def animal = zoo.findAnimal('bono')

        then:
        with(animal as Monkey) {
            height == 154
            weight == 93
            name == 'bono'
        }
    }
}