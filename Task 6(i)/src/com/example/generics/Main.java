package com.example.generics;

public class Main {
    public static void main(String[] args) {
        // Integer array
        Integer[] intArray = {3, 8, 1, 6, 2};
        MinMax<Integer> intMinMax = new MinMaxImpl<>();
        System.out.println("Integer Array: ");
        System.out.println("Min: " + intMinMax.findMin(intArray));
        System.out.println("Max: " + intMinMax.findMax(intArray));

        // String array
        String[] stringArray = {"apple", "orange", "banana", "pear"};
        MinMax<String> stringMinMax = new MinMaxImpl<>();
        System.out.println("\nString Array: ");
        System.out.println("Min: " + stringMinMax.findMin(stringArray));
        System.out.println("Max: " + stringMinMax.findMax(stringArray));

        // Character array
        Character[] charArray = {'z', 'a', 'u', 'm'};
        MinMax<Character> charMinMax = new MinMaxImpl<>();
        System.out.println("\nCharacter Array: ");
        System.out.println("Min: " + charMinMax.findMin(charArray));
        System.out.println("Max: " + charMinMax.findMax(charArray));

        // Float array
        Float[] floatArray = {3.2f, 8.5f, 1.1f, 6.7f, 2.3f};
        MinMax<Float> floatMinMax = new MinMaxImpl<>();
        System.out.println("\nFloat Array: ");
        System.out.println("Min: " + floatMinMax.findMin(floatArray));
        System.out.println("Max: " + floatMinMax.findMax(floatArray));
    }
}
