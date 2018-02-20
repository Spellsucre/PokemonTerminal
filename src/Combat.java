
/*
import Pokemons.Pokemon;
import Pokemons.Bulbizarre;
import Pokemons.Racaillou;
import Pokemons.Pikachu;
import Pokemons.Salameche;
import Pokemons.Carapuce;
import Dresseurs.Dresseur;
import Dresseurs.Joueur; */

public class Combat {

	public static void main(String[] args) {

		Bulbizarre Patrick = new Bulbizarre("Patrick",200,40,90);
		Patrick.nomPerso=true;

		Carapuce Bleu = new Carapuce("Carapuce",150,50,100);
		Bleu.nomPerso=true;
		
		Racaillou Pierre = new Racaillou("Racaillou",130,45,80);
		Pierre.nomPerso=true;
		
		Pokemon[] listeMoi = {Patrick,Bleu,Pierre};
		
		Joueur moi = new Joueur("Moi",listeMoi);
		
		Salameche Rouge = new Salameche("Salameche",120,60,105);
		Rouge.nomPerso=true;
		
		Pikachu Jaune = new Pikachu("Pikachu",130,50,110);
		Jaune.nomPerso=true;
		
		Pokemon[] listeBasile = {Rouge,Jaune};
		
		Dresseur Basile = new Dresseur("Basile",listeBasile);
		
		Basile.capturePokemons(1);
		
		moi.gagnerNiveauAdversaire(4);
		
		Basile.gagnerNiveauAdversaire(4);
				
		moi.combat(Basile,null);
		
	}

}
