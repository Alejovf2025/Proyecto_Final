import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ClinicaVeterinaria {
    private List<Propietario> lstpropietario = new ArrayList<>();
    private List<Animal> lstanimal = new ArrayList<>();
    private List<Cita> lstcitas = new ArrayList<>();
//    private List<Especie> lstEspecies = new ArrayList<>();


    public void registrarPropietarios(int id, String nombre, String telefono, String direccion){
        for(Propietario p : lstpropietario){
            if(p.getId() == id){
                System.out.println("Ya existe un propietario con esa ID");
            }

        }
        lstpropietario.add(new Propietario(id,nombre,telefono,direccion));
    }

    public void registrarAnimal(String id, String nombre, int edad, Propietario propietario, EspcieAnimal especie ){
        for (Animal a : lstanimal) {
            if (a.getId().equalsIgnoreCase(id)) {
                System.out.println(" Ya existe un animal con esa ID.");
                return;
            }
        }

        Animal a = new Animal(id, nombre,propietario,edad,especie);
        lstanimal.add(a);
        propietario.agregarAnimal(a);


    }
    public void agendarCita(String id,String fecha, String hora, Animal animal, String motivo, TipoVeterinario veterinario){
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
    public static boolean fechaValida(String fecha){
        try{
            LocalDate.parse(fecha);
            return true;
        }catch (DateTimeParseException e) {
            return false;
        }
    }

    public void guardarPropietarios(){
        try (PrintWriter writer = new PrintWriter(new FileWriter("propietarios.txt"))) {
            for (Propietario p : lstpropietario) {
                writer.println(p.getId() + ";" + p.getNombre() + ";" + p.getTelefono() + ";" + p.getDireccion());
            }
            System.out.println("Propietarios guardados en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los propietarios: " + e.getMessage());
        }
    }
    public void guardarAnimales() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("animales.txt"))) {
            for (Animal a : lstanimal) {
                writer.println(a.getId() + ";" + a.getNombre() + ";" + a.getEdad() + ";" +
                        a.getPropietario().getId() + ";" + a.getEspecie().name());
            }
            System.out.println("Animales guardados en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los animales: " + e.getMessage());
        }
    }

    public void guardarCitas() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("citas.txt"))) {
            for (Cita c : lstcitas) {
                writer.println(c.getIdAnimal() + ";" + c.getFecha() + ";" + c.getHora() + ";" +
                        c.getMotivo() + ";" + c.getVeterinario().name());
            }
            System.out.println("Citas guardadas en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar las citas: " + e.getMessage());
        }
    }

    public void guardarHistoriales() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("historial.txt"))) {
            for (Animal animal : lstanimal) {
                for (HistorialMedico historial : animal.getLstHistorialMedico()) {
                    writer.println(animal.getId() + ";" +
                            historial.getFecha() + ";" +
                            historial.getDiagnostico() + ";" +
                            historial.getTratamiento() + ";" +
                            historial.getVeterinario());
                }
            }
            System.out.println("Historiales médicos guardados en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar historiales médicos: " + e.getMessage());
        }
    }

    public void cargarHistorialesDesdeArchivo() {
        File archivo = new File("historial.txt");
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    String idAnimal = partes[0];
                    String fecha = partes[1];
                    String diagnostico = partes[2];
                    String tratamiento = partes[3];
                    String veterinario = partes[4];

                    Animal animal = buscarAnimalPorID(idAnimal);
                    if (animal != null) {
                        TipoVeterinario vet = TipoVeterinario.validacionVeterinario(veterinario);
                        if (vet != null) {
                            HistorialMedico historial = new HistorialMedico(fecha, diagnostico, tratamiento, vet);
                            animal.agregarHistorial(historial);
                        }

                    }
                }
            }
            System.out.println("Historiales médicos cargados.");
        } catch (IOException e) {
            System.out.println("Error al leer historial.txt: " + e.getMessage());
        }
    }
    public void cargarPropietariosDesdeArchivo() {
        File archivo = new File("propietarios.txt");
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String telefono = partes[2];
                    String direccion = partes[3];
                    registrarPropietarios(id, nombre, telefono, direccion);
                }
            }
            System.out.println("Propietarios cargados desde archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer propietarios.txt: " + e.getMessage());
        }
    }

    public void cargarAnimalesDesdeArchivo() {
        File archivo = new File("animales.txt");
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    String idAnimal = partes[0];
                    String nombre = partes[1];
                    int edad = Integer.parseInt(partes[2]);
                    int idPropietario = Integer.parseInt(partes[3]);
                    EspcieAnimal especie = EspcieAnimal.validacion(partes[4]);
                    Propietario propietario = buscarPropietarioPorId(idPropietario);
                    if (propietario != null && especie != null) {
                        registrarAnimal(idAnimal, nombre, edad, propietario, especie);
                    }
                }
            }
            System.out.println("Animales cargados desde archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer animales.txt: " + e.getMessage());
        }
    }

    public void cargarCitasDesdeArchivo() {
        File archivo = new File("citas.txt");
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    String idAnimal = partes[0];
                    String fecha = partes[1];
                    String hora = partes[2];
                    String motivo = partes[3];
                    TipoVeterinario veterinario = TipoVeterinario.validacionVeterinario(partes[4]);
                    Animal animal = buscarAnimalPorID(idAnimal);
                    if (animal != null && veterinario != null) {
                        agendarCita(idAnimal, fecha, hora, animal, motivo, veterinario);
                    }
                }
            }
            System.out.println("Citas cargadas desde archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer citas.txt: " + e.getMessage());
        }
    }









}

