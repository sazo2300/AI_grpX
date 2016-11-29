package chess;

public class Knight extends Piece
{

        public boolean check(int m, int n, char arr[][])
        {
		if(arr[m][n]=='N')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void printName()
	{
            System.out.println("The piece is a Knight");
	}

	public boolean color(int plr,int a, int b, char arr[][])
	{
		boolean counter=false;
		if(arr[x][y+1]=='K')
		{
			counter=true;
			return counter;
		}
		if(plr==1&&arr[x][y]=='B')
		{
			counter=true;
		}
		else if(plr==2&&arr[x][y]=='W')
		{
			counter=true;
		}
		return counter;
	}

	public void cal( int i, int j,char arr[][])
	{

		for(int k=0; k<41; k++)
		{
			if(arr[k][0]==i)
			{
				x=k;
				break;
			}
		}
		for(int k=0; k<41; k++)
		{
			if(arr[0][k]==j)
			{
				y=k;
				break;
			}
		}

	}

	public boolean movement(int plr, int a, int b ,char arr[][])
	{
		if((x==a-10||x==a+10)&&(y==b+5||y==b-5)&&color(plr, a, b, arr)==false)
		{
			arr[x][y]=arr[a][b];
			arr[x][y+1]=arr[a][b+1];
			arr[a][b]=arr[a][b-1];
			arr[a][b+1]=arr[a][b-1];
			return false;
		}
		else if((x==a-5||x==a+5)&&(y==b+10||y==b-10)&&color(plr, a, b, arr)==false)
		{
			arr[x][y]=arr[a][b];
			arr[x][y+1]=arr[a][b+1];
			arr[a][b]=arr[a][b-1];
			arr[a][b+1]=arr[a][b-1];
			return false;
		}
		else
		{

			return true;
		}
	}

	public boolean check_mate(int plr, int a, int b, char arr[][])
	{
		boolean counter=false;
		if(plr==1)
		{
			if(arr[a+10][b-5]=='W')
			{
				if(arr[a+10][b-4]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-10][b-5]=='W' && counter==false && arr.length>0)
			{
				if(arr[a-10][b-4]=='K')
				{
					counter=true;
				}
			}
			if(arr[a+10][b+5]=='W'&&counter==false)
			{
				if(arr[a+10][b+4]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-10][b+5]=='W'&&counter==false)
			{
				if(arr[a-10][b+4]=='K')
				{
					counter=true;
				}
			}//
			if(arr[a+5][b-10]=='W'&&counter==false)
			{
				if(arr[a+5][b-10]=='K')
				{
					counter=true;
				}
			}
			if(arr[a+5][b+10]=='W'&&counter==false)
			{
				if(arr[a+5][b+10]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-5][b-10]=='W'&&counter==false)
			{
				if(arr[a-5][b-10]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-5][b+10]=='W'&&counter==false)
			{
				if(arr[a-5][b+10]=='K')
				{
					counter=true;
				}
			}
		}
		else
		{
			if(arr[a+10][b-5]=='B'&&counter==false && arr.length>0)
			{
				if(arr[a+10][b-4]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-10][b-5]=='B'&&counter==false)
			{
				if(arr[a-10][b-4]=='K')
				{
					counter=true;
				}
			}
			if(arr[a+10][b+5]=='B'&&counter==false)
			{
				if(arr[a+10][b+4]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-10][b+5]=='B'&&counter==false)
			{
				if(arr[a-10][b+4]=='K')
				{
					counter=true;
				}
			}//
			if(arr[a+5][b-10]=='B'&&counter==false)
			{
				if(arr[a+5][b-10]=='K')
				{
					counter=true;
				}
			}
			if(arr[a+5][b+10]=='B'&&counter==false)
			{
				if(arr[a+5][b+10]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-5][b-10]=='B'&&counter==false)
			{
				if(arr[a-5][b-10]=='K')
				{
					counter=true;
				}
			}
			if(arr[a-5][b+10]=='B'&&counter==false)
			{
				if(arr[a-5][b+10]=='K')
				{
					counter=true;
				}
			}
		}
		return false;
	}
}