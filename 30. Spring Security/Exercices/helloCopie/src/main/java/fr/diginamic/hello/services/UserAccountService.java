package fr.diginamic.hello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.entities.UserAccount;
import fr.diginamic.hello.repositories.UserAccountRepository;
import jakarta.annotation.PostConstruct;

@Service
public class UserAccountService {
    @Autowired
    public UserAccountRepository userAccountRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
    	create(new UserAccount("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN"));
    	create(new UserAccount("user", passwordEncoder.encode("user"), "ROLE_USER"));
    }
    public void create(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }
    public void update(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }
    public void delete(UserAccount userAccount) {
        userAccountRepository.delete(userAccount);
    }
}