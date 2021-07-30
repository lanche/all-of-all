package algorithm.jianzhiOffer;

import java.util.Stack;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description 两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class CQueue {

    public CQueue() {

    }

    /**
     * 栈是先进后出，用两个栈操作后变为了先进先出，第一个栈进，第二个栈取数
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 在队列末尾时添加元素时插入第一个栈
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 删除队列头部元素时从第二个栈出，但是有两种情况：
     * 第二个栈元素不为空，直接从栈出来即可
     * 第二个元素为空，需要把第一个中元素全部放入第二个元素再弹出
     * @return
     */
    public int deleteHead() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()) {
                return -1;
            }
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
