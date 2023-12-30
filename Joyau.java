public class Joyau extends Contenu{
    private int valeur;
    public Joyau(String s,int i,int valeur){
        super(s,i);
        this.valeur= valeur;

    }
    public int getValeur(){
        return valeur;
    }
    public String toString(){
        return super.toString()+" prix : "+valeur;
    }

}
//Anh Tu NGUYEN 21108438