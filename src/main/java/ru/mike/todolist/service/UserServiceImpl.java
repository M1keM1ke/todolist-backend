package ru.mike.todolist.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.mike.todolist.dto.UserRequestDto;

import java.util.List;

import static org.keycloak.representations.idm.CredentialRepresentation.PASSWORD;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    public List<UserRepresentation> findUserByUsername(String username) {
        return keycloak.realm(realm)
                .users()
                .search(username)
        ;
    }

    public void createUser(UserRequestDto userRequestDto) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(PASSWORD);
        credential.setValue(userRequestDto.getPassword());
        credential.setTemporary(false);

        UserRepresentation user = new UserRepresentation();

        user.setEnabled(true);
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getMail());
        user.setFirstName(userRequestDto.getFirstname());
        user.setLastName(userRequestDto.getLastname());
        user.setCredentials(List.of(credential));

        var usersApi = keycloak.realm(realm).users();
        usersApi.create(user);

    }
}
