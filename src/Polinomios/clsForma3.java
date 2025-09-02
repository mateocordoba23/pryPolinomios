
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
    
    public void Construir(String Vs[]){
        for (int i = 0; i < Vs.length; i += 2) { //Recorremos Vs por los coe
            int coe = Integer.parseInt(Vs[i]); //Tomamos el coe
            int exp = Integer.parseInt(Vs[i + 1]); //Tomamos el exp

            InsertarFinal(coe, exp);
     
        }
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
    
    public void mostrarLista(){
        if(Punta == null){
            System.out.println("La lista está vacía."); //punta->null lista vacia
        }
        
        Nodo p = Punta;
        System.out.println("\n\nContenido de VPF3: ");
        
        while(p != null){
            System.out.print("("+ p.getCoe() + ", " + p.getExp() + ")");
        
            if(p.getLiga() != null){
                System.out.print(" -> ");
            }
            
            p = p.getLiga(); //Pasa de liga en liga
        }
        
        System.out.println(" -> NULL");
    }
    
    
}
