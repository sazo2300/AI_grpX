package chess;

public class Queen extends Piece
{

public boolean check(int m, int n, char arr[][])
	{
		if(arr[m][n]=='Q')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void printName()
	{
            System.out.println("The piece is a Queen");
		
	}

	boolean color(int plr, int a, int b, char arr[][])
	{
		boolean counter=false;
		int i=0, j=0;
		if(arr[x][y+1]=='K')
		{
			counter=true;
			return counter;
		}
		if(x<a&&y<b)
		{
			for( i=a-1, j=b-1; i>=x && j>=y; i--, j--)
			{
				if(plr==1&&(arr[i][j]=='B'||(arr[i][j]=='W'&&i!=x&&j!=y)))
				{
					counter=true;
					break;
				}
				else if(plr==2&&(arr[i][j]=='W'||(arr[i][j]=='B'&&i!=x&&j!=y)))
				{
					counter=true;
					break;
				}
			}
		}
		else if(x<a&&y>b)
		{
			for( i=a-1, j=b+1; i>=x && j<=y; i--, j++)
			{
				if(plr==1&&(arr[i][j]=='B'||(arr[i][j]=='W'&&i!=x&&j!=y)))
				{
					counter=true;
					break;
				}
				else if(plr==2&&(arr[i][j]=='W'||(arr[i][j]=='B'&&i!=x&&j!=y)))
				{
					counter=true;
					break;
				}
			}
		}
		else if(x>a && y<b)
		{
			for( i=a+1, j=b-1; i<=x && j>=y; i++, j--)
			{
				if(plr==1 &&(arr[i][j]=='B'||(arr[i][j]=='W' && i!=x &&j!=y)))
				{
					counter=true;
					break;
				}
				else if(plr==2&&(arr[i][j]=='W'||(arr[i][j]=='B'&&i!=x&&j!=y)))
				{
					counter=true;
					break;
				}
			}
		}
		else if(x>a&&y>b)
		{
			for( i=a+1, j=b+1; i<=x && j<=y; i++, j++)
			{
				if(plr==1&&(arr[i][j]=='B'||(arr[i][j]=='W'&&i!=x&&j!=y)))
				{
					counter=true;
					break;
				}
				else if(plr==2&&(arr[i][j]=='W'||(arr[i][j]=='B'&&i!=x&&j!=y)))
				{
					counter=true;
					break;
				}
			}
		}
		else if(x==a)
		{
			if(y>b)
			{
				for(int ii=b+1; ii<=y; ii++)
				{
					if(plr==1 && ((arr[a][ii]=='B')||(arr[a][ii]=='W'&& ii<y)))
					{
						counter=true;
						break;
					}
					else if(plr==2&&(arr[a][ii]=='W'||(arr[a][ii]=='B' && ii!=y)))
					{
						counter=true;
						break;
					}
				}
			}
			else
			{
				for(int ii=b-1; ii>=y; ii--)
				{
					if(plr==1 && (arr[a][ii]=='B'||(arr[a][ii]=='W' && ii!=y)))
					{
						counter=true;
						break;
					}
					else if(plr==2&&(arr[a][ii]=='W'||(arr[a][ii]=='B'&& ii!=y)))
					{
						counter=true;
						break;
					}
				}
			}
		}
		else if(y==b)
		{
			if(x>a)
			{
				for(int ii=a+1; ii<=x; ii++)
				{
					if(plr==1&&(arr[ii][b]=='B'||(arr[ii][b]=='W'&& ii!=x)))
					{
						counter=true;
						break;
					}
					else if(plr==2&&(arr[ii][b]=='W'||(arr[ii][b]=='B'&& ii!=x)))
					{
						counter=true;
						break;
					}
				}
			}
			else
			{
				for(int ii=a-1; ii>=x; ii--)
				{
					if(plr==1 &&( arr[ii][b]=='B'||(arr[ii][b]=='W'&& ii!=x)))
					{
						counter=true;
						break;
					}
					else if(plr==2&&(arr[ii][b]=='W'||(arr[ii][b]=='B'&& ii!=x)))
					{
						counter=true;
						break;
					}
				}
			}
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
		if(((x==a&&y!=b)||(x!=a&&y==b))&&color(plr, a, b, arr)==false)
		{
			arr[x][y]=arr[a][b];
			arr[x][y+1]=arr[a][b+1];
			arr[a][b]=arr[a][b-1];
			arr[a][b+1]=arr[a][b-1];
			return false;
		}
		else if(((x-a)*(x-a)==(y-b)*(y-b))&&color(plr, a, b, arr)==false)
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
		char C='a';
		if(plr==1)
		{
			C='W';
		}
		else
		{
			C='B';
		}
		for(int i=a+1,j=b+1; i<40 && j<40; i++, j++)
		{
			if(arr[i][j]==C)
			{
				if(arr[i][j+1]=='K')
				{
					counter=true;
				}
				break;
			}
		}
		if(counter==false)
		{
			for(int i=a-1,j=b-1; i>2 && j>2; i--, j--)
			{
				if(arr[i][j]==C)
				{
					if(arr[i][j+1]=='K')
					{
						counter=true;
					}
					break;
				}
			}
		}
		if(counter==false)
		{
			for(int i=a-1, j=b+1; i>2 && j<40; i--, j++)
			{
				if(arr[i][j]==C)
				{
					if(arr[i][j+1]=='K')
					{
						counter=true;
					}
					break;
				}
			}
		}
		if(counter==false)
		{
			for(int i=a-1, j=b+1; i>2 && j<40; i--, j++)
			{
				if(arr[j][i]==C)
				{
					if(arr[j][i+1]=='K')
					{
						counter=true;
					}
					break;
				}
			}
		}
		for(int i=a+1; i<40; i++)
		{
			if(arr[i][b]==C)
			{
				if(arr[i][b+1]=='K')
				{
					counter=true;
					break;
				}
			}

		}
		if(counter==false)
		{
			for(int i=a-1; i>1; i--)
			{

				if(arr[i][b]==C)
				{
					if(arr[i][b+1]=='K')
					{
						counter=true;
						break;
					}
				}

			}
		}
		if(counter==false)
		{
			for(int i=a-1; i>1; i--)
			{

				if(arr[a][i]==C)
				{
					if(arr[a][i+1]=='K')
					{
						counter=true;
						break;
					}
				}

			}
		}
		if(counter==false)
		{
			for(int i=a+1; i<40; i++)
			{

				if(arr[a][i]==C)
				{
					if(arr[a][i+1]=='K')
					{
						counter=true;
						break;
					}
				}

			}
		}
		return counter;
	}
}