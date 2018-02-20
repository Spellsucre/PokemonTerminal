public class Osselait extends Terre{
	private static int cpt=1;

	public Osselait(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Osselait";
	}
	
	public Osselait(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Osselait() {
		this("Osselait"+cpt, 160+(int)(Math.random()*50), 70+(int)(Math.random()*30), 100+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}

	public void subire(Adversaire adversaire, int degats){
		if(adversaire.getCombattant().getType().equals("Electricite") && talentactif){
			degats=0;
			System.out.println("\t\t\t\t" +getAfficherNom() + " est un paratonnerre ! ");
			talentactif=false;
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Osselait")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Ossatueur");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Osselait"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
