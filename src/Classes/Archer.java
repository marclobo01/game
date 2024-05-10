package Classes;

public class Archer extends Perso{

	public Archer(String name,int vida, int atq, int vel, int def) {
		super(name, vida, atq, vel, def);
		this.agro = 100;
		
	}
	
	public void atacar(Mob m) {
		double dano = 1.5*this.pa - 0.5*m.pd;
		if(dano >= m.pv) {
			System.out.println(m.name + " morreu");
		}else {
			m.pv = m.pv - (int)dano;
			System.out.println(this.name +" causou " + dano + " de dano a "+m.name+ ",");
			System.out.println("agora, "+ m.name +" tem " + m.pv + " de vida.");
		}
	}
	
	public void skill(Mob m) {
		double dano = 1.5*this.pa - 0.2*m.pd;
		if(dano >= m.pv) {
			System.out.println(m.name + " morreu");
		}else {
			m.pv = m.pv - (int)dano;
			System.out.println(this.name +" causou " + dano + " de dano a "+m.name+ ",");
			System.out.println("agora, "+ m.name +" tem " + m.pv + " de vida.");
		}
	}

	
	public void skill() {
		// TODO Auto-generated method stub
		
	}

}
