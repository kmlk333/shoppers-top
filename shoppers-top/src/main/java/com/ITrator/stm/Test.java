package com.ITrator.stm;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    
    public static void main(String...a){
        
        String str = "ABCDABCDGHETR";

        method3(str);

    }

    public static char findFirstNonRepChar(String string) {
        Map<Integer,Long> characters = string.chars().boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return (char)(int)characters.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("No unrepeated character"));
    }

    private static void method3(String str){
        for(Character ch: str.toCharArray()) {
            if(str.indexOf(ch) == str.lastIndexOf(ch)) {
                System.out.println("First non repeat character = " + ch);
                break;
            }
        }
    }

    private void method2(String str){
        char[] chars = str.toCharArray();
        //List<Character> charList = Arrays.asList(chars);
    }

    private void method1(String str){
        char[] arr = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            String sub = str.substring(i, str.length()-1);
            System.out.println("SubString is > " + sub);
            if(!sub.contains(String.valueOf(arr[i]))){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
