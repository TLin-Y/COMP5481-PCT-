package FindGram;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

public class lineToWord {
	
	private int ngram;
	private String str;

	
	public static List<String> ngrams(int n, String str) {
	    List<String> ngrams = new ArrayList<String>();
	    for (int i = 0; i < str.length() - n + 1; i++)//For "abcd", n=2, loop 0,1,2, 3 times 
	        ngrams.add(str.substring(i, i + n));//For 0~2 substring, which is index[0]and[1], "ab" 
	    return ngrams;//Return List["ab","bc","cd"]
	}
	
	public void getNgram(List<String> lines, int ngram) { 
        //ArrayList to String
		
		for (int i = 1; i < lines.size(); i++) {
			str = str + lines.get(i);
		}
        
		//Remove space ., from str
		String splitArray[] = str.split("\\s+|\\.|\\,");
		
		//Clear empty element in Array.
		String combineStr = "";
		for (int i = 0; i < splitArray.length; i++){
			if (splitArray[i] != null) {
				combineStr = combineStr + splitArray[i]+" ";
			}
		}
		
		//Generate split elements without "." "," in String Array.
		String csplitArray[]= combineStr.split("\\s+");
		
		//Find all ngram
		int NumberG = ngram;
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < csplitArray.length; i++) {
			List<String> tempList = ngrams(NumberG, csplitArray[i]);
			newList.addAll(tempList);
		}
		
		//Count occurrences of the list elements
		int maxFre = 0;
		List<String> maxWord = new ArrayList<String>();
		for (int i = 0; i < newList.size(); i++) {
			int occurrences = Collections.frequency(newList, newList.get(i));
			if (occurrences >= maxFre) {
				maxFre = occurrences;
			}
		}
		
		//Put all max words in list
		for (int i = 0; i < newList.size(); i++) {
			int occurrences = Collections.frequency(newList, newList.get(i));
			if (occurrences == maxFre) {
				maxWord.add(newList.get(i));
			}
		}
		//Sort the list in alpha order
		Collections.sort(maxWord);
		
		//Output for 1,2,3 gram number
		if (NumberG == 1) {
			System.out.println("Unigram "+maxWord.get(0));
		}
		if (NumberG == 2) {
			System.out.println("Bigram "+maxWord.get(0));
		}
		if (NumberG == 3) {
			System.out.println("Trigram "+maxWord.get(0));
		}
	}
	
}
