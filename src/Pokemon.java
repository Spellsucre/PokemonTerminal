
public abstract class Pokemon implements Adversaire{

	protected static int aleaNum = 1;
	protected String nom;
	protected int pvmax;
	protected int niveau, pv, attaque, speed;
	protected String [] attaquesDisponibles;
	protected int nbAttaques;
	protected double multiplicateur;
	protected int paralyse;
	protected boolean poison;
	protected boolean brulure;
	protected String type;
	protected boolean vaincu;
	protected int argent;
	protected String id;
	protected boolean evolution = false;
	public boolean nomPerso = false;
	public boolean bonbonRage = false;
	
	/*private static final String[] listePokemonAleatoire = {"Chenipan","Aspicot","Sabelette","Goupix","Mystherbe","Taupiqueur","Psykokwak","Caninos","Ptitard","Chetiflor","Tentacool","Racaillou","Pontya","Ramoloss","Magneti","Otaria","Kokiyas","Onix","Krabby","Voltorbe","Noeuneuf","Osselait","Rhinocorne","Saquedeneu","Hypotrempe","Poissirene","Stari","Elekid","Magby","Magicarpe"};*/	protected static final int nbEspeces = 30;

	public Pokemon (String nom, int pvmax, int attaque, int speed, int nbAttaque, int niveau) {
		this.nom = nom;
		this.pvmax = pvmax;
		pv = pvmax;
		niveau = 1;
		this.speed = speed;
		this.attaque = attaque;
		this.nbAttaques = nbAttaque;
		attaquesDisponibles = new String[nbAttaques];
		attaquesDisponibles[0] = "Charge";
		multiplicateur = 1.0;
		paralyse = 0;
		poison = false;
		brulure = false;
		vaincu=false;
		type="Normal";
		this.niveau=niveau;
		argent=50*niveau+50*(int)(Math.random()*niveau);
		for(int i=0;i<niveau-1;i++){
			this.gagnerNiveau();
		}
	}

	public Pokemon (String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1,1);
	}

	public Pokemon () {
		this("Anonyme"+aleaNum, 100+(int)(Math.random()*100), 40+(int)(Math.random()*100),70+(int)(Math.random()*60));
		aleaNum++;
	}
	
	public static Pokemon pokemonAleatoire (int Niveau) {
		Pokemon pkmnalea;
		int i = (int)(Math.random()*nbEspeces);
		switch(i){
		case 0:
				pkmnalea =  new Chenipan();
				break;
		case 1:
				pkmnalea =  new Aspicot();
				break;
		case 2:
				pkmnalea =  new Sabelette();
				break;
		case 3:
				pkmnalea =  new Goupix();
				break;
		case 4:
				pkmnalea =  new Mystherbe();
				break;
		case 5:
				pkmnalea =  new Taupiqueur();
				break;
		case 6:
				pkmnalea =  new Psykokwak();
				break;
		case 7:
				pkmnalea =  new Caninos();
				break;
		case 8:
				pkmnalea =  new Ptitard();
				break;
		case 9:
				pkmnalea =  new Chetiflor();
				break;
		case 10:
				pkmnalea =  new Tentacool();
				break;
		case 11:
				pkmnalea =  new Racaillou();
				break;
		case 12:
				pkmnalea =  new Ponyta();
				break;
		case 13:
				pkmnalea =  new Ramoloss();
				break;
		case 14:
				pkmnalea =  new Magneti();
				break;
		case 15:
				pkmnalea =  new Otaria();
				break;
		case 16:
				pkmnalea =  new Kokiyas();
				break;
		case 17:
				pkmnalea =  new Onix();
				break;
		case 18:
				pkmnalea =  new Krabby();
				break;
		case 19:
				pkmnalea =  new Voltorbe();
				break;
		case 20:
				pkmnalea =  new Noeuneuf();
				break;
		case 21:
				pkmnalea =  new Osselait();
				break;
		case 22:
				pkmnalea =  new Rhinocorne();
				break;
		case 23:
				pkmnalea =  new Saquedeneu();
				break;
		case 24:
				pkmnalea =  new Hypotrempe();
				break;
		case 25:
				pkmnalea =  new Poissirene();
				break;
		case 26:
				pkmnalea =  new Stari();
				break;
		case 27:
				pkmnalea =  new Elekid();
				break;
		case 28:
				pkmnalea =  new Magby();
				break;
		default:
				pkmnalea =  new Magicarpe();
		}
		for(int j=0;j<Niveau;j++)
			pkmnalea.gagnerNiveau();
		return pkmnalea;
	}
	
	public static Pokemon pokemonAleatoire () {
		return pokemonAleatoire(1);
	}

	public int getNiveau() {
		return niveau;
	}
	
	public void setNiveau(int niveau) {
		this.niveau=niveau;
	}
	
	public int getPv() {
		return pv;
	}
	
	public void setPv(int pv) {
		this.pv=pv;
	}
	
	public int getPvMax() {
		return pvmax;
	}
	
	public void setPvMax(int pvmax) {
		this.pvmax=pvmax;
	}
	
	public void setAttaque(int attaque) {
		this.attaque=attaque;
	}
	
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	public void changerId (String nouvelId) {
		id = nouvelId ;
	}
	
	public String getId() {
		return id;
	}
	
	public String getAfficherId() {
		return id;
	}

	public boolean estKO () {
		return pv <= 0;
	}
	
	public boolean estParalyse(){
		if(paralyse>0)
			return true;
		return false;
	}
	
	public void brule(){
		brulure=true;
	}
	
	public void empoisonne(){
		poison=true;
	}
	
	public void paralyse(int nbtours){
		paralyse+=nbtours;
	}

	public void perdu () {
		pv = 0;
		System.out.println("\t\t\t\t"+this.getAfficherNom() +" est KO !");
		multiplicateur = 1;
		poison=false;
		brulure=false;
		paralyse=0;
	}

	public void soigner () {
		pv = pvmax;
		paralyse=0;
		brulure=false;
		poison=false;
		reset();
	}
	
	public int soin(int soin) {
		int recup=soin;
		if(pv+soin>pvmax){
			recup=pvmax-pv;
			pv=pvmax;
		}
		else
			pv+=soin;
		reset();
		return recup;
	}

	public boolean fortContre (Pokemon adversaire) {
		for(int i=0;i<this.getNbFort();i++){
			if((adversaire.type).equals(this.getFort()[i])){
				return true;
			}
		}
		return false;
	}

	public boolean faibleContre (Pokemon adversaire) {
		for(int i=0;i<this.getNbFaible();i++){
			if((adversaire.type).equals(this.getFaible()[i])){
				return true;
			}
		}
		return false;
	}
	
	public int getNbAttaques() {
		return nbAttaques;
	}

	public String [] getAttaquesDisponibles() {
		return attaquesDisponibles.clone();
	}

	public void afficheAttaques () {
		System.out.println("\nAttaques : ");
		String s = "\n";	
		for (int i=0; i<nbAttaques;i++){
			s +=i+1 +" : "+attaquesDisponibles[i]+" \n";
		}
		System.out.println (s);
	}
	
	public boolean estAttaqueValide(String s){
		boolean atkExiste = false;
		for(int i = 0;i<nbAttaques;i++){
			if((attaquesDisponibles[i].toLowerCase()).equals(s.toLowerCase()) || atkExiste){
				atkExiste=true;
				break;
			}
		}
		return atkExiste;
	}
	
	public abstract void talent();

	public void subire (Adversaire adversaire, int degats) {
		pv -= degats;
		if (pv < 0)
			pv = 0;
		System.out.println ("\t\t\t\t" + this.getAfficherNom() + " subit " + degats + " dégats ! Il lui reste " + pv + "/" + pvmax +" pvs ! ");
	}

	public void attaque (Pokemon adversaire) {
		double multiplicateurAvantage = 1;
		if (fortContre(adversaire)) {
			multiplicateurAvantage = 2;
			if(multiplicateur>0)
				System.out.println("\t\t\t\t" +"C'est super efficace contre le " + adversaire.getAfficherNom() + " ennemi !");
		}
		else if (faibleContre(adversaire)) {
			multiplicateurAvantage = 0.5;
			if(multiplicateur>0)
				System.out.println("\t\t\t\t" +"Ce n'est pas très efficace contre le " + adversaire.getAfficherNom()  + " ennemi.");
		}
		if(multiplicateur>0)
			System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque avec un multiplicateur de :" + multiplicateur*multiplicateurAvantage + " -> " + (int)(attaque*multiplicateur*multiplicateurAvantage) + " dégats !");
		adversaire.subire(this, (int)(attaque * multiplicateur * multiplicateurAvantage));
		multiplicateur = 1;
	}

	public void attaque (Pokemon adversaire, String choixAttaque) {
		if (choixAttaque.equals("Charge")){
			System.out.print ("\n\t\t\t\tAttaque " + choixAttaque + " ! ");
			System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque avec un multiplicateur de :" + multiplicateur + " -> " + (int)(attaque*multiplicateur) + " dégats !");
			adversaire.subire(this, (int)(attaque * multiplicateur));
			multiplicateur = 1;
		}
		this.attaque(adversaire, choixAttaque);
	}
	
	public String attaqueAleatoire() {
		int alea = (int)(Math.random()*nbAttaques);
		return attaquesDisponibles[alea];
	}

	public static void combat (Pokemon p1, Pokemon p2, String attaque1, String attaque2) {
		p1.talent();
		p2.talent();
		if(!p1.estParalyse() && !p2.estParalyse()){
			if(p1.speed>=p2.speed){
				p1.attaque(p2, attaque1);
				if(!p2.estKO() ){
					if(!p2.estParalyse() || Math.random()>0.3)
						p2.attaque(p1, attaque2);
					else
						System.out.println ("\t\t\t\t" +p2.getAfficherNom() + " est paralysé, il n'a pas pu attaquer. ");		
				}
			}
			else{
				p2.attaque(p1, attaque2);
				if(!p1.estKO()){
					if(!p1.estParalyse() || Math.random()>0.3)
						p1.attaque(p2, attaque1);
					else
						System.out.println ("\t\t\t\t"+p1.getAfficherNom()  + " est paralysé, il n'a pas pu attaquer. ");
				}
			}
		}
		else if(p1.estParalyse() || p2.estParalyse()){
			if(p1.estParalyse() && Math.random()<0.3){
				System.out.println ("\t\t\t\t" +p1.getAfficherNom() + " est paralysé. ");
				System.out.println ("\t\t\t\t"+p1.getAfficherNom() + " est paralysé, il n'a pas pu attaquer. ");
				p1.paralyse--;
				p2.attaque(p1, attaque2);
			}
			else if(p1.estParalyse()){
				System.out.println ("\t\t\t\t" +p1.getAfficherNom() + " est paralysé. ");
				if(p1.speed*0.75>=p2.speed){
					p1.attaque(p2, attaque1);
					if(!p2.estKO())
						p2.attaque(p1, attaque2);
				}
				else{
					p2.attaque(p1, attaque2);
					if(!p1.estKO())
						p1.attaque(p2, attaque1);
					
				}
			}
			if(p2.estParalyse() && Math.random()<0.3){
				System.out.println ("\t\t\t\t" +p2.getAfficherNom() + " est paralysé. ");
				System.out.println ("\t\t\t\t"+p2.getAfficherNom() + " est paralysé, il n'a pas pu attaquer. ");
				p2.paralyse--;
				p1.attaque(p2, attaque1);
			}
			else if(p2.estParalyse() ){
				System.out.println ("\t\t\t\t" +p2.getAfficherNom() + " est paralysé. ");
				if(p1.speed>=p2.speed*0.75){
					p1.attaque(p2, attaque1);
					if(!p2.estKO())
						p2.attaque(p1, attaque2);
				}
				else{
					p2.attaque(p1, attaque2);
					if(!p1.estKO())
						p1.attaque(p2, attaque1);
				}
			}
		}
		if(p1.poison){
			p1.pv-=0.15*p1.pvmax;
			System.out.println ("\t\t\t\t"+p1.getAfficherNom() + " souffre du poison ! ");
		}
		if(p2.poison){
			p2.pv-=0.15*p2.pvmax;
			System.out.println ("\t\t\t\t"+p2.getAfficherNom() + " souffre du poison ! ");
		}
		if(p1.brulure){
			p1.pv-=0.15*p1.pvmax;
			System.out.println ("\t\t\t\t"+p1.getAfficherNom() + " souffre de la brulure ! ");
		}
		if(p2.brulure){
			p2.pv-=0.15*p2.pvmax;
			System.out.println ("\t\t\t\t"+p2.getAfficherNom() + " souffre de la brulure ! ");
		}
		if(p1.estKO() && !p2.estKO()){
			p1.perdu();
			p2.gagnerNiveau();
		}
		else if(p2.estKO() && !p1.estKO()){
			p2.perdu();
			p1.gagnerNiveau();
		}
		else if(p2.estKO() && p1.estKO()){
			p2.gagnerNiveau();
			p1.gagnerNiveau();
			p2.perdu();
			p1.perdu();
		}
	}

	public void gagnerNiveau() {
		niveau++;
		pvmax += (int)(0.03*pvmax)+1;
		pv += (int)(0.1*pvmax)+1;
		if (pv > pvmax) {
			pv = pvmax;
		}
		attaque += (int)(0.03*attaque)+1;
		speed += (int)(0.01*speed)+1;
		System.out.println (this.getAfficherNom() + " passe au niveau " + niveau + " ! " + this );
		evolution();
	}
	
	public void infirmerie () {
		soigner();
	}
	
	public void reset(){
	}
	
	public void evolution(){
		if(evolution){
			attaque+=attaque*0.1;
			pvmax+=pvmax*0.1;
			speed+=speed*0.05;
			evolution=false;
		}
	}
	
	public void vaincu(){
		vaincu=true;
	}
	
	public int calculNiveau(){
		return getNiveau();
	}
	
	public void gagnerNiveauAdversaire(int Level){
		for(int i=0;i<Level;i++){
			if(Math.random()<0.90)
				gagnerNiveau();
			if(Math.random()<0.10)
				gagnerNiveau();
		}
	}
	
	public Pokemon getCombattant(){
		return this;
	}

	public void newCombattant(Pokemon suivant) {
	}

	public void changerNom (String nouveauNom) {
		nom = nouveauNom;
	}
	
	public String getAfficherNom () {
		return nom;
	}

	public String toString() {
		return getAfficherNom() + " niveau "+ niveau + " (" + pv + "/" + pvmax + "pv, " + attaque + " att, " + speed + " vitesse)";
	}

	public String getNom() {
		return nom;
	}
	
	public String getType() {
		return type;
	}
	
	public int getNbPokemons(){
		return 1;
	}
	
	public Pokemon[] getPokemons(){
		Pokemon[] self = {this};
		return self;
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
	
	public String toSave(){
		return getClass()+" "+id+" "+nom+" "+niveau+" "+pvmax+" "+pv+" "+attaque+" "+speed+" "+paralyse+" "+brulure+" "+poison+" ";
	}
	
	public abstract String[] getFort();
	
	public abstract String[] getFaible();
	
	public abstract int getNbFort();
	
	public abstract int getNbFaible();
}
