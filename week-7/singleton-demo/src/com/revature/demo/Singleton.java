package com.revature.demo;

import java.util.Objects;

public class Singleton {

	private static Singleton instance;
	
	private String a;
	private String b;
	private String c;
	private String d;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(Singleton.instance == null) {
			Singleton.instance = new Singleton();
		}
		
		return Singleton.instance;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b, c, d);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Singleton other = (Singleton) obj;
		return Objects.equals(a, other.a) && Objects.equals(b, other.b) && Objects.equals(c, other.c)
				&& Objects.equals(d, other.d);
	}

	@Override
	public String toString() {
		return "Singleton [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}
	
}
