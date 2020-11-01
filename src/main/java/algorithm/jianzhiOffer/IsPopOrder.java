package algorithm.jianzhiOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lanche
 * @Date 2020/10/31
 * @Description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class IsPopOrder {

    /**
     * 判断合不合法，用个栈试一试: 把压栈的元素按顺序压入，当栈顶元素和出栈的第一个元素相同，则将该元素弹出，出栈列表指针后移并继续判断。
     * 最后判断出栈列表指针是否指向出栈列表的末尾即可。
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque();
        int i = 0;
        for(int el : pushed) {
            stack.push(el);
            while(i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }

}
