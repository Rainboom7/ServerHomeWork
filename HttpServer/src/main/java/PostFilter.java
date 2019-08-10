import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import servlets.ProductInfoGenerator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public final class PostFilter implements  Filter{
    boolean noPostInTHisSession;
    @Inject
    @NotNull ProductInfoGenerator productInfoGenerator= new ProductInfoGenerator();

    public PostFilter() throws SQLException {
    }

    @Override
    public void init(@NotNull FilterConfig filterConfig) {
        noPostInTHisSession=true;

    }

    @Override
    public void doFilter(@NotNull ServletRequest request,
                         @NotNull ServletResponse response,
                         @NotNull FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getMethod().equals("POST")&&noPostInTHisSession){
            productInfoGenerator.setInfo( httpServletRequest.getQueryString() );
            noPostInTHisSession=false;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
