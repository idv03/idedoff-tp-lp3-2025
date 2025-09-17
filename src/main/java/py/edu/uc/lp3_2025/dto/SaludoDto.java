package py.edu.uc.lp3_2025.dto;

public class SaludoDto {

    private String mensaje;

    public SaludoDto(String mensaje) {
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}