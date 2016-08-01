package dynamicProgamming;

import java.util.Scanner;

public class MinEdDis {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String a = " ", b = " ";
		System.out.print("Please enter string 1: ");
		a += input.nextLine();
		System.out.print("Please enter string 2: ");
		b += input.nextLine();
		input.close();
		String[][] step = new String[a.length() + 1][b.length() + 1];
	    int[][] c = new int[a.length() + 1][b.length() + 1];
	    int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
	    for (int i = 0; i <= a.length(); i++)
	        c[i][0] = i;
	    for (int j = 0; j <= b.length(); j++)
	        c[0][j] = j;
	    for (int i = 1; i <= a.length(); i++) {
	        for (int j = 1; j <= b.length(); j++) {
	            int min = Integer.MAX_VALUE;
	            x = c[i - 1][j] + 1; //del
	            y = c[i][j - 1] + 1; //add
	            if (a.charAt(i - 1) == b.charAt(j - 1)) {
	                z = c[i - 1][j - 1]; //match
	            } else {
	                z = c[i - 1][j - 1] + 1; //replace
	            }
	            if (min > x) {
	                min = x;
	                step[i][j] = "del " + a.charAt(i - 1);
	            }
	            if (min > y) {
	                min = y;
	                step[i][j] = "add " + b.charAt(j - 1);
	            }
	            if (min > z) {
	                min = z;
	                if (a.charAt(i - 1) == b.charAt(j - 1)) {
	                    step[i][j] = "match";
	                } else {
	                    step[i][j] = a.charAt(i - 1) + "-->" + b.charAt(j - 1);
	                }
	            }
	            c[i][j] = min;
//	            System.out.print("(" + (i - 1) + "," + (j - 1) + ")" + step[i][j] + "\t");
	        }
//	        System.out.println();
	    }
//	    for (int i = 1; i <= a.length(); i++) {
//	        for (int j = 1; j <= b.length(); j++)
//	        	System.out.print("(" + (i - 1) + "," + (j - 1) + "): " + c[i][j] + "\t");
//	        System.out.println();
//	    }
	    System.out.println("Edit steps are showing below: ");
	    for (int i = a.length(), j = b.length(); i + j != 2;) {
	    	if (step[i][j].contains("match")) {
	    		i--;
	    		j--;
	    	} else if (step[i][j].contains("-->")) {
	    		System.out.println(step[i][j] + "\tat\t" + (i - 1));
	    		i--;
	    		j--;
	    	} else if (step[i][j].contains("del")) {
	    		System.out.println(step[i][j] + "\tat\t" + (i - 1));
	    		i--;
	    	} else {
	    		System.out.println(step[i][j] + "\tbetween\t" + (i - 1) + "~" + i);
	    		j--;
	    	}
	    }
	    System.out.println("Total cost: " + c[a.length()][b.length()]);
	}

}
