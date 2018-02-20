public class Goupix extends Feu{
	private static int cpt=1;

	public Goupix(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Goupix";
	}
	
	public Goupix(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Goupix() {
		this("Goupix"+cpt, 160+(int)(Math.random()*50), 70+(int)(Math.random()*30), 100+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		if(adversaire.getCombattant().getType().equals("Feu") && adversaire!=this){
			multiplicateur*=1.5;
			System.out.println("\t\t\t\t" +adversaire.getCombattant().getAfficherNom() +" a ravivé la flamme de " + getAfficherNom() + " ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Goupix")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Feunard");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Goupix"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
