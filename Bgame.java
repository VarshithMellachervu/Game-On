import java.util.*;
public class Bgame
{
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose your choice\n 1.Snake Game\n2.Tic Tac Toe\n3.Brick Brake");
		int op=sc.nextInt();
		switch(op)
		{
		case 1:new SnakeGame();
		break;
		case 2:new TicTacTeo();
		break;
		case 3:new Mains1();
		}
	}
	

}
