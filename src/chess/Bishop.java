package chess;

public class Bishop extends Piece
{
    public boolean check(int m, int n, char arr[][]){
        if(arr[m][n]=='B'){
            return true;
	}
	else
    	{
        	return false;
        }
    }
    public void printName() 
    {
        System.out.println("The piece is a Bishop");
    }
    
    public boolean color(int plr,int a, int b, char arr[][])
    {
        int i=0, j=0;
	boolean counter=false;
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
        else if(x>a&&y<b)
	{
            for( i=a+1, j=b-1; i<=x && j>=y; i++, j--)
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
        else if(x>a && y>b)
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
        if(((x-a)*(x-a)==(y-b)*(y-b))&& color(plr, a, b, arr)==false && y!=b)
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
        for(int i = a+1,j = b+1; i<40 && j<40; i++, j++)
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
            for(int i=a-1, j=b-1; i>2 && j>2; i--, j--)
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
                        counter = true;
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
        return counter;
    }
}