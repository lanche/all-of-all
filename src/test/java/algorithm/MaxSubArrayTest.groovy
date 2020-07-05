package algorithm

import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author hezhensheng02* @date 2020/7/6 02:35
 * @description
 */
class MaxSubArrayTest extends Specification {

    @Shared
    MaxSubArray services

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        services = (MaxSubArray) proxy.getInstance(new MaxSubArray())
    }

    def "MaxSubArray"() {
        setup:
        int[] array = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        when:
        int r1 = services.maxSubArray(array)
        then:
        r1 == 6
    }
}
