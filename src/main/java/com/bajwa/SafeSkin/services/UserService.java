package com.bajwa.SafeSkin.services;

import com.bajwa.SafeSkin.models.User;
import com.bajwa.SafeSkin.repositories.UserRepository;
import com.bajwa.SafeSkin.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public User addUser(User users) {
        User newUser = new User();
        newUser.setUserId(users.getUserId());
        newUser.setUsername(users.getUsername());
        newUser.setPassword(encodePassword(users.getPassword()));
        newUser.setFirstName(users.getFirstName());
        newUser.setLastName(users.getLastName());
        newUser.setEmailAddress(users.getEmailAddress());

        return repository.save(newUser);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }


    public AuthenticationResponse login(LoginRequest loginRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String authenticationToken = jwtProvider.generateToken(authentication);
        return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    public User updateUser(String username, User users){
        User ogUsers = findByUsername(username);
        if(users.getFirstName() != null)
            ogUsers.setFirstName(users.getFirstName());
        if(users.getLastName() != null)
            ogUsers.setLastName(users.getLastName());
        if(users.getPassword() != null)
            ogUsers.setPassword(users.getPassword());
        if(users.getEmailAddress() != null)
            ogUsers.setEmailAddress(users.getEmailAddress());

        return repository.save(ogUsers);
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public Boolean deleteByUsername(String username){
        User users = findByUsername(username);
        if(users != null) {
            repository.delete(users);
            return true;
        }

        return false;
    }

    public String getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }

}
