import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/3.
 */
public class Filter implements javax.servlet.Filter {
    private int count;
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        count++;
        HttpServletRequest req=(HttpServletRequest) request;
        ServletContext context=req.getSession().getServletContext();
        context.setAttribute("count",count);
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        String param= config.getInitParameter("count");
        count = Integer.valueOf(param);

    }

}
