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
        for(int i=0; i<Vs.length; i++){
            VPF2[j] = Integer.parseInt(Vs[i]);
            j++;
        }
        
    }
    
    public void Recontruir(int[] VPF2){
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
            System.out.println("0");
        } else {
            System.out.println(s);
        }
    }
    
    public void mostrarVector() { //Mostrar el VPF2
        System.out.println("\n\nContenido de VPF2: ");
        for (int i = 0; i < VPF2.length; i++) {
            System.out.print("|" + VPF2[i] + "|");
        }
    }
    
    public void insertarTermino(int coe, int exp) {
        if(coe == 0){ //Caso hipotetico de que el coe se cero
            return;
        }
        
        int posicion = 1;
        
        //Se busca si el termino que se ingresa tiene igual exp que uno del vector
        while(posicion <= Du && VPF2[posicion + 1] != exp){
            posicion += 2;
        }
        
        //exp hallado
        if(posicion <= Du){
            VPF2[posicion] += coe; //Suma el coe nuevo con el coe existente
            if(VPF2[posicion] == 0){
                //Se elimina el coe que se vuelve cero
                eliminarTermino(exp);
            }
        } else {
            //El termino es nuevo
            posicion = 2; //Se busca la posicion para agregarlo
            while (posicion <= Du && VPF2[posicion] > exp){
                posicion += 2;
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
    
    public void eliminarTermino(int exp){
        int posicion = -1; //Funciona para indicar que no se ha encontrado
        
        //Buscar posicion de coe dado su exponente
        for(int i=2; i<=Du; i++){ //Se recorre el vector por los exp
            if(VPF2[i] == exp){
                posicion = i; //Posion del exp
                break; //Sale apenas encuentre la vaina
            }
        }
        
        //Validar si el termino está
        if(posicion == -1){
            System.out.println("\n\n\tEl termino con elevado a " + exp + " no se encontro copielo bien :).");
            return;
        }
        
        //Se pasa a la izquierda en el punto de los coe y exp que se quiere eliminar
        // (posicion - 1) indica el coe y pos el exp
        for(int i=posicion-1; i<=Du-2;i++){
            VPF2[i] = VPF2[i+2];
        }
        
        //Se actualiza el # de termino y la dimension del vector
        VPF2[0] = VPF2[0] - 1;
        Du = Du - 2;
        
        System.out.println("\n\n\tTermino elevado al " + exp + " se borro correctamente.");
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
    
    public void sumarPolinomiosForma2(){
        
    }
    
    
    
    
}
    
