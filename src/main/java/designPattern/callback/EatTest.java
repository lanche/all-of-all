package designPattern.callback;

/**
 * @Author hezhensheng
 * @Date 2021/1/20
 * @Description
 */
public class EatTest {
    public static void main(String[] args) {
        Mom mom = new Mom();
        Son son = new Son();
        son.setMom(mom);
        son.askMom();

        /// new Thread(() -> mom.doCook( () -> System.out.println("吃饭了"))).start();
    }
}
