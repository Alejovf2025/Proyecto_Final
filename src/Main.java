import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ClinicaVeterinaria clinica = new ClinicaVeterinaria();
        clinica.cargarPropietariosDesdeArchivo();
        clinica.cargarAnimalesDesdeArchivo();
        clinica.cargarCitasDesdeArchivo();
        clinica.cargarHistorialesDesdeArchivo();
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
                           """
            );
            try {
                System.out.print("Digite una opción: ");
                opc = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opc = -1; 
            }


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
                        EspcieAnimal especie = null;
                        do {
                            System.out.println("Escriba la especie del animal que posee (Perro, Gato, Loro, Conejo, Hamster):");
                            String entrada = teclado.nextLine();
                            especie = EspcieAnimal.validacion(entrada);
                            if(especie == null){
                                System.out.println("Especie exótica (no está dentro de nuestros servicios). Intente de nuevo.");
                            }
                        } while(especie == null);
                        System.out.print("Nombre: ");
                        String nombreAnimal = teclado.nextLine();
                        System.out.print("Edad: ");
                        int edad = teclado.nextInt();
                        teclado.nextLine();
                        clinica.registrarAnimal(idAnimal,nombreAnimal,edad,propietario,especie);

                    }else{
                        System.out.println("Propietario no encontrado");
                    }

                }
                case 3->{

                    System.out.println("Digte la ID del animal : ");
                    String idAnimal = teclado.next();
                    teclado.nextLine();
                    Animal animal = clinica.buscarAnimalPorID(idAnimal);
                    if(animal != null){
                        String fecha;
                        do{
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        fecha =  teclado.nextLine();
                        if(!ClinicaVeterinaria.fechaValida(fecha)){
                            System.out.println("Fecha invalida. Intentalo otra vez");
                        }
                        }while(!ClinicaVeterinaria.fechaValida(fecha));
                        System.out.print("Hora (HH:MM): ");
                        String hora = teclado.nextLine();
                        System.out.print("Motivo: ");
                        String motivo = teclado.nextLine();
                        TipoVeterinario veterinario = null;
                        do{
                            System.out.print("Veterinario (DR_MARVOTA / DR_NEYMAR) :  ");
                            String entrada = teclado.nextLine();
                            veterinario = TipoVeterinario.validacionVeterinario(entrada);
                            if(veterinario == null){
                                System.out.println("Especie exótica (no está dentro de nuestros servicios). Intente de nuevo.");
                            }
                        }while(veterinario == null);

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


                        System.out.print("Diagnóstico: ");
                        String diagnostico = teclado.nextLine();
                        System.out.print("Tratamiento: ");
                        String tratamiento = teclado.nextLine();

                        TipoVeterinario veterinario = null;
                        do{
                        System.out.print("Veterinario (DR_MARVOTA / DR_NEYMAR) :  ");
                        String entrada = teclado.nextLine();
                        veterinario = TipoVeterinario.validacionVeterinario(entrada);
                            if(veterinario == null){
                                System.out.println("Especie exótica (no está dentro de nuestros servicios). Intente de nuevo.");
                            }
                        }while(veterinario == null);
                        String fecha;
                        do{
                            System.out.print("Fecha (YYYY-MM-DD): ");
                            fecha =  teclado.nextLine();
                            if(!ClinicaVeterinaria.fechaValida(fecha)){
                                System.out.println("Fecha invalida. Intentalo otra vez");
                            }
                        }while(!ClinicaVeterinaria.fechaValida(fecha));


                        HistorialMedico histAnimal = new HistorialMedico(fecha, diagnostico, tratamiento, veterinario);
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
                    clinica.guardarPropietarios();
                    clinica.guardarAnimales();
                    clinica.guardarCitas();
                    clinica.guardarHistoriales();
                }
                default -> System.out.println("Opcion invalida");
            }

        }while(opc != 7);


    }
}

//Tener una lista para la especie de animales domesticos(Perros,gatos, loros, conejos,hamster)  y veterinarios
//Validar fechar existentes
//Validar solo numneros en el switch
//Archivo TXT
//Validacion de fecha
//crear una lista "ENUM"