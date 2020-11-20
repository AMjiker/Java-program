package Experiment;

import java.util.Scanner;

public class Complex {
	private double realPart;
	private double imaginPrat;

	public Complex() {
		this.realPart = 0;
		this.imaginPrat = 0;
	}

	public Complex(double r, double i) {
		this.realPart = r;
		this.imaginPrat = i;
	}

	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginPrat() {
		return imaginPrat;
	}

	public void setImaginPrat(double imaginPrat) {
		this.imaginPrat = imaginPrat;
	}

	public Complex complexAdd(Complex a) {
		return new Complex(this.realPart + a.realPart, this.imaginPrat + a.imaginPrat);
	}

	public Complex complexSub(Complex a) {
		return new Complex(this.realPart - a.realPart, this.imaginPrat - a.imaginPrat);
	}

	public Complex complexMulti(Complex a) {
		return new Complex(this.realPart * a.realPart - this.imaginPrat * a.imaginPrat,
				this.imaginPrat * a.realPart + this.realPart * a.imaginPrat);
	}

	public Complex complexDiv(Complex a) {
		// 根据复数乘法特性，把分母的虚部d变为-d，利用乘法进行运算
		a.setImaginPrat(a.imaginPrat * -1);
		double x = a.getRealPart() * a.getRealPart() + a.getImaginPrat() * a.getImaginPrat();
		Complex s = this.complexMulti(a);
		s.setImaginPrat(s.getImaginPrat() / x);
		s.setRealPart(s.getRealPart() / x);
		return s;
	}

	public String toString() {
		double r = this.getRealPart();
		double i = this.getImaginPrat();
		String sr = String.format("%.1f", r) + "";
		String si = String.format("%.1f", i) + "i";

		if (sr.equals("-0.0") || sr.equals("0.0")) {
			sr = "";
		}

		if (si.equals("-0.0i") || si.equals("0.0i")) {
			si = "";
		}

		if (i > 0 && !sr.equals(""))
			si = "+" + si;
		if (si.equals("+0.0i") || si.equals("-0.0i") || si.equals("0.0i")) {
			si = "";
		} else if (si.equals("+1.0i") || si.equals("-1.0i") || si.equals("1.0i")) {
			if (i > 0)
				si = "+i";
			else
				si = "-i";
		}

//		if(sr.equals("")&&si.charAt(0)=='+') {
//			si=si.substring(1);
//			
//		}

		if (sr.equals("") && si.equals(""))
			sr = "0";
		return sr + si;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Complex to = new Complex(sc.nextDouble(), sc.nextDouble());
		Complex a = new Complex(sc.nextDouble(), sc.nextDouble());
		System.out.println(to);
		System.out.println(a);

//		System.out.println(to.complexAdd(a));
//		System.out.println(to.complexSub(a));
//		System.out.println(to.complexMulti(a));
//		System.out.println(to.complexDiv(a));
	}
}

class demo {

}