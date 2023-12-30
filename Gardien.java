public class Gardien extends Contenu{
    private int pointsdevie;
    public Gardien(String s,int i){
        super(s,i);
        this.pointsdevie = (int)(Math.random()*100);

    }
    public int getTheforce(){
        return pointsdevie;

    }
    public void baisserpoint(int f){
        this.pointsdevie = pointsdevie - f;
    }
    public String toString(){
        return super.toString()+" points de vie : "+pointsdevie;
    }
    
}
//Anh Tu NGUYEN 21108438