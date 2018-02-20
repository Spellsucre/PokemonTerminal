public class Onix extends Terre{
	private static int cpt=1;

	public Onix(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Onix";
	}
	
	public Onix(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Onix() {
		this("Onix"+cpt, 200+(int)(Math.random()*50), 60+(int)(Math.random()*30), 100+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}

	public void subire(Adversaire adversaire, int degats){
		if(pv==pvmax && degats >= pvmax){
			degats=pvmax-1;
			System.out.println("\t\t\t\t" +getAfficherNom() + " résiste ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Onix")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Steelix");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Onix"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
