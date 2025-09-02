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
    
    public void mostrarVector() { //Mostrar el VPF1
        System.out.println("\n\nContenido de VPF1: ");
        for (int i = 0; i < VPF1.length; i++) {
            System.out.print("|" + VPF1[i] + "|");
        }
    }
    
    
    
    
    
}