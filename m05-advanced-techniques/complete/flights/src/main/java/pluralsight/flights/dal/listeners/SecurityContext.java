package pluralsight.flights.dal.listeners;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityContext  implements AuditorAware<SecurityProperties.User> {
    @Override
    public Optional<SecurityProperties.User> getCurrentAuditor() {
        var user = new SecurityProperties.User();
        user.setName("Dan Geabunea");
        return Optional.of(user);
    }
}
