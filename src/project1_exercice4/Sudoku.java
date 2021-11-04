/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_exercice4;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);

        int row =9;
        int col = 9;
       int[][] arr = new int[9][9];

       System.out.println("Enter 81 numbers for your board : ");
       for(int i=0; i<row; i++)
       {
           for(int j=0; j<col; j++)
           {
               arr[i][j] = scan.nextInt();
           }
       }
      
       System.out.print("Your Sudoku Puzzle :\n");
       for(int i=0; i<row; i++)
       {
           for(int j=0; j<col; j++)
           {
               System.out.print(arr[i][j]+ "  ");
           }
           System.out.println();
       }
           System.out.println();
                            
       isBetweenRange(arr);
       isRepeatingInRow(arr);
       isRepeatingInColomun(arr);
       isInBox(arr);
   }    
static boolean isBetweenRange(int [] [] board){ 
    boolean st = false;
       for(int i=0; i<9; i++)
       {
           for(int j=0; j<9; j++)
           {
               if (board[i][j] > 0 && board[i][j]<10){
                   st = true;                   
               }
               else if (board[i][j] < 0 || board[i][j]>10){
                   st = false;
                    System.out.println("Some of your numbers are not between 1 and 9");                   
               }
           }           
       }
return st;    
}
static boolean isRepeatingInRow(int [] [] board){   
    boolean st = false;
    
       for(int i=0; i<8; i++)
       {
           for(int j=0; j<8; j++)
           {
               if (board[i][j] == board[i][j+1]){
                   st = true;
                   System.out.println("You have repeating number(s) in the same row");                                                          
               }
               else{
                    st = false;
               }
           }           
       }
    return st;    
}
static boolean isRepeatingInColomun(int [] [] board){
    boolean st = false;    
       for(int i=0; i<8; i++)
       {
           for(int j=0; j<8; j++)
           {
               if (board[i][j] == board[i+1][j]){
                    st = true;
                    System.out.println("You have repeating number(s) in the same column");                                      
               }
               else{
                   st = false;
               }
           }           
       }
    return st;    
}
static boolean isInBox(int [] [] board){
    boolean st = false;        
        int i;
        int j;
       for( i=0; i<8; i++)
       {
           for( j=0; j<8; j++)
           {
               int localBoxRow = i - i%3;
               int localBoxCol = j - j%3;
               
                for( i = localBoxRow; i<localBoxRow+3; i++){
                    for(j = localBoxRow; j<localBoxCol+3; j++){
                    if (board[localBoxRow][localBoxRow] == board[localBoxRow][localBoxRow+1]){
                        
                        st = true;
                        System.out.println("You have repeating number(s) in a 3 x 3 box");                        
                    }
                    else{
                        st = false;
                        
                    }
                    }
                    
                }
           }           
       }
       return st;
}


}
