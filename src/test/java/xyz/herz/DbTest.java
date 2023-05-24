package xyz.herz;

import org.lealone.main.Lealone;

public class DbTest {


    public static void main(String[] args) {
        // 根据配置文件启动数据库
        // 目前嵌入式是占用文件/端口启动 参考 https://github.com/lealone/Lealone/issues/97


        // System.setProperty("lealone.config", "lealone-test.yaml");
        String[] args2 = {
                 "-config", "./lealone-test.yaml",//
        };
        Lealone.main(args2);
    }


}
