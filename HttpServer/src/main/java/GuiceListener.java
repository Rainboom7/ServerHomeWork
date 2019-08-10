import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import org.jetbrains.annotations.NotNull;
import servlets.ProductsServlet;

public final class GuiceListener extends GuiceServletContextListener {
    @NotNull
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule(){
            @Override
            protected void configureServlets() {
                bind( ProductsServlet.class).asEagerSingleton();
                serve("/*").with(ProductsServlet.class);
            }



        } );
    }
}
