    package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Security.Config;

    import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.CustomerDetailsService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.crypto.password.NoOpPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;

    @EnableWebSecurity
    @Configuration
    public class SecurityConfig {


        final CustomerDetailsService customerDetailsService;

        public SecurityConfig(CustomerDetailsService customerDetailsService) {
            this.customerDetailsService = customerDetailsService;
        }

        @Bean public PasswordEncoder passwordEncoder() { return NoOpPasswordEncoder.getInstance();}

            //Bean para exponer AuthenticationManager
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
        }

        //CONTROL DE ACCESO A RUTAS
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                    .csrf(csrf -> csrf.disable())
                    //Desactiva csrf (Protección contra ataque comúnes)
                    .authorizeHttpRequests(auth ->
                            auth.requestMatchers("/Auth/validarInicio",
                                            "/Api/GeneratedPasswordRecover","/Api/keyValidCode",
                                            "/Api/UpdatePasswordLogin","/Auth/registerUser","/Api/FindByIdUserPatient").permitAll() //Rutas con acceso público
                                    .anyRequest().authenticated() //Todo lo demas requiere Token
                    ).build();
        }
    }
