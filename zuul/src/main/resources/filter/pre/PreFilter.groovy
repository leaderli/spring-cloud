import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import groovy.util.logging.Slf4j

import javax.servlet.http.HttpServletRequest
@Slf4j
class Prefilter extends ZuulFilter{

    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 1000
    }

    @Override
    boolean shouldFilter() {
        return  true
    }

    @Override
    Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info("this is a pre filter : Send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        return null;
    }
}