public class MicolaProceso implements Proceso_cola{

    private Nodo cabeza, cola;

    public void encola(Nodo Lista){
        Nodo nuevaLista = new Nodo(Lista);

        if (cabeza == null){
            cabeza = nuevaLista;
            cola = nuevaLista;
        }
        else{
            cola.sig = nuevaLista;
        }
        cola = nuevaLista;
    }

    public Nodo consultar(){
        if (cabeza == null){
            return null;
        }
        else{
            return cabeza.Lista;
        }
    }

    public Nodo pop(){
        if (cabeza == null){
            return null;
        }
        else{
            return cabeza.Lista;
            cabeza = cabeza.sig;


            if ( cabeza == null){
                cola = null;
            }
        }
    }

    public void eliminar(){
        if (cabeza != null){
            Nodo chao = cabeza;
            cabeza = cabeza.sig;
            chao.sig = null;
            if ( cabeza == null){
                cola = null;
            }
        }
    }


}