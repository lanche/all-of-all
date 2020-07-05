package algorithm

import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author hezhensheng02* @date 2020/7/5 12:54
 * @description
 */
class ClimbStairsTest extends Specification {

    @Shared
    ClimbStairs services

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        services = (ClimbStairs) proxy.getInstance(new ClimbStairs())
    }

    def "climbStairs"() {
        when:
        int r1 = services.recursiveNoOptimization(10)
        int r2 = services.recursiveWithOptimization(10)
        int r3 = services.dpWithArray(10)
        int r4 = services.dpWithoutArray(10)
        then:
        r1 == r2 && r2 == r3 && r3 == 89
    }
}
