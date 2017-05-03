package ad.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Encoder implements Filter {
    private String encoding = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("http-request-encoding");
        if(encoding == null) {
            throw new ServletException("init parameter \"http-request-encoding\" is absent");
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
