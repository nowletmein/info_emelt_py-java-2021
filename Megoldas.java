package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Megoldas {
   private static Scanner scanner = new Scanner(System.in);
   private static final int[][] sudoku = new int[9][];
   private static final List<int[]> lepesek = new ArrayList<>();
   private static  int sorSzam;
    private static  int oszlopSzam;

   public static void felszam(int num){
        System.out.println(num + ". feladat");
    }

    static void feladat1es2(){
        felszam(1);

        System.out.println("Adja meg a bemeneti fájl nevét! ");
        String file = scanner.nextLine();
        System.out.println("Adja meg egy sor számát! ");
         sorSzam = scanner.nextInt();
        System.out.println("Adja meg egy oszlop számát! ");
         oszlopSzam = scanner.nextInt();

        felszam(2);
        try{
            BufferedReader adat = new BufferedReader(new FileReader(file));
            int sor = 0;
            String _Sor = " ";
            while((_Sor = adat.readLine()) != null){
                String[] szamok = _Sor.split(" ");
               if (sor < 9){

                   sudoku[sor] = new int[9];

                   for (int i = 0; i < szamok.length; i++) {
                       sudoku[sor][i] = parseInt(szamok[i]);
                   }
               }else {
                    lepesek.add(new int []{parseInt(szamok[1]), parseInt(szamok[2]), parseInt(szamok[0])});

               }
               sor++;
            }
            adat.close();

        }catch (IOException e){
            System.out.println(e);
        }
    }
    static int reszTabla(int sor , int oszlop){

       return(3 * ((sor - 1) / 3) + ((oszlop - 1)/ 3) + 1);
    }
    static void feladat3(){
            felszam(3);
            int answare = sudoku[sorSzam -1 ][oszlopSzam -1];
            if (answare == 0){
                System.out.println("Az adott helyet még nem töltötték ki.");

            }else {
                System.out.println("Az adott helyen szereplő szám: "+answare);
            }
            int a = reszTabla(sorSzam,oszlopSzam);
        System.out.format("A hely a(z) %d résztáblázathoz tartozik.\n", a);

        }
     static  void  feladat4(){
       felszam(4);
       int kitoltve = 0;
         for (int i = 0; i < sudoku.length; i++) {
             for (int j = 0; j < sudoku[i].length; j++) {
                 if (sudoku[i][j] == 0){
                     kitoltve++;
                 }
             }
         }
       double answare =  (double) kitoltve / 81 * 100;
         System.out.format("Az üres helyek aránya: %.1f%%", answare);
     }
    static  void   feladat5(){
        felszam(5);
        for (int i = 0; i < lepesek.size(); i++) {
            boolean doable = true;
            System.out.format("A kiválasztott sor: %d oszlop: %d a szám: %d \n", lepesek.get(i)[0],lepesek.get(i)[1], lepesek.get(i)[2] );
            int lepesSor= lepesek.get(i)[0] - 1;
            int lepesOszlop= lepesek.get(i)[1] - 1;
            int szam = lepesek.get(i)[2];
            if (sudoku[lepesSor][lepesOszlop] != 0){
                System.out.println("A helyet már kitöltötték.\n");
                doable = false;

            }else{
                if (Arrays.asList(sudoku[lepesSor]).contains(szam) && doable == true){
                    System.out.println("Az adott sorban már szerepel a szám\n");
                    doable = false;

                }
                for (int j = 0; j < sudoku.length; j++) {
                    if (sudoku[j][lepesOszlop] == szam && doable == true){
                        doable = false;
                        System.out.println("Az adott oszlopban már szerepel a szám\n");

                    }
                }

                int resz = reszTabla(lepesek.get(i)[0],lepesek.get(i)[1]);
                for (int j = 0; j < sudoku.length; j++) {
                    for (int k = 0; k < sudoku[i].length; k++) {
                        if (sudoku[j][k] == szam && reszTabla(j +1 , k +1) == resz && doable == true){
                            System.out.println("Az adott résztáblázatban már szerepel a szám\n");
                            doable = false;

                        }
                        if (!doable){
                            break;
                        }
                    }
                }
                if (doable == true){
                    System.out.println("A lépés megtehető. \n");
                }
            }


        }
    }

    }

