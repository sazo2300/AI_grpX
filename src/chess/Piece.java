package chess;

abstract class Piece {
    //Beskyttede attribytter brugt til at rykke brikkerne til det næste valgte index.
    protected int x, y;
    public Piece()
    {}
    abstract boolean check(int m,int n,char[][] arr);                           //Checker hvilken brik der er valgt til at blive rykket.
    abstract boolean color(int plr, int a, int b, char[][] arr);		//Checker farven på den valgte brik
    abstract void printName();							//Returnerer brikkens navn
    abstract void cal(int i, int j, char[][] arr);				//pure virtual function which cal the indexis where we are desired to move the piece
    abstract boolean movement(int plr, int a, int b, char[][] arr);		//Metoden til faktisk at rykke
    abstract boolean check_mate(int plr, int a, int b, char[][] arr);           //Checker for skakmat for den givne brik.
}