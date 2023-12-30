import java.lang.reflect.Array;
import java.util.ArrayList;

public class Agent9{
    private int x;
    private int y;
    private ArrayList<Joyau> sacJoyaux ;
    private Grille g;
    private String event="";

    public Agent9(int xnew,int ynew){
        this.x = xnew;
        this.y = ynew;
        this.sacJoyaux= new ArrayList<>();
        int ran = (int)(Math.random()*21+1);
        this.g = new Grille(ran,ran);
        
        
    }
    public void seDeplacer(int xnew,int ynew) throws DeplacementIncorrectException,CoordonneesIncorrectesException,CaseNonPleineException{
       
        if (g.sontValides(xnew,ynew)) {

            Contenu contenu =  g.getCase(xnew,ynew);
            if(contenu instanceof Joyau){
                sacJoyaux.add((Joyau) contenu);
                g.videCase(xnew,ynew);
                System.out.print("recuperer Joyau\n");
                this.event = "recuperer Joyau\n";
            
            }else if(contenu instanceof Gardien){
                sacJoyaux = new ArrayList<>();
                System.out.println("perdre tous les joyaux\n");
                this.event = "perdre tous les joyaux\n";
            }else{
                System.out.println("pas evenement\n");
                this.event = "pas evenement\n";
            }
            this.x = xnew;
            this.y = ynew;
        }else{
            //si on veut ca marche pour tous les étape sans exception, on va enlever la ligne throw deplace , ca va installer les x,y comme au début
            x =0;
            y =0;
            throw new DeplacementIncorrectException("Déplacement incorect");
        }
    }
    public void seDeplacer(int xnew,int ynew,int f) throws DeplacementIncorrectException,CoordonneesIncorrectesException,CaseNonPleineException{
        if(g.sontValides(xnew,ynew)){
            Contenu contenu = g.getCase(xnew,ynew);
            if(contenu instanceof Joyau){
                sacJoyaux.add((Joyau) contenu);
                System.out.print("recuperer Joyau\n");
                this.event = "recuperer Joyau\n";
                

                g.videCase(xnew,ynew);

            }else if(contenu instanceof Gardien){
                if(((Gardien)contenu).getTheforce() <= f ){
                    g.videCase(xnew,ynew);
                    System.out.print("taper gardien\n");
                
                    this.event = "taper gardien et recuperer Joyau\n";

                }else{
                    sacJoyaux = new ArrayList<>();
                    ((Gardien)contenu).baisserpoint(f);
                    System.out.println("perde tous les joyaux\n");
                    this.event = "perdre tous les joyaux\n";

                }
            }else{
                System.out.println("pas evenement\n");
                this.event = "recuperer Joyau\n";
            }
            this.x=xnew;
            this.y=ynew;
        }else{
            //si on veut ca marche pour tous les étape sans exception, on va enlever la ligne throw deplace , ca va installer les x,y comme au début
            x=0;
            y=0;
            throw new DeplacementIncorrectException("Déplacement incorect");
        }        
    }
    public int fortune(){
        int val =0;
        for(Joyau j: sacJoyaux){
            val += j.getValeur()*j.getQuantite();

        }return val;
    } 
    public ArrayList<Joyau> contenuSac(){
        return new ArrayList<>(sacJoyaux);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Grille getGrille(){
        return g;
    }
    public String toString(){
        String chaine = "Agent9 en position : ["+x+","+y+ " ] " + "avec le sac(valeur): \n";
        for(Joyau j: sacJoyaux){
            chaine+= j.type+"\n";

        }return chaine;
    }
    public String getEvent(){
        return event;
    }
}
//Anh TU nGUYEN 21108438