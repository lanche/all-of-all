package designPattern.callback;

/**
 * @Author hezhensheng
 * @Date 2021/1/20
 * @Description
 */
public class Mom {

    public void doCook(Callback callback) {

        new Thread( () -> {
            System.out.println("做饭中....");
            try {
                Thread.sleep(5000);
                callback.eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
