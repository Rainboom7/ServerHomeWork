import org.eclipse.jetty.server.*;
import org.jetbrains.annotations.NotNull;

final class ServerBuilder {
@NotNull
private final Server server= new Server(  );
    @NotNull
    final Server build(){
final HttpConfiguration httpConfiguration = new HttpConfiguration(  );
final HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory( httpConfiguration );
final ServerConnector serverConnector =new ServerConnector(server,httpConnectionFactory );
serverConnector.setHost( "localhost" );
serverConnector.setPort( 3605 );
server.setConnectors( new ServerConnector[]{serverConnector} );
return server;


    }
}
