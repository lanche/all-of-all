package algorithm.jianzhiOffer


import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author lanche* @Date 2021/6/11
 * @Description
 */
class DeleteNodeTest extends Specification {

    @Shared
    DeleteNode command

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        command = (DeleteNode) proxy.getInstance(new DeleteNode())
    }

    def "DeleteNode1"() {
    }

    def "DeleteNode2"() {
    }
}
