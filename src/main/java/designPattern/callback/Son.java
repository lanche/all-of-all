package designPattern.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author hezhensheng
 * @Date 2021/1/20
 * @Description
 */

public class Son implements Callback{

    private Mom mom;

    public void setMom(Mom mom) {
        this.mom = mom;
    }

    @Override
    public void eat() {
        System.out.println("我来吃饭了");
    }

    public void askMom() {
        System.out.println("饭做好了吗？");
        System.out.println("没做好的话我继续玩游戏了");
        new Thread(() -> mom.doCook(Son.this)).start();
        System.out.println("玩游戏中.......");
    }
}
