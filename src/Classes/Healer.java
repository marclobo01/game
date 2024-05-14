package Classes;

public class Healer extends Perso{

	public Healer(String name,int vida, int atq, int vel, int def, int energy) {
		super(name, vida, atq, vel, def, energy);
		this.agro = 80;
		this.meelee = 0;
	}
	
	public void atacar(Mob m) {
		double dano = 1.5*this.pa - 0.5*m.pd;
		if(dano >= m.pv) {
			System.out.println(m.name + " morreu");
		}else {
			m.pv = m.pv - (int)dano;
			System.out.println("voce causou " + dano + " de dano.");
			System.out.println("agora, o mob tem " + m.pv + " de vida.");
		}
	}
	
	public void skill(Perso p) {
		if(p.pv == 0) {
			System.out.println(p.name + "morreu");
		}else if(p.pv == p.max_pv) {
			System.out.println(p.name + " esta com a vida maxima");
		}else {
			int heal = (int) (0.2*this.max_pv);
			if(p.pv + heal > p.max_pv) {
				p.pv = p.max_pv;
				System.out.println(p.name + " foi curado em " + heal + " por " + this.name + " e agora está com " + p.pv + " de vida.");
			}else {
				p.pv = p.pv + heal;
				System.out.println(p.name + " foi curado em " + heal + " por " + this.name + " e agora está com " + p.pv + " de vida.");
			}
		}
	}
}
