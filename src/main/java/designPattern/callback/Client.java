package designPattern.callback;

/**
 * @Author hezhensheng
 * @Date 2021/1/20
 * @Description
 */
public class Client {

    public Server server;
    public String request;

    public Client connect(Server server) {
        this.server = server;
        return this;
    }

    public Client setRequest(String request) {
        this.request = request;
        return this;
    }

    public void enqueue(Server.Callback callback) {
        new Thread(() -> server.setCallBack(request, callback)).start();
    }
}
