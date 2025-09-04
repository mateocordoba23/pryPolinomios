
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
    
    public void Reconstruir(){
        //Valida si la lista esta vacia
        if(Punta == null){
            System.out.println("0");
            return;
        }
        
        String s = "";
        Nodo p = Punta; //puntero auxiliar
        
        //Recorremos la lista
        while(p != null){
            int coe = p.getCoe();
            int exp = p.getExp();
            
            //Agrega + ó - al polinomio
            if(s.length() > 0){
                s += (coe > 0 ? " + " : " - ");
            } else if (coe < 0){
                s += "-";
            }
            
            //Agrega coe sin signo
            int valAbsCoe = (coe < 0) ? -coe : coe;
            if(valAbsCoe != 1 || exp == 0){
                s += valAbsCoe;
            }
            
            //Agrega x y el exp
            if (exp > 0){
                s += "x";
                if(exp > 1){
                    s += "^" + exp;
                }
            }
            
            p = p.getLiga(); //p avanza al siguiente nodo
        }
        
        if(s.length() == 0){
            System.out.println("0");
        } else {
            System.out.println(s);
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
    
    public void eliminarTermino(int exp){
        //Lista vacia
        if(Punta == null){
            System.out.println("\n\n\tLista vacia no se puede eliminar nada :) .");
            return;
        }
        
        //Termino a borrar es la punta
        if(Punta.getExp() == exp){
            Punta = Punta.getLiga(); //La punta la reemplaza la siguiente
            System.out.println("\n\n\tTermino elevado a " + exp + " borrado :) .");
            return;
        }
        
        //Termino en el medio o al final
        Nodo previo = Punta; //Atras
        Nodo actual = Punta.getLiga(); //Adelante
        
        //Se recorre la lista buscando el exp
        while(actual != null && actual.getExp() != exp){
            previo = actual;
            actual = actual.getLiga();
        //actual va delante de previo recorriedo los punteros 
        }
        
        //El termino no se encontro
        if(actual == null){
            System.out.println("\nNo se encontró el termino elevado a " + exp );
        } else {
            //Se encontro esa vaina le plantamos cara para eliminarlo
            previo.setLiga(actual.getLiga());
            System.out.println("\n\n\tSe dado de baja el termino elevado a " + exp);
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
    
    public void evaluarPolForma3(int x){
        int resultado = 0;
        Nodo p = Punta; //puntero auxiliar
        
        while(p != null){
            int coe = p.getCoe();
            int exp = p.getExp();
            
            int xElevada = 1;
            for(int j=0; j<exp; j++){
                xElevada *= x;
            }
            
            resultado += coe * xElevada;
            
            p = p.getLiga();
        }
        
        System.out.println("El sultado es: " + resultado);
    }
    
    public void sumarPolinomiosForma3(){
        
    }
}
