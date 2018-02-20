public class Saquedeneu extends Herbe{
	private static int cpt=1;

	public Saquedeneu(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Saquedeneu";
	}
	
	public Saquedeneu(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Saquedeneu() {
		this("Saquedeneu"+cpt, 210+(int)(Math.random()*50), 40+(int)(Math.random()*30), 85+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		degats*=0.85;
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Saquedeneu")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Bouldeneu");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Saquedeneu"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}


}
