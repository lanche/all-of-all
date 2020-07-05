package algorithm

import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author hezhensheng02* @date 2020/7/6 02:55
 * @description
 */
class IsSymmetricTest extends Specification {

    @Shared
    IsSymmetric services

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        services = (IsSymmetric) proxy.getInstance(new IsSymmetric())
    }
/*
    def "IsSymmetric"() {
        setup:
        when:
        then:
    }*/
}
