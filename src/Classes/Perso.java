package Classes;

public class Perso extends Creatures{
	
	int max_pv;
	int pv;
	int pa;
	int vel;
	int pd;
	int agro;
	String name;
	
	public Perso(String name,int vida, int atq, int vel, int def) {
		this.pd = def;
		this.pa = atq;
		this.vel = vel;
		this.max_pv = vida;
		this.pv = this.max_pv;
		this.name = name;
		
	}
	
	public void printDamage() {
		
	}
	
	// formula de ataque - 1.5*atq - 0.5*def
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

	public void skill(Perso a) {
		// TODO Auto-generated method stub
		
	}
	
	public void skill(Mob m) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
