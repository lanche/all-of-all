package algorithm

import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author hezhensheng02
 * @date 2020/7/2 23:57
 * @description
 */
class LongestPalindromeTest extends Specification {

    @Shared
    LongestPalindrome services

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        services = (LongestPalindrome) proxy.getInstance(new LongestPalindrome())
    }

    @Unroll
    def "longestPalindrome 暴力解法"() {
        expect:
        output == services.longestPalindromeViolence(input)
        where:
        input                  || output
        "abcdcb"               || "bcdcb"
        "abc"                  || "a"
        "abcdcbabckdkhgkgmmmg" || "abcdcba"
    }

    @Unroll
    def "longestPalindrome 中心扩散法"() {
        expect:
        output == services.longestPalindromeCenterSpread(input)
        where:
        input                  || output
        "abcdcb"               || "bcdcb"
        "abc"                  || "a"
        "abcdcbabckdkhgkgmmmg" || "abcdcba"
    }
}
