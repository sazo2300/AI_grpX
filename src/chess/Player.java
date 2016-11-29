package chess;

public class Player
{
	int x, y;
	int m, n, counter;
public void init(int i, int j) //init start værdier 
	{
		x=i;
		y=j;
		m=0;
		n=0;
		counter=0;
	}
	public int check(char arr[][], int turn) //Checker indeks for at vælge piece og sætter ind i attribytter.
	{
		int  count=0;
		for(int i=0; i<40; i++)
		{
			if(arr[i][0]==x)
			{
				m=i;
				break;
			}

			if(i==39)
			{
                            count=1;
			}
		}
		if(count==0)
		{
			for(int i=0; i<40; i++)
			{
				if(arr[0][i]==y)
				{
					n=i;
					break;
				}

				if(i==39)
                                {
                                    count=1;
				}
			}
		}
		if((turn==1&&arr[m][n]=='B')||(turn==2&&arr[m][n]=='W')) //Checker om det er sort eller hvid
		{
			counter=1;
			return counter;
		}
		else
		{
			counter=0;
		}
		return counter;
	}
	int get_row() //Returnerer original række af hvor brikken er nu.
	{
		return m;
	}
	int get_col() //Returnerer original kolonne af hvor brikken er nu.
	{
		return n;
	}

}