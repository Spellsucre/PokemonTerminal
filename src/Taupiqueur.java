public class Taupiqueur extends Terre{
	private static int cpt=1;

	public Taupiqueur(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Taupiqueur";
	}
	
	public Taupiqueur(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Taupiqueur() {
		this("Taupiqueur"+cpt, 150+(int)(Math.random()*50), 60+(int)(Math.random()*30), 110+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}

	public void subire(Adversaire adversaire, int degats){
		if(Math.random()<0.20){
			System.out.println("\t\t\t\t"+getAfficherNom() + " s'est caché dans le sol ! Il évite l'attaque ");
		}
		else{
			super.subire(adversaire, degats);
		}
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Taupiqueur")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Triopiqueur");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Taupiqueur"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}


}
