
package Polinomios;

public class clsForma3 {
    //Atributos
    Nodo Punta;

    public clsForma3() {
        Punta = null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }
    
    public void InsertarFinal(int coe, int exp){
        //p es de tipo nodo pero en x se esta creando un uevo nodo
        Nodo p,x = new Nodo(coe, exp);
        
        if(Punta == null){
            Punta = x;
        } else {
            p = Punta;
            
            while(p.getLiga() != null) {
                //Avance de p
                p = p.getLiga();
            }
            p.setLiga(x);
        }
        
    }
    
    
}
