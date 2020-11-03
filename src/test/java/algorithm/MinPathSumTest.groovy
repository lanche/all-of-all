package algorithm

import algorithm.leetcode.MinPathSum
import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author hezhensheng02* @date 2020/7/6 01:58
 * @description
 */
class MinPathSumTest extends Specification {

    @Shared
    MinPathSum services

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        services = (MinPathSum) proxy.getInstance(new MinPathSum())
    }

    def "MinPathSum"() {
        setup:
        def grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]] as int[][]
        when:
        int r1 = services.minPathSum(grid)
        int r2 = services.minPathSum(grid)
        String[] array = "look you".split("o");
        then:
        r1 == 7
        r2 == 7
        println(array)
    }


}
