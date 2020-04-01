package be.adrienhelin.project.api.security.authentication.external;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    private List<ExternalAuthentication> externalAuthentications = newArrayList(
            ExternalAuthentication.externalAuthentication().withUsername("member").withPassword("root").withRoles(newArrayList("CUSTOMER")),
            ExternalAuthentication.externalAuthentication().withUsername("anotherMember").withPassword("root").withRoles(newArrayList("CUSTOMER")),
            ExternalAuthentication.externalAuthentication().withUsername("admin").withPassword("root").withRoles(newArrayList("ADMIN")),
            ExternalAuthentication.externalAuthentication().withUsername("anotherAdmin").withPassword("root").withRoles(newArrayList("ADMIN"))
    );

    public ExternalAuthentication getUser(String username, String password) {
        return externalAuthentications.stream()
                .filter(externalAuthentication -> externalAuthentication.getUsername().equals(username))
                .filter(externalAuthentication -> externalAuthentication.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}