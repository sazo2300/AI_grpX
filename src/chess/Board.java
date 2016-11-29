package chess;

import java.util.Scanner;

public class Board 
{

    char[][] arr = new char [41][41];
    int m, n;
    Player first;
    Player second ;
    Piece piece[] = new Piece[1];
    
    Pawn pawn = new Pawn();
    Rook rok = new Rook();
    Bishop bishop = new Bishop();
    Knight knight = new Knight();
    Queen queen = new Queen();
    King king = new King();
    
    public Board()
    {
        
        char arr1[]={'1','2','3','4','5','6','7','8'};
        boolean check = false;
        int k = 0, count = 0, count1 = 0;
        first = new Player();
        second = new Player();

        m = 0;
        n = 0;
        for (int i = 1; i < 41; i++) {
            if (count1 == 5) {
                count1 = -1;
                i = i + 4;

            } else {
                count = 0;
                for (int j = 1; j < 41; j++) {

                    if (count == 5) {
                        count = 0;
                        j = j + 5;
                    }
                    if (j < 40) {
                        arr[i][j] = '.';
                    }

                    count++;
                }
            }
            count1++;
        }
        count1 = 0;
        for (int i = 6; i < 41; i++) {

            if (count1 == 5) {
                count1 = -1;
                i = i + 4;

            } else {
                count = 0;
                for (int j = 6; j < 41; j++) {

                    if (count == 5) {
                        count = 0;
                        j = j + 5;
                    }
                    if (j < 41) {
                        arr[i][j] = '.';
                    }

                    count++;
                }

            }
            count1++;
        }

        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 41; j++) {
                if (arr[i][j] != '.') {
                    arr[i][j] = ' ';
                }
            }

        }

        for (int i = 3, j = 0; i < 41; i = i + 5) {
            arr[i][j] = arr1[k];
            k++;
        }
        k = 0;
        for (int i = 3, j = 0; i < 41; i = i + 5) {
            arr[j][i] = arr1[k];
            k++;
        }


        for (int i = 3; i < 9; i = i + 5) {
            for (int j = 3; j < 40; j = j + 5) {
                arr[i][j] = 'B';
            }
        }

        for (int i = 38; i > 32; i = i - 5) {
            for (int j = 3; j < 40; j = j + 5) {
                arr[i][j] = 'W';
            }
        }

        for (int i = 8; i < 34; i++) {
            for (int j = 4; j < 41; j = j + 5) {
                arr[i][j] = 'P';
            }
            i = i + 24;
        }

        for (int i = 3; i < 41; i++) {
            for (int j = 4; j < 41; j = j + 35) {
                arr[i][j] = 'R';
            }
            i = i + 34;
        }

        for (int i = 3; i < 41; i++) {
            for (int j = 9; j < 41; j = j + 25) {
                arr[i][j] = 'N';
            }
            i = i + 34;
        }

        for (int i = 3; i < 41; i++) {
            for (int j = 14; j < 41; j = j + 15) {
                arr[i][j] = 'B';
            }
            i = i + 34;
        }

        for (int j = 19; j < 26; j = j + 5) {
            for (int i = 3; i < 41; i = i + 35) {
                if (j == 19) {
                    arr[i][j] = 'K';
                } else {
                    arr[i][j] = 'Q';
                }
            }
        }

    }

    public char[][] display() 
    {
        return arr;      
    }

    public int[] getScore()
    {
        final int totalPts=39;
        int p1Pts=0, p2Pts=0;
        
        for(int a=0;a<41;a++)
        {
            for(int b=0;b<41;b++)
            {
                if(arr[a][b]=='B') 
                {
                    b++;
                    if(arr[a][b]=='R')
                    {
                        p2Pts+=5;
                    }
                    else if(arr[a][b]=='N')
                    {
                        p2Pts+=3;
                    }
                    else if(arr[a][b]=='B')
                    {
                        p2Pts+=3;
                    }
                    else if(arr[a][b]=='Q')
                    {
                        p2Pts+=9;
                    }
                    else if(arr[a][b]=='P')
                    {
                        p2Pts++;
                    }
                }
                else if(arr[a][b]=='W') 
                {
                    b++;
                    if(arr[a][b]=='R')
                    {
                        p1Pts+=5;
                    }
                    else if(arr[a][b]=='N')
                    {
                        p1Pts+=3;
                    }
                    else if(arr[a][b]=='B')
                    {
                        p1Pts+=3;
                    }
                    else if(arr[a][b]=='Q')
                    {
                        p1Pts+=9;
                    }
                    else if(arr[a][b]=='P')
                    {
                        p1Pts++;
                    }
                }
            }
        }
        p1Pts=totalPts-p1Pts;
        p2Pts=totalPts-p2Pts;
        
        int score[] = new int[2];
        score[0] = p1Pts;
        score[1] = p2Pts;
        return score; 
    }

    public int character(boolean count, char arr[][])
	{
		boolean counter = false;
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                piece[0] = pawn;
            } else if (i == 1) {
                piece[0] = rok;
            } else if (i == 2) {
                piece[0] = bishop;
            } else if (i == 3) {
                piece[0] = knight;
            } else if (i == 4) {
                piece[0] = queen;
            } else if (i == 5) {
                piece[0] = king;
                counter = true;
            }
            if (piece[0].check(m, n + 1, arr) == true)	{
                piece[0].printName();
                break;
            }
        }
        if (count == true && counter == true) {
            return 0;
        } else if (count == true && counter == false) {
            return 1;
        } else {
            return 2;
        }
    }

    boolean pick_player_1(boolean counter, int a, int b) 
    {
        first.init(a, b);
        if (first.check(arr,1) == 1){
            m = first.get_row();
            n = first.get_col();
            if (character(counter, arr) == 1)
            {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    public boolean pick_player_2(boolean counter, int a, int b)
    {
        first.init(a,b);
        if (first.check(arr, 2) == 1) {
            m = first.get_row();
            n = first.get_col();
            if (character(counter, arr) == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    public boolean move(int plr, int x,int y)
    {
        piece[0].cal(x, y, arr);
        if (piece[0].movement(plr, m, n, arr) == true ){
            return true;
        }
        else
        {
            return false;
        }
    }

}
