public class HistorialMedico {
    private String fecha;
    private String diagnostico;
    private String tratamiento;
    private String veterinario;

    public HistorialMedico(String fecha, String diagnostico, String tratamineto, String veterinario) {
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
}
