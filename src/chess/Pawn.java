package chess;

public class Pawn extends Piece
{
    
    public Pawn()
    {
	x=0;
	y=0;
    }
    
    public boolean color(int plr, int a, int b, char arr[][] )
    {
        boolean counter=false; //Boolean der viser om move er lovligt eller ikke
	if(arr[x][y+1]=='K') // if condition der tjekker om der er en konge
	{
            counter=true;
            return counter;
	}
	if(plr==1) //Checker for player 1
	{
            for(int i=a+2; i<=x; i++) // Loop der går fra top til tå
            {
		if(arr[i][b]=='B'||arr[i][b]=='W') // Checker at ingen brik er i det index
		{
                    counter=true;
                    break;
		}
            }
	}
	else
	{
            for(int i=a-2; i>=x; i--) // Loop der går fra tå til top
            {
                if(arr[i][b]=='B'||arr[i][b]=='W') // Checker at ingen brik er i det index
		{
                    counter=true;
                    break;
		}
            }
	}
            return counter;
	}
    public boolean check(int m, int n, char arr[][])
    {
        if(arr[m][n]=='P')
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
        System.out.println("The piece is a Pawn\n");
    }
    public void cal( int i, int j,char arr[][])
    {
        for(int k=0; k<41; k++)	//Loop der checker og gemmer indexet for rækken
	{
            if(arr[k][0]==i)
            {
                x=k;
		break;
            }
	}
        for(int k=0; k<41; k++) //Loop der checker og gemmer indexet for kolonne
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
        if(plr==1)
        {
            if(x>a)
            {
                if(a==8 && x-a<=10 && x-a>0 && y==b && color(plr, a, b, arr)==false) //Checker for pawns på init position, og inkludere farve funktionen
		{
                    arr[x][y]=arr[a][b];
                    arr[x][y+1]=arr[a][b+1];
                    arr[a][b]=arr[a][b-1];
                    arr[a][b+1]=arr[a][b-1];
                    return false;
		}
                else if(x-a==5&&y==b&&color(plr, a, b, arr)==false) //Checker for pawns ikke p init posistion, og iknludere også farve funkntionen
		{
                    arr[x][y]=arr[a][b];
                    arr[x][y+1]=arr[a][b+1];
                    arr[a][b]=arr[a][b-1];
                    arr[a][b+1]=arr[a][b-1];
                    return false;
                }
                else if(x-a==5&&(y==b-5||y==b+5)&&arr[x][y]=='W') //Checker for pawns på init posistion, og iknludere check hvis den hvide ikke er tilstede.
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
            else
            {
		return true;
            }
        }
	else
        {
            if(x<a) //Det samme for player 2
            {
		if(a==33&&a-x<=10&&a-x>0&&y==b&&color(plr, a, b, arr)==false)
		{
                    arr[x][y]=arr[a][b];
                    arr[x][y+1]=arr[a][b+1];
                    arr[a][b]=arr[a][b-1];
                    arr[a][b+1]=arr[a][b-1];
                    return false;
                }
                else if(a-x==5&&y==b&&color(plr, a, b, arr)==false)
                {
                    arr[x][y]=arr[a][b];
                    arr[x][y+1]=arr[a][b+1];
                    arr[a][b]=arr[a][b-1];
                    arr[a][b+1]=arr[a][b-1];
                    return false;
                }
		else if(a-x==5&&(y==(b-5)||y==(b+5))&&arr[x][y]=='B')
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
            else
            {
                return true;
            }
        }
    }
    public boolean check_mate(int plr, int a, int b, char arr[][]) 
    {
        if(plr==1)
        {
            if(a==8)
            {
                if(arr[a+5][b]=='W')
		{
                    if(arr[a+5][b+1]=='K')
                    {
                        return true;
                    }
                }
                else if(arr[a+10][b]=='W')
                {
                    if(arr[a+10][b+1]=='K')
                    {
                        return true;
                    }
		}
            }
            else
            {
                if(arr[a+5][b]=='W') //Checker for bånder ved ikke initial positions
		{
                    if(arr[a+5][b+1]=='K')
                    {
			return true;
                    }
                }
            }
        }
        else
        {
            if(a==33)	
            {
                if(arr[a-5][b]=='W')
                {
                    if(arr[a-5][b+1]=='K')
                    {
                    	return true;
                    }
                }
                else if(arr[a-10][b]=='W')
		{
                    if(arr[a-10][b+1]=='K')
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(arr[a-5][b]=='W')
                {
                    if(arr[a-5][b+1]=='K')
                    {
                        return true;
                    }
                }
            }
        }
            return false;
    }
}