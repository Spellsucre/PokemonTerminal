public class Pokeball extends Items{
		double chanceCapture;
		
		public Pokeball(int qte){
			super("Pokéball",500,qte);
			chanceCapture=1;
		}	
		
		public Pokeball(){
			this(0);
			chanceCapture=1;
		}			
		
		public boolean effetItem(Pokemon pokemonAdv, Dresseur J){
			if(pokemonAdv!=null){
				String nomCapture = "null";
				System.out.println("Nombre de Pokémons dans l'équipe = " + J.getNbPokemons() + "/6");
				if(J.getNbPokemons() <6){
					System.out.println("Lancer Pokéball?");
					if(Waitfor.choixYN()=='Y'){
						qte--;
						System.out.println( "...");
						System.out.println( "...");
						if(Math.random()+0.15>pokemonAdv.getPv()/pokemonAdv.getPvMax()){
							System.out.println( "...");
							qte++;
							Pokemon[] capture = {pokemonAdv};
							J.capturePokemons(capture);
							System.out.println( "Félicitations ! Pokémon capturé ! " + pokemonAdv.getAfficherNom() +" rejoint l'équipe !" );	
							System.out.println( "Le renommer?");
							if(Waitfor.choixYN()=='Y'){
								nomCapture= Choix.choixName();
								if(!nom.toLowerCase().equals("null")){
									pokemonAdv.changerNom(nomCapture);
									pokemonAdv.nomPerso=true;
								}
							}
							return true;
						}	
						else{		
							System.out.println( "Le Pokémon s'est échappé ! ");
							pokemonAdv.attaque(J.getCombattant(),pokemonAdv.attaqueAleatoire());
						}	
					}	
				}		
			else	
				System.out.println( "Vous n'avez plus de place pour un autre Pokémon ! ");
		}
		else
			System.out.println( "Il n'y a pas de Pokemon à capturer ! ");
	return false;
	}
}
