package Classes;

public class Archer extends Perso{

	public Archer(String name,int vida, int atq, int vel, int def, int energy) {
		super(name, vida, atq, vel, def, energy);
		this.agro = 100;
		this.meelee = 0;
	}
	
	
	public void atacar(Mob m) {
		double dano = 1.5*this.pa - 0.5*m.pd;
		if(dano >= m.pv) {
			System.out.println(m.name + " morreu");
			m.pv = 0;
			System.out.println("agora, "+ m.name +" tem " + m.pv + " de vida.");
		}else {
			m.pv = m.pv - (int)dano;
			System.out.println(this.name +" causou " + dano + " de dano a "+m.name+ ",");
			System.out.println("agora, "+ m.name +" tem " + m.pv + " de vida.");
		}
	}
	
	public void skill(Mob m) {
		Effect debuff = new Effect(1,10,2);
		double dano = 1.5*this.pa - 0.2*m.pd;
		if(dano >= m.pv) {
			System.out.println(m.name + " morreu");
			m.pv = 0;
		}else {
			debuff.applyMob(m);
			m.pv = m.pv - (int)dano;
			System.out.println(this.name +" causou " + dano + " de dano a "+m.name+ ",");
			System.out.println("agora, "+ m.name +" tem " + m.pv + " de vida.");
		}
	}

	

}
