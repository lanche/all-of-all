package designPattern.callback;

/**
 * @Author hezhensheng
 * @Date 2021/1/20
 * @Description
 */
public class Server {

    public String response = "这是一个HTML";

    // 注册回调接口的方法
    public void setCallBack(String request, Callback callback) {
        System.out.println("收到request，正在计算当中.....");
        new Thread( () -> {
            try {
                Thread.sleep(5000);
                callback.onResponse(request + response);
            } catch (InterruptedException e) {
                e.printStackTrace();
                callback.onFail(e);
            }
        }).start();
    }

    public interface Callback {
        void onResponse(String response);
        void onFail(Throwable throwable);
    }
}
