import spock.lang.Specification

/**
 * @author hezhensheng02* @date 2020/7/2 02:28
 * @description
 */
class ForeachTest extends Specification {

    def "HashMap accepts null key"() {
        given:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }

}
