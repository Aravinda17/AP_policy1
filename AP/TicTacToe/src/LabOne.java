import java.util.Random;
import java.util.Scanner;

public class LabOne {

	public static void main(String[] args) 
	{
		Board abc;
		char [][] grid = new char [3][3];
		int i,j;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				grid[i][j]='-';
			}
		}
		System.out.println("1. Player1 vs Player2");
		System.out.println("2. Player1 vs Random");
		System.out.println("3. Random vs AI");
		System.out.println("4. AI vs Player1");
		Scanner scan = new Scanner(System.in);
		int ch;
		int x,y;
		ch=scan.nextInt();
		int user=1;
		char val;
		Random rand = new Random();
		if(ch==1)
		{
			//Player vs Player
			Board.printGrid(grid);
			while(Board.checkState(grid)==3)
			{
				if(user==1)
				{
					val='O';
				}
				else
				{
					val='X';
				}
				//System.out.println("\nx coordinate: \n");
				x=Integer.parseInt(scan.next());
				//System.out.println("\ny coordinate: \n");
				y=Integer.parseInt(scan.next());
				Board.put(x,y,val,grid);
				Board.printGrid(grid);
				user=user*(-1);
			}
			if(Board.checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(Board.checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(Board.checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else if(ch==2)
		{
			//Player vs Random
			Board.printGrid(grid);
			while(Board.checkState(grid)==3)
			{
				if(user==1)
				{
					val='O';
				}
				else
				{
					val='X';
				}
				if(user==1)
				{
					//System.out.println("\nx coordinate: \n");
					x=Integer.parseInt(scan.next());
					//System.out.println("\ny coordinate: \n");
					y=Integer.parseInt(scan.next());
				}
				else
				{
					x=rand.nextInt(3)+1;
					y=rand.nextInt(3)+1;
					while(grid[x-1][y-1]!='-')
					{
						x=rand.nextInt(3)+1;
						y=rand.nextInt(3)+1;
					}
				}
				Board.put(x,y,val,grid);
				Board.printGrid(grid);
				user=user*(-1);
			}
			if(Board.checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(Board.checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(Board.checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else if(ch==3)
		{
			//Random vs AI
			//check for win possibility
			Board.printGrid(grid);
			while(Board.checkState(grid)==3)
			{
				if(user==1)
				{
					val='O';
				}
				else
				{
					val='X';
				}
				if(user==-1)
				{
					if((grid[0][0]==grid[0][1]) && grid[0][0]=='X')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='X')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='X')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='X')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='X')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='X')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='X')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='X')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='X')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='X')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='X')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='X')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='X')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='X')
					{
						Board.putAI(1,3,'X',grid);
					}
					
					// Don't let him win
					
					
					else if((grid[0][0]==grid[0][1]) && grid[0][0]=='O')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='O')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='O')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='O')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='O')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='O')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='O')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='O')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='O')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='O')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='O')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='O')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='O')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='O')
					{
						Board.putAI(1,3,'X',grid);
					}
					else
					{
						x=rand.nextInt(3)+1;
						y=rand.nextInt(3)+1;
						while(grid[x-1][y-1]!='-')
						{
							x=rand.nextInt(3)+1;
							y=rand.nextInt(3)+1;
						}
						Board.putAI(x,y,val,grid);
					}
				}
				else
				{
					x=rand.nextInt(3)+1;
					y=rand.nextInt(3)+1;
					while(grid[x-1][y-1]!='-')
					{
						x=rand.nextInt(3)+1;
						y=rand.nextInt(3)+1;
					}
					Board.putAI(x,y,val,grid);
				}
				Board.printGrid(grid);
				System.out.println("\n");
				user=user*(-1);
			}
			if(Board.checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(Board.checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(Board.checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else if(ch==4)
		{
			//AI vs Player
			Board.printGrid(grid);
			while(Board.checkState(grid)==3)
			{
				if(user==1)
				{
					val='O';
				}
				else
				{
					val='X';
				}
				if(user==-1)
				{
					if((grid[0][0]==grid[0][1]) && grid[0][0]=='X')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='X')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='X')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='X')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='X')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='X')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='X')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='X')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='X')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='X')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='X')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='X')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='X')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='X')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='X')
					{
						Board.putAI(1,3,'X',grid);
					}
					
					// Don't let him win
					
					
					else if((grid[0][0]==grid[0][1]) && grid[0][0]=='O')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='O')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='O')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='O')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='O')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='O')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='O')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='O')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='O')
					{
						Board.putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='O')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='O')
					{
						Board.putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='O')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='O')
					{
						Board.putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='O')
					{
						Board.putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='O')
					{
						Board.putAI(1,3,'X',grid);
					}
					else
					{
						x=rand.nextInt(3)+1;
						y=rand.nextInt(3)+1;
						while(grid[x-1][y-1]!='-')
						{
							x=rand.nextInt(3)+1;
							y=rand.nextInt(3)+1;
						}
						Board.putAI(x,y,val,grid);
					}
				}
				else
				{
					//System.out.println("\nx coordinate: \n");
					x=Integer.parseInt(scan.next());
					//System.out.println("\ny coordinate: \n");
					y=Integer.parseInt(scan.next());
					Board.putAI(x,y,val,grid);
				}
				Board.printGrid(grid);
				System.out.println("\n");
				user=user*(-1);
			}
			if(Board.checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(Board.checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(Board.checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else
		{
			System.out.println("Invalid Selection");
		}
		

	}

}
