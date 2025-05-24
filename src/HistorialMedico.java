public class HistorialMedico {
    private String fecha;
    private String diagnostico;
    private String tratamiento;
    private TipoVeterinario veterinario;


    public HistorialMedico(String fecha, String diagnostico, String tratamineto,TipoVeterinario veterinario) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamineto;
        this.veterinario = veterinario;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Diagnóstico: " + diagnostico +
                ", Tratamiento: " + tratamiento + ", Veterinario: " + veterinario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public TipoVeterinario getVeterinario() {
        return veterinario;
    }
}
