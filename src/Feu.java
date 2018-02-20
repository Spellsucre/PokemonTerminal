


public abstract class Feu extends Pokemon{
	protected static String[] faible = {"Feu", "Eau","Terre"};
	protected static int nbFaible = 3;
	protected static String[] fort = {"Herbe"};
	protected static int nbFort = 1;
	protected boolean talentactif=false;

	public Feu(String nom, int pvmax, int attaque, int speed,int niveau){
		super(nom, pvmax, attaque, speed,4, niveau);
		type="Feu";
		attaquesDisponibles[1]="Boutefeu";
		attaquesDisponibles[2]="Surchauffe";
		attaquesDisponibles[3]="Lance-Flamme";
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque " + choixAttaque + " ! ");
		if (!choixAttaque.equals("Charge")){
			if(choixAttaque.equals("Boutefeu")){
					multiplicateur*=1.2;
					this.attaque(adversaire);
					System.out.println("\t\t\t\tA cause du recul, ");
					this.subire(this, (int)(attaque * multiplicateur *0.1));
			}	
			if(choixAttaque.equals("Surchauffe")){
				if(Math.random()<0.8){
					multiplicateur*=1.3;
					this.attaque(adversaire);
					if(Math.random()<0.3){
						adversaire.brulure=true;
						System.out.println("\t\t\t\t" +adversaire.getAfficherNom() +" est brûlé ! ");
					}
				}
				else{
					System.out.println("\t\t\t\t" +getAfficherNom() + " rate son attaque ! ");
				}
			}	
			if(choixAttaque.equals("Lance-Flamme")){
					multiplicateur*=1;
					this.attaque(adversaire);
					if(Math.random()<0.3){
						adversaire.brulure=true;
						System.out.println("\t\t\t\t" +adversaire.getAfficherNom() +" est brûlé ! ");
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
		return (CouleurTerminal.LIGHTRED + nom+ CouleurTerminal.RESET);
	}
	
	public String getAfficherId () {
		return (CouleurTerminal.LIGHTRED + nom+ CouleurTerminal.RESET);
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
