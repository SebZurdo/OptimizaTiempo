import java.util.*;

public class App {

    public static void priorizar(ListaAct tarea){
        System.out.println("Ingrese la cantidad de tareas que quiere priorizar:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        for (int j = 0; j < a; j++){
            tarea.priori(tarea);
        }
        in.close();
    }

    public static void completar(ListaAct tarea){
        Scanner ent = new Scanner(System.in);
        System.out.println("¿Finalizó cuántas tareas? Ingrese el número");
        int n = ent.nextInt();
        ent.close();
        for (int i = 0; i < n; i++){
            tarea.completar();
        }
        System.out.println("Las tareas que quedan son:"+tarea.numTareas());
    }


    public static void crear(){
        System.out.println("Ingrese el número de tareas a realizar:");
        Scanner ent = new Scanner(System.in);
        int n = ent.nextInt();
        ListaAct tarea = new ListaAct();
        System.out.println("Ingresa el nombre de la tarea en una linea y en la otra la descripción de la tarea a realizar:");
        for (int i = 0; i < n; i++){
            String nombre = ent.nextLine();
            String respuesta = ent.nextLine();
            tarea.asignarPrimero(new Actividad(nombre, respuesta));
        }
        System.out.println("Se almacenó con éxito"+tarea.numTareas()+"\nSi quiere marcara tareas realizadas ingrese '1'\nSi quiere priorizar la última tarea ingrese '2'");
        String marcar = ent.next();
        ent.close();

        if (marcar == "1"){
            completar(tarea);
        }
        else if(marcar == "2"){
            priorizar(tarea);
        }
        else{
            System.out.println("Vuelta al menú");
            menu();
        }
        }

    public static void menu(){
        Scanner entra = new Scanner(System.in);
        System.out.println("Bienvenido, si desea comenzar una actividad ingrese 'si'. De lo contrario ingrese 'no'");
        String respuesta = entra.nextLine();
        entra.close();
        if (respuesta == "si"){
            crear();
        }
        else{
            System.out.println("Programa terminado");
        }
    }

    public static void main(String[] args) throws Exception {
        menu();
    }        
}
        

