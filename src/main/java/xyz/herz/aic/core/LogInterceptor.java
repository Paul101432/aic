package xyz.herz.aic.core;

import lombok.extern.slf4j.Slf4j;
import org.dromara.hutool.core.date.DateUtil;
import org.dromara.hutool.json.JSONUtil;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;
import org.noear.solon.core.route.RouterInterceptor;
import org.noear.solon.core.route.RouterInterceptorChain;

import java.util.Objects;

@Slf4j
@Component(index = 999)
public class LogInterceptor implements RouterInterceptor {

    @Override
    public void doIntercept(Context ctx, Handler mainHandler, RouterInterceptorChain chain) throws Throwable {
        chain.doIntercept(ctx, mainHandler);
    }

    @Override
    public Object postResult(Context ctx, Object result) throws Throwable  {

        try {
            String repStr = "";
            if (Objects.isNull(result) || ctx.action() == null) {
                return "";
            }else if(result instanceof Throwable){
                return result ;
            }else {
                repStr = JSONUtil.toJsonStr(result);
            }

            StringBuilder sb = new StringBuilder("\n-------------------------- ").append(DateUtil.now())
                    .append(" ---------------------------------\n");

            sb.append("Url         : ").append(ctx.method()).append(" ").append(ctx.action().fullName()).append("\n");
            sb.append("Parameter   : ").append(resetStr(ctx.body())).append("\n");
            sb.append("result      : ").append(resetStr(repStr)).append("\n");
            sb.append("--------------------------------------------------------------------------------\n");
            log.info(sb.toString());
        } catch (Exception e) {
            log.error("日志打印异常", e);
        }
        return result;
    }

    private String resetStr(String str){
        if(str.length()>2048){
            return  str.substring(  0,2048);
        }else{
            return str;
        }
    }
}
