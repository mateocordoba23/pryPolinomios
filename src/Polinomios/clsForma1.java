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
        int k=0;
        VPF1[k] = Integer.parseInt(Vs[1]); //Vs[1] es el grado de VPF1
        k++;
        
        for(int i=1; i<Vs.length-1;i+=2){ //Recorre Vs pasando solo por los exp
            
            for(int j = VPF1[0]; j>=0; j--){ //Toma el grado y se devuelve
                if(j == Integer.parseInt(Vs[i])){ // Valida que el exp Vs es igual a j
                    VPF1[k] = Integer.parseInt(Vs[i-1]);
                    k++;
                } else {
                    VPF1[k] = 0; //Si j != de Vs[i] agrega un cero
                                 // --> Indicando que se agruega 0 si no hay un coe por ese exp
                    k++;
                }
            }
            
        }       
    }
    
    
    
    
    
}