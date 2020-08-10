package com.example.cursospring.services;
import com.example.cursospring.domain.Client;
import com.example.cursospring.repository.ClientRepository;
import com.example.cursospring.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);

        if(client == null){
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(client.getId(), client.getEmail(),
                client.getPassword(), client.getProfile());
    }
}
