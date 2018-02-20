import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Partie{
	Monde M;

	public Partie(){
		M = new Monde(20,20,20,intro());
	}

	public Joueur intro(){
		clearScreen();
		String name = "Joueur";
		Pokemon[] PokemonDepart = new Pokemon[1];
		System.out.println("[???] Bonjour, Dresseur !");
		System.out.println("[???] Tout d'abord, laisse moi me présenter. Je suis le maitre du PokéDéfi.");
		Waitfor.waitContinue();
		clearScreen();
		System.out.println("[Maitre du Pokédéfi] Aujourd'hui, tu vas devoir affronter dans mon collisée 20 dresseurs différents, les uns après les autres.");
		Waitfor.waitContinue();
		clearScreen();
		System.out.println("[Maitre du Pokédéfi] Mais je manque à tous mes devoirs... je ne me souviens plus de ton nom...");
		name = choixName();
		System.out.println("[Maitre du Pokédéfi] " + name + " , c'est bien ça? C'est pourtant très commun, étonnant que je n'arrive jamais à m'en rappeller...");
		System.out.println("..."); 
		System.out.println("..."); 
		System.out.println("..."); 
		Waitfor.waitContinue();
		clearScreen();
		System.out.println("[Maitre du Pokédéfi] Enfin, bref.");
		System.out.println("[Maitre du Pokédéfi] Passons plutôt aux choses sérieuses, veux-tu?");
		char choixYN1 = Waitfor.choixYN();
		clearScreen();
		if(choixYN1 == 'N' )
			System.out.println("[Maitre du Pokédéfi] Dans tous les cas, je suis le maitre, tu n'as pas ton mot à dire. Voilà.");
		else
			System.out.println("[Maitre du Pokédéfi] Très bien, je vois que tu as hâte de commencer ! ");
		System.out.println("[Maitre du Pokédéfi] Je vais, dans ma grande clémence, te donner un pokémon.");
		System.out.print("[Maitre du Pokédéfi] Quel type préfères tu? Eau, Feu, Herbe, ou bien Electricité? ");
		int choix=(int)choixPokemonDepart();
		if(choix=='1')
			PokemonDepart[0] = new  Carapuce("Carapuce",240,80,100);
		else if(choix=='2')
			PokemonDepart[0] = new  Salameche("Salameche",200,100,110);
		else if(choix=='3')
			PokemonDepart[0] = new Bulbizarre("Bulbizarre",260,80,100);
		else if(choix=='4')
			PokemonDepart[0] = new Pikachu("Pikachu",220,90,115);
		clearScreen();
		System.out.println("[Maitre du Pokédéfi] Je n'aurai pas choisi celui là, mais soit... voici donc ton "+PokemonDepart[0].getAfficherNom());
		System.out.println(name +" reçoit un " +PokemonDepart[0].getAfficherNom() +"!");
		System.out.println("[Maitre du Pokédéfi] Souhaites tu affubler d'un surnom ce "+PokemonDepart[0].getAfficherNom() +"?");
		if(Waitfor.choixYN()=='Y'){
			PokemonDepart[0].changerNom(choixName());
			PokemonDepart[0].nomPerso=true;
		}
		clearScreen();
		System.out.println("[Maitre du Pokédéfi] Très bien, je crois que tout est prêt !");
		System.out.println("[Maitre du Pokédéfi] Rentre dans mon collisée pokémon! Bats toi pour la victoire!");
		Waitfor.waitContinue();
		Joueur J = new Joueur(name, PokemonDepart);
		return J;
	}
	
	public String choixName(){
		@SuppressWarnings("resource")
		Scanner Scan= new java.util.Scanner(System.in);
		String name = "Johnny";
		do{
			System.out.println("[Maitre du Pokédéfi] Alors, qui est tu?");
			System.out.println("{Entrez le nom choisi}");
			if(Scan.hasNext())
				name=Scan.nextLine();
				System.out.println("[Maitre du Pokédéfi] Es tu sûr? ça ne me dit rien du tout. ");
		}
		while(Waitfor.choixYN()!='Y');
		return name;
	}
	
	public char choixPokemonDepart(){
		int choix = 0;
		do{
			System.out.println("Fais ton choix.");
			System.out.println("1 : " + CouleurTerminal.CYAN+ "Eau" + CouleurTerminal.RESET);
			System.out.println("2 : "+ CouleurTerminal.LIGHTRED+"Feu"+ CouleurTerminal.RESET);
			System.out.println("3 : "+ CouleurTerminal.GREEN+"Plante"+ CouleurTerminal.RESET);
			System.out.println("4 : "+ CouleurTerminal.LIGHTYELLOW+"Electricité"+ CouleurTerminal.RESET);
			System.out.println("D : "+ CouleurTerminal.PURPLE+"La réponse D"+ CouleurTerminal.RESET);
			Reader Lecteur = new InputStreamReader(System.in);
			System.out.println("{Votre choix : numéro du type}");
			try{
				choix = (int)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
			if(choix==(int)'D' || choix==(int)'d'){
				System.out.println("[Maitre du Pokédéfi] Si j'étais animateur télé, tu aurais gagné des millions. Mais c'est pas le cas, alors un peu de sérieux, je n'ai pas de temps à perdre, moi !");
				continue;
			}
			else
				System.out.println("[Maitre du Pokédéfi] Es tu sûr?");
		}
		while(Waitfor.choixYN()!='Y' || !(choix==(int)('1')||choix==(int)('2') || choix==(int)('3') || choix==(int)('4')) );
		return (char)choix;
	}
	
	public Monde getMonde(){
		return M;
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J\n");  
	    System.out.flush();  
	}
}


