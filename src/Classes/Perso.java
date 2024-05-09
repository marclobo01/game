package Classes;

public class Perso {
	
	int max_pv;
	int pv;
	int pa;
	int vel;
	int pd;
	
	public Perso(int vida, int atq, int vel, int def) {
		this.pd = def;
		this.pa = atq;
		this.vel = vel;
		this.max_pv = vida;
		this.pv = this.max_pv;
	}
	
	// formula de ataque - 1.5*atq - 0.5*def
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

	public void skill(Perso a) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
