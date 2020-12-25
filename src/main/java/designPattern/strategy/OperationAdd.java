package designPattern.strategy;

/**
 * @Author hezhensheng
 * @Date 2020/12/23
 * @Description
 */
public class OperationAdd implements Strategy{
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
