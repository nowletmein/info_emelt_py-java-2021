package com.company;

import java.util.ArrayList;
import java.util.List;



public class Main {
    private List<String> sudoku = new ArrayList<>();
    public static void felszam(int num){
        System.out.println(num + ". feladat");
    }


    public static void main(String[] args) {
	// write your code here
        Megoldas.feladat1es2();
        Megoldas.feladat3();
        Megoldas.feladat4();
        Megoldas.feladat5();
    }
}
