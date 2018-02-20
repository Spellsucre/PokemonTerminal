


public abstract class Eau extends Pokemon{
	protected static String[] faible = {"Eau","Electricite", "Herbe"};
	protected static int nbFaible = 3;
	protected static String[] fort = {"Feu","Terre"};
	protected static int nbFort = 2;
	protected boolean stun;
	protected boolean talentactif=false;

	public Eau(String nom, int pvmax, int attaque, int speed,int niveau) {
		super(nom ,pvmax, attaque, speed,4,niveau);
		type="Eau";
		stun = false;
		attaquesDisponibles[1]="Hydroblast";
		attaquesDisponibles[2]="Ebullition";
		attaquesDisponibles[3]="Surf";
	}

	public abstract void talent();
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		if(!stun){
			System.out.println("\t\t\t\t" + getAfficherNom() + " attaque " + choixAttaque + " ! ");
			if (!choixAttaque.equals("Charge")){
				if(choixAttaque.equals("Hydroblast")){
					if(Math.random()<0.8){
						multiplicateur*=2.2;
						stun=true;
						System.out.println("\t\t\t\t"+ getAfficherNom() + " utilise toutes ses forces ! ");
						this.attaque(adversaire);
					}
					else{
						System.out.println("\t\t\t\t"+getAfficherNom() + " rate son attaque ! ");
					}
				}
				if(choixAttaque.equals("Ebullition")){
					multiplicateur*=0.8;
					this.attaque(adversaire);
					if(Math.random()<0.3){
						adversaire.brulure=true;
						System.out.println("\t\t\t\t" +adversaire.getAfficherNom() +" est brûlé ! ");
					}
				}
				if(choixAttaque.equals("Surf")){
					multiplicateur*=1.1;
					this.attaque(adversaire);
				}
			}
			else{
				System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque avec un multiplicateur de :" + multiplicateur + " -> " + (int)(attaque*multiplicateur) + " dégats !");
				adversaire.subire(this, (int)(attaque * multiplicateur));
				multiplicateur = 1;
			}
		}
		else{
			System.out.println("\t\t\t\t"+getAfficherNom() + " est épuisé ! ");
			stun=false;
		}
	}
	
	public String getAfficherNom () {
		return (CouleurTerminal.CYAN+ nom+ CouleurTerminal.RESET);
	}
	
	public String getAfficherId () {
		return (CouleurTerminal.CYAN + nom+ CouleurTerminal.RESET);
	}
	
	public void reset(){
		stun=false;
		talentactif=false;
	}
	
	public void evolution(){
		super.evolution();
	}
	
	public String getType(){
		return type;
	}
	
	public String[] getFaible(){
		return faible;
	}
	
	public String[] getFort(){
		return fort;
	}
	
	public int getNbFaible(){
		return nbFaible;
	}
	
	public int getNbFort(){
		return nbFort;
	}

}
