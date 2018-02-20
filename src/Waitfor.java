import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Waitfor{

	public static void waitContinue(){
		int choix = 1;
		do{
			System.out.println("\nContinuer : Espace + Entrée");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)(' ')));
	}
	
	public static void waitQuit(){
		int choix = 1;
		do{
			System.out.println("\nRevenir au jeu : Espace + Entrée");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)(' ')));
	}
	
	public static char choixYN(){
		int choix = 0;
		do{
			System.out.println("[Vous]: Y/N?");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)Character.toUpperCase(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)('Y')||choix==(int)('N') ));
		return (char)choix;
	}
	
	public static char choixCombattreYN(){
		int choix = 0;
		do{
			System.out.println("Combattre ce dresseur?");
			System.out.println("[Vous]: Y/N?");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)Character.toUpperCase(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)('Y')||choix==(int)('N') ));
		return (char)choix;
	}

}
