package com.ucx.utility.palindrome;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

    public boolean isPalindrome(String text){
        StringBuilder sb =  new StringBuilder(text);
        return sb.reverse().toString().equals(text);
    }
}
