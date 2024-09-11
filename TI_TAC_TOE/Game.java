 package TI_TAC_TOE;
import java.util.*;
public class Game {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
            }
        }

        char player='X';
        boolean gameOver=false;

        Scanner sc=new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.print("Player "+player+" enter : ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            if(board[row][col]==' '){
                board[row][col]=player;
                gameOver=haveWon(board,player);
                if(gameOver){
                    printBoard(board);
                    System.out.println("player "+player+" has won the Game");
                }else{
                    player=(player=='X')?'O':'X';
                }
            }else{
                System.out.println("Place already occupied try again");
            }
        }
    }
    static boolean haveWon(char[][] baord,char player){
        for(int i=0;i<3;i++){
            if(baord[i][0]==player && baord[i][1]==player && baord[i][2]==player){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(baord[0][i]==player && baord[1][i]==player && baord[2][i]==player){
                return true;
            }
        }

        if(baord[0][0]==player && baord[1][1]==player && baord[2][2]==player){
            return true;
        }
        if(baord[0][2]==player && baord[1][1]==player && baord[2][0]==player){
            return true;
        }
        return false;
    }
    static void printBoard(char[][] board){
        for(int i=0;i<3;i++){
            System.out.println("------");
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
