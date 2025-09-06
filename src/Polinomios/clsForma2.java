package Polinomios;

public class clsForma2 {
    
     //Atributos
    private int Du,VPF2[];
    
    //Metodos

    public clsForma2(int Terminos){
        Du = Terminos*2;
        VPF2 = new int[Du+1];  //lo mismo que Du+1
        VPF2[0] = Terminos;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] VPF2) {
        this.VPF2 = VPF2;
    }
    
    public int getVPF2(int i) { //solo retorna un dato del vector
        return VPF2[i];
    }

    public void setVPF2(int i, int d) {
        VPF2[i] = d;
    }
    
    public void Construir(String []Vs){
        int j=1;
        for(int i=0; i<Vs.length; i+=2){
            int coe = Integer.parseInt(Vs[i]);
            int exp = Integer.parseInt(Vs[i+1]);
            
            if(coe != 0){
                VPF2[j] = coe;
                VPF2[j+1] = exp;
                j+=2;
            }
        }
        
    }
    
    public void Reconstruir(int[] VPF2){
        //Valida que el # de terminos no sea 0
        if(VPF2[0] == 0){
            System.out.println("0");
            return;
        }
        
        String s="";
        int terminos = VPF2[0];
        int Du = terminos * 2; //indice final
        
        for(int i=1; i<=Du; i+=2){
            int coe = VPF2[i];
            int exp = VPF2[i + 1];
            
            //operadores + o -
            if(s.length() > 0){
                s += (coe>0 ? " + " : " - ");
            } else if(coe<0){
                s += "-";
            }
            
            //Agrega coe sin signo
            int valAbsCoe = (coe<0) ? -coe : coe;
            
            //coeX ó termino independiente
            if(valAbsCoe != 1 || exp == 0){
                s += valAbsCoe;
            }
            
            if(exp>0){
                s+="x"; //x
                if(exp>1){ //x^exp
                    s+="^" + exp;
                }
            }
        }
        
        //Al final del ciclo s esta vacia o tiene el polinomio
        if(s.length() == 0){
            System.out.println("\n0");
        } else {
            System.out.println("\n" + s);
        }
    }
    
    public void mostrarForma() { //Mostrar el VPF2
        System.out.println("\n\nContenido de VPF2:");
        for (int i = 0; i < VPF2.length; i++) {
            System.out.print("|" + VPF2[i] + "|");
        }
    }
    
    public void insertarTermino(int coe, int exp) {
        if(coe == 0){ //Caso hipotetico de que el coe se cero
            return;
        }
        
        //Se busca la posicion del donde el exponente del vector 
        //donde sea menor o igual al exponente del nuevo termino
        int posicion = 2;
        while(posicion <= Du && VPF2[posicion] > exp){
            posicion += 2;
        }
        
        //exp hallado
        if(posicion <= Du && VPF2[posicion] == exp){
            VPF2[posicion - 1] += coe; //Suma el coe nuevo con el coe existente
            if(VPF2[posicion - 1] == 0){
                //Se elimina el coe que se vuelve cero
                eliminarTermino(exp);
            }
        } else {
            //El termino es nuevo
            if(Du + 2 >= VPF2.length){
                int nuevoTam = VPF2.length + 2;
                int[] VPF2_nuevo = new int[nuevoTam];
                
                for(int i=0; i<VPF2.length;i++){
                    VPF2_nuevo[i] = VPF2[i];
                }
            
                this.VPF2 = VPF2_nuevo;
                
            }
            
            //Se corre todo a la derecha para hacer espacio
            for(int i=Du; i>= posicion - 1; i--){
                VPF2[i + 2] = VPF2[i]; //Se copia valores i a i+2 para hacer dos huecos
            }
            
            //Meter el nuevo termino
            VPF2[posicion - 1] = coe;
            VPF2[posicion] = exp;
            
            //Aumentar atributos
            VPF2[0]++;
            Du += 2;
            
            System.out.println("\n\n\tSe ha insertado el termino: Coeficiente: " + coe + ", Exponente: " + exp);
            
        }
                
    }
    
    public void eliminarTermino(int exp) {
        int posicionExponente = -1; // Inicia en -1 para indicar que no se ha encontrado.

        for (int i = 2; i <= Du; i += 2) {
            if (VPF2[i] == exp) {
                posicionExponente = i; // Se guarda la posición del exponente.
                break; // Se sale del bucle una vez encontrado.
            }
        }

        if (posicionExponente == -1) {
            System.out.println("\n\n\tEl término con exponente " + exp + " no se encontró.");
            return; // Termina la ejecución del método.
        }

        for (int i = posicionExponente - 1; i <= Du - 2; i++) {
            VPF2[i] = VPF2[i + 2];
        }

        VPF2[0]--;
        Du -= 2;

        // REDIMENSIONAMIENTO DEL VECTOR ---
        int[] nuevoVPF2 = new int[Du + 1];

        // Se copian los elementos útiles del vector original al nuevo.
        System.arraycopy(VPF2, 0, nuevoVPF2, 0, Du + 1);

        // Se reemplaza el vector antiguo de la clase por el nuevo, ya redimensionado.
        this.VPF2 = nuevoVPF2;

        System.out.println("\n\n\tEl término con exponente " + exp + " se eliminó correctamente.");
    }
     
    public void evaluarPolForma2(int x){
        int resultado = 0;
        int terminos = VPF2[0];
        
        for(int i=1; i<=Du; i+=2){
            int coe = VPF2[i];
            int exp = VPF2[i + 1];
            
            int xElevada = 1;
            for(int j=0; j<exp;j++){
                xElevada *= x;
            }
            
            resultado += coe * xElevada;
        }
        
        System.out.println("El resultado es: " + resultado);
        
    }
    
    public void sumarPolinomiosForma2(clsForma2 B){

        int maxTer = this.VPF2[0] + B.getVPF2(0);
        clsForma2 C = new clsForma2(maxTer);
        
        //i j k
        int i=1; //pol A
        int j=1; //pol B
        int k=1; //pol C 
        
        //vectores A y B
        int[] VPF2_A = this.getVPF2();
        int[] VPF2_B = B.getVPF2();
        
        //Mientras halla terminos en cualquiera de los dos
        while (i <= this.getDu() || j <= B.getDu()){
            if(i<=this.getDu() && j<=B.getDu()){ //Si ambos tienen terminos
                int expA = VPF2_A[i + 1];
                int expB = VPF2_B[j + 1];
                
                if(expA == expB){ //exponentes iguales
                    int nuevoCoe = VPF2_A[i] + VPF2_B[j];
                    if(nuevoCoe != 0){
                        C.setVPF2(k, nuevoCoe);
                        C.setVPF2(k+1, expA);
                        k += 2;
                    }
                    i += 2;
                    j += 2;
                } else if (expA > expB){ //Exponente A es mayor
                    C.setVPF2(k, VPF2_A[i]);
                    C.setVPF2(k+1, VPF2_A[i + 1]);
                    k += 2;
                    i += 2;
                } else { //Exponente B es mayor
                    C.setVPF2(k, VPF2_B[j]);
                    C.setVPF2(k+1, VPF2_B[j+1]);
                    k += 2;
                    j += 2;
                }
            } else if (i<=this.getDu()){ //Si solo quedan terminos en A
                C.setVPF2(k, VPF2_A[i]);
                C.setVPF2(k+1, VPF2_A[i+1]);
                k+=2;
                i+=2;
            } else { //Si solo quedan terminos en B
                C.setVPF2(k, VPF2_B[j]);
                C.setVPF2(k+1, VPF2_B[j+1]);
                k += 2;
                j += 2;
            }
        }
        //Actualizar el terminos y Du
        int terminosC = (k-1)/2;
        C.setVPF2(0, terminosC);
        C.setDu(terminosC*2);
        
        int[] vFinalC = new int[C.getDu() + 1];
        int[] vTempC = C.getVPF2();
        
        for (int w = 0; w <= C.getDu(); w++) {
            vFinalC[w] = vTempC[w];
        }
        C.setVPF2(vFinalC);
        
        //Mostrar
        System.out.println("\n\nEl resultado de la suma es: ");
        C.Reconstruir(C.getVPF2());
        C.mostrarForma();
        
    }
    
    public void multiplicarPolinomios(clsForma2 B){
        
        clsForma2 C = new clsForma2(0);
        
        int[] VPF2_A = this.getVPF2();
        int[] VPF2_B = B.getVPF2();
        
        //recorrer cada termino del pol A 
        for(int i=1; i<= this.getDu(); i += 2){
            int coeA = VPF2_A[i];
            int expA = VPF2_A[i+1];
            
            //recorrer el pol B
            for(int j=1; j<= B.getDu(); j+= 2){
                int coeB = VPF2_B[j];
                int expB = VPF2_B[j+1];
                
                int nuevoCoe = coeA * coeB;
                int nuevoExp = expA + expB;
                
                C.insertarTermino(nuevoCoe, nuevoExp);
            }
        }
        
        //Mostrar
        System.out.println("\n\nEl resultado de la multiplicacion es: ");
        C.Reconstruir(C.getVPF2());
        C.mostrarForma();
        
        
    }
     
}
    
