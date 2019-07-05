package String;

import java.util.HashMap;
import java.util.Scanner;

public class receiver {
	static String str;
	static String letters;
	
	static void validatorSTR(String a) {
		if (a.length()>70) {
			System.out.println("Invalid input, length should <=70!");
			str = "abcd";
		}
	}
	static void validatorLET(String a) {
		if (a.length()>str.length()) {
			System.out.println("Invalid input, length should less than first line!");
			letters = "abcd"; 
		}
	}

	static String minWindow(String search, String target) {
		//Handle for out of range search
		String result = "";
		if(target.length()>search.length()) 
	        return result;
		//Step0, using hash map for "char" save.
	     HashMap <Character, Integer> shouldFind = new HashMap<Character, Integer>();
	     HashMap <Character, Integer> hasFound = new HashMap<Character, Integer>();
	     int count =0, j=0,  minWindow = search.length()+1, start=0, finish =0;

	     Integer sLength = search.length();
	     Integer tLength = target.length();
	  
	     // Step1 Search each char from target, count the occurrence, updated in HashMap
	     for(int i = 0 ; i < tLength ; i++)
	     {
	         char tChar = target.charAt(i);//"S": S,S
	         if(!shouldFind.containsKey(tChar))
	         shouldFind.put(tChar,1);//First time put "S,1"
	         else 
	         shouldFind.put (tChar ,shouldFind.get(tChar)+1);//Second time put "S,1+1"

	     }

	     // Step2 Search in FirstLineString for each char from target, count++ if a character matches
	     for (int i =0; i <sLength; i ++)
	     {
	         char sChar = search.charAt(i);//"1qnkyp098fSkkmnQryS9pkYn0Qd7mksy0fRW0a7Sxzc"

	         if(shouldFind.containsKey(sChar))//Find target char in String, here first "S" is 98f"S"kk
	         {
	             if(!hasFound.containsKey(sChar)){
	             hasFound.put(sChar, 1);//First time put in hashmap with char"S" and value"1"
	             count++;//Update count, track appearance char in target are matched
	             }
	             else {
	                 if(hasFound.get(sChar) < shouldFind.get(sChar) )//If more "SSSSSSSSS" here, not update count++
	                 count ++;//Update count, track appearance char in target are matched

	             hasFound.put(sChar, hasFound.get(sChar) +1);//Second time put "1+1"

	             }
	         }

	         //Step 3, find window, than find minimum window.
	         
	        if(count == tLength)// all chars are found, window is found.
	        {
	            char ch = search.charAt(j);//j=0, from start search

	          while (!hasFound.containsKey(ch) || hasFound.get(ch) > shouldFind.get(ch))
	        	  // check if char"S" is occurring more number in target, etc. "SabScS" for "SS" 
	        	  // or is not the target char
	        	  // "SabcS" i=4, hasFound.get("S") = 2,
	          {
	              if(hasFound.containsKey(ch) && hasFound.get(ch)>shouldFind.get(ch))
	            	  // check if char"S" is occurring more number in target
	              hasFound.put(ch , hasFound.get(ch) -1);// -1 from value save "S", etc. 4-1 = 3.

	              j++;//Search for next char, count window length on j.
	              ch = search.charAt(j);
	          }

	            //Find the minimum window
	            if(minWindow > (i-j+1) )
	            {
	                minWindow = i - j + 1;//"SabS" "ScS",3
	                start = j;//0
	                finish = i+1;//3
	                result = search.substring(start, finish);

	            }

	        }
	        
	        }

	        return result;
	}
	
	
	static String minWindow2(String S, String T) {
	    int start=0;
	    String result = "";
	 
	    while(start<S.length()){
	        int j=0;
	 
	        for(int i=start; i<S.length(); i++){
	            if(S.charAt(i)==T.charAt(j)&&j==0){
	                start=i;
	            }
	 
	            if(S.charAt(i)==T.charAt(j)){
	                j++;
	            }
	 
	            if(j==T.length()){
	                if(result.equals("")||(i-start+1)<result.length()){
	                    result = S.substring(start, i+1);
	                }
	                start=start+1;
	                break;
	            }
	 
	            if(i==S.length()-1){
	                return result;
	            }
	        }
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner =  new Scanner(System.in);
		str = inputScanner.nextLine();
		letters = inputScanner.nextLine();
		validatorSTR(str);
		validatorLET(letters);
		System.out.println(minWindow(str,letters));
	}

}
