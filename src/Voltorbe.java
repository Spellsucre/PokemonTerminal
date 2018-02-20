public class Voltorbe extends Electricite{
	private static int cpt=1;

	public Voltorbe(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Voltorbe";
		talentactif=false;
	}
	
	public Voltorbe(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Voltorbe() {
		this("Voltorbe"+cpt, 140+(int)(Math.random()*50), 65+(int)(Math.random()*30), 110+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		super.subire(adversaire, degats);
		if(estKO()&&talentactif){
			System.out.println("\t\t\t\t"+getAfficherNom() + " explose ! ");
			adversaire.subire(this, degats/2);
			talentactif=false;
		}
	}
	
	public void reset(){
		talentactif=false;
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Voltorbe")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Electrode");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Voltorbe"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
	}

}
