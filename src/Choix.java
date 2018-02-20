import java.io.IOException;
import java.io.InputStreamReader;

import java.io.Reader;
import java.util.Scanner;

import java.lang.NumberFormatException;

public class Choix{

	public static char lireChoixPartie(){
		char choix = 0;
		do{
			clearScreen();
			System.out.println("Pokeminal: Un jeu Pokemon sur terminal");
			System.out.println("1 : Version complete (intro, 1 pokemon de départ, 20 dresseurs)");
			System.out.println("2 : Version Quickstart (Sans intro, 4 pokemons de départ, 3 dresseurs)");
			System.out.println("3 : Charger sauvegarde existante");
			System.out.println("Entrez le numéro correspondant à votre choix :");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (char)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix=='1'||choix=='2'||choix=='3'));
		return choix; // Le résultat se fait dans la méthode main
	}
	
	public static char lireChoixSauvegarde(){
		char choix = 0;
		do{
			clearScreen();
			System.out.println("1 : Sauvegarder");
			System.out.println("0 : Annuler");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (char)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
			if(choix=='1'){
				System.out.println("Etes vous sûrs? Cela écrasera toute donnée sauvegardée.");
				if(choixYN()=='N')
					choix='0';
			}
		}
		while(!(choix=='1'||choix=='0'));
		return choix;
	}

	public static char lireChoixDansMondeClavier(){
		int choix = 0;
		do{
			System.out.println("Déplacement (Z, Q, S, D) ou Menu (M): ");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)Character.toUpperCase(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)('Z')||choix==(int)('Q') || choix==(int)('S') || choix==(int)('D') || choix==(int)('M')));
		return (char)choix;
	}
	
	public static char lireChoixDansInfirmerieClavier(){
		char choix = 0;
		do{
			clearScreen();
			System.out.println("Bienvenue au Centre Pokémon ! De quoi avez vous besoin ?");
			System.out.println("1 : Soigner Pokémons");
			System.out.println("2 : Acheter Objets");
			System.out.println("0 : Retour");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (char)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix=='1'||choix=='2' ||choix=='0'));
		return choix;
	}
	
	public static int choixShop(Joueur J){
		int choix = 0;
		do{
			clearScreen();
			System.out.println("Magasin : \t\t\tArgent " + J + " : " + J.getArgent() +" poké $");
			for(int i = 0;i<J.tailleSac;i++)
				System.out.println(i+1+" : " + J.getSac()[i].getNom() +" : " + J.getSac()[i].getPrix());
			System.out.println("0 : Retour ");
			System.out.println("\nQuel objet acheter?");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)(Lecteur.read())-48;
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix>=0 || choix<=J.tailleSac));
		return choix-1;
	}

	public static char lireChoixDansMenuClavier(){
		int choix = 0;
		do{
			clearScreen();
			System.out.println("Menu:");
			System.out.println("1 : Dresseur");
			System.out.println("2 : Pokemon");
			System.out.println("3 : Sac");
			System.out.println("4 : Sauvegarde");
			System.out.println("0 : Quitter Menu");
			System.out.println("Ctrl+C : Quitter Jeu");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)('1')||choix==(int)('2') || choix==(int)('3') || choix==(int)('4') || choix==(int)('0') ));
		return (char)choix;
	}
	
	public static char lireChoixDansMenuPokemonClavier(Joueur J){
		int choix = 0;
		do{
			clearScreen();
			J.affichePokemons();
			System.out.println("\n1 : Voir détails Pokemon");
			System.out.println("2 : Placer un Pokemon en tête");
			System.out.println("3 : Relacher Pokemon");
			System.out.println("0 : Quitter Menu");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)('1')||choix==(int)('2') ||choix==(int)('3')||choix==(int)('0')));
		return (char)choix;
	}
	
	public static char lireChoixDansMenuSacClavier(Joueur J){
		int choix = 0;
		do{
			clearScreen();
			J.afficheSac();
			System.out.println("\n1 : Utiliser Objet");
			System.out.println("2 : Jeter Objet");
			System.out.println("0 : Quitter Menu");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)(Lecteur.read());
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix==(int)('1')||choix==(int)('2') ||choix==(int)('0')));
		return (char)choix;
	}
	
	public static int choixItem(Joueur J){
		int choix = 0;
		do{
			clearScreen();
			J.afficheSac();
			System.out.println("0 : Retour");
			System.out.println("\nQuel objet?");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				choix = (int)(Lecteur.read())-48;
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(choix>=0 && choix <=J.tailleSac));
		return choix-1;
	}
	
	public static int choixNbr(){
		int choix = 0;
		System.out.println("\nCombien?");
		Scanner Scan= new java.util.Scanner(System.in);
		if(Scan.hasNext())
			choix=Scan.nextInt();	
		return choix;
	}
	
	public static String lireAttaqueClavier(Pokemon attaquant){
		attaquant.afficheAttaques();
		System.out.println("0 : Annuler");
		@SuppressWarnings("resource")
		Scanner Scan= new java.util.Scanner(System.in);
		String attaqueJoueur = "";
		int attaqueJoueurInt = -1;
		boolean attaqueEstInt = false;
		do{
			if(Scan.hasNext()){
				attaqueJoueur=Scan.nextLine();
				if(!(attaquant.estAttaqueValide(attaqueJoueur)||attaqueJoueur.toLowerCase().equals("annuler")||(int)attaqueJoueur.charAt(0)-48<0||(int)attaqueJoueur.charAt(0)-48>attaquant.getNbAttaques())){
					try{
						attaqueJoueurInt=Integer.parseInt(attaqueJoueur);
					}
					catch(NumberFormatException e){
						attaqueJoueurInt=-1;
						System.out.println("Cette attaque n'existe pas.");
					}
					attaqueEstInt = true;
				}
			}
		}
		while(!(attaquant.estAttaqueValide(attaqueJoueur)||attaqueJoueur.toLowerCase().equals("annuler")||(attaqueJoueurInt>=0 && attaqueJoueurInt-1<attaquant.getNbAttaques())));
		if(!attaqueEstInt)
			return attaqueJoueur;
		return Integer.toString(attaqueJoueurInt);
	}

	
	public static char lireChoixCombatClavier(){
		System.out.println("1 : Attaquer");
		System.out.println("2 : Pokemon");
		System.out.println("3 : Sac");
		System.out.println("4 : Fuir");
		int Choix = 0;
		do{
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				Choix = (int)Lecteur.read();
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(Choix==(int)('1')|| Choix==(int)('2') || Choix==(int)('3')|| Choix==(int)('4')));
		return (char)Choix;
	}
	
	public static int choixPokemonClavier(Dresseur J){
		J.affichePokemons();
		int pokemonChoisi = 0;
		System.out.println("0: Retour.");
		do{
			System.out.println("\nChoisissez un pokémon pour l'action");
			System.out.println("{Votre choix : numéro du pokémon}");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				pokemonChoisi = (int)Lecteur.read()-49;
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
		}
		while(!(pokemonChoisi>=-1 && pokemonChoisi<J.getNbPokemons()));
		return pokemonChoisi;
	}

	public static int choixPokemonCombatClavier(Dresseur J){
		J.affichePokemons();
		int pokemonChoisi = 0;
		System.out.println("0: Retour.");
		do{
			System.out.println("\nChoisissez un pokémon pour l'action");
			System.out.println("{Votre choix : numéro du pokémon}");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				pokemonChoisi = (int)Lecteur.read()-49;
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
			if(pokemonChoisi>=0 && pokemonChoisi<J.getNbPokemons()){
				if(J.getPokemons()[pokemonChoisi].estKO()){
					System.out.println( J.getPokemons()[pokemonChoisi].getAfficherNom() + "n'est pas en état de se battre ! ");
					pokemonChoisi=-2;
				}
				else if(J.getPokemons()[pokemonChoisi]==J.getCombattant()){
					System.out.println( J.getPokemons()[pokemonChoisi].getAfficherNom() + " est déjà sur le terrain ! ");
					pokemonChoisi=-2;
				}
			}
		}
		while(!(pokemonChoisi>=-1 && pokemonChoisi<J.getNbPokemons()));
		return pokemonChoisi;
	}
	
	public static int choixPokemonKOClavier(Dresseur J){
		J.affichePokemons();
		int pokemonChoisi = 0;
		do{
			System.out.println("\nChoisissez un pokémon pour remplacer le pokémon KO");
			System.out.println("{Votre choix : numéro du pokémon}");
			Reader Lecteur = new InputStreamReader(System.in);
			try{
				pokemonChoisi = (int)Lecteur.read()-49;
			} catch(IOException e){
				System.out.println("Erreur de lecture");
			}
			if(pokemonChoisi>=0 && pokemonChoisi<J.getNbPokemons()){
				if(J.getPokemons()[pokemonChoisi].estKO()){
					System.out.println( J.getPokemons()[pokemonChoisi].getAfficherNom() + "n'est pas en état de se battre ! ");
					pokemonChoisi=-1;
				}
				else if(J.getPokemons()[pokemonChoisi]==J.getCombattant()){
					System.out.println( J.getPokemons()[pokemonChoisi].getAfficherNom() + " est déjà sur le terrain ! ");
					pokemonChoisi=-1;
				}
			}
		}
		while(!(pokemonChoisi>=0 && pokemonChoisi<J.getNbPokemons()));
		return pokemonChoisi;
	}
	
	public static String choixName(){
		@SuppressWarnings("resource")
		Scanner Scan= new java.util.Scanner(System.in);
		String name = "";
		do{
			System.out.println("{Entrez le nom choisi, null pour annuler}");
			if(Scan.hasNext())
				name=Scan.nextLine();
			if(!name.toLowerCase().equals("null"))
				System.out.println("L'appeller "+name+"?");
		}
		while(Waitfor.choixYN()!='Y');
		return name;
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
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J\n");  
	    System.out.flush();  
	}
}
