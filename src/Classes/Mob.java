package Classes;

public class Mob extends Creatures{
	
	String name;
	int max_pv;
	int pv;
	int max_pa;
	int pa;
	int vel;
	int max_pd;
	int pd;
	
	public Mob(String nome, int vida, int atq, int def) {
		this.pv = vida;
		this.max_pv = vida;
		this.pa = atq;
		this.max_pa = atq;
		this.pd = def;
		this.max_pd = def;
		this.vel = 100;
		this.name = nome;
	}
	
	public void atack(Perso p) {
		double dano = 1.5*this.pa - 0.5*p.pd;
		if(dano >= p.pv && dano >= 0) {
			System.out.println(p.name + " morreu");
		}else {
			p.pv = p.pv - (int)dano;
			System.out.println("o " + this.name + " causou " + dano + " de dano a "+ p.name +",");
			System.out.println("agora,"+ p.name +" tem " + p.pv + " de vida.");
		}
	}
	
}
