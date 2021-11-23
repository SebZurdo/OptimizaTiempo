public class ListaAct{

    public Nodo cabeza;
    private int nactividades = 0;
    Nodo cola;

    private class Nodo{
    Actividad act;

    public Nodo sig = null;
        Nodo(Actividad act){
            this.act = act;

        }
        
    }

    public void asignarPrimero(Actividad act){
        Nodo nodo = new Nodo(act);
        nodo.sig = cabeza;
        cabeza = nodo;
        nactividades++;
    }

    public void asignarFinal(Actividad act){
        Nodo nodo = new Nodo(act);
        if (cabeza == null){
            cabeza = nodo;
            cola.sig = cabeza;
        }
        else{
            nodo.sig = cola.sig;
            cola.sig = nodo;
        }
        nactividades++;
    }

    public void asignarDespues(int i, Actividad act){
        Nodo nodo = new Nodo(act);
        if (cabeza == null){
            cabeza = nodo;
        }
        else{
            Nodo puntero = cabeza;
            int cont = 0;
            while(cont < i && cabeza.sig != null){
                puntero = puntero.sig;
                cont++;
            }
            nodo.sig = puntero.sig;
            puntero.sig = nodo;
        }
        nactividades++;
    }

    public Actividad consultar(int n){
        if (cabeza == null){
            return cabeza.act;
        }
        else{
            Nodo puntero = cabeza;
            int cont = 0;
            while(cont < n && cabeza.sig != null){
                puntero = puntero.sig;
                cont++;
            }
            if (cont != n){
                return null;
            }
            else{
                return puntero.act;
            }
        }
    }

    public int numTareas(){
        return nactividades;
    }

    public boolean hayTareas(){
        return cabeza == null;
    }

    public boolean completar(){
        if(cabeza != null){
            cabeza.act.estado = true;
            Nodo primera = cabeza;
            cabeza = cabeza.sig;
            primera.sig = null;
            nactividades--;
            return true;
        }
        else{
            return false;
        }
        
    }

    public void priori(ListaAct tarea) {
        if (cabeza != null){
            Nodo nnodo = cabeza;
            cabeza.sig = cola.sig;
            cola.sig = nnodo.sig;

        }
    }

}