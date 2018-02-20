public class Potion extends Items{
		int soinPv;
		
		public Potion(int qte){
			super("Potion",1000, qte);
			soinPv=100;
		}
		
		public Potion(){
			this(0);
			soinPv=100;
		}
		
		public boolean effetItem(Pokemon pokemon, Dresseur J){
			if(qte>0){
				System.out.println("\nSur qui utiliser?");
				int choixPokemon = Choix.choixPokemonClavier(J);
				if(choixPokemon<J.getNbPokemons()){
					if(!J.getPokemons()[choixPokemon].estKO()){
						System.out.println("\t\t\t\t" + J.getPokemons()[choixPokemon]+" a récupéré " + J.getPokemons()[choixPokemon].soin(soinPv) + " pvs ! ");
						qte--;
						return true;
					}
					else
						System.out.println("Aucun effet sur " + J.getPokemons()[choixPokemon].getNom() + " ! ");
				}
				return false;
			}
			System.out.println("Vous n'en avez pas assez !"); 
			return false;
		}	
		
}
