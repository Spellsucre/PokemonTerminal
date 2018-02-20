


public abstract class Herbe extends Pokemon{
	protected static String[] faible = {"Feu", "Herbe"};
	protected static int nbFaible = 2;
	protected static String[] fort = {"Eau","Terre"};
	protected static int nbFort = 2;
	protected boolean charge;
	protected boolean talentactif=false;

	public Herbe(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed,4,niveau);
		type="Herbe";
		charge = false;
		attaquesDisponibles[1]="Végé-attack";
		attaquesDisponibles[2]="Giga-Sansgue";
		attaquesDisponibles[3]="Fouet-Liane";
	}

	public abstract void talent();
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		if(charge){
			choixAttaque="Végé-attack";
			System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque " + choixAttaque + " ! ");
			charge = false;
			this.attaque(adversaire);
		}
		else{
			System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque " + choixAttaque + " ! ");
			if (!choixAttaque.equals("Charge")){
				if(choixAttaque.equals("Végé-attack")){
					charge=true;
					multiplicateur*=2.5;
					System.out.println("\t\t\t\t" +getAfficherNom() +" charge son Energie ! ");
				}	
				if(choixAttaque.equals("Giga-Sansgue")){
					multiplicateur*=0.8;
					this.attaque(adversaire);
					int pvVoles = (int)(0.9*attaque*0.3);
					if(fortContre(adversaire))
						pvVoles*=2;
					else if(faibleContre(adversaire))
						pvVoles=(int)(pvVoles*0.5);
					System.out.println("\t\t\t\t" +getAfficherNom() +" récupère son énergie ! " );
					pv+=pvVoles;
					if(pv>pvmax)
						pv=pvmax;		
				}
				if(choixAttaque.equals("Fouet-Liane")){
					multiplicateur*=0.9;
					this.attaque(adversaire);
				}
			}
			else{
				System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque avec un multiplicateur de :" + multiplicateur + " -> " + (int)(attaque*multiplicateur) + " dégats !");
				adversaire.subire(this, (int)(attaque * multiplicateur));
				multiplicateur = 1;
			}	
		}
	}
	
	public String getAfficherNom () {
		return (CouleurTerminal.GREEN+ nom+ CouleurTerminal.RESET);
	}
	
	public String getAfficherId () {
		return (CouleurTerminal.GREEN+ nom+ CouleurTerminal.RESET);
	}
	
	
	public void reset(){
		charge=false;
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
