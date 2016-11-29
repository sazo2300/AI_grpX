package chess;

public class MyAI {
    private long deadline = 5;
    Board state = new Board();  //obj for board klasse
    Chess chess = new Chess();  //obj for chess klasse
    Piece[] pc = new Piece[1];
    
    int[] result = new int[2];
    int player = 0;
    boolean checkmate = false;
	public MyAI(int plyr, Board state) //contructor til at sætte player i starten
        {
            
            player = plyr;
            
	}
        
        //Det her er selve algoritmen og den udregner det bedste move med alpha beta pruning.
	public int[] getMove(Board state) {
            
            
            long start = System.currentTimeMillis();
            long end = start + deadline*1000;
		int depth_cut_off=10;
		int x=0,y=0;
		int alpha=Integer.MIN_VALUE , beta=Integer.MAX_VALUE;
		int oponent=1;
		player=2;
		int depth=depth_cut_off-1;
		
		int V=Integer.MIN_VALUE;
		int prunning=0;
               // int i = 0;
                //while(System.currentTimeMillis() < end){
		for(int i=0; i<41; ++i){
                    //if(i<41) //huskhusk
			for(int j=0; j<41; ++j){
				
				if(state.pick_player_2(checkmate, i,j)==false) {
					Board newBoard; 
                                        newBoard = state;
                                        pc[0].cal(i, j, state.arr);
                                        pc[0].movement(2,i,j,state.arr);
                                        if(depth==0)  
					{
						if(chess.win(newBoard)==player)
						{
							x=i;
							y=j;
                                                        result[0] = x;
                                                        result[1] = y;
                                                        return result;
							
						}
						if(chess.win(newBoard)==0)
						{
							x=i;
							y=j;
                                                        result[0] = x;
                                                        result[1] = y;
                                                        return result;
							
						}
						V=Heuristic_Evaluation_Functions(newBoard);
						if(V>=beta) 
						{
							x=i;
							y=j;
                                                        result[0] = x;
                                                        result[1] = y;
                                                        return result;
						}
						if(alpha<V)
						{
							alpha=V;
							x=i;
							y=j;
						}
						
					}
					else
					{
						if(chess.win(newBoard)==player)
						{
							x=i;
							y=j;
                                                        result[0] = x;
                                                        result[1] = y;
                                                        return result;
						}
						if(chess.win(newBoard)==oponent)   
						{
							x=i;
							y=j;
                                                        result[0] = x;
                                                        result[1] = y;
                                                        return result;
						}
						if(chess.win(newBoard)==0)
						{
							x=i;
							y=j;
                                                        result[0] = x;
                                                        result[1] = y;
                                                        return result;
						}
						V=Alpha_Beta_pruning(newBoard,Integer.MIN_VALUE,beta,depth,oponent);
						if(V>=beta)
						{
							x=i;
							y=j;
                                                        result[0] = x;
                                                        result[1] = y;
                                                        return result;
						}
						if(alpha<V)
						{
							alpha=V;
							x=i;
							y=j;
						}
					}
                                    //++i;
				}
			}
		}
                result[0] = x;
                result[1] = y;
                return result;
	}
	
	public int Alpha_Beta_pruning(Board state , int alpha, int beta, int depth,int turn)
	{
            int player = 2;
            int oponent =1;
            
            depth--;
		if(turn==player) 
		{
			int V=Integer.MIN_VALUE;
			int prunning=0;
			for(int i=0; i<41; ++i)
			{
				for(int j=0; j<41; ++j)
				{
					
					if(state.pick_player_2(checkmate, i,j)==false){
						Board newBoard;
						newBoard = state;
                                                newBoard.move(2,i,j);
						if(chess.win(newBoard)==player)
							return 100;
						if(chess.win(newBoard)==oponent)
							return -100;
						if(chess.win(newBoard)==0)
							return -99;
						if(depth==0)
						{
			 				if(chess.win(newBoard)==player)
								return 100;
							if(chess.win(newBoard)==oponent)
								return -100;
							if(chess.win(newBoard)==0)
								return -99;
							V=Heuristic_Evaluation_Functions(newBoard);
							if(V>=beta)
								return alpha;
							if(alpha<V)
								alpha=V;
						}
						else
						{   
							V=Alpha_Beta_pruning(newBoard,alpha,Integer.MAX_VALUE,depth,oponent);
							if(V>=beta)
								return alpha;
							if(alpha<V)
								alpha=V;
						}
					}
				}
				
			}
			return alpha;   
		}
		else    
		{       
			int V=Integer.MIN_VALUE;
			for(int i=0; i<41; ++i)
			{
				for(int j=0; j<41; ++j)
				{
					if(state.pick_player_1(checkmate, i,j)==false)
					{
						if(state.pick_player_1(checkmate, i,j)==false)
						{
							Board newBoard;
							newBoard = state;
                                                        newBoard.move(1,i,j);
							if(chess.win(newBoard)==player)
								return 100;
							if(chess.win(newBoard)==oponent)
								return -100;
							if(chess.win(newBoard)==0)
								return -99;
							if(depth==0)
							{
								if(chess.win(newBoard)==player)
									return 100;
								if(chess.win(newBoard)==oponent)
									return -100;
								if(chess.win(newBoard)==0)
									return -99;
								V=Heuristic_Evaluation_Functions(newBoard);
								if(V<=alpha)
									return beta;
								if(beta>V)
									beta=V;
							}
							else
							{
								V=Alpha_Beta_pruning(newBoard,Integer.MIN_VALUE,beta,depth,player);
								if(V<=alpha)
									return beta;
								if(beta>V)
									beta=V;
							}
							
						}
					}
				}
			}
			return beta;
		}
	}

	public int Heuristic_Evaluation_Functions(Board state)
	{
		
		int player1=0,player2=0;
		player1=winning_possibility(state,1);
		player2=winning_possibility(state,2);
		if(player==1)
			return player1-player2;
		else	
			return  player2-player1;
	}

	public int winning_possibility(Board state,int p)
	{
		int cal=0;
		int count_check=0;
		int count=0;
                int []scores = new int[2];
                scores=state.getScore();
                int K =scores[1]-scores[0];
				

		for(int k=0;k<41;k++)
		{
			for(int i=0;i<=41-K;i++)
			{
				count_check=0;
				for(int j=i;j<K+i;j++)
				{
                                    
                                    if(state.pick_player_1(checkmate, k,j)!=false)
                                    {
                                        count_check=1;
					break;
                                    }
                                    else if(state.pick_player_2(checkmate,k,j)!=false)
                                    {
                                        count_check=1;
					break;
                                    }
				}
				if(count_check==0)
					cal++;
			}
		}
		
		for(int k=0;k<41;k++)
		{
			for(int i=0;i<=41-K;i++)
			{
				count_check=0;
				for(int j=i;j<K+i;j++)
				{
					if(state.pick_player_1(checkmate, k,j)!=false)
                                    {
                                        count_check=1;
					break;
                                    }
                                    else if(state.pick_player_2(checkmate,k,j)!=false)
                                    {
                                        count_check=1;
					break;
                                    }
				}
				if(count_check==0)
					cal++;
			}
		}
		
		
		for(int j=0; j<41-(K-1); ++j)
		{
			for(int i=K-1; i<41; ++i)
			{
				int t=i;
				int s=j;
				count=0;
				for(int k=0;k<K;k++)
				{
                                    if(state.pick_player_1(checkmate, k,j)==false)
                                    {
                                        count++;
                                        t--;
                                        s++;
                                    }
                                    else if(state.pick_player_2(checkmate,k,j)==false)
                                    {
                                        count++;
                                        t--;
                                        s++;
                                    }
                                    
				}
				if(count==scores[1]-scores[0])
					cal++;
			}
		}
		
		
		for(int j=0; j<41-(K-1); ++j)
		{
			for(int i=41-K; i>=0; --i)
			{
				int t=i;
				int s=j;
				count=0;
				for(int k=0;k<K;k++)
				{
                                    if(state.pick_player_1(checkmate,k,j)==false)	
                                    {
						count++;
						s++;
						t++;
                                    }
                                    else if(state.pick_player_2(checkmate,k,j)==false)	
                                    {
						count++;
						s++;
						t++;
                                    }
				}
				if(count==scores[1]-scores[0])
					cal++;
			}
		}
		
		return cal;
	}

        
	public int[] getMove(Board state, int deadline) 
	{
		return getMove(state);
	}
}