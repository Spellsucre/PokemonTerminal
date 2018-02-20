public class Racaillou extends Terre{
	private static int cpt=1;

	public Racaillou(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Racaillou";
	}
	
	public Racaillou(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Racaillou() {
		this("Racaillou"+cpt, 180+(int)(Math.random()*50), 50+(int)(Math.random()*30), 80+(int)(Math.random()*10));
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
		if(niveau>=7 && id.equals("Racaillou")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Gravalanch");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Racaillou"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
		if(niveau>=15 && id.equals("Gravalanch")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Grolem");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Gravalanch"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
