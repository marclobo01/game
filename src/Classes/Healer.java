package Classes;

public class Healer extends Perso{

	public Healer(int vida, int atq, int vel, int def) {
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
	
	public void skill(Perso p) {
		if(p.pv == 0) {
			System.out.println("O personagem a ser curado morreu");
		}else if(p.pv == p.max_pv) {
			System.out.println("O personagem estao com a vida maxima");
		}else {
			int heal = (int) (0.2*this.max_pv);
			if(p.pv + heal > p.max_pv) {
				p.pv = p.max_pv;
			}else {
				p.pv = p.pv + heal;
			}
		}
	}
}
