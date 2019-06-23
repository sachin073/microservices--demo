package filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sachin on 23/6/19.
 */

@Component
public class ZullLogginFilter extends ZuulFilter{

    static Logger logger = LoggerFactory.getLogger(ZullLogginFilter .class);

    @Override
    public boolean shouldFilter() {
        //log all reqest
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request ->{},  Path ->{}",request,request.getRequestURI());
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }


    @Override
    public String filterType() {
        return "pre";
    }
}
