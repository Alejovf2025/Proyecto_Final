import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ClinicaVeterinaria clinica = new ClinicaVeterinaria();
        int opc;
        do{
            System.out.println(
                    """
            CLINICA VATERINARIA GOLDEN
            1) Registrar Propietario
            2) Registrar Animal
            3) Agendar Cita
            4) Ver citas del dia
            5) Registrar Diagnostico
            6) Ver historial medico de un animal
            7) Salir
            Digite una opcion : 
                                                                                      
                            """
            );
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc){
                case 1 ->{
                    String nombre;
                    String telefono;
                    String direccion;
                    int id;
                    System.out.println("Nombre : ");
                    nombre = teclado.nextLine();
                    System.out.println("Telefono : ");
                    telefono = teclado.nextLine();
                    System.out.println("Direccion : ");
                    direccion = teclado.nextLine();
                    System.out.println("ID : ");
                    id = teclado.nextInt();
                    teclado.nextLine();
                    clinica.registrarPropietarios(id,nombre,telefono,direccion);

                }

                case 2 ->{
                    System.out.println("ID del propietario del animal: ");
                    int idpropietario = teclado.nextInt();
                    teclado.nextLine();
                    Propietario propietario = clinica.buscarPropietarioPorId(idpropietario);
                    if(propietario != null){
                        System.out.print("ID del animal: ");
                        String idAnimal = teclado.nextLine();
                        System.out.print("Nombre: ");
                        String nombreAnimal = teclado.nextLine();
                        System.out.print("Especie: ");
                        String especie = teclado.nextLine();
                        System.out.print("Edad: ");
                        int edad = teclado.nextInt();
                        teclado.nextLine();
                        clinica.registrarAnimal(idAnimal,nombreAnimal,especie,edad,propietario);

                    }else{
                        System.out.println("Propietario no encontrado");
                    }

                }
                case 3->{
                    String fecha;
                    System.out.println("Digte la ID del animal : ");
                    String idAnimal = teclado.next();
                    teclado.nextLine();
                    Animal animal = clinica.buscarAnimalPorID(idAnimal);
                    if(animal != null){
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        fecha =  teclado.nextLine();
                        System.out.print("Hora (HH:MM): ");
                        String hora = teclado.nextLine();
                        System.out.print("Motivo: ");
                        String motivo = teclado.nextLine();
                        System.out.print("Veterinario: ");
                        String veterinario = teclado.nextLine();
                        clinica.agendarCita(idAnimal,fecha, hora, animal, motivo, veterinario);
                        System.out.println("la fehca es : " + fecha);
                    }else{
                        System.out.println("Animal no encontrado");
                    }

                }
                case 4->{
                    System.out.println("Ingrese la fecha : ");
                    String consulta = teclado.next();
                    List<Cita> lstCitas = clinica.verCitasDelDia(consulta);
                    if(lstCitas.isEmpty()){
                        System.out.println("No hay citas para esa fecha ");
                    }else{
                        System.out.println("Citas para fecha " + consulta + " : ");
                        for(Cita c : lstCitas){
                            System.out.println(c);
                        }
                    }

                }
                case 5->{
                    System.out.println("Digite el ID del animal");
                    String id = teclado.next();
                    teclado.nextLine();
                    Animal animalDiag = clinica.buscarAnimalPorID(id);
                    if(animalDiag !=null){
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        String fechaDiag = teclado.nextLine();
                        System.out.print("Diagnóstico: ");
                        String diagnostico = teclado.nextLine();
                        System.out.print("Tratamiento: ");
                        String tratamiento = teclado.nextLine();
                        System.out.print("Veterinario: ");
                        String veterinarioDiag = teclado.nextLine();
                        HistorialMedico histAnimal = new HistorialMedico(fechaDiag, diagnostico, tratamiento, veterinarioDiag);
                        clinica.registrarDiagnostico(animalDiag, histAnimal);
                        System.out.println("Diagnóstico registrado");
                    }else{
                        System.out.println("Animal no encontrado");
                    }
                }
                case 6->{
                    System.out.println("Digite la ID del animal");
                    String id = teclado.next();
                    Animal animalHist = clinica.buscarAnimalPorID(id);
                    if(animalHist != null){
                        List<HistorialMedico> hisMedico = animalHist.getLstHistorialMedico();
                        if(hisMedico.isEmpty()){
                            System.out.println("No hay historial medico registrado");

                    }else{
                            System.out.println("Historial medico de "  + animalHist.getNombre() + " : ");
                            for(HistorialMedico h :  hisMedico){
                                System.out.println(h);
                            }
                        }

                    }else{
                        System.out.println("Animal no encontrado");
                    }
                }
                case 7->{
                    System.out.println("Bayyyy");
                }
                default -> System.out.println("Opcion invalida");
            }

        }while(opc != 7);


    }
}