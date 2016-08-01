package fibit;
import java.math.BigInteger;


public class Fibonacci {

	public static void main(String[] args) {
		BigInteger even = new BigInteger("0"), odd = new BigInteger("1");
		for (int i = 0; i < 100; i++) {
			System.out.println("f(" + (2*i) + ")\t=\t" + even);
			System.out.println("f(" + (2*i + 1) + ")\t=\t" + odd);
			even = even.add(odd);
			odd = odd.add(even);
		}
	}

}
