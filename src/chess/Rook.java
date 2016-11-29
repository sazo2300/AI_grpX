package chess;

public class Rook extends Piece
{
    public boolean check(int m, int n, char arr[][])
    {
        if(arr[m][n]=='R')
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
        System.out.println("The piece is a Rook");
    }
    public boolean color(int plr, int a, int b, char arr[][])
    {
        boolean counter=false;
	int max=0, min=0;
	if(arr[x][y+1]=='K')
	{
            counter=true;
            return counter;
	}
        if(x==a)
	{
            if(y>b)
            {
                for(int i=b+1; i<=y; i++)
		{
                    if(plr==1&&((arr[a][i]=='B')||(arr[a][i]=='W'&&i<y)))
                    {
                        counter=true;
                        break;
                    }
                    else if(plr==2&&(arr[a][i]=='W'||(arr[a][i]=='B'&&i!=y)))
                    {
                        counter=true;
                        break;
                    }
                }
            }
            else
            {
                for(int i=b-1; i>=y; i--)
		{
                    if(plr==1&&(arr[a][i]=='B'||(arr[a][i]=='W'&&i!=y)))
                    {
                        counter=true;
                        break;
                    }
                    else if(plr==2&&(arr[a][i]=='W'||(arr[a][i]=='B'&&i!=y)))
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
                for(int i=a+1; i<=x; i++)
		{
                    if(plr==1&&(arr[i][b]=='B'||(arr[i][b]=='W'&&i!=x)))
                    {
                        counter=true;
                        break;
                    }
                    else if(plr==2&&(arr[i][b]=='W'||(arr[i][b]=='B'&&i!=x)))
                    {
                        counter=true;
                        break;
                    }
                }
            }
            else
            {
                for(int i=a-1; i>=x; i--)
		{
                    if(plr==1&&(arr[i][b]=='B'||(arr[i][b]=='W'&&i!=x)))
                    {
                        counter=true;
                        break;
                    }
                    else if(plr==2&&(arr[i][b]=='W'||(arr[i][b]=='B'&&i!=x)))
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