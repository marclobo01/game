package Classes;

import java.util.ArrayList;

public class Perso implements Comparable<Perso>{
	
	int id;
	
	int max_pv;
	int pv;
	
	int max_pa;
	int pa;
	
	int max_vel;
	int vel;
	
	int max_pd;
	int pd;
	
	int max_energy;
	int energy;
	
	int agro;
	int meelee;
	int ap;
	String name;
	ArrayList<Effect> effects = new ArrayList<Effect>();
	
	public Perso(String name,int vida, int atq, int vel, int def, int energy) {
		this.max_pd = def;
		this.max_pa = atq;
		this.max_vel = vel;
		this.max_pv = vida;
		this.max_energy = energy;
		this.pv = this.max_pv;
		this.pd = this.max_pd;
		this.pa = this.max_pa;
		this.vel = this.max_vel;
		this.energy = 0;
		this.name = name;
		this.ap = 10000/vel;
		
	}
	
	public void printDamage() {
		
	}
	
	// formula de ataque - 1.5*atq - 0.5*def
	public void atacar(Mob m) {
		double dano = 1.5*this.pa - 0.5*m.pd;
		if(dano >= m.pv) {
			m.pv = 0;
			System.out.println(m.name + " morreu");
		}else {
			m.pv = m.pv - (int)dano;
			System.out.println(this.name +" causou " + dano + " de dano a "+m.name+ ",");
			System.out.println("agora, "+ m.name +" tem " + m.pv + " de vida.");
		}
	}

	public void skill(Perso a) {
		// skill to heal//buff
		
	}
	
	public void skill(Mob m) {
		// skill to atack
		
	}
	
	@Override public int compareTo(Perso other) { 
		if (this.ap < other.ap) { 
		  return -1; 
		  } if (this.ap > other.ap) { 
		  return 1; 
		  } 
		  return 0; 
		 }
	
	
	
}
