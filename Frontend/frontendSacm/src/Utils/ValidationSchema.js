import * as yup from "yup";

export const registroSchema = yup.object({

  email: yup
    .string()
    .email("Debe de ser un correo válido")
    .matches(/@gmail\.com$/, "Debe de ser un correo Gmail")
    .required("El correo es obligatorio"),

  password: yup
    .string()
    .min(6, "La contraseña debe tener al menos 6 caracteres")
    .required("La contraseña es obligatoria"),

  confirmPassword: yup
    .string()
    .oneOf([yup.ref("password"), null], "Las contraseñas deben coincidir")
    .required("Debe confirmar la contraseña"),
    
  usuario: yup.string().required("El nombre es obligatorio"),
  role: yup.string().required("Debe seleccionar un rol"),
});
