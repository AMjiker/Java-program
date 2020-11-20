
import java.util.*;
import java.text.*;

public class CardID{
	private String cardNum;
	public CardID(String cd){
		this.cardNum = cd;
	}
	public String getId(){
		return this.cardNum;
	}
	public void setId(String cardNum){
		this.cardNum = cardNum;
	}
	public boolean lengthVerify(){ //长度验证
		return cardNum.length() == 18 ?true:false;
	}
	boolean isNum(char c){
		return c <= '9' && c >= '0';
	}
	public boolean charVerify(){ //字符验证  初始办法，不够简单，可用正则表达式
		boolean flag = true;
		char c;
		if(lengthVerify()){
			for(int i = 0 ; i < 17 && flag; i++){
			 c = cardNum.charAt(i);
			if(!isNum(c)){
				flag = false;
			}
		}
		c = cardNum.charAt(17);
			if(flag && (isNum(c) || c == 'X' || c == 'X' )){
				flag = true;
			}
		}else{
			flag = false;
		}
		return flag;
	}
	public boolean checkcodeVerify(){//校验码验证
		if(charVerify() && lengthVerify()){
			char[] check = {'1','0','X','9','8','7','6','5','4','3','2'};
			int[] wi = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
			int[] ai = new int[17];
			int sum = 0;
			char mui = cardNum.charAt(17);
			for(int i = 0 ; i < 17 ; i++ ){
				ai[i] = cardNum.charAt(i) - '0';
			}
			for (int i = 0;i < 17 ;i++ ) {
				sum = sum + ai[i]*wi[i];
			}
			sum = sum % 11;
			if(check[sum] == mui ){
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	public boolean Verify(){
		return lengthVerify()&&charVerify()&&checkcodeVerify();
	}
	
	public void output(){
		if(Verify()){
			System.out.println("出生日期:" + this.cardNum.substring(6,10) + "/" + this.cardNum.substring(10,12) + "/" + this.cardNum.substring(12,14));
			if (Integer.parseInt(cardNum.charAt(16) +"")%2==1) {
				System.out.println("男");
			}else{
				System.out.println("女");
			}
			int i = age();
			System.out.printf("年龄:%d岁%d月%d天\n\n\n", i /365 , (i % 365) /30 , (i % 365)%30);

			
		} else {
			System.out.println("Error");
		}
	}

	public int age() {
		SimpleDateFormat formats = new SimpleDateFormat("yyyyMMdd");
		String st = cardNum.substring(6,14) ;
		String now = formats.format(new Date()) ;
		// System.out.println(st);
		// System.out.println(now);
		int[] date = {31,28,31,30,31,30,31,31,30,31,30,31};
		int year1 = Integer.parseInt(st.substring(0,4));
		int year2 = Integer.parseInt(now.substring(0,4));
		int year = year2 - year1;
		int day = 0;
		int month1 = Integer.parseInt(st.substring(4,6));
		int month2 = Integer.parseInt(now.substring(4,6));
		int day1 = Integer.parseInt(st.substring(6,8));
		int day2 = Integer.parseInt(now.substring(6,8));
		// System.out.println(month1);
		// System.out.println(month2);
		// System.out.println(day1);
		// System.out.println(day2);
		for(int i = year1 +1 ; i < year2 ; i++){
			if(i % 100 != 0 && i % 4 ==0 || i % 400 == 0 ){
				day ++;
			}
		}
		//day1
		for(int  i = 1 ; i < month1 ; i++){
			day1 = day1 + date[i];
		}

		if((year1 %100 != 0 && year1 %4 == 0 || year1 % 400 ==0 ) && month1 > 2){
				day1 ++;
		}
		//day2
		for(int  i = 1 ; i < month2 ; i++){
			day2 = day2 + date[i];
		}

		if((year2 %100 != 0 && year2 %4 == 0 || year2 % 400 ==0 ) && month2 > 2){
				day2 ++;
		}

		// day = day + year*365 - day1 + day2; // 要计算润年
		day = year*365 - day1 + day2;//不用闰年
		// System.out.println(day1);
		// System.out.println(day2);
		// System.out.println(day);
		return day ;
	}

	
}

class demo{
	public static void main(String [] s){
		Scanner sc = new Scanner(System.in);
		// String rs;
		// rs = sc.nextLine();
		// CardID id = new CardID(rs);
		// System.out.println(rs);
		// id.output();
		
		for(String i : res){
			CardID ids = new CardID(i);
			ids.output();
		}
	}
}