import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private List<Animal> lstAnimal = new ArrayList<>();

    public Propietario(int id, String nombre, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;

    }

    public void agregarAnimal(Animal animal){
        lstAnimal.add(animal);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Animal> getLstAnimal() {
        return lstAnimal;
    }

    public void setLstAnimal(List<Animal> lstAnimal) {
        this.lstAnimal = lstAnimal;
    }

    @Override
    public String toString() {
        return "Propietario: " + nombre + ", Tel: " + telefono + ", Dirección: " + direccion;
    }
}
