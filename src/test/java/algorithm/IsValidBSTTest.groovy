package algorithm

import algorithm.model.TreeNode
import designPattern.Proxy.CJlibProxy
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author lanche
 * @Date 2020/7/8
 * @Description
 */
class IsValidBSTTest extends Specification {

    @Shared
    IsValidBST services

    void setupSpec() {
        CJlibProxy proxy = new CJlibProxy()
        services = (IsValidBST) proxy.getInstance(new IsValidBST())
    }

    TreeNode root
    TreeNode t1
    TreeNode t2

    void setup() {
        t1 = new TreeNode(1)
        root = new TreeNode(2)
        t2 = new TreeNode(3)
    }

    def "IsValidBST true"() {
        setup:
        root.left = t1
        root.right = t2
        when:
        boolean result = services.isValidBST(root)
        boolean result2 = services.isValidBSTInOrder(root)
        then:
        result
        result2
    }

    def "IsValidBST false"() {
        setup:
        root.left = t2
        root.right = t1
        when:
        boolean result = services.isValidBST(root)
        boolean result2 = services.isValidBSTInOrder(root)
        then:
        !result
        !result2
    }
}
