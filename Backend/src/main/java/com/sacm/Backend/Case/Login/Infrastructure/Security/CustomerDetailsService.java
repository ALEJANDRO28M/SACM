package com.sacm.Backend.Case.Login.Infrastructure.Security;

import com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

// QUEDA POR VALIDAR SI EL USERDETAILS NOS SIRVE PARA
//BUSCAR POR EMAIL A LA BD
@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    SpringDataLogin DaoLogin;

    private Optional<UserLoginEntity> userEntity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userEntity = DaoLogin.findByUser(username);
        if (userEntity.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    userEntity.get().getUser(),
                    userEntity.get().getPassword(),
                    new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
    public UserLoginEntity getUserEntity() {

        return userEntity.get();}

}
