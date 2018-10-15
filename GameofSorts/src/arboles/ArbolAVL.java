package arboles;

public class ArbolAVL {
	
	private Nodo ra�z; 
    public ArbolAVL (){ 
        ra�z = null; 
    } 
    public void insertar(int nuevoM){ 
        if(ra�z==null){ 
            ra�z =  new Nodo(nuevoM); 
        } 
        else{ 
            insertar(ra�z,nuevoM); 
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
        if(ra�z!=null) 
            ra�z.re_enorden(); 
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
