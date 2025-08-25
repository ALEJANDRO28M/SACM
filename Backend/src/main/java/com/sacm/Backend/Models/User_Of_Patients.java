/*
package com.sacm.Backend.Models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

*/
/**
 * Representa un paciente en el sistema. Esta entidad se mapea a la tabla 'pacientes'
 * en la base de datos.
 *//*

@Entity
@Table(name="user_of_patient")
public class User_Of_Patients {

    // Identificador único del paciente. Mapeado a la columna 'id' en la base de datos.
    @Id 
    @Getter @Setter @Column(name="id")
    private int id;

    // Nombre del paciente. Mapeado a la columna 'nombre' en la base de datos.
    @Getter @Setter @Column(name="nombres")
    private String nombres;

    // Apellido del paciente. Mapeado a la columna 'apellido' en la base de datos.
    @Getter @Setter @Column(name="apellidos")
    private String apellidos;

    // Correo electrónico del paciente. Mapeado a la columna 'email' en la base de datos.
    @Getter @Setter @Column(name="email")
    private String email;

    // Edad del paciente. Mapeado a la columna 'edad' en la base de datos.
    @Getter @Setter @Column(name="edad")
    private String edad;

    // Número de teléfono del paciente. Mapeado a la columna 'telefono' en la base de datos.
    @Getter @Setter @Column(name="telefono")
    private String telefono;

    // Documento de identidad del paciente. Mapeado a la columna 'documento_de_identidad' en la base de datos.
    @Getter @Setter @Column(name="cc")
    private String cc;

    // Fecha de nacimiento del paciente. Mapeado a la columna 'fecha_de_nacimiento' en la base de datos.
    @Getter @Setter @Column(name="fecha_de_nacimiento")
    private LocalDate fecha_De_Nacimiento;

    // Género del paciente. Mapeado a la columna 'genero' en la base de datos.
    @Getter @Setter @Column(name="genero")
    private String genero;



    ///RELACIONES ENTRE CLASES///
    
    @OneToOne(cascade= CascadeType.ALL)
    private HistorialMedico historialMedico;

    @OneToMany(cascade=CascadeType.ALL)//ESPECIFICA QUE CADA CAMBIO QUE SE HAGA, TAMBIEN LO HARA EN CITAS
    @JoinColumn(name="Paciente_id")
    @JsonBackReference // Esto evita la serialización infinita
    private List<Citas> citas;
    */
/*
     * La anotación @JoinColumn se utiliza para especificar el nombre de la columna de
     *  clave foránea que se creará en la tabla de la entidad "muchos" (en este caso, Citas).
     *//*




    // Constructor vacío necesario para JPA.
    public User_Of_Patients() {
    }

    */
/**
     * Constructor con todos los atributos para inicializar una nueva instancia de User_Of_Patients.
     * 
     * @param id Identificador único del paciente.
     * @param nombres Nombre del paciente.
     * @param apellidos Apellido del paciente.
     * @param fecha_De_Nacimiento Fecha de nacimiento del paciente.
     * @param cc Documento de identidad del paciente.
     * @param telefono Número de teléfono del paciente. 
     * @param email Correo electrónico del paciente.
     * @param genero Género del paciente.
     * @param edad Edad del paciente.
     *//*

    public User_Of_Patients(int id, String nombres, String apellidos, LocalDate fecha_De_Nacimiento,
            String cc, String telefono, String email, String genero,
            String edad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_De_Nacimiento = fecha_De_Nacimiento;
        this.cc = cc;
        this.telefono = telefono;
        this.email = email;
        this.genero = genero;
        this.edad = edad;
    }

    // RELACIONES ENTRE CLASES-MODELOS (comentado por ahora)
    // @OneToMany @Getter @Setter @Column(name="id")
    // private List<Citas> citas;
    
    // @OneToMany @Getter @Setter @Column(name="id")
    // private List<HistorialMedico> historialMedico;



    
}
*/
