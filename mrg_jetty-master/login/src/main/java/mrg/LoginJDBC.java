package mrg;

import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.JDBCLoginService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

@SuppressWarnings("Duplicates")
public final class LoginJDBC {

    public static void main(@NotNull String[] args) throws Exception {
        final Server server = new DefaultServer().build(3466);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        final URL resource = LoginService.class.getResource("/static");
        context.setBaseResource(Resource.newResource(resource.toExternalForm()));
        context.setWelcomeFiles(new String[]{"/static/example"});
        context.addServlet(new ServletHolder("default", DefaultServlet.class), "/*");

        final String jdbc_config = LoginJDBC.class.getResource("/jdbc_config").toExternalForm();
        final JDBCLoginService jdbcLoginService = new JDBCLoginService("login", jdbc_config);
        final ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(server, jdbcLoginService);
        securityHandler.setHandler(context);
        server.setHandler(securityHandler);

        server.start();
    }
}
