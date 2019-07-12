import spock.lang.Specification

class MyFirstSpec extends Specification {

    def "should add numbers"() {
        expect:
        2 + 2 == 4
    }
}