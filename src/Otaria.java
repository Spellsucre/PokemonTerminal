public class Otaria extends Eau{
	private static int cpt=1;

	public Otaria(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Otaria";
	}
	
	public Otaria(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Otaria() {
		this("Otaria"+cpt, 190+(int)(Math.random()*50), 55+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		if(adversaire.getCombattant().getType().equals("Feu")){
			degats*=0.5;
			System.out.println("\t\t\t\t" +getAfficherNom() + " a une couche isograisse ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Otaria")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Lamantine");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Otaria"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
