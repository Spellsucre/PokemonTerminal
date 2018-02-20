public class Magneti extends Electricite{
	private static int cpt=1;

	public Magneti(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Magneti";
	}
	
	public Magneti(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Magneti() {
		this("Magneti"+cpt, 160+(int)(Math.random()*50), 65+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		if(Math.random()<0.2){
			adversaire.getCombattant().paralyse+=1;
			System.out.println("\t\t\t\t"+adversaire.getCombattant().getAfficherNom() + " a touché le statik ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Magneti")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Magneton");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Magneti"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
