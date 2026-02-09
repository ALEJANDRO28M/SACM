package com.sacm.Backend.Case.Citas.Domain.Models;



import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;


public record Citas(
   long id,
   String fecha,
   String motivo,
   UserEntity user
/*   HistorialMedico historialMedico,
   User_Of_Patients user*/
) {}
