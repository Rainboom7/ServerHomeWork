import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.security.authentication.BasicAuthenticator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

final class SecurityHandlerBuilder {
        private static final @NotNull String MANAGER = "manager";
        private static final @NotNull String GUEST = "guest";
        private final @NotNull ConstraintSecurityHandler security = new ConstraintSecurityHandler();

        final @NotNull ConstraintSecurityHandler build(@NotNull Server server,
                                                       @NotNull LoginService loginService) {
                server.addBean(loginService);
                security.setLoginService(loginService);

                final List<ConstraintMapping> constraintMappings = new ArrayList<>();
                constraintMappings.addAll( constraintMapping(
                        buildConstraint( MANAGER ),
                        Collections.singletonList("/products/set"),"*" ));
                constraintMappings.addAll(constraintMapping(
                        buildConstraint( GUEST, MANAGER ),
                        Collections.singletonList( "/" ),"GET" ));

                security.setConstraintMappings(constraintMappings);
                security.setAuthenticator(new BasicAuthenticator());
                security.setDenyUncoveredHttpMethods(true);
                return security;
        }

        private static @NotNull Constraint buildConstraint(@NotNull String... userRoles) {
                final Constraint starterConstraint = new Constraint();
                starterConstraint.setName(Constraint.__BASIC_AUTH);
                starterConstraint.setRoles(userRoles);
                starterConstraint.setAuthenticate(true);
                return starterConstraint;
        }


        private static @NotNull Collection<ConstraintMapping> constraintMapping(@NotNull Constraint constraint,
                                                                                @NotNull Collection<String> paths,
                                                                                @NotNull String method) {
                return paths.stream().map( path -> {
                        final ConstraintMapping mapping = new ConstraintMapping( );
                        mapping.setConstraint( constraint );
                        mapping.setPathSpec( path );
                        mapping.setMethod( method );
                        return mapping;
                }
                ).collect( Collectors.toList());
        }
}
