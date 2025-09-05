package Polinomios;

public class clsForma1 {
    //Atributos
    private int Du, VPF1[];
    
    //Metodos
    public clsForma1() {
    }

    public clsForma1(int grado) {
        Du = grado + 1;
        VPF1 = new int[Du+1];
        VPF1[0] = grado;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF1() {
        return VPF1;
    }

    public void setVPF1(int[] VPF1) {
        this.VPF1 = VPF1;
    }
    
    public int getVPF1(int i) {
        return VPF1[i];
    }

    public void setVPF1(int i, int d) {
        VPF1[i] = d;
    }
    
    public void Construir(String[] Vs){
        
        for(int i=0; i< Vs.length; i+=2){ //Recorremos Vs por los coe
            int coe = Integer.parseInt(Vs[i]); //Tomamos el coe
            int exp = Integer.parseInt(Vs[i+1]); //Tomamos el exp
            
            if(exp <= VPF1[0]){ //Comparamos exp y grado
                int pos = Du - exp;
                VPF1[pos] = coe;
            }
               
        }
         
    }
    
    public void Recontruir(int[] VPF1){
        
        //Valida que el VPF1 es correcto o es 0
        if(VPF1.length <= 1){
            System.out.println("0");
            return;
        }
        
        String s="";
        int grado = VPF1[0];
        int Du = grado + 1;
        
        //Se recorre el VPF1 desde 1 hasta el final
        for (int i = 1; i <= Du; i++) {
            int coe = VPF1[i]; //coe del termino actual
            int exp = Du - i;  //exp del termino actual

            //Si coe es cero no muestra
            if (coe == 0) {
                continue;
            }
            
            //agregar + o -
            if(s.length() > 0){ //hay algo en s
                s += (coe > 0 ? " + " : " - "); //ternario
                                                // (condicion ? verdadero : falso)
            } else if (coe < 0) { //coe negativo
                s += "-";
            }
            
            int valAbsCoe = (coe < 0 ? -coe : coe); //se pasa coe a positivo

            //Valida si valCoe es termino independiente o coe !=1 (algoporX)
            if(valAbsCoe != 1 || exp == 0){
                s += valAbsCoe;
            }
            
            //exp mayor a cero se agrega x^exp
            if(exp > 0){
                s += "x"; //se agrega solo x
                if(exp > 1){
                    s+="^" + exp; //se agrega x^exp
                }
            }            

        }
        
        if(s.length() == 0){
            System.out.println("0");
        } else {
            System.out.println(s);
        }
          
    }
    
    public void mostrarForma() { //Mostrar el VPF1
        System.out.println("\n\nContenido de VPF1: ");
        for (int i = 0; i < VPF1.length; i++) {
            System.out.print("|" + VPF1[i] + "|");
        }
    }
    
    public void insertarTermino(int coe, int exp){
        
        System.out.println("\n\n\tSe ha insertado el termino: Coeficiente: " + coe + ", Exponente: " + exp);
        
        if(coe == 0){ //Caso hipotetico si el coe es cero 
            return;
        }
        
        //Exp del coe es mayor que el grado hay redimensionar el VPF1
        if(exp > VPF1[0]){
            int DuAnterior = Du;
            int VPF1Anterior[] = VPF1;
            
            //Se vuelve a inicializar los atributos de clsForma1
            this.Du = exp + 1;
            this.VPF1 = new int[Du + 1];
            this.VPF1[0] = exp; //El nuevo grado de VPF1 es el exp
            
            //Se pone coe en VPF1
            this.VPF1[1] = coe;
            
            //Se copia los coe del VPF1Anterior al nuevo VPF1
            for(int i=1; i<=DuAnterior; i++){
                int coeAnterior = VPF1Anterior[i];
                
                //Se valida si el coe anterior != de cero
                if(coeAnterior != 0){
                    
                    //Se calcula el exponente que correspondia a la posicion "i" en el VPF1Anterior
                    int expAnterior = DuAnterior - i;
                    
                    //Se calcula la nueva posicion para ese exponente en el VPF1 nuevo
                    int posNueva = this.Du - expAnterior;
                    
                    //Se pone el coe anterior en su nueva posicion
                    this.VPF1[posNueva] = coeAnterior;
                }
            }
            
            
        } else {
            //En esta situacion el nuevo termino es <= que el grado actual
            
            //Formula de la VPF1 para la pos
            int pos = Du - exp;
            
            //Se suma el nuevo coe con el anterior coe
            VPF1[pos] += coe;
            
        }
        
        
    }
    
    public void eliminarTermino(int exp){

        //Validar si el exp pertenece al VPF1
        if(exp<0 || exp>VPF1[0]){
            System.out.println("\n\n\tEl exponente " + exp + " no pertenece al VPF1");
            return;
        }
        
        System.out.println("\n\n\tSe ha eliminado el termino con exponente: "+ exp);
        
        //posicion del termino y volverlo cero
        int pos = Du - exp;
        VPF1[pos] = 0;
        
        //Validar si se elemino el termino del grado
        if(exp == VPF1[0]){
            int gradoNuevo = -1; //Buscar nuevo grado del Polinomio
            for(int i=1; i<VPF1.length; i++){ //Se recorre todo el VPF1 buscando el termino 
                                              //no nulo desde el coe de mayor grado 
                if(VPF1[i] != 0){
                    gradoNuevo = Du - i;
                    break; //Salga cuando encuentre el coe != 0
                }
                
            }
            
            //Validando si no se encontro nuevo grado despues de eliminar
            //el polinomio es cero
            if(gradoNuevo == -1){
                gradoNuevo = 0;
            }
            
            //Ajustar tamaño del polinomio
            int DuAnterior = Du;
            int VPF1Anterior[] = VPF1;
            
            this.Du = gradoNuevo + 1;
            this.VPF1 = new int[Du + 1];
            this.VPF1[0] = gradoNuevo;
            
            //Copiar los coe restantes del vector viejo al nuevo
            for(int i=1; i<=this.Du; i++){
                int expActual = this.Du - i; //exp al nuevo vector
                int posAnterior = DuAnterior - expActual; //pos de ese exp en vector viejo
                
                this.VPF1[i] = VPF1Anterior[posAnterior];
                
            }
            
        }
        
        
    }
    
    public void evaluarPolForma1(int x){
        int resultado = 0;
        
        //Recorrer VPF1 desde el primer coe
        for(int i=1; i<= this.Du; i++){
            int coe = VPF1[i]; //se consigue coe
            
            //coe 0 no aporta al resultado
            if(coe != 0){
                int exp = this.Du - i; //se obtiene exp
                
                int xElevado = 1;
                //Multiplica x ella misma exp veces
                for(int j=0;j<exp; j++){
                    xElevado *= x;
                }
                
                resultado += coe * xElevado;
            }
        }
        
        System.out.println("El resultado es: " + resultado);
    }
    
    public void sumarPolinomiosForma1(clsForma1 B) {

        //Determinar el grado mayor entre los 2 polis
        int gradoA = this.VPF1[0];
        int gradoB = B.getVPF1(0);
        int gradoMay;

        if (gradoA > gradoB) {
            gradoMay = gradoA;
        } else {
            gradoMay = gradoB;
        }

        //Se crea el objeto c
        clsForma1 C = new clsForma1(gradoMay);

        //Se recorre todos los exponentes desde el frado mayor a 0
        for (int exp = gradoMay; exp >= 0; exp--) {
            
            int coeA = 0;
            //Si el exp actual de pol A  existe se obtiene su coeficiente
            if(exp<=gradoA){
                int posicionA = this.Du - exp;
                coeA = this.getVPF1(posicionA);
            }
            
            int coeB = 0;
            //Si el exp actual de pol B existe se obtiene su coeficiente
            if(exp<=gradoB){
                int posicionB = B.getDu() - exp;
                coeB = B.getVPF1(posicionB);
            }
            
            //Sumar los coe y agregar a C
            int posicionC = C.getDu() - exp;
            C.setVPF1(posicionC, coeA + coeB);
        }
        
        //Mostrar suma y c
        System.out.println("\n\n---- Suma de polinomios ----");
        System.out.println("Polinomio A: ");
        this.Recontruir(this.getVPF1());//Muestra el primer POLINOMIO 
        
        System.out.println("Polinomio B: ");
        this.Recontruir(this.getVPF1());//Muestra el segundo POLINOMIO
        
        System.out.println("Resultado de la suma A+B: ");
        C.Recontruir(C.getVPF1()); //Muestra c
        C.mostrarForma();
        
    }
    
    public void multiplicarPolinomios(clsForma1 B){
        
        //El grado de c es la suma de grados
        int gradoA = this.VPF1[0];
        int gradoB = B.getVPF1(0);
        int gradoC = gradoA + gradoB;
        
        //Se crea c
        clsForma1 C = new clsForma1(gradoC);
        
        //Se anda por todo el pol A
        for(int i=1; i<=this.Du; i++){
            int coeA = this.VPF1[i];
            
            //Si coe es 0, no se hace nada
            if(coeA == 0){
                continue;
            }
            int expA = this.Du - i;
            
            //Se anda por todo B
            for(int j=1; j<= B.getDu(); j++){
                int coeB = B.getVPF1(j);
                
                if(coeB == 0){
                    continue;
                }
                int expB = B.getDu() - j;
                
                //Se calcula el producto de los dos terminos
                int coeResul = coeA * coeB;
                //El nuevo exp es la suma de los exp
                int expResul = expA + expB;
                
                //Acumular el resultado en C
                int posicionResul = C.getDu() - expResul;
                C.VPF1[posicionResul] += coeResul;
            }
        }
        
        //Mostrar
        System.out.println("\n\n---- Multiplicacion de polinomios ----");
        
        System.out.println("Polinomio A: ");
        this.Recontruir(this.getVPF1());
        
        System.out.println("Polinomio B: ");
        B.Recontruir(B.getVPF1());
        
        System.out.println("Resultado A*B: ");
        C.Recontruir(C.getVPF1());
        C.mostrarForma();
    }
    

}
