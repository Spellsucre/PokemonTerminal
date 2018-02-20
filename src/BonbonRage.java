public class BonbonRage extends Items{
		
		public BonbonRage(int qte){
			super("Bonbon Rage",10000, qte);
		}
		
		public BonbonRage(){
			this(0);
		}
		
		public boolean effetItem(Pokemon pokemon, Dresseur J){
			if(qte>0){
				System.out.println("\nSur qui utiliser?");
				int choixPokemon = Choix.choixPokemonClavier(J);
				if(choixPokemon<J.getNbPokemons()){
					if(J.getPokemons()[choixPokemon].getId().equals("Magicarpe")){
						J.getPokemons()[choixPokemon].bonbonRage=true;
						J.getPokemons()[choixPokemon].evolution();
						qte--;
						return true;
					}
					else{
						System.out.println("Aucun effet sur ce pokémon."); 
					}	
				return false;
				}
			}
		System.out.println("Vous n'en avez pas assez !"); 
		return false;
		}
		
}
