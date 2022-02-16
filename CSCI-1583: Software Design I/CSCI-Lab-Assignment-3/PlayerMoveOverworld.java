import java.util.Scanner;
class PlayerMoveOverworld
{
	public static void main(String[] args )
	{
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
    input.nextLine();

		for(int currentCase = 0; currentCase < cases; currentCase++)
		{
      int x = input.nextInt();
			int y = input.nextInt();

      Scanner input2 = new Scanner(System.in);
      String sequence = input2.nextLine();
      Scanner reader = new Scanner(sequence);

			while(reader.hasNextLine() == true)
			{
        String playerInput = reader.next();
        
				if(playerInput.equals("w"))
				{
					y = (y - 1);
				}
				else if(playerInput.equals("a"))
				{
					x = (x - 1);
				}
				else if(playerInput.equals("d"))
				{
					x = (x + 1);
				}
				else if(playerInput.equals("s"))
				{
					y = (y + 1);
				}
			}
      System.out.printf("%s %s\n", x,y);
		}
	}
}