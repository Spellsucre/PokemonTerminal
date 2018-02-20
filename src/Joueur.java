import java.lang.NumberFormatException;

public class Joueur extends Dresseur{
	private int nbVictoires=0;
	private int nbDefaites=0;
	
	public Joueur(String nom, int x, int y, Pokemon[] listePoke,int niveau,int argent,Items[] sac) {
		super(nom, x, y,niveau,false,listePoke,argent);
		this.sac=sac;
	}
	
	public Joueur(String nom, int x, int y, Pokemon[] listePoke,int niveau) {
		super(nom, x, y, listePoke,niveau);
	}
	
	public Joueur(String nom, Pokemon[] listePoke){
		super(nom,(int)(Math.random()*20),(int)(Math.random()*20),listePoke, 3);
	}
	
	public Joueur(String nom, int x, int y) {
		super(nom, x, y);
	}
	
	public Joueur(int x, int y) {
		super("Joueur", x, y);
	}
	
	public Joueur(String nom){
		super(nom, 0, 0);
	}
	
	public Joueur(){
		super("Joueur", 0, 0);
	}
	
	public boolean combat (Adversaire adversaire, Monde M) {
		clearScreen();
		System.out.println ("Un combat commence ! ");
		String annonce=""; 
		Pokemon[] capture = new Pokemon[1];
		String nomCapture = "";
		annonce+=this+ " affronte " + adversaire;
		if(adversaire instanceof Pokemon)
			annonce+= " sauvage !";
		System.out.println (annonce);
		boolean termine = false;
		int pokemonNumAdv = 0;
		Adversaire vainqueur = null;
		boolean fuite = false;
		while (!termine) {
			System.out.println ("\n<"+combattant+ " contre " + adversaire.getCombattant() +">");
			System.out.println("\nQue Faire?\n");
			char choixCombat = Choix.lireChoixCombatClavier();
			if(choixCombat=='1'){
				clearScreen();
				System.out.println ("\n<"+getCombattant()+ " contre " + adversaire.getCombattant() +">");
				String attaqueJoueur = Choix.lireAttaqueClavier(combattant);
				if(!(attaqueJoueur.toLowerCase().equals("annuler")||attaqueJoueur.equals("0"))){
					if((int)attaqueJoueur.charAt(0)-49>=0&&(int)attaqueJoueur.charAt(0)-49<combattant.getNbAttaques())
						attaqueJoueur=combattant.getAttaquesDisponibles()[Integer.parseInt(attaqueJoueur)-1];
					Pokemon.combat(combattant, adversaire.getCombattant(), attaqueJoueur, adversaire.getCombattant().attaqueAleatoire());
					if (combattant.estKO()) {
						nbValides--;
						boolean survivant = false;
						int i = 0;
						while(i<nbPokemons && !survivant){
							if(!pokemons[i].estKO())
								survivant=true;
							i++;
						}
						if(survivant)
							newCombattant(pokemons[Choix.choixPokemonKOClavier(this)]);
					}
					if (adversaire.getCombattant().estKO()) {
						if(adversaire instanceof Pokemon){
							adversaire=null;
							resetPokemons();
							return true;
						}
						pokemonNumAdv++;
						if (pokemonNumAdv != adversaire.getNbPokemons())
							adversaire.newCombattant(adversaire.getPokemons()[pokemonNumAdv]);
					}
					if (nbValides==0) {
						termine = true;
					 	if (pokemonNumAdv != adversaire.getNbPokemons()) {
					 		vainqueur = adversaire;
					 		adversaire.infirmerie();
					 	}
					}
					else if (pokemonNumAdv==adversaire.getNbPokemons()) {
						termine = true;
						vainqueur = this;
					}
				}
			}
			else if(choixCombat=='2'){
				int choixPkmn = Choix.choixPokemonCombatClavier(this);
				clearScreen();
				if(choixPkmn<nbPokemons && choixPkmn>=0){
					System.out.println ("\n<"+getCombattant()+ " contre " + adversaire.getCombattant() +">");
					combattant=pokemons[choixPkmn];
					System.out.println( "\n\t\t\t\tGo " +combattant.getAfficherNom() + " ! ");
					adversaire.getCombattant().attaque(combattant,adversaire.getCombattant().attaqueAleatoire());
					if(combattant.estKO()){
						nbValides--;
						boolean survivant = false;
						int i = 0;
						while(i<nbPokemons && !survivant){
							if(!pokemons[i].estKO())
								survivant=true;
							i++;
						}
						if(survivant)
							newCombattant(pokemons[Choix.choixPokemonKOClavier(this)]);
					}
				}
			}
			else if(choixCombat=='3'){
				clearScreen();
				int choixSac = Choix.choixItem(this);
				if(choixSac==0){
					if(adversaire instanceof Dresseur)
						System.out.println( "Ce Pokémon appartient déjà à quelqu'un!");
					else
						if(utiliseItem("Pokéball",adversaire.getCombattant())){
							resetPokemons();
							return false;
					}
				}
				else if(choixSac==1)
					sac[1].utilise(null,this);
			}
			else if(choixCombat=='4'){
				if(adversaire instanceof Dresseur){
					System.out.println ("On ne s'enfuit pas d'un combat de dresseurs ! ");
					System.out.println ("Souhaitez vous abandonner ? Cela sera considéré comme une défaite.");
					if(Waitfor.choixYN()=='Y'){
						vainqueur=adversaire;
						termine=true;
					}
				}
				else{
					fuite=true;
					termine=true;
				}
			}
		}
		if(fuite){
			System.out.println ("Vous avez pris la fuite ! ");
			resetPokemons();
			return false;
		}
		if(adversaire instanceof Dresseur){
			if (vainqueur == null) {
				System.out.println ("Egalité !");
			}
			else if(vainqueur!=this){
				System.out.println ("Victoire de " + vainqueur.getAfficherNom() + " !");
				perdArgent(adversaire.getArgent()/12*nbPokemons);
				adversaire.gagneArgent(adversaire.getArgent()/12*nbPokemons);;
				System.out.println (getAfficherNom()+ " donne " + adversaire.getArgent()/12*nbPokemons +" poké $ à "+  adversaire.getAfficherNom()+" !");
				nbDefaites++;
				if(nbValides==0){
					System.out.println (getAfficherNom()+" n'a plus de pokemons en forme ! " +getAfficherNom() +" est hors-jeu !");
					System.out.println ("Continuer?");
					if(Waitfor.choixYN()=='Y'){
						System.out.println (getAfficherNom()+" se hate vers le centre Pokemon le plus proche pour les faire soigner. ");
						x=M.centrePokemon.x+1;
						y=M.centrePokemon.y+1;
						infirmerie();
						return false;
					}
					else
						M.termine();
				}
			}	
			else if(vainqueur==this){
				nbVictoires++;
				adversaire.vaincu();
				resetPokemons();
				adversaire.perdArgent(adversaire.getArgent()/2);
				gagneArgent(adversaire.getArgent()/2);
				System.out.println (adversaire.getAfficherNom() + " donne " + adversaire.getArgent()/2 + " poké $ à "+  getAfficherNom() +" !");
				return true;
			}
		}
		else if(!fuite && nbValides==0 && adversaire instanceof Pokemon){
			nbDefaites++;
			System.out.println (getAfficherNom()+" n'a plus de pokemons en forme ! " +getAfficherNom() +" est hors-jeu !");
			System.out.println ("Continuer?");
			if(Waitfor.choixYN()=='Y'){
				System.out.println (getAfficherNom()+" se hate vers le centre Pokemon le plus proche pour les faire soigner. ");
				x=M.centrePokemon.x+1;
				y=M.centrePokemon.y+1;
				infirmerie();;
				return false;
			}
			else
				M.termine();
		}
		resetPokemons();
		return false;
	}
	
	public String getAfficherNom() {
		return (CouleurTerminal.LIGHTBLUE+nom+CouleurTerminal.RESET);
	}
	
	public void deplace(int i, int j){
		x+=i;
		y+=j;
	}
	
	public void setPosition(int i, int j){
		x=i;
		y=j;
	}
	
	public boolean aPokemonEau(){
		boolean aPkmnEau = false;
		for(int i=0;i<nbPokemons;i++){
			if(pokemons[i].getType().equals("Eau") || aPkmnEau){
				aPkmnEau=true;
				break;
			}
		}
		return aPkmnEau;
	}
	
	public int getNbVictoires(){
		return nbVictoires;
	}
	
	public void afficherDresseur(){
		System.out.println("Dresseur " + getAfficherNom());
		System.out.println("Niveau : " + niveau);
		System.out.println("Nombre Pokemons : " + nbPokemons);
		System.out.println("Nombre de victoires : " + nbVictoires);
		System.out.println("Nombre de défaites : " + nbDefaites);
		Waitfor.waitQuit();
	}
	
	public void menuRelachePokemon(){
		if(nbPokemons>1){
				int choixPokemonRelache=Choix.choixPokemonClavier(this);
						if(choixPokemonRelache<nbPokemons){
								System.out.println("Etes vous sûr de vouloir relacher " +pokemons[choixPokemonRelache]+ " ? Il vous sera impossible de le récupérer après.");
								if(Waitfor.choixYN()=='Y'){
								relachePokemon(pokemons[choixPokemonRelache]);
								Waitfor.waitQuit();
								}
							}
						}
						else
							System.out.println("Vous ne pouvez pas relacher votre dernier Pokémon!");
								
	}
	
	public void echangePokemon(){
		int choixPokemonEchange=Choix.choixPokemonClavier(this);
			if(choixPokemonEchange>=0){
				if(!(pokemons[choixPokemonEchange].estKO())){
					combattant=(pokemons[choixPokemonEchange]);
					System.out.println(pokemons[choixPokemonEchange] + " est pret au combat !");
				}
				else
					System.out.println(pokemons[choixPokemonEchange] + " n'est pas en état de se battre !");
			}
	}
	
	public String toSave() {
		String pokemonsave = "";
		for(int i = 0;i<nbPokemons;i++)
			pokemonsave+=pokemons[i].toSave()+"\n";
		return nom+" "+x+" "+y+" "+niveau+" "+argent+" "+nbVictoires+" "+nbDefaites+" "+nbPokemons+"\n"+pokemonsave+tailleSac+"\n"+sacToSave();
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J\n");  
	    System.out.flush();  
	}
	
}
