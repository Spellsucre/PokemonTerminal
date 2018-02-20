public class Dresseur implements Adversaire{
	protected String nom;
	protected Pokemon [] pokemons;
	protected Items[] sac;
	public int tailleSac;
	protected int argent;
	protected int nbPokemons;
	protected static int nbDresseurs = 0;
	protected boolean vaincu;
	protected int nbValides;
	protected int x;
	protected int y;
	protected int niveau;
	protected Pokemon combattant;
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	
	public Dresseur (String nom, int x, int y, int niveau, boolean vaincu, Pokemon[] listepoke,int argent) {
		this.nom = nom;
		pokemons = new Pokemon[6];
		Pokeball pokeballs = new Pokeball(6);
		Potion potions = new Potion(0);
		BonbonRage bonbonRage = new BonbonRage(0);
		Items[] listeItems = {pokeballs, potions, bonbonRage};
		remplirSac(listeItems);
		tailleSac=sac.length;
		nbPokemons = 0;
		capturePokemons(listepoke);
		this.x = x;
		this.y = y;
		this.argent=argent;
		nbDresseurs++;
		this.vaincu = vaincu;
		nbValides = nbPokemons;
		combattant=pokemons[0];
		this.niveau=niveau;
	}
	
	public Dresseur (String nom, int x, int y, Pokemon[] listepoke, int niveau){
		this(nom,x,y,niveau,false,listepoke,500*niveau+(int)(500*Math.random()*niveau));
	}
	
	public Dresseur (String nom, Pokemon[] listepoke) {
		this(nom,0,0,listepoke,1);
	}

	public Dresseur (String nom, int x, int y) {
		this.nom = nom;
		pokemons = new Pokemon[10];
		Pokeball pokeballs = new Pokeball(6);
		Potion potions = new Potion(0);
		BonbonRage bonbonRage = new BonbonRage(0);
		Items[] listeItems = {pokeballs, potions, bonbonRage};
		remplirSac(listeItems);
		tailleSac=sac.length;
		nbPokemons = 0;
		capturePokemons(3);
		this.x = x;
		this.y = y;
		nbDresseurs++;
		vaincu = false;
		nbValides = nbPokemons;
		combattant=pokemons[0];
		niveau=2;
		argent=500*niveau+500*(int)(Math.random()*niveau);
		gagnerNiveauAdversaire(calculNiveau());
	}

	public Dresseur (String nom) {
		this(nom, 0, 0);
	}

	public Dresseur (int x, int y) {
		this("Dresseur"+(nbDresseurs+1), x, y);
	}

	public Dresseur () {
		this("Dresseur"+(nbDresseurs+1));
	}

	public void capturePokemons (Pokemon [] nouveauxPokemons) {
		for (int pokemonNum=0; pokemonNum<nouveauxPokemons.length; pokemonNum++) {
			if (nbPokemons == 6|| sac[0].getQte() == 0) {
				break;
			}
			pokemons[nbPokemons] = nouveauxPokemons[pokemonNum];
			nbPokemons++;
			sac[0].takeQte(1);;
		}
	}

	public void capturePokemons (int nbPokemons) {
		Pokemon [] nouveauxPokemons = new Pokemon[nbPokemons];
		for (int n=0; n<nbPokemons; n++) {
			nouveauxPokemons[n] = Pokemon.pokemonAleatoire();
		}
		capturePokemons(nouveauxPokemons);
	}
	
	public void relachePokemon(Pokemon pokemonRelache){
		boolean trouve = false;
		int i = 0;
		while(i<nbPokemons && !trouve){
			if(pokemonRelache==pokemons[i]){
				trouve=true;
				pokemons[i]=null;
				break;
				}
			i++;
		}
		if(trouve){
			for(int j = i;j<nbPokemons-1;j++)
				pokemons[j]=pokemons[j+1];
			System.out.println ("Pokemon relaché !");
			nbPokemons--;
			nbValides--;
			combattant=pokemons[0];
		}
		else
			System.out.println ("Pas de pokemon correspondant à relacher !");
	}
	
	public void infirmerie () {
		for (int pokemonNum=0; pokemonNum<nbPokemons; pokemonNum++) {
			pokemons[pokemonNum].soigner();
		}
		nbValides = nbPokemons;
		if(this instanceof Joueur)
			System.out.println("Pokemons en pleine forme ! ");
	}
	
	public void affichePokemons() {
		String s = "\n";	
		for (int i=0; i<nbPokemons;i++){
			if(pokemons[i].estKO())
				s += (RED + "KO" + RESET);
			s += i+1 + ": "+ pokemons[i].getAfficherNom() +  " lvl " + pokemons[i].getNiveau() + " ("+pokemons[i].getPv()+"/" +pokemons[i].getPvMax()+ "pvs)"+ " \n";
		}
		System.out.println (s);
	}
	
	public String toString() {
		return getAfficherNom() + " niveau " + niveau + " ("+nbPokemons+"/6 pokémons)";
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getAfficherNom() {
		return (CouleurTerminal.RED+nom+CouleurTerminal.RESET);
	}
	
	public boolean estVaincu(){
		return vaincu;
	}
	
	public void ListePokemon(){
		for (int pokemonNum=0; pokemonNum<this.pokemons.length; pokemonNum++) {
			System.out.println(pokemons[pokemonNum]);
		}
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}	
	
	public int getNbPokemons(){
		return nbPokemons;
	}
	
	public int getNiveau() {
		return niveau;
	}
	
	public int calculNiveau(){
		int maxLevel=1;
		for(int i=0;i<nbPokemons;i++){
			if(pokemons[i].getNiveau()>maxLevel)
				maxLevel=pokemons[i].getNiveau();
		}
		return maxLevel;
	}
	
	public void gagnerNiveauAdversaire(int Level){
		for(int i=0;i<nbPokemons;i++){
			pokemons[i].gagnerNiveauAdversaire(Level-niveau);
		}
		argent+=(50+(int)(50*Math.random()))*niveau;
		niveau=Level;
	}
	
	public void newNiveau(int niveau){
		this.niveau=niveau;
	}

	public void attaque(Pokemon adversaire, String Attaque) {
		combattant.attaque(adversaire, Attaque);
	}

	public void subire(Adversaire adversaire, int degats) {
		combattant.subire(adversaire.getCombattant(), degats);
	}
	
	public void resetPokemons(){
		for(int i=0;i<nbPokemons;i++){
			pokemons[i].reset();
		}
	}
	
	public void acheterItem(Items item, int qte){
		if(item.getPrix()*qte<=argent){
			argent-=item.getPrix()*qte;
			for(int i = 0; i<tailleSac;i++)
				if(sac[i].getNom().equals(item.getNom()))
					sac[i].addQte(qte);
			System.out.println(qte + " " + item.getNom() +" acheté(s) !");
		}
		else
			System.out.println("Pas assez d'argent !");
	}
	
	public boolean utiliseItem(String item, Pokemon pokemon){
		for(int i = 0; i<tailleSac;i++)
				if(sac[i].getNom().equals(item))
					if(sac[i].getQte()>0)
						return sac[i].utilise(pokemon, this);
		System.out.println("Vous n'avez pas de " + item+ " disponible ! ");
		return false;
	}
	
	public void remplirSac(Items[] listeItems){
		sac=listeItems;
	}
	
	public Items[] getSac(){
		return sac;
	}
	
	public void afficheSac(){
		System.out.println("Sac :\t\t\t Argent " + nom + " : " + argent +" poké$");
		for(int i = 0;i<tailleSac;i++)
			System.out.println(i+1+" : " + sac[i].getNom() +"(s) : " + sac[i].getQte());
	}
	
	public String sacToSave(){
		String sacToSave="";
		for(int i = 0;i<tailleSac;i++)
			sacToSave+=sac[i].toSave()+"\n";
		return sacToSave;
	}
	
	public int getArgent(){
		return argent;
	}
	
	public void gagneArgent(int gain){
		argent+=gain;
	}
	
	public void perdArgent(int perte){
		argent-=perte;
	}
	
	public Pokemon getCombattant() {
		return combattant;
	}
	
	public void newCombattant(Pokemon suivant) {
		combattant=suivant;
	}
	
	public Pokemon[] getPokemons(){
		return pokemons;
	}
	
	public void vaincu(){
		vaincu=true;
	}
	
	public String toSave() {
		String pokemonsave = "";
		for(int i = 0;i<nbPokemons;i++)
			pokemonsave+=pokemons[i].toSave()+"\n";
		return nom+" "+x+" "+y+" "+niveau+" "+argent+" "+vaincu+" "+nbPokemons+"\n"+pokemonsave;
	}

}
