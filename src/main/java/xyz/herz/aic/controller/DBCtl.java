package xyz.herz.aic.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

import java.util.HashMap;
import java.util.Map;


@Controller
@Mapping("/db")
public class DBCtl {

    @Db
    DbContext db;


    // TODO 插入失败
    @Get
    @Mapping("create")
    public String create() throws Exception {
        for (int i = 0; i < 100; i++) {
            Map data = new HashMap();
            data.put("name", "n_" + i);
            data.put("age", i);

            db.table("user").setEntity(data).insert();
        }
        return "create";
    }

    @Get
    @Mapping("list")
    public String list() throws Exception {
        Long data = db.table("user u")
                .whereGt("u.age", 11)
                .limit(0, 10000)
                .selectCount();
        return "list:"+data;
    }


}
