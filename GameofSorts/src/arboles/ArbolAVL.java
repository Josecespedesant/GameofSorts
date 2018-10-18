package arboles;

public class ArbolAVL {
	
	private Nodo raíz; 
    public ArbolAVL (){ 
        raíz = null; 
    } 
    public void insertar(int nuevoM){ 
        if(raíz==null){ 
            raíz =  new Nodo(nuevoM); 
        } 
        else{ 
            insertar(raíz,nuevoM); 
        } 
    } 
    private void insertar(Nodo rz, int nm){ 
        if (rz == null) 
            rz = new Nodo(nm); 
        else if(nm < rz.numMat) 
            insertar(rz.izqda,nm); 
        else if(nm > rz.numMat) 
            insertar(rz.drcha,nm); 
        else 
            System.out.println("Numero Duplicados"); 
    } 
    public void visualizar(){ 
        if(raíz!=null) 
            raíz.re_enorden(); 
    }
    
    private class Nodo { 
        int numMat; 
        Nodo izqda, drcha; 
        public Nodo(int mat){ 
            numMat = mat; 
            izqda = drcha = null; 
        } 
        public void re_enorden(){ 
            if(izqda != null) 
                izqda.re_enorden(); 
            System.out.println("Matricula:   " +numMat); 
            if(drcha != null) 
                drcha.re_enorden(); 
        } 
    } 

}
