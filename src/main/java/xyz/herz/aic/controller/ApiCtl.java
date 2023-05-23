package xyz.herz.aic.controller;


import org.noear.snack.ONode;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Result;

import java.time.LocalDateTime;


@Controller
@Mapping("/api")
public class ApiCtl {


    @Get
    @Mapping("json")
    public Result crud(){
        return Result.succeed(ONode.newObject().attrSet("name","json").attrSet("time", LocalDateTime.now().toString()));
    }

}
