public class Cita {
    private String id;
    private String fecha;
    private String hora;
    private Animal animal;
    private String motivo;
    private String veterinario;

    public Cita(String id, String fecha, String hora, Animal animal, String motivo, String veterinario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.animal = animal;
        this.motivo = motivo;
        this.veterinario = veterinario;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Fecha: " + fecha + ", Hora: " + hora +
                ", Animal: " + animal.getNombre() + ", Motivo: " + motivo + ", Veterinario: " + veterinario;
    }
}


