package leetcode.n929UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>(0);
		for (String email : emails) {
			StringBuffer name = new StringBuffer(30);
			char[] chars = email.toCharArray();
			int i = 0;
			while (i < chars.length) {
				if (chars[i] == '@') {
					break;
				}
				name.append(chars[i]);
				i++;
			}

			StringBuffer sb = new StringBuffer();
			for (char c : name.toString().toCharArray()) {
				if (c == '+') {
					break;
				}

				if (c == '.') {
					continue;
				}
				sb.append(c);
			}
			set.add(sb.append(email.substring(i)).toString());
		}
		return set.size();
	}

	public int numUniqueEmails2(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
	    
	    for (String rawEmail : emails) { 
	        
	        StringBuilder cleanMail = new StringBuilder();
	        
	        // compute local name (substring up to the first '+' or '@', remove all '.')
	        int i = 0;
	        while (i < rawEmail.length()) {
	            
	            char currChar = rawEmail.charAt(i);

	            if (currChar == '+' || currChar == '@') break;      // end of clean local part                
	            if (currChar != '.') cleanMail.append(currChar);
	            i++;
	        }
	        
	        // compute domain name (substring from '@' to end)
	        while (i < rawEmail.length()) {
	            
	            char currChar = rawEmail.charAt(i);
	            if (currChar == '@') {
	                cleanMail.append(rawEmail.substring(i));
	                break;
	            }
	            
	            i++;
	        }
	        
	        uniqueEmails.add(cleanMail.toString());
	    }
	    
	    return uniqueEmails.size();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numUniqueEmails(new String[0]));
	}
}
