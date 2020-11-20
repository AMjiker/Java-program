import java.util.Scanner;

public class Complex{
	//私有部分
	private double realPart;
	private double imaginPart;
	// public double realPart;
	// public  double imaginPart;
	//构造函数
	Complex(){
		this.realPart = 0;
		this.imaginPart = 0;
	}
	Complex(double r , double i){
		this.realPart = round(r);
		this.imaginPart = round(i);
	}
	public static double round(double n){
		return n;
	}
	//公有方法
	public void setrealPart(double r){
		this.realPart = r;
	}
	public void setimaginPart(double i){
		this.imaginPart = i;
	}
	public double getrealPart(){
		return this.realPart;
	}
	public double getimaginPart(){
		return this.imaginPart;
	}

	public Complex complexAdd(Complex a){ // 加法
		Complex complex = new Complex();
		complex.setrealPart(this.getrealPart() + a.getrealPart());
		complex.setimaginPart(this.getimaginPart() + a.getimaginPart());
		return complex;
	}
	public Complex complexSub(Complex a){ // 减法
		Complex complex = new Complex();
		complex.setrealPart(this.getrealPart() - a.getrealPart());
		complex.setimaginPart(this.getimaginPart() - a.getimaginPart());
		return complex;
	}
	public Complex complexMulti(Complex a){ // 乘法
		Complex complex = new Complex();
		complex.setrealPart(this.getrealPart() * a.getrealPart() - this.getimaginPart() * a.getimaginPart()) ;
		complex.setimaginPart(this.getimaginPart() *a.getrealPart() +  a.getimaginPart() * this.getrealPart());
		return complex;
	}
	public Complex complexDiv(Complex a){ // 除法
		Complex complex = new Complex();
		double z = this.getrealPart();
		double b = this.getimaginPart();
		double c = a.getrealPart();
		double d = a.getimaginPart();
		double va = round((z*c+b*d)/(c*c+d*d));
		complex.setrealPart(va);
		va = round((b*c-z*d)/(c*c+d*d));
		complex.setimaginPart(va);
		return complex;
	}
	Boolean equals(Complex a){
		return (this.realPart == a.realPart) && (this.imaginPart == a.imaginPart);
	}

	public String toString(){
		String im ;
		String rea ;
		String ad;
		String i;
		if(this.getrealPart() != 0){
			String reag = String.format("%.1f",this.getrealPart());
			rea = reag;
		}else{
			rea = "";
		}
		if(this.getimaginPart() != 0){
			if(this.getimaginPart() > 0){
				ad = "";
				if(this.getrealPart() != 0) ad = "+";
			}else{
				ad = "-";
			}
			if(Math.abs(this.getimaginPart()) == 1){
				im = "";
			}else{
				String img = String.format("%.1f",Math.abs(this.getimaginPart()));
				im = img;
			}
			i = "i";
		}else{
			rea = "0";
			im = "";
			ad = "";
			i = "";
		}
		return rea + ad + im + i;
	}



}

class test{
	public static void main(String [] s){
		Scanner sc = new Scanner(System.in);
		Complex cp ;
		Complex ts1 = new Complex();
		Complex ts2 = new Complex();
		double re,im;

		re = sc.nextDouble();
		im = sc.nextDouble();
		ts1.setrealPart(re);
		ts1.setimaginPart(im);

		re = sc.nextDouble();
		im = sc.nextDouble();
		ts2.setrealPart(re);
		ts2.setimaginPart(im);

		System.out.println(ts1.toString());
		System.out.println(ts2.toString());

		cp = ts1.complexAdd(ts2);
		System.out.println(cp.toString());	

		cp = ts1.complexSub(ts2);
		System.out.println(cp.toString());

		cp = ts1.complexMulti(ts2);
		System.out.println(cp.toString());

		cp = ts1.complexDiv(ts2);
		System.out.println(cp.toString());	
	}
}
