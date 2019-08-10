package servlets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("unused")
public final class ProductsServlet extends HttpServlet {
    private final @NotNull ProductInfoGenerator productInfoGenerator;

    @Inject
    public ProductsServlet(@NotNull ProductInfoGenerator productInfoGenerator) {
        this.productInfoGenerator = productInfoGenerator;
    }

    @Override
    public void init(@NotNull ServletConfig config) {
        @Nullable ServletConfig servletConfig = config;
    }

    @Override
    public void service(@NotNull ServletRequest req, @NotNull ServletResponse res) throws IOException {
        try ( ServletOutputStream outputStream = res.getOutputStream()) {
            outputStream.write(productInfoGenerator.getInfo().getBytes( StandardCharsets.UTF_8));
            outputStream.flush();
    }
}}
