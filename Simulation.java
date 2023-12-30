import javax.swing.text.AbstractDocument.Content;

public class Simulation{
    private Agent9 agent;
    private Grille grille ;
    private Contenu[] tabContenu;
    private String agenda = "";

    public Simulation(int m) throws CoordonneesIncorrectesException{
        
        this.tabContenu =  new Contenu[m];
        this.agent = new Agent9(0,0);// la premier position d'agent;
        this.grille=agent.getGrille();
        for (int i = 0 ; i < m ; i++){
            int ligne = grille.nbLignes;
            int colonne = grille.nbColonnes;

            int ranx = (int)(Math.random()*(ligne));
            int rany = (int)(Math.random()*(colonne));

            double ran = Math.random()*1;
            int quantite = (int)(Math.random()*10+1);
            if(ran <= 0.9){//proba voir les joyau
                int ranj =  (int)(Math.random()*3+1);
                if(ranj == 1){
                    tabContenu[i]= new Ruby(quantite);
                    

                }else if(ranj == 2){
                    tabContenu[i] = new Diamant(quantite);

                }else if(ranj == 3){
                    tabContenu[i] = new Opale(quantite);
                }
                grille.setCase(ranx,rany,tabContenu[i]);
            }else{
                tabContenu[i] = new Gardien("Gardien", quantite);

                grille.setCase(ranx,rany,tabContenu[i]);
            }


        }
    }
    public String toString(){
        String chaine = "L'argent : \n";
        chaine += "position : ["+agent.getX()+","+agent.getY()+"]"+"\n";
        chaine += "fortune : "+ agent.fortune()+"\n";
        
        for(Contenu con: tabContenu){
            chaine += con.toString()+" \n";
        }
        return chaine;
    }
    public void  lance(int nbEtapes) throws DeplacementIncorrectException,CoordonneesIncorrectesException,CaseNonPleineException{
        for (int i =1; i <= nbEtapes; i ++){
            double ran = Math.random()*1;
            int xnew = agent.getX() + (int)(Math.random()*3-1);
            int ynew = agent.getY() + (int)(Math.random()*3-1);
            int f = (int)(Math.random()*(100-10+1)+10);
            if(ran <=0.3){
                agent.seDeplacer(xnew, ynew,f);
            }else{
                agent.seDeplacer(xnew, ynew);
            }
            System.out.print("étape "+i);
            System.out.print("\n");
            System.out.println(agent.toString());
            this.agenda += "Étape "+i+ "\n";
            agenda += agent.getEvent();
            agenda += agent.toString();

            grille.affiche(2);
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }


    }
    public Agent9 getAgent(){
        return agent;
    }
    public Grille  getGrille(){
        return grille;
    }
    public Contenu[] getTabContenu(){
        return tabContenu;
        
    }
    public String getAgenda(){
        return agenda;
    }

}
//Anh Tu NGUYEN 21108438