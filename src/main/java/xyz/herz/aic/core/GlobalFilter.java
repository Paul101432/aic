package xyz.herz.aic.core;



import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import org.noear.solon.core.handle.Result;
import org.smartboot.http.common.enums.HttpStatus;

@Slf4j
@Component(index = 99)
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            chain.doFilter(ctx);
        } catch (Throwable e) {
            log.error("服务端运行出错",e);
            ctx.render(Result.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务端运行出错"));
        }
    }

}
