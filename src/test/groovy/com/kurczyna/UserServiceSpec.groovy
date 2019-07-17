package com.kurczyna

import spock.lang.Specification

class UserServiceSpec extends Specification {

    UserRepository repository
    UserService service

    def setup() {
        repository = Mock()
        service = new UserService(repository)
    }

    def "should return true when user is verified"() {
        given: 'user with id user187 is VERIFIED'
        def id = 'user187'
        repository.getUserState(id) >> UserState.VERIFIED

        expect: 'isUserVerified returns true'
        service.isUserVerified(id)

        and: 'unknown user is not verified'
        !service.isUserVerified('unknown')
    }

    def "should return true when user is verified and verify method was called once"() {
        given:
        def id = 'user187'

        when: 'isUserVerified is called'
        def result = service.isUserVerified(id)

        then: 'result is true'
        result

        and: 'method was called once and VERIFIED was returned'
        1 * repository.getUserState(_) >> UserState.VERIFIED
    }
}