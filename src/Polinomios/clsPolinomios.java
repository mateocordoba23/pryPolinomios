/**
 * Clase Principal
 */

package Polinomios;

import javax.swing.JOptionPane;

public class clsPolinomios {
    public static void main(String[] args) {
    
        //int opc = 0;
       
        String Vs[] = Ordenar(Ajustar(IngresoPol())); // Asigna a Vs el polinomio ajustado el tamaño y 
                                                      // ordenado de mayor a menor exp con su coeficiente
        clsForma1 F1 = new clsForma1(Integer.parseInt(Vs[1]));
        F1.Construir(Vs);
        F1.mostrarVector();
        
        int Terminos = Terminos(Vs); //Numero de coe diferentes de cero
        clsForma2 F2 = new clsForma2(Terminos);
        F2.Construir(Vs);
        F2.mostrarVector();
        
        clsForma3 F3 = new clsForma3();
        F3.Construir(Vs);
        F3.mostrarLista();
        
        //Hacer un menú
//        do {
//            opc = Menu();
//            switch (opc) {
//                case 1:
//                    //Insertar
//                    //F1.InsertarTermino(coe, exp);
//                    break;
//                case 2:
//                    JOptionPane.showInputDialog("Digite el termino que quiere eliminar del polinomio: \n");
//                    break;
//                case 3:
//                    JOptionPane.showInputDialog("Mostrar el polinomio en Forma 1: \n");
//                    break;
//                case 0:
//                    
//                    break;
//                default:
//                    JOptionPane.showMessageDialog(null, "Opción Incorrecta.");
//            }
//        } while (opc!=0);
    
    }
    
//    public static int Menu(){
//        int opc = Integer.parseInt(JOptionPane.showInputDialog("**********Menú Principal**********"
//                + "\n1. Ingresar Termino."
//                + "\n2. Eliminar Termino"
//                + "\n3. Mostrar Forma 1."
//                + "\n0. Salir"));
//        return opc;
//    }
        
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
   
