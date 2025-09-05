
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
    
    public void insertarTermino(int coe, int exp) {
        //Si el coeficiente es 0, no hay nada que hacer.
        if (coe == 0) {
            return;
        }

        Nodo nuevo = new Nodo(coe, exp);
        Nodo p = Punta;
        Nodo ant = null;

        // 2. Buscar la posición correcta para insertar o encontrar un exponente existente.
        // El bucle avanza mientras no lleguemos al final y el exponente del nodo actual
        // sea mayor que el exponente del nuevo término.
        while (p != null && p.getExp() > exp) {
            ant = p;
            p = p.getLiga();
        }

        // 3. Evaluar el resultado de la búsqueda.
        //Se encontró un término con el mismo exponente.
        if (p != null && p.getExp() == exp) {
            int nuevoCoe = p.getCoe() + coe;
            p.setCoe(nuevoCoe);

            // Si el nuevo coeficiente es 0, se debe eliminar el nodo.
            if (p.getCoe() == 0) {
                if (ant == null) { // El nodo a eliminar es el primero (Punta).
                    Punta = p.getLiga();
                } else { // El nodo a eliminar está en medio o al final.
                    ant.setLiga(p.getLiga());
                }
            }
        } // Es un término nuevo, se debe insertar en la lista.
        else {
            if (ant == null) { // Inserción al principio de la lista.
                nuevo.setLiga(Punta);
                Punta = nuevo;
            } else { // Inserción en medio o al final de la lista.
                nuevo.setLiga(p);
                ant.setLiga(nuevo);
            }
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
        
        System.out.println("El Resultado es: " + resultado);
    }
    
    public void sumarPolinomiosForma3(clsForma3 B){
        clsForma3 polC = new clsForma3(); //pol resultado
        Nodo p = this.getPunta(); //puntero A
        Nodo q = B.getPunta(); //puntero B
        
        //Mientras haya nodos en ambos polinomios
        while(p != null && q != null){
            int expP = p.getExp();
            int expQ = q.getExp();
            
            if(expP > expQ){ //Si el exp de B es mayor
                polC.InsertarFinal(p.getCoe(), expQ);
                p = p.getLiga(); //avanza el pol A
            } else if (expQ > expP){
                //Si el exp B es mayor
                polC.InsertarFinal(q.getCoe(), expQ);
                q = q.getLiga();//avanza el pol B
            } else {
                //Exp iguales
                int nuevoCoe = p.getCoe() + q.getCoe();
                
                if(nuevoCoe != 0){
                    polC.InsertarFinal(nuevoCoe, expP);
                }
                
                p = p.getLiga();
                q = q.getLiga();
            }
        }
        
        //Añade los terminos de A si hay
        while(p != null){
            polC.InsertarFinal(p.getCoe(), p.getExp());
            p = p.getLiga();
        }
        
        //Añade los terminos de B si hay
        while(q != null){
            polC.InsertarFinal(q.getCoe(), q.getExp());
            q = q.getLiga();
        }
        
        System.out.println("\nEl resultado de la suma de polinomios es: \n");
        polC.Reconstruir();
        
    }
    
    public void multiplicarPolinomiosForma3(clsForma3 B) {
        // Polinomio C almacenará el resultado final.
        clsForma3 polC = new clsForma3();
        // 'p' recorrerá el polinomio actual (this).
        Nodo p = this.getPunta();

        // Si alguno de los polinomios está vacío, el resultado es 0.
        if (p == null || B.getPunta() == null) {
            System.out.println("El resultado de la multiplicación de polinomios es:");
            System.out.println("0");
            return;
        }

        // Bucle para iterar a través de cada término del primer polinomio (this).
        while (p != null) {
            // 'q' recorrerá el segundo polinomio (B) por cada término de 'p'.
            Nodo q = B.getPunta();

            // Bucle para multiplicar el término actual de 'p' con cada término de 'q'.
            while (q != null) {
                // Se calcula el nuevo coeficiente y exponente.
                int nuevoCoe = p.getCoe() * q.getCoe();
                int nuevoExp = p.getExp() + q.getExp();

                // --- Lógica para insertar/sumar el nuevo término en el polinomio resultado 'polC' ---
                // Si el polinomio resultado está vacío, se inserta el primer término.
                if (polC.Punta == null) {
                    polC.Punta = new Nodo(nuevoCoe, nuevoExp);
                } else {
                    // Punteros para recorrer el polinomio resultado 'polC'.
                    Nodo r = polC.Punta;
                    Nodo anterior = null;

                    // Se busca la posición correcta para el nuevo término (ordenado por exponente de mayor a menor).
                    while (r != null && r.getExp() > nuevoExp) {
                        anterior = r;
                        r = r.getLiga();
                    }

                    // Si se encuentra un término con el mismo exponente, se suman los coeficientes.
                    if (r != null && r.getExp() == nuevoExp) {
                        int coeExistente = r.getCoe();
                        r.setCoe(coeExistente + nuevoCoe);

                        // Si la suma de coeficientes da cero, se elimina el nodo.
                        if (r.getCoe() == 0) {
                            if (anterior == null) { // El nodo a eliminar es el primero.
                                polC.Punta = r.getLiga();
                            } else { // El nodo a eliminar está en medio o al final.
                                anterior.setLiga(r.getLiga());
                            }
                        }
                    } else {
                        // Si no existe un término con ese exponente, se crea un nuevo nodo y se enlaza.
                        Nodo nuevoNodo = new Nodo(nuevoCoe, nuevoExp);
                        if (anterior == null) { // Insertar al inicio de la lista.
                            nuevoNodo.setLiga(polC.Punta);
                            polC.Punta = nuevoNodo;
                        } else { // Insertar en medio o al final de la lista.
                            nuevoNodo.setLiga(r);
                            anterior.setLiga(nuevoNodo);
                        }
                    }
                }
                // Se avanza al siguiente término del segundo polinomio.
                q = q.getLiga();
            }
            // Se avanza al siguiente término del primer polinomio.
            p = p.getLiga();
        }

        // Se muestra el polinomio resultante.
        System.out.println("\nEl resultado de la multiplicación de polinomios es: \n");
        polC.Reconstruir();
    }

    public static clsForma3 SumarF1F2(clsForma1 A, clsForma2 B) {
        clsForma3 resultado = new clsForma3();

        // Recorrer Forma1
        for (int i = 1; i < A.getVPF1().length; i++) {
            int coe = A.getVPF1()[i];
            int exp = A.getVPF1()[0] - (i - 1);
            if (coe != 0) {
                resultado.InsertarFinal(coe, exp);
            }
        }

        // Recorrer Forma2
        for (int i = 2; i <= B.getDu(); i += 2) {
            int coe = B.getVPF2(i - 1);
            int exp = B.getVPF2(i);
            if (coe != 0) {
                resultado.InsertarFinal(coe, exp);
            }
        }

        return resultado;
    }
}
