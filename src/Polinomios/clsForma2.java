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
    
    public void mostrarVector() { //Mostrar el VPF2
        System.out.println("\n\nContenido de VPF2: ");
        for (int i = 0; i < VPF2.length; i++) {
            System.out.print("|" + VPF2[i] + "|");
        }
    }
    
}