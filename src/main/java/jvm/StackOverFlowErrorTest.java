package jvm;

/**
 * @Author hezhensheng
 * @Date 2021/1/12
 * @Description
 */
public class StackOverFlowErrorTest {
    private int stackSize = 1;

    public void stackLead() {
        stackSize++;
        stackLead();
    }

    /**
     * 虚拟机参数设置，-Xss（虚拟机栈容量）设置的最小参数与操作系统有关，本机提示至少为160k
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable{
        StackOverFlowErrorTest flowErrorTest = new StackOverFlowErrorTest();
        try {
            flowErrorTest.stackLead();
        } catch (Exception e) {
            System.out.println("---------");
            System.out.println("stackSize:" + flowErrorTest.stackSize);
            throw e;
        }
    }
}
