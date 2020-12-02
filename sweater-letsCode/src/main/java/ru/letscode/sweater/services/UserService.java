package ru.letscode.sweater.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.letscode.sweater.entyti.Role;
import ru.letscode.sweater.entyti.User;
import ru.letscode.sweater.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MailSender mailSender;

    public UserService(UserRepository userRepository, MailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);
        sendMessage(user);
        return true;
    }

    private void sendMessage(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s \n" +
                            "Welcome to Sweater. Please, visit next link: http://localhost:8080/activation/%s",
                    user.getUsername(), user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Activation code", message);
        }
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        userRepository.save(user);
        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> from) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String role : from.keySet()) {
            if (roles.contains(role)) {
                user.getRoles().add(Role.valueOf(role));
            }
        }
        userRepository.save(user);
    }

    public void updateUser(User user, User updateUser) {
        String email = user.getEmail();
        String updateEmail = updateUser.getEmail();
        boolean isEmailChanged = (email != null && !email.equals(updateEmail))
        || (updateEmail != null && !updateEmail.equals(email));

        if (isEmailChanged) {
            user.setEmail(updateEmail);
            if (!StringUtils.isEmpty(updateEmail)) {
                user.setActivationCode(UUID.randomUUID().toString());
            }
        }

        String updatePassword = updateUser.getPassword();
        if (!StringUtils.isEmpty(updatePassword)) {
            user.setPassword(updatePassword);
        }

        userRepository.save(user);
        if (isEmailChanged) {
            sendMessage(user);
        }
    }
}
