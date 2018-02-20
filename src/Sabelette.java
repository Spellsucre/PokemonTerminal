public class Sabelette extends Terre{
	private static int cpt=1;

	public Sabelette(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Sabelette";
	}
	
	public Sabelette(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Sabelette() {
		this("Sabelette"+cpt, 90+(int)(Math.random()*50), 70+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		if(adversaire.getCombattant().getType().equals("Terre")){
			degats*=0.5;
			System.out.println("\t\t\t\t" +getAfficherNom() + " s'est roulé en boule dans le sable ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Sabelette")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Sablaireau");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Sabelette"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
