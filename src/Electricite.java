


public abstract class Electricite extends Pokemon{
	protected static String[] faible = {"Electricite","Terre"};
	protected static int nbFaible = 2;
	protected static String[] fort = {"Eau"};
	protected static int nbFort = 1;
	protected boolean talentactif=false;

	public Electricite(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom,pvmax, attaque, speed,4,niveau);
		type="Electricite";
		attaquesDisponibles[1]="Elecanon";
		attaquesDisponibles[2]="Fatal-Foudre";
		attaquesDisponibles[3]="Tonnerre";
	}

	public abstract void talent();
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque " + choixAttaque + " ! ");
		if (!choixAttaque.equals("Charge")){
			if(choixAttaque.equals("Elecanon")){
				multiplicateur*=0.6;
				this.attaque(adversaire);
				if(Math.random()<0.6){
						adversaire.paralyse+=1;
						System.out.println("\t\t\t\t" +adversaire.getAfficherNom() + " est paralysé ! ");
				}
			}
			if(choixAttaque.equals("Fatal-Foudre")){
				if(Math.random()<0.5){
					multiplicateur*=2.2;
					this.attaque(adversaire);
					if(Math.random()<0.5){
						adversaire.paralyse++;
						System.out.println("\t\t\t\t" +adversaire.getAfficherNom() +" est paralysé ! ");
					}
				}
				else{
					System.out.println("\t\t\t\t" +getAfficherNom() + " rate son attaque ! ");
				}
			}	
			if(choixAttaque.equals("Tonnerre")){
				multiplicateur*=0.9;
				this.attaque(adversaire);
				if(Math.random()<0.2){
						adversaire.paralyse++;
						System.out.println("\t\t\t\t" +adversaire.getAfficherNom() +" est paralysé ! ");
					}
			}
		}
		else{	
		System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque avec un multiplicateur de :" + multiplicateur + " -> " + (int)(attaque*multiplicateur) + " dégats !");
		adversaire.subire(this, (int)(attaque * multiplicateur));
		multiplicateur = 1;
		}
	}
	
	public String getAfficherNom () {
		return (CouleurTerminal.LIGHTYELLOW + nom+ CouleurTerminal.RESET);
	}
	
	public String getAfficherId () {
		return (CouleurTerminal.LIGHTYELLOW + nom+ CouleurTerminal.RESET);
	}
	
	public void subir(Pokemon adversaire, int degats){
		super.subire(adversaire, degats);
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
