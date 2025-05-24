import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String id;
    private String nombre;
    private Propietario propietario;
    private int edad;
    private List<HistorialMedico> lstHistorialMedico = new ArrayList<>();
    private EspcieAnimal especie;




    public Animal(String id, String nombre,Propietario propietario, int edad, EspcieAnimal especie) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.edad = edad;
        this.especie = especie;

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

    public EspcieAnimal getEspecie() {
        return especie;
    }

    public void setEspecie(EspcieAnimal especie) {
        this.especie = especie;
    }

    public String toString() {
        return "Animal: " + nombre + ", Especie: " + " Edad: " + edad + "Propietario " + propietario + "Especie " + especie;
    }
}

