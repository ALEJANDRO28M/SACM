import {useNavigate} from "react-router-dom";
import {Alert, MenuItem, Select} from "@mui/material";
import {Controller, useForm} from "react-hook-form";
import {yupResolver} from "@hookform/resolvers/yup";
import {registroSchema} from "../Utils/ValidationSchema.js"
import imgSacm from "../css/SACM.png";
import "../css/Registros.css";

function Registro() {

    const redireccionar = useNavigate();

    const {
        register,
        handleSubmit,
        control,
        formState:
            {errors}
    } = useForm(
        {resolver: yupResolver(registroSchema)},
    );

    const handleRegistro = async (data) => {
        try {
            const request = await fetch("http://localhost:8080/Auth/registerUser", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(data),
            });
            if (request.ok) {
                alert("¡Registrado con exito!");
                redireccionar("/");
            } else {
                alert("Error en el Registro");
            }
        } catch (error) {
            console.log("Error en la solicitud", error);

        }
    }
    // Renderizar el formulario de registro
    return (
        <div className="mainRegister">
            <div className="registro-container">
                {" "}
                <h2 id="titulo">Registro de Usuario</h2> {/* Título del formulario */}
                {/* Contenedor principal */}
                <div className="contForm">
                    <img src={imgSacm} alt="Logo SACM" className="imgRegisterSacm"/> {/* Imagen del logo */}
                    <form onSubmit={handleSubmit(handleRegistro)} className="formulario">
                        {" "}
                        {/* Formulario con su manejador */}

                        {/* Campo de entrada para el nombre de usuario */}
                        <div className="form-group">
                            <label htmlFor="nombre">Nombre</label>
                            <input
                                {...register("name")}
                                className="inputsRegister"
                                placeholder="Ingrese su nombre"
                                type="text"
                                id="nombre"
                            />
                            {errors.name && (
                                <Alert severity="error"
                                       sx={{
                                           marginTop: "05px",
                                           paddingTop: "0",
                                           paddingBottom: "0",
                                           borderRadius: "20px",
                                       }}
                                >
                                    {errors.name.message}
                                </Alert>
                            )}
                        </div>

                        {/* Campo de entrada para el correo electrónico */}
                        <div className="form-group">
                            <label htmlFor="emailRegister">Email</label>
                            <input
                                {...register("email")}
                                className="inputsRegister"
                                placeholder="Ingrese su email"
                                type="email"
                                id="emailRegister"
                            />
                            {errors.email && (
                                <Alert severity="error"
                                       sx={{
                                           marginTop: "05px",
                                           paddingTop: "0",
                                           paddingBottom: "0",
                                           borderRadius: "20px",
                                       }}
                                >
                                    {errors.email.message}
                                </Alert>
                            )}
                        </div>
                        {/* Campo de entrada para la contraseña */}
                        <div className="form-group">
                            <label htmlFor="password">Contraseña</label>
                            <input
                                {...register("password")}
                                className="inputsRegister"
                                placeholder="Genere una contraseña"
                                type="password"
                                id="password"
                            />
                            {errors.password && (
                                <Alert severity="error"
                                       sx={{
                                           marginTop: "05px",
                                           paddingTop: "0",
                                           paddingBottom: "0",
                                           borderRadius: "20px",
                                       }}
                                >
                                    {errors.password.message}
                                </Alert>
                            )}
                        </div>
                        {/* Campo de entrada para confirmar la contraseña */}
                        <div className="form-group">
                            <label htmlFor="confirmPassword">Confirmar Contraseña</label>
                            <input
                                {...register("confirmPassword")}
                                className="inputsRegister"
                                placeholder="Confirme su contraseña"
                                type="password"
                                id="confirmPassword"
                            />
                            {errors.confirmPassword && (
                                <Alert severity="error"
                                       sx={{
                                           marginTop: "05px",
                                           paddingTop: "0",
                                           paddingBottom: "0",
                                           borderRadius: "20px",
                                       }}
                                >
                                    {errors.confirmPassword.message}
                                </Alert>
                            )}
                        </div>
                        {/* Display Empty acturara como un placeholder pero en el select,
        con la finalidad de que podamos incorporar una propiedad vacia
        pero que contiene la etiqueta texto como tal*/}
                        <br/>
                        <label style={{marginBottom: "0px"}}>Seleccione un Role</label>
                        <Controller
                            name="role"
                            control={control}
                            defaultValue=""
                            render={({ field }) => (
                                <Select {...field} displayEmpty size="small">
                                    <MenuItem value="">-</MenuItem>
                                    <MenuItem value="admin">Admin</MenuItem>
                                    <MenuItem value="user">User</MenuItem>
                                </Select>
                            )}
                        />

                        {errors.role && (
                            <Alert severity="error"
                                   sx={{
                                       marginTop: "0px",
                                       paddingTop: "0",
                                       paddingBottom: "0",
                                       borderRadius: "20px",
                                   }}
                            >{errors.role.message}</Alert>
                        )}
                        <br/>
                        {/* Botón para enviar el formulario */}
                        <button type="submit" className="btn">
                            Registrarse
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Registro;