package chess;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * DEPRECATED! use chess_v2
 * 
 */
public class Chess {

    Chess(){
    }

    public int check_mate(int plr, Board obj)
{
	int counter=0;
	for(int i=0; i<41; i++)
	{
		for(int j=0; j<41; j++)
		{
			if(counter==2)
			{
				break;
			}
			if(plr==1){
				if(obj.arr[i][j]=='B')
				{
					if(obj.arr[i][j+1]=='P')
					{
						obj.piece[0]=obj.pawn;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='R')
					{
						obj.piece[0]=obj.rok;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='K')
					{
						obj.piece[0]=obj.knight;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='B')
					{
						obj.piece[0]=obj.bishop;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='Q')
					{
						obj.piece[0]=obj.queen;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='K')
					{
						obj.piece[0]=obj.king;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
				}
			}
			else
			{
				if(obj.arr[i][j]=='W'){
					if(obj.arr[i][j+1]=='P')
					{
						obj.piece[0]=obj.pawn;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='R')
					{
						obj.piece[0]=obj.rok;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='K')
					{
						obj.piece[0]=obj.knight;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='B')
					{
						obj.piece[0]=obj.bishop;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='Q')
					{
						obj.piece[0]=obj.queen;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
					else if(obj.arr[i][j+1]=='K')
					{
						obj.piece[0]=obj.king;
						if(obj.piece[0].check_mate(plr, i, j, obj.arr)==true)
						{
							counter++;
						}
					}
				}
			}
		}
	}
	return counter;
}

    public int win(Board obj){
	boolean first_loss=false, second_loss=false; 
	for(int i=3; i<41; i++)
	{
		for(int j=0; j<41; j++)
		{
			if(obj.arr[i][j]=='B')
			{
				first_loss=true;
			}
			else if(obj.arr[i][j]=='W')
			{
				second_loss=true;
			}
		}
	}
	if(first_loss==true && second_loss==false)
	{
		return 1;
	}
	else if(first_loss==false && second_loss==true)
	{
		return 2;
	}
	else
	{
		return 3;
	}

}

    public static void main(String[] args) {
        Chess chess=new Chess();
        Board obj = new Board();
        char[][] arr = new char [41][41];
        arr = obj.display();
        
        char x,y;
        Scanner in = new Scanner(System.in);
	boolean count=false, checkmate=false;
        int[] score = new int[2];
        score = obj.getScore(); 

	for (int c = 0; c < 41; c++)
        {
            for (int d = 0; d < 41; d++) {
                System.out.print(arr[c][d]);
            }
            System.out.println();
        }
        score = obj.getScore();
        System.out.println("====================");
        System.out.println("Your Points: "+score[0]+"\nComputer's Points: "+score[1]);
        System.out.println("====================");
	
        int choice = 0;
        int start=0;

        System.out.println("Choose one: ");
        System.out.println("1 - I start");
        System.out.println("2 - Computer starts");
        choice = in.nextInt();
            if(choice==1)
            {
                start=0;
            }
            else if (choice == 2)
            {
                start++;
            }
        for(int i=start; i<100; i++)
	{
            
		count=false;
                
                if(i%2==0)  
                {
                    System.out.println("Please enter the y value for the piece you wish to move:");
                    x = in.next().charAt(0);
                    System.out.println("Please enter the x value for the piece you wish to move:");
                    y = in.next().charAt(0);
                    if(x!='0'&& y!='0')
                    {
                            if(i%2==0)
                            {
                                    if(obj.pick_player_1(checkmate, x, y)==false)
                                    {
                                        System.out.println("Please enter the y value for where you want to move the piece to:");
                                        x = in.next().charAt(0);
                                        System.out.println("Please enter the x value for where you want to move the piece to:");
                                        y = in.next().charAt(0);
                                            if(obj.move(1,x,y)==true)
                                            {
                                                System.out.println("Invalid move... Please try again with a different index.");
                                                    i--;
                                            }
                                            else
                                            {
                                                for (int c = 0; c < 41; c++) 
                                                {
                                                    for (int d = 0; d < 41; d++) {
                                                        System.out.print(arr[c][d]);
                                                    }
                                                    System.out.println();
                                                }
                                                 score = obj.getScore();
                                                System.out.println("====================");
                                                System.out.println("Your Points: "+score[0]+"\nComuter's Points: "+score[1]);
                                                System.out.println("====================");
                                            }

                                    }
                                    else   
                                    {
                                        for (int c = 0; c < 41; c++) 
                                        {
                                            for (int d = 0; d < 41; d++) {
                                                System.out.print(arr[c][d]);
                                            }
                                            System.out.println();
                                        }
                                        score = obj.getScore();
                                        System.out.println("====================");
                                        System.out.println("Your Points: "+score[0]+"\nComputer's Points: "+score[1]);
                                        System.out.println("====================");
                                            System.out.println("Invalid input...The piece at "+x+" , "+y + " Is not your piece.");
                                            System.out.println("Please try again");
                                            i--;
                                    }
                            }
                    }
                    else
                    {
                            --i;
                    }
                }
                else 
                {
                    Random rand = new Random();
                    boolean done = false;
                    for(char x_='1';x_<='8';x_++)
                    {
                        {
                        int ax = rand.nextInt(7)+1;
                        char y_=(char)('0' + ax);
                        
                               if(obj.pick_player_2(checkmate,x_, y_)==false)
                               {
                                   int[] res = new int[2];
                                   MyAI AI = new MyAI(2,obj);
                                   res = AI.getMove(obj);
                                   for(char xx_='1';xx_<='8';xx_++)
                                   {
                                       for(char yy_='1';yy_<='8';yy_++)
                                       {
                                           if(obj.move(2,xx_,yy_)==false)
                                           {
                                               for (int c = 0; c < 41; c++) 
                                                {
                                                    for (int d = 0; d < 41; d++) {
                                                        System.out.print(arr[c][d]);
                                                    }
                                                    System.out.println();
                                                }
                                               score = obj.getScore();
                                                System.out.println("====================");
                                                System.out.println("Your Points: "+score[0]+"\nComputer's Points: "+score[1]);
                                                System.out.println("====================");
                                                done = true;
                                                break;
                                           }
                                       }
                                       if(done == true)
                                       break;
                                   }
                                   if(done == true)
                                       break;
                               }else
                                    {
                                        
                                         score = obj.getScore();
                                        i--;
                                    }
                        }if(done==true)
                            break;
                    }
                }
		if(chess.win(obj)==1) 
		{
                    System.out.println("============================");
                    System.out.println("YOU HAVE WON THE GAME");
                    System.out.println("============================");
			break;
		}
		else if(chess.win(obj)==2)
		{
                    System.out.println("============================");
                    System.out.println("YOU HAVE LOST THE GAME\nCOMPUTER WINS");
                    System.out.println("============================");
			break;
		}
        }
    }
}
