import { useState } from "react";
import "../../../../css/Login_Css/StylesRecoverUser_Css/NewCodeStyles.css"; // Asegúrate de tener este archivo CSS

// Componente funcional ChangePassword
function ChangePassword() {
    // Estados para la nueva contraseña y su confirmación
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    // Función para manejar cambios en los inputs
    const handleInputChange = (setter) => (event) => {
        setter(event.target.value);
    };

    // Función principal de envío del formulario
    const updatePassword = async (event) => {
        event.preventDefault();

        // Validaciones antes de enviar al backend
        if (password.length < 8) {
            alert("La contraseña debe tener al menos 8 caracteres.");
            return;
        }

        if (password !== confirmPassword) {
            alert("Las contraseñas no coinciden.");
            return;
        }

        try {
            const request = await fetch("http://localhost:8080/Api/UpdatePasswordLogin", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ newPassword: password }),
            });

            if (request.ok) {
                alert("¡Contraseña actualizada correctamente!");
            } else {
                alert("Error al actualizar la contraseña. Intenta nuevamente.");
            }
        } catch (error) {
            alert("Error de conexión con el servidor: " + error.message);
        }
    };

    // JSX del formulario
    return (
        <div className="mainNewPassword">
            <div className="formContainer">
                <h2>Crear nueva contraseña</h2>
                <p>Ingresa tu nueva contraseña y confírmala para continuar.</p>

                <form onSubmit={updatePassword}>
                    {/* Campo de entrada para la nueva contraseña */}
                    <input
                        type="password"
                        placeholder="Nueva contraseña"
                        value={password}
                        onChange={handleInputChange(setPassword)}
                        required
                    />

                    {/* Campo de entrada para confirmar la nueva contraseña */}
                    <input
                        type="password"
                        placeholder="Confirmar contraseña"
                        value={confirmPassword}
                        onChange={handleInputChange(setConfirmPassword)}
                        required
                    />

                    {/* Botón para enviar el formulario */}
                    <button type="submit">Actualizar contraseña</button>
                </form>
            </div>
        </div>
    );
}

// Exportamos el componente para poder usarlo en otros archivos
export default ChangePassword;
