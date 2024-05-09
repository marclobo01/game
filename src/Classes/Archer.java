package Classes;

public class Archer extends Perso{

	public Archer(int vida, int atq, int vel, int def) {
		super(vida, atq, vel, def);
		
	}
	
	public void atacar(Mob m) {
		double dano = 1.5*this.pa - 0.5*m.pd;
		if(dano >= m.pv) {
			System.out.println("o mob morreu");
		}else {
			m.pv = m.pv - (int)dano;
			System.out.println("voce causou " + dano + " de dano.");
			System.out.println("agora, o mob tem " + m.pv + " de vida.");
		}
	}
	
	public void skill(Mob m) {
		double dano = 1.5*this.pa - 0.2*m.pd;
		if(dano >= m.pv) {
			System.out.println("o mob morreu");
		}else {
			m.pv = m.pv - (int)dano;
			System.out.println("voce causou " + dano + " de dano.");
			System.out.println("agora, o mob tem " + m.pv + " de vida.");
		}
	}

	
	public void skill() {
		// TODO Auto-generated method stub
		
	}

}
