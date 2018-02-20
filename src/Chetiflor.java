public class Chetiflor extends Herbe{
	private static int cpt=1;

	public Chetiflor(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Chetiflor";
	}
	
	public Chetiflor(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Chetiflor() {
		this("Chetiflor"+cpt, 140+(int)(Math.random()*50), 40+(int)(Math.random()*30), 95+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		if(Math.random()<0.2){
			adversaire.getCombattant().poison=true;
			System.out.println("\t\t\t\t"+adversaire.getCombattant().getAfficherNom() + " a touché le point poison ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=7 && id.equals("Chetiflor")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Boustiflor");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Chetiflor"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
		if(niveau>=15 && id.equals("Boustiflor")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Empiflor");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Boustiflor"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
	}

}
