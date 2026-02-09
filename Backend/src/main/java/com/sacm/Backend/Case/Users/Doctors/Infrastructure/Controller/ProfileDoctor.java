package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller;

import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Mappers.ResponseLoginMapper;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.CustomerDetailsService;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.DoctorUserDetails;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/Api")
public class ProfileDoctor {

    @GetMapping("/Profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        DoctorUserDetails doctorUserDetails = (DoctorUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(doctorUserDetails.getDoctor());
    }
}
