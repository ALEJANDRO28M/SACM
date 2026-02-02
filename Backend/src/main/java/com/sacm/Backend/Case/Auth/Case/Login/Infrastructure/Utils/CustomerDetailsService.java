package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils;

import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {

    //necesitamos un repositorio al cual podamos acceder a la bd y usarlo
    //en el metodo actual

    private final SpringDataLogin springDataLogin;

    private UserLoginEntity userDetails;

    public CustomerDetailsService(SpringDataLogin springDataLogin) {
        this.springDataLogin = springDataLogin;
    }



    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        userDetails = springDataLogin.findByUser(user);
        if (!Objects.isNull(userDetails)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(userDetails.getUser())
                    .password(userDetails.getPassword())
                    .authorities(userDetails.getRole().getRole())
                    .build();//retornar el objeto userDetails con security
        }else {
            throw new UsernameNotFoundException("User not found");
        }
        //spring security: autorizaciones,validaciones/authenticacion
        //Recibe Datos
    }
    public UserLoginEntity getUserDetails() {
        return userDetails;
    }
}



//Suponemos que este metodo retorna un objeto de
//Spring Security con los datos del usuario
//login
//No es que no lo recuerde, es que no se expresarme bien
//Entonces para temas de estudio y que pueda yo responder bien
//me hago siempre en mi mente 3 preguntas(Que es, para que se usa y que ofrece)
