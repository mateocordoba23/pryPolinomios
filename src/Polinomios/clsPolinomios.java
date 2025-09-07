package Polinomios;

import javax.swing.JOptionPane;

public class clsPolinomios {

    public static void main(String[] args) {

        int opc = 0, opc1 = 0;

        String Vs[] = Ordenar(Ajustar(IngresoPol())); // Asigna a Vs el polinomio ajustado el tamaño y 
        // ordenado de mayor a menor exp con su coeficiente

        clsForma1 F1 = new clsForma1(Integer.parseInt(Vs[1]));
        F1.Construir(Vs);

        int Terminos = Terminos(Vs);
        clsForma2 F2 = new clsForma2(Terminos);
        F2.Construir(Vs);

        clsForma3 F3 = new clsForma3();
        F3.Construir(Vs);

        //menu
        do {
            opc1 = Formas();

            switch (opc1) {
                case 1:
                    do {
                        opc = Menu(); //Forma 1
                        switch (opc) {
                            case 1: //Insertar termino en Forma1 
                                //Se pide al usuario un coe y un exp y se guarda en var (se adapta al tipo de dato que le des desde que le des uno)
                                var coe = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un Coeficiente: "));
                                var exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un Exponente: "));
                                
                                JOptionPane.showMessageDialog(null,"Se ha insertado el termino: Coeficiente: " + coe + ", Exponente: " + exp);
                                F1.insertarTermino(coe, exp);

                                break;

                            case 2: //Eliminar termino del VPF1 en Forma1
                                //Se pide al usuario una exp del termino a borrar
                                var expBorrar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Exponente que desea borrar: "));

                                F1.eliminarTermino(expBorrar);

                                break;

                            case 3: //Mostrar VPF1 |dato| ...
                                F1.mostrarForma();

                                break;

                            case 4: //Pasa el VPF1 a su forma de polinomio
                                //Mediante POO se llama a VPF1
                                System.out.println("\n\nVPF1 en Polinomio: ");
                                F1.Reconstruir(F1.getVPF1());

                                break;

                            case 5: //Se evalua el polinomio dandole un valor a X
                                var x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor para X: "));
                                F1.evaluarPolForma1(x);

                                break;

                            case 6: //Suma de polinomios de la misma forma2
                                //Ta hay un polinomio ingresado el del inicio del programa solo falta pedir otro
                                //Se crea otro polinomio para sumarlos
                                var Vs2 = Ordenar(Ajustar(IngresoPol())); // Asigna a Vs el polinomio ajustado el tamaño y 
                                // ordenado de mayor a menor exp con su coeficiente

                                clsForma1 F1b = new clsForma1(Integer.parseInt(Vs2[1]));
                                F1b.Construir(Vs2);

                                F1.sumarPolinomiosForma1(F1b);

                                break;

                            case 7: //Multiplicacion de polinomios de la misma forma1
                                //Se crea otro polinomio para multiplicarlo
                                var Vs3 = Ordenar(Ajustar(IngresoPol())); // Asigna a Vs el polinomio ajustado el tamaño 

                                clsForma1 F1c = new clsForma1(Integer.parseInt(Vs3[1]));
                                F1c.Construir(Vs3);

                                F1.multiplicarPolinomios(F1c);

                            case 0:
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                        }
                    } while (opc != 0);
                    
                    break;

                case 2:
                    do {
                        opc = Menu2(); //Forma 2
                        switch(opc){
                            case 1: //Insertar termino
                                //El usuario ingresa un coe y un exp 
                                var coe = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un Coeficiente: "));
                                var exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un Exponente: "));
                                
                                F2.insertarTermino(coe, exp);
                                
                                if(coe != 0){
                                    System.out.println("\n\nSe ha insertado el termino: Coeficiente: " + coe + ", Exponente: " + exp);
                                    JOptionPane.showMessageDialog(null,"Se ha insertado el termino: Coeficiente: " + coe + ", Exponente: " + exp);
                                }
                                
                                break;
                                
                            case 2: //Eliminar termino
                                //El usuario ingresa el exp del termino por eliminar
                                var expBorrar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Exponente del termino que desea borrar: ")); 
                                
                                F2.eliminarTermino(expBorrar);
       
                                break;
                                
                            case 3://Mostrar Forma (mostrar VPF2)
                                F2.mostrarForma();
                                
                                break;
                                
                            case 4: //Mostrar el VPF2 en polinomio
                                System.out.println("\n\nVPF2 en Polinomio: ");
                                F2.Reconstruir(F2.getVPF2());
                                
                                break;
                                
                            case 5: //Evaluar polinomio dandole un valor a X
                                var x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor para X: "));
                                F2.evaluarPolForma2(x);
                                
                                break;
                                
                            case 6: //Suma de polinomios de la misma forma
                                //Se crea otro polinomio para sumarlos
                                var Vs2 = Ordenar(Ajustar(IngresoPol())); // Asigna a Vs el polinomio ajustado el tamaño y 
                                // ordenado de mayor a menor exp con su coeficiente
                                int Terminos1 = Terminos(Vs2);
                                clsForma2 F2b = new clsForma2(Terminos1);
                                F2b.Construir(Vs2);

                                F2.sumarPolinomiosForma2(F2b);

                                break;
                                
                            case 7: //Multiplicacion de polinomios
                                //Se crea otro polinomio para multiplicarlo
                                var Vs3 = Ordenar(Ajustar(IngresoPol())); // Asigna a Vs el polinomio ajustado el tamaño y 

                                int Terminos2 = Terminos(Vs3);
                                clsForma2 F2c = new clsForma2(Terminos2);
                                F2c.Construir(Vs3);

                                F2.multiplicarPolinomios(F2c);
                                
                                break;
                                
                            case 0:
                                break;
                                
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                        }
                    } while (opc != 0);
                    
                    break;
                    
                case 3:
                    //F3.construir(Vs);
                    do {
                        opc = Menu3(); //Forma 3
                        
                        switch(opc){
                            case 1: //Insertar termino 
                                var coe = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un Coeficiente"));
                                var exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un Exponente"));
                                
                                JOptionPane.showMessageDialog(null,"Se ha insertado el termino: Coeficiente: " + coe + ", Exponente: " + exp);
                                F3.insertarTermino(coe, exp);
                                
                                break;
                                
                            case 2: //Eliminar termino
                                var expBorrar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Exponente del termino que desea borrar: "));
                                
                                F3.eliminarTermino(expBorrar);
                                
                                break;
                                
                            case 3: //Mostrar Lista (VPF3)
                                F3.mostrarLista();
                                
                                break;
                                
                            case 4: //Mostrar Lista en Polinomio
                                System.out.println("\n\nVPF3 en Polinomio: ");
                                F3.Reconstruir();
                                
                                break;
                                
                            case 5: //Evaluar pol dando un valor a X
                                var x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de x: "));
                                
                                F3.evaluarPolForma3(x);
                                
                                break;
                                
                            case 6: //Suma de polinomios de la misma forma
                                String Vs3[] = Ordenar(Ajustar(IngresoPol()));
                                
                                clsForma3 F3b = new clsForma3();
                                F3b.Construir(Vs3);
                                
                                F3.sumarPolinomiosForma3(F3b);
                                
                                break;
                            
                            case 7: //Multiplicacion de polinomios de la misma forma
                                String Vs4[] = Ordenar(Ajustar(IngresoPol()));
                                
                                clsForma3 F3c = new clsForma3();
                                F3c.Construir(Vs4);
                                
                                F3.multiplicarPolinomiosForma3(F3c);
                                
                                break;
                                
                            case 0:
                                break;
                                
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                        }
                    } while (opc != 0);
                    
                    break;
                    
                case 4:
                    //Construir  vector F1
                    String VsF1[] = Ordenar(Ajustar(IngresoPol()));
                    clsForma1 F1t = new clsForma1(Integer.parseInt(VsF1[1]));
                    F1t.Construir(VsF1);
                    
                    //Construir vector F2
                    String VsF2[] = Ordenar(Ajustar(IngresoPol()));
                    int terminosF2 = Terminos(VsF2);
                    clsForma2 F2t = new clsForma2(terminosF2);
                    F2t.Construir(VsF2);
                    
                    System.out.println("\n\nPolinomio A:");
                    F1t.mostrarForma();
                    F1t.Reconstruir(F1t.getVPF1());
                    
                    System.out.println("\nPolinomio B:");
                    F2t.mostrarForma();
                    F2t.Reconstruir(F2t.getVPF2());
                    
                    //Crear el resultado en F3
                    clsForma3 F3res = clsForma3.SumarF1F2(F1t, F2t);
                    
                    System.out.println("\nResultado de (Forma1)F1 + (Forma2)F2 = (Forma3)F3 : ");
                    
                    F3res.Reconstruir();
                    F3res.mostrarLista();
                    
                    break;

                case 5:
                    //Construir F3
                    String VsF3[] = Ordenar(Ajustar(IngresoPol()));
                    clsForma3 F3t = new clsForma3();
                    F3t.Construir(VsF3);
                    
                    //Construir F2
                    String VsF2b[] = Ordenar(Ajustar(IngresoPol()));
                    int terminosF2b = Terminos(VsF2b);
                    clsForma2 F4t = new clsForma2(terminosF2b);
                    F4t.Construir(VsF2b);
                    
                    //Crear resultado en forma 1 usando directamente F3 y F2
                    clsForma1 F1res = clsForma1.MultiplicarF3F2(F3t, F4t);
                    
                    System.out.println("\n\nPolinomio A:");
                    F3t.Reconstruir();
                    F3t.mostrarLista();
                    
                    System.out.println("\nPolinomio B:");
                    F4t.Reconstruir(F4t.getVPF2());
                    F4t.mostrarForma();
                    
                    System.out.println("\n\nResultado de F3(Forma 3) * F2(Forma 2) = F1(Forma 1) : ");
                    
                    F1res.Reconstruir(F1res.getVPF1());
                    F1res.mostrarForma();
                    
                    break;
                    
                default:   
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
            }
        } while (opc1 != 0);
    }
    
    public static int Formas(){
        int opc1 = Integer.parseInt(JOptionPane.showInputDialog("----- Elija la forma -----\n"
                + "1. Forma 1.\n"
                + "2. Forma 2.\n"
                + "3. Forma 3.\n"
                + "4. Operacion de F1 + F2.\n"
                + "5. Operacion de F3 * F2.\n"
                + "0. Salir.\n"));
        return opc1;
    
    }
    
    public static int Menu(){
        int opc = Integer.parseInt(JOptionPane.showInputDialog("----- Menu Principal (Forma 1)-----\n"
                + "1. Insertar Termino.\n"
                + "2. Eliminar Termino.\n"
                + "3. Mostrar Forma.\n"
                + "4. Mostrar polinomio.\n"
                + "5. Evaluar el polinomio con un dato ingresado.\n"
                + "6. Sumar polinomios de la misma forma.\n"
                + "7. Multiplicar polinomios de la misma forma.\n"
                + "0. Salir\n"));
        return opc;
    }
    
    public static int Menu2(){
        int opc = Integer.parseInt(JOptionPane.showInputDialog("----- Menú Principal (Forma 2)-----\n"
                + "1. Insertar Termino.\n"
                + "2. Eliminar Termino.\n"
                + "3. Mostrar Forma.\n"
                + "4. Mostrar polinomio.\n"
                + "5. Evaluar el polinomio con un dato ingresado.\n"
                + "6. Sumar polinomios de la misma forma.\n"
                + "7. Multiplicar polinomios de la misma forma.\n"
                + "0. Salir.\n"));
        return opc;
    }
    
    public static int Menu3(){
        int opc = Integer.parseInt(JOptionPane.showInputDialog("----- Menú Principal (Forma 3)-----\n"
                + "1. Insertar Termino.\n"
                + "2. Eliminar Termino.\n"
                + "3. Mostrar Forma.\n"
                + "4. Mostrar polinomio.\n"
                + "5. Evaluar el polinomio con un dato ingresado.\n"
                + "6. Sumar polinomios de la misma forma.\n"
                + "7. Multiplicar polinomios de la misma forma.\n"
                + "0. Salir.\n"));
        return opc;
    }
    
    public static String[] IngresoPol(){

        var pol = JOptionPane.showInputDialog("Ingrese un Polinomio: "); //Recibe el polinomio
        pol = pol.replaceAll("\\s+", ""); //Quita todos los espacios del String
        
        String s = "";
        int j = 0;
        char Vc[] = pol.toCharArray(); //Se pasa pol (string) a un arreglo de caracteres en el vector Vc
        String Vs[] = new String[Vc.length]; //Se crea un nuevo vector con el tamaño de Vc

        for (int i = 0; i < Vc.length; i++) {

            System.out.println("|" + Vc[i] + "|"); //Se imprime Vc 

        }

        for (int i = 0; i < Vc.length; i++) {

            if (Vc[i] == '-' || Character.isDigit(Vc[i])) { 
                s = s + Vc[i]; //Si |-| |8| --> |-8|
                
                if(i == Vc.length - 1 && !s.equals("")){ //Valida que el ultimo elemento es el termino independiente y es negativo
                    if(Vc[i-1]=='-' && Vc[i-2]=='x'){
                        Vs[j] = s;
                        Vs[j+1] = "0";
                        j+=2;
                    } 
                }
                
            } else {
                if (Vc[i] == 'x') {
                    if(!s.equals("")){ //Valida que la x tenga un coeficente
                        Vs[j] = s;
                        s = "";
                        j++;

                        if (Vc[i + 1] == '+' || Vc[i + 1] == '-') { //Valida que la x tenga exponente
                            Vs[j] = "1"; // |8| |x| |+| |3| --> |8| |1| |3|  agregar a las x sin exponentes
                            j++;
                        }
                    } else { // |x| |+| |3| |x| --> |1| |1| |3| |1| 
                        Vs[j] = "1";
                        j++;
                    
                        if(Vc[i+1] == '+' || Vc[i+1] == '-'){
                            Vs[j] = "1";
                            j++;
                        }
                    }  
                } 
                
            }

            if (Vc[i] == '^') {
                
                if(Vc[i+1] == '-'){ //Validar si el exponente es negativo
                    Vs[j] = "" + Vc[i+1] + Vc[i+2]; //Concatena ambos valores y los convierte en String
                    j++;
                    i+=2;
                } else {
                   Vs[j] = Character.toString(Vc[i + 1]);
                    j++;
                    i++; 
                }
                     
            }

            if (!s.equals("")) {  
                if(Vc[i] == '+'){ //Valida el termino independiente positivo y le da exponente 0
                    Vs[j] = s;
                    Vs[j + 1] = "0";
                    j+=2;
                    s = "";
                }
                
            }

        }

        System.out.println("\n");
        for (int i = 0; i < Vs.length; i++) {
            System.out.print("|" + Vs[i] + "|");
        }
        
        return Vs;
    }
    
    public static String[] Ajustar(String[] polinomio){
        
        int cont=0;
        
        for(int i=0; i<polinomio.length; i++){
            if(polinomio[i] != null){ 
                cont++; //Contador numero de elementos diferentes de null
            }
        }
        
        String[] Vs = new String[cont];
        int j=0;
        
        for(int i=0; i<polinomio.length; i++){
            if(polinomio[i] != null){
                Vs[j] = polinomio[i]; //Toma los elementos no nulos de un vector y los pasa a otro
                j++;
            }
        }
        
        System.out.println("\n");
        for (int i = 0; i < Vs.length; i++) {
            System.out.print("|" + Vs[i] + "|");
        }
        
        return Vs;
        
    }  
    
    public static String[] Ordenar(String[] polinomio){
        //Ordenar el vector de mayor a menor
        String[] Vs = polinomio;
        int numParejas = Vs.length / 2;
        String tempExp, tempCoe; 
        
        for(int i=0; i<numParejas - 1; i++){ 
            for(int j=1; j<Vs.length-1-(2*i); j+=2){ //Reduce el rango de comparacion con cada ciclo de i
                if(Integer.parseInt(Vs[j]) < Integer.parseInt(Vs[j+2])){
                    
                    //Intercambio de exponentes
                    tempExp = Vs[j];                
                    Vs[j] = Vs[j+2];
                    Vs[j+2] = tempExp;
                    
                    //Intercambio de coeficientes
                    tempCoe = Vs[j-1];
                    Vs[j-1] = Vs[j+1];
                    Vs[j+1] = tempCoe;
                    
               
                }
            }
        }
        
        System.out.println("\n");
        for (int i = 0; i < Vs.length; i++) {
            System.out.print("|" + Vs[i] + "|");
        }
        
        return Vs;
        
    }
    
    public static int Terminos(String[] polinomio){
        int terminosCont = 0;
        for(int i=0; i<polinomio.length; i+=2){
            if(Integer.parseInt(polinomio[i]) != 0){
                terminosCont++;
            }
        }
        
        return terminosCont;
    }
        
}
   
