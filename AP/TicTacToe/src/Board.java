import java.util.Scanner;
import java.util.Random;
public class Board 
{
	
	public static void printGrid(char[][] grid)
	{
		int i;
		int j;
		for(i=0;i<3;i++)
		{
			System.out.println("\n");
			for(j=0;j<3;j++)
			{
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
		}
	}
	
	public static int hasWon(char[][] grid)
	{
		if(((grid[0][0] == grid[0][1]) && (grid[0][1] == grid[0][2])) && (grid[0][2]=='X'||grid[0][2]=='O'))
		{
			grid[0][0]=grid[0][2];
			return 1;
		}
		else if(((grid[1][0]==grid[1][1]) && (grid[1][1]==grid[1][2])) && (grid[1][2]=='X'||grid[1][2]=='O'))
		{
			grid[0][0]=grid[1][2];
			return 1;
		}
		else if(((grid[2][0]==grid[2][1]) && (grid[2][1]==grid[2][2])) && (grid[2][2]=='X'||grid[2][2]=='O'))
		{
			grid[0][0]=grid[2][2];
			return 1;
		}
		else if(((grid[0][0]==grid[1][0]) && (grid[1][0]==grid[2][0])) && (grid[2][0]=='X'||grid[2][0]=='O'))
		{
			grid[0][0]=grid[2][0];
			return 1;
		}
		else if(((grid[0][1]==grid[1][1]) && (grid[1][1]==grid[2][1])) && (grid[2][1]=='X'||grid[2][1]=='O'))
		{
			grid[0][0]=grid[2][1];
			return 1;
		}
		else if(((grid[0][2]==grid[1][2]) && (grid[1][2]==grid[2][2])) && (grid[2][2]=='X'||grid[2][2]=='O'))
		{
			grid[0][0]=grid[2][2];
			return 1;
		}
		else if(((grid[0][0]==grid[1][1]) && (grid[1][1]==grid[2][2])) && (grid[2][2]=='X'||grid[2][2]=='O'))
		{
			grid[0][0]=grid[2][2];
			return 1;
		}
		else if(((grid[0][2]==grid[1][1]) && (grid[1][1]==grid[2][0])) && (grid[2][0]=='X'||grid[2][0]=='O'))
		{
			grid[0][0]=grid[2][0];
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static int isTie(char [][] grid)
	{
		int i;
		int j;
		int flag=0;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				if(grid[i][j]=='-')
				{
					flag=1;
				}
			}
		}
		if(flag==0)
		{
			return 1;
		}
		return 0;
	}
	
	public static int checkState(char [][] grid)
	{
		int i;
		int j;
		if(hasWon(grid)==1)
		{
			if(grid[0][0]=='X')
			{
				return 2;
			}
			else
			{
				return 1;
			}
		}
		else
		{
			if(isTie(grid)==1)
			{
				return 0;
			}
		}
		return 3;
	}
	
	public static void put(int x, int y, char val, char[][] grid)
	{
		Scanner scan = new Scanner(System.in);
		if(x>3 || y>3 || grid[x-1][y-1]!='-' )
		{
			System.out.println("\nInvalid coordinates\n");
			//System.out.println("\nx coordinate: \n");
			x=Integer.parseInt(scan.next());
			//System.out.println("\ny coordinate: \n");
			y=Integer.parseInt(scan.next());
			put(x,y,val,grid);
		}
		else
		{
			grid[x-1][y-1]=val;
		}
	}
	
	public static void putAI(int x, int y, char val, char[][] grid)
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		if(x>3 || y>3 || grid[x-1][y-1]!='-' )
		{
			x=rand.nextInt(3)+1;
			y=rand.nextInt(3)+1;
			while(grid[x-1][y-1]!='-')
			{
				x=rand.nextInt(3)+1;
				y=rand.nextInt(3)+1;
			}
			putAI(x,y,val,grid);
		}
		else
		{
			grid[x-1][y-1]=val;
		}
	}

	/*public static void main(String[] args) 
	{
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
			printGrid(grid);
			while(checkState(grid)==3)
			{
				if(user==1)
				{
					val='O';
				}
				else
				{
					val='X';
				}
				System.out.println("\nx coordinate: \n");
				x=scan.nextInt();
				System.out.println("\ny coordinate: \n");
				y=scan.nextInt();
				put(x,y,val,grid);
				printGrid(grid);
				user=user*(-1);
			}
			if(checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else if(ch==2)
		{
			//Player vs Random
			printGrid(grid);
			while(checkState(grid)==3)
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
					System.out.println("\nx coordinate: \n");
					x=scan.nextInt();
					System.out.println("\ny coordinate: \n");
					y=scan.nextInt();
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
				put(x,y,val,grid);
				printGrid(grid);
				user=user*(-1);
			}
			if(checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else if(ch==3)
		{
			//Random vs AI
			//check for win possibility
			printGrid(grid);
			while(checkState(grid)==3)
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
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='X')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='X')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='X')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='X')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='X')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='X')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='X')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='X')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='X')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='X')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='X')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='X')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='X')
					{
						putAI(1,3,'X',grid);
					}
					
					// Don't let him win
					
					
					else if((grid[0][0]==grid[0][1]) && grid[0][0]=='O')
					{
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='O')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='O')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='O')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='O')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='O')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='O')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='O')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='O')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='O')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='O')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='O')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='O')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='O')
					{
						putAI(1,3,'X',grid);
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
						putAI(x,y,val,grid);
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
					putAI(x,y,val,grid);
				}
				printGrid(grid);
				System.out.println("\n");
				user=user*(-1);
			}
			if(checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else if(ch==4)
		{
			//AI vs Player
			printGrid(grid);
			while(checkState(grid)==3)
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
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='X')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='X')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='X')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='X')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='X')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='X')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='X')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='X')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='X')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='X')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='X')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='X')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='X')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='X')
					{
						putAI(1,3,'X',grid);
					}
					
					// Don't let him win
					
					
					else if((grid[0][0]==grid[0][1]) && grid[0][0]=='O')
					{
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[0][2]) && grid[0][0]=='O')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][1]==grid[0][2]) && grid[0][1]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[1][0]==grid[1][1]) && grid[1][0]=='O')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][0]==grid[1][2]) && grid[1][0]=='O')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[1][2]) && grid[1][1]=='O')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[2][0]==grid[2][1]) && grid[2][0]=='O')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[2][0]==grid[2][2]) && grid[2][0]=='O')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[2][1]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[1][0]) && grid[0][0]=='O')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][0]==grid[2][0]) && grid[0][0]=='O')
					{
						putAI(2,1,'X',grid);
					}
					else if((grid[1][0]==grid[2][0]) && grid[2][0]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][1]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(3,2,'X',grid);
					}
					else if((grid[0][1]==grid[2][1]) && grid[2][1]=='O')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][1]) && grid[1][1]=='O')
					{
						putAI(1,2,'X',grid);
					}
					else if((grid[0][2]==grid[1][2]) && grid[1][2]=='O')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][2]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(2,3,'X',grid);
					}
					else if((grid[1][2]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(1,3,'X',grid);
					}
					else if((grid[0][0]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(3,3,'X',grid);
					}
					else if((grid[0][0]==grid[2][2]) && grid[2][2]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[2][2]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(1,1,'X',grid);
					}
					else if((grid[0][2]==grid[1][1]) && grid[1][1]=='O')
					{
						putAI(3,1,'X',grid);
					}
					else if((grid[0][2]==grid[2][0]) && grid[2][2]=='O')
					{
						putAI(2,2,'X',grid);
					}
					else if((grid[1][1]==grid[2][0]) && grid[1][1]=='O')
					{
						putAI(1,3,'X',grid);
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
						putAI(x,y,val,grid);
					}
				}
				else
				{
					System.out.println("\nx coordinate: \n");
					x=scan.nextInt();
					System.out.println("\ny coordinate: \n");
					y=scan.nextInt();
					putAI(x,y,val,grid);
				}
				printGrid(grid);
				System.out.println("\n");
				user=user*(-1);
			}
			if(checkState(grid)==1)
			{
				System.out.println("\nO has won!\n");
			}
			if(checkState(grid)==2)
			{
				System.out.println("\nX has won!\n");
			}
			if(checkState(grid)==0)
			{
				System.out.println("\nIt is a tie\n");
			}
		}
		else
		{
			System.out.println("Invalid Selection");
		}
		

	}*/

}
