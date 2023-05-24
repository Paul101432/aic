package xyz.herz.aic;

import org.lealone.main.Lealone;
import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;


@SolonMain
public class AICApp {
    public static void main(String[] args) {


        String[] dbArg = {"-config", "./lealone.yaml",};
        // 1 先启动数据库
        // 2 执行另一个线程的
        Lealone.main(dbArg, () -> dbRunAfter(args));

    }


    // 数据库启动后的操作
    public static void dbRunAfter(String[] args){
        //  启动服务
        Solon.start(AICApp.class, args);
    }
}
