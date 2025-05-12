import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String id;
    private String nombre;
    private String especie;
    private Propietario propietario;
    private int edad;
    private List<HistorialMedico> lstHistorialMedico = new ArrayList<>();

    public Animal(String id, String nombre, String especie, Propietario propietario, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.propietario = propietario;
        this.edad = edad;

    }
    public void agregarHistorial(HistorialMedico histAnimal){
        lstHistorialMedico.add(histAnimal);
    }

    public String getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<HistorialMedico> getLstHistorialMedico() {
        return lstHistorialMedico;
    }

    public void setLstHistorialMedico(List<HistorialMedico> lstHistorialMedico) {
        this.lstHistorialMedico = lstHistorialMedico;
    }

    public String toString() {
        return "Animal: " + nombre + ", Especie: " + especie + ", Edad: " + edad;
    }
}

