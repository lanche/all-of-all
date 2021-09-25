package designPattern.callback;

/**
 * @Author hezhensheng
 * @Date 2021/1/20
 * @Description
 */
public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client();
        client.connect(new Server()).setRequest("这个文件是什么？").enqueue(new Server.Callback() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
            }

            @Override
            public void onFail(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
