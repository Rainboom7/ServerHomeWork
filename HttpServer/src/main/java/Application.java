import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.JDBCLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;

import javax.servlet.DispatcherType;
import java.io.IOException;
import java.net.URL;
import java.util.EnumSet;

public final class Application {
    public static void main(@NotNull String[] args) throws Exception {
        final Server server = new ServerBuilder().build( );

        final ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();
        contextHandlerCollection.addHandler( getFirstContextHandler( ) );
        contextHandlerCollection.addHandler( getSecondContextHandler() );


        final String config = Application.class.getResource("/DB_config").toExternalForm();
        final JDBCLoginService jdbcLoginService = new JDBCLoginService("login", config);
        final ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(server, jdbcLoginService);



        securityHandler.setHandler(contextHandlerCollection);
        server.setHandler(securityHandler);
        server.start();


    }

    @NotNull
    private static ServletContextHandler getSecondContextHandler() throws IOException {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        final URL resource = org.eclipse.jetty.security.LoginService.class.getResource( "/help" );
        context.setBaseResource( Resource.newResource(resource.toExternalForm()));
        context.setWelcomeFiles(new String[]{"/help"});
        context.addServlet(new ServletHolder("default", DefaultServlet.class), "/*");
        return context;
    }

    @NotNull
    private static ServletContextHandler getFirstContextHandler() {
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        contextHandler.setContextPath("/products");
        contextHandler.addEventListener(new GuiceListener());
        contextHandler.addFilter( GuiceFilter.class, "/info", EnumSet.of( DispatcherType.REQUEST));
        contextHandler.addFilter( PostFilter.class,"/set",EnumSet.of( DispatcherType.REQUEST ) );
        return contextHandler;
    }
}