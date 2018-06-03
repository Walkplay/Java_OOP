import java.util.Scanner;
import java.util.StringTokenizer;


public class Lab8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String strng = new String(in.nextLine());
        String word;
        char[] wordC = null;
        //int length = strng.length();
        //String[] arr = strng.split(" ");
        

        StringTokenizer st = new StringTokenizer(strng,".!,? ");
        String[] strArr = new String[st.countTokens()];
        //System.out.println("tikens "+st.countTokens());
        int tokens = st.countTokens();
        for(int i = 0; i < tokens; i++) {
        	strArr[i] = st.nextToken();
        }
        
        //System.out.println();
        //System.out.print(" ");
        //System.out.println("tikens "+st.countTokens());
        for(int i = 0; i < tokens; i++) {
        	for(int j = 1; j < tokens; j++) {
        		//if(j==3)System.out.println("j==3");
        		if(strArr[i].length() == strArr[j].length()) {
        			wordC = new char[strArr[i].length()];
        			for(int k = strArr[i].length(); k > 0 ;k--) {
        			
        				wordC[strArr[i].length()-k] = strArr[j].charAt(k-1);
        			}
        			word = new String(wordC);
        			//System.out.println(strArr[i] +"---"+ word+" ||turn "+i+ "-"+ j);
        			if(strArr[i].equals(word) && wordC != null) {
            			System.out.println(strArr[i]+ " - " + strArr[j]);
            		}
        		}
        		
        		//System.out.println(word);
        		
        	}
        }
        
    }
}