package chess;

public class King extends Piece{

public boolean check(int m, int n, char arr[][]){
		if(arr[m][n]=='K')
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
            System.out.println("The piece is a King");
	}

	public boolean color(int plr, int a, int b, char arr[][])
	{
		boolean counter=false;
		if(arr[x][y+1]=='K')
		{
			counter=true;
			return counter;
		}
		if(plr==1&&arr[x][y]=='B')  //Hvis den er sort
		{
			counter=true;
		}
		else if(plr==2&&arr[x][y]=='W') //Hvis den er hvid
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
		if(((x-a)*(x-a)==25&&(y-b)*(y-b)==0)&&color(plr, x, y, arr)==false)
		{
			arr[x][y]=arr[a][b];
			arr[x][y+1]=arr[a][b+1];
			arr[a][b]=arr[a][b-1];
			arr[a][b+1]=arr[a][b-1];
			return false;
		}
		else if(((x-a)*(x-a)==0&&(y-b)*(y-b)==25)&&color(plr, x, y, arr)==false)
		{
			arr[x][y]=arr[a][b];
			arr[x][y+1]=arr[a][b+1];
			arr[a][b]=arr[a][b-1];
			arr[a][b+1]=arr[a][b-1];
			return false;
		}
		else if(((x-a)*(x-a)==25&&(y-b)*(y-b)==25)&&color(plr, x, y, arr)==false)
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
		if(arr[a-5][b]==C)
		{
			if(arr[a-5][b+1]=='K')
			{
				counter=true;
			}
		}
		if(arr[a+5][b]==C&&counter==false)
		{
			if(arr[a+5][b+1]=='K')
			{
				counter=true;
			}
		}
		if(arr[a][b-5]==C&&counter==false)
		{
			if(arr[a][b-4]=='K')
			{
				counter=true;
			}
		}
		if(arr[a][b+5]==C&&counter==false)
		{
			if(arr[a][b+6]=='K')
			{
				counter=true;
			}
		}
		if(arr[a-5][b-5]==C&&counter==false)
		{
			if(arr[a-5][b-4]=='K')
			{
				counter=true;
			}
		}
		if(arr[a-5][b+5]==C&&counter==false)
		{
			if(arr[a-5][b+6]=='K')
			{
				counter=true;
			}
		}
		if(arr[a-5][b-5]==C&&counter==false)
		{
			if(arr[a-5][b-4]=='K')
			{
				counter=true;
			}
		}
		if(arr[a+5][b+5]==C&&counter==false)
		{
			if(arr[a+5][b+6]=='K')
			{
				counter=true;
			}
		}
		return counter;
	}
}