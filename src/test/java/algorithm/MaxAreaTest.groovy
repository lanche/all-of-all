package algorithm

import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author hezhensheng02* @date 2020/7/5 04:15
 * @description
 */
class MaxAreaTest extends Specification {

    @Shared
    MaxArea services

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        services = (MaxArea) proxy.getInstance(new MaxArea())
    }

    @Unroll
    def "TwoPointer"() {
        expect:
        output == services.twoPointer(input as int[])
        where:
        input                       || output
        [1, 8, 6, 2, 5, 4, 8, 3, 7] || 49
        [1, 8, 6, 2, 5, 4, 8, 3, 7] || 49
        [1, 8, 6]                   || 6
    }
}
