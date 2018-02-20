public class Rhinocorne extends Terre{
	private static int cpt=1;

	public Rhinocorne(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Rhinocorne";
	}
	
	public Rhinocorne(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Rhinocorne() {
		this("Rhinocorne"+cpt, 220+(int)(Math.random()*50), 60+(int)(Math.random()*30), 70+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}

	public void subire(Adversaire adversaire, int degats){
		degats*=0.85;
		System.out.println("\t\t\t\t"+getAfficherNom()+" a la peau dure !");
		adversaire.subire(this,(int)(degats*0.15));
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Rhinocorne")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Rhinastoc");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Rhinocorne"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
