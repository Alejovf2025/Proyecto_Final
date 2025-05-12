import java.util.ArrayList;
import java.util.List;

public class ClinicaVeterinaria {
    private List<Propietario> lstpropietario = new ArrayList<>();
    private List<Animal> lstanimal = new ArrayList<>();
    private List<Cita> lstcitas = new ArrayList<>();


    public void registrarPropietarios(int id, String nombre, String telefono, String direccion){
        for(Propietario p : lstpropietario){
            if(p.getId() == id){
                System.out.println("Ya existe un propietario con esa ID");
            }

        }
        lstpropietario.add(new Propietario(id,nombre,telefono,direccion));
    }

    public void registrarAnimal(String id, String nombre, String especie,int edad, Propietario propietario){
        for (Animal a : lstanimal) {
            if (a.getId().equalsIgnoreCase(id)) {
                System.out.println(" Ya existe un animal con esa ID.");
                return;
            }
        }

        Animal a = new Animal(id, nombre, especie,propietario,edad);
        lstanimal.add(a);
        propietario.agregarAnimal(a);


    }
    public void agendarCita(String id,String fecha, String hora, Animal animal, String motivo, String veterinario){
        lstcitas.add(new Cita(id,fecha, hora, animal, motivo, veterinario));
    }

    public Animal buscarAnimalPorID(String id) {
        for (Animal a : lstanimal) {
            if (a.getId().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    public Propietario buscarPropietarioPorId(int id) {
        for (Propietario p : lstpropietario) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Cita> verCitasDelDia(String fecha) {
        List<Cita> lstCitasDia = new ArrayList<>();
        for (Cita c : lstcitas) {
            if (c.getFecha().equals(fecha)) {
                lstCitasDia.add(c);
            }
        }
        return lstCitasDia;
    }

    public void registrarDiagnostico(Animal animal, HistorialMedico histAnimal) {
        animal.agregarHistorial(histAnimal);
    }

    public List<Propietario> getLstpropietario() {
        return lstpropietario;
    }



}

