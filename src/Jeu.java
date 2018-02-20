import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.lang.reflect.Constructor;

public class Jeu{

	public static void main(String[] args) {
		
		char choixPartie = Choix.lireChoixPartie();
		
		if(choixPartie=='1'){
			Partie Jeu = new Partie();
			Jeu.getMonde().jouer();
		}
		
		else if(choixPartie=='2'){
			Pikachu Pika = new Pikachu("Pikachu",230,90,115);
			Pika.nomPerso=true;
			Carapuce Cara = new Carapuce("Carapuce",250,80,100);
			Cara.nomPerso=true;
			Salameche Salam = new Salameche("Salameche",200,100,110);
			Salam.nomPerso=true;
			Bulbizarre Bulbi = new Bulbizarre("Bulbizarre",280,80,100);
			Bulbi.nomPerso=true;
			Rhinocorne Rhino = new Rhinocorne("Rhinocorne",280,80,100);
			Rhino.nomPerso=true;
			Magicarpe Magi = new Magicarpe("Magicarpe",130,60,90);
			Magi.nomPerso=true;
			Pokemon[] listePoke = {Pika,Cara,Bulbi,Salam,Rhino,Magi};
			
			Joueur X = new Joueur("X",listePoke);
			X.gagneArgent(100000);
			Monde M = new Monde(20,20,3,X);
			M.jouer();
		}
		
		if(choixPartie=='3'){
			int tailleX=0;
			int tailleY=0;
			int[][] cases=null;
			int nbDresseurs=0;
			int nbDresseursActifs=0;
			Dresseur[] dresseurs=null;
			Joueur J=null;
			Infirmerie centrePokemon =null;
			try{
				BufferedReader in = new BufferedReader(new FileReader("../data/save.txt"));
				String line= in.readLine();
				if(line==null){
					System.out.println("Pas de sauvegarde trouvée.");
					in.close();
					return;
				}	
				if(!line.equals("Save")){
					System.out.println("Pas de sauvegarde trouvée.");
					in.close();
					return;
				}
				tailleX=Integer.parseInt(in.readLine(),10);
				tailleY=Integer.parseInt(in.readLine(),10);
				cases = new int[tailleX][tailleY];
				for(int i=0;i<tailleX;i++){
					line=in.readLine();
					String[] ligne=line.split(" ");
					for(int j=0;j<tailleY;j++){
						cases[i][j]=Integer.parseInt(ligne[j],10);
						if(cases[i][j]==7)
							centrePokemon = new Infirmerie(i,j);
					}
				}
				System.out.println("Map chargée...");
				nbDresseurs=Integer.parseInt(in.readLine(),10);
				nbDresseursActifs=Integer.parseInt(in.readLine(),10);
				dresseurs=new Dresseur[nbDresseurs];
				int nbD = 0;
				String nomD="";
				int XD=0;
				int YD=0;
				int niveauD=0;
				int argentD=0;
				boolean vaincu=false;
				int nbPokemonsD=0;
				Pokemon[] pokemonsD;
				while(nbD<nbDresseurs){
					line=in.readLine();
					String[] ligne=line.split(" ");
					nomD=ligne[0];
					XD=Integer.parseInt(ligne[1]);
					YD=Integer.parseInt(ligne[2]);
					niveauD=Integer.parseInt(ligne[3]);
					argentD=Integer.parseInt(ligne[4]);
					vaincu=Boolean.parseBoolean(ligne[5]);
					nbPokemonsD=Integer.parseInt(ligne[6]);
					pokemonsD=new Pokemon[nbPokemonsD];
					pokemonsD[0]=null;
					for(int nbP=0;nbP<nbPokemonsD;nbP++){
						line=in.readLine();
						ligne=line.split(" ");
						Pokemon pokemon = null;
						try {
							pokemon = (Pokemon)(Class.forName(ligne[1]).newInstance());
						}
						catch (ClassNotFoundException e) {e.printStackTrace();}
						catch (InstantiationException e) {e.printStackTrace();}
						catch (IllegalAccessException e) {e.printStackTrace();}
						pokemon.changerNom(ligne[3]);
						pokemon.setPvMax(Integer.parseInt(ligne[5]));
						pokemon.setPv(Integer.parseInt(ligne[6]));
						pokemon.setAttaque(Integer.parseInt(ligne[7]));
						pokemon.setSpeed(Integer.parseInt(ligne[8]));
						pokemon.setNiveau(Integer.parseInt(ligne[4]));
						pokemon.changerId(ligne[2]);
						pokemon.paralyse(Integer.parseInt(ligne[9]));
						if(Boolean.parseBoolean(ligne[10]))
							pokemon.brule();
						if(Boolean.parseBoolean(ligne[11]))
							pokemon.empoisonne();
						pokemonsD[nbP]=pokemon;
					}
					dresseurs[nbD]=new Dresseur(nomD,XD,YD,niveauD,vaincu,pokemonsD,argentD);
					nbD++;
					System.out.println("Dresseur n°" + nbD +" chargé...");
				}
				System.out.println("Dresseurs chargés...");
				line=in.readLine();
				String[] ligne=line.split(" ");
				nomD=ligne[0];
				XD=Integer.parseInt(ligne[1]);
				YD=Integer.parseInt(ligne[2]);
				niveauD=Integer.parseInt(ligne[3]);
				argentD=Integer.parseInt(ligne[4]);
				int nbVictoires=Integer.parseInt(ligne[5]);
				int nbDefaites=Integer.parseInt(ligne[6]);
				nbPokemonsD=Integer.parseInt(ligne[7]);
				pokemonsD=new Pokemon[nbPokemonsD];
				pokemonsD[0]=null;
				for(int nbP=0;nbP<nbPokemonsD;nbP++){
					line=in.readLine();
					ligne=line.split(" ");
					Pokemon pokemon = null;
					try {
						pokemon = (Pokemon)(Class.forName(ligne[1]).newInstance());
					}
					catch (ClassNotFoundException e) {e.printStackTrace();}
					catch (InstantiationException e) {e.printStackTrace();}
					catch (IllegalAccessException e) {e.printStackTrace();}
					pokemon.changerNom(ligne[3]);
					pokemon.setPvMax(Integer.parseInt(ligne[5]));
					pokemon.setPv(Integer.parseInt(ligne[6]));
					pokemon.setAttaque(Integer.parseInt(ligne[7]));
					pokemon.setSpeed(Integer.parseInt(ligne[8]));
					pokemon.setNiveau(Integer.parseInt(ligne[4]));
					pokemon.changerId(ligne[2]);
					pokemon.paralyse(Integer.parseInt(ligne[9]));
					if(Boolean.parseBoolean(ligne[10]))
						pokemon.brule();
					if(Boolean.parseBoolean(ligne[11]))
						pokemon.empoisonne();
					pokemonsD[nbP]=pokemon;
				}
				int tailleSac=Integer.parseInt(in.readLine());
				Items[] sac=new Items[tailleSac];
				for(int nbI=0;nbI<tailleSac;nbI++){
					line=in.readLine();
					ligne=line.split(" ");
					Items objet = null;
					try {
						objet = (Items)(Class.forName(ligne[1]).newInstance());
					}
					catch (ClassNotFoundException e) {e.printStackTrace();}
					catch (InstantiationException e) {e.printStackTrace();}
					catch (IllegalAccessException e) {e.printStackTrace();}
					objet.addQte(Integer.parseInt(ligne[2]));
					sac[nbI]=objet;
				}
				J = new Joueur(nomD,XD,YD,pokemonsD,niveauD,argentD,sac);
				System.out.println("Joueur chargé..." + J);
			} catch(IOException e){
				System.out.println("Pas de fichier trouvé.");
			} catch(NumberFormatException e){
				System.out.println("Format de monde corrompu.");
			}
			System.out.println("Sauvegarde chargée.");
			Waitfor.waitContinue();
			Monde M=new Monde(tailleX,tailleY,cases, nbDresseurs, nbDresseursActifs, dresseurs,J,centrePokemon);
			M.jouer();
		}
	}
}
