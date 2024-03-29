package mrg;

import org.eclipse.jetty.server.*;
import org.jetbrains.annotations.NotNull;

public final class Connectors {

    public static void main(@NotNull String[] args) throws Exception {
        final Server server = new Server();

        final HttpConfiguration httpConfig = new HttpConfiguration();

        final HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(httpConfig);

        final ServerConnector serverConnector = new ServerConnector(server, httpConnectionFactory);

        serverConnector.setHost("localhost");
        serverConnector.setPort(3466);

        server.setConnectors(new Connector[]{serverConnector});

        server.start();
    }
}
