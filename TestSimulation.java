import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.DataOutputStream;
public class TestSimulation{
    public static void main(String[] args) throws IOException{
        File file = new File("Anh_Tu_NGUYEN_21108438.txt");

        FileWriter filewrite = new FileWriter(file);

        BufferedWriter write = new BufferedWriter(filewrite);
        try{
           
            write.write("Nom: NGUYEN , Prénom: Anh Tu, Groupe: 9, Numéro: 21108438");
            write.newLine();
           

            try{
                Simulation simu = new Simulation(100);
                Grille grille = simu.getGrille();
                Agent9 agent = simu.getAgent();
                //grille.affiche(2);//2 est le size de carre
                try{
                    simu.lance(100);


                }catch(CoordonneesIncorrectesException e){
                    System.out.println(e.getMessage());
                }catch(DeplacementIncorrectException e){
                    System.out.println(e.getMessage());
                }catch(CaseNonPleineException e){
                    System.out.println(e.getMessage());
                }finally{
                    System.out.println(simu.toString());
                    write.write(simu.getAgenda());
                    write.write(simu.toString());



                }
            }catch(CoordonneesIncorrectesException e){
                    System.out.println(e.getMessage());
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(write != null){
                write.close();
            }
        }
    }
}
//Anh Tu NGUYEN 21108438