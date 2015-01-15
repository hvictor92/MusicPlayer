import java.util.Scanner;

public class MusicPlayer 
{
	Scanner kbd = new Scanner(System.in);
		
	private ListArray listPlayer = new ListArray();
	private LinkList linkPlayer = new LinkList();
	private String Song1;
	private String Song2;
	private String Song3;
	private int mode;
	
	
	public MusicPlayer(String song1, String song2, String song3)
	{
		Song1 =song1;
	    Song2 =song2;
	    Song3 =song3;
	}
	
	public void start()
	{
		System.out.println("Please select mode");
		System.out.println("0: LinkList OR 1: ArrayList");
		mode = kbd.nextInt();

		if(mode == 0)
		 {
			linkPlayer.addNode(Song1);
			linkPlayer.addNode(Song2);
			linkPlayer.addNode(Song3);
			
			System.out.println();
			System.out.println("Playlist:");
			linkPlayer.printList();
			
			System.out.println();
			/*System.out.println(linkPlayer.findNodeNum(1).getValue());
			System.out.println(linkPlayer.findNodeNum(2).getValue());
			System.out.println(linkPlayer.findNodeNum(3).getValue());*/
			try 
			{
				commandOptions();
			} catch (InvalidInputException e) {
				System.out.println(e);
			}
			
		 }
		else
		{
			listPlayer.addNode(Song1);
			listPlayer.addNode(Song2);
			listPlayer.addNode(Song3);
			
			System.out.println();
			System.out.println("Playlist:");
			listPlayer.printList();
			
			System.out.println();
			try {
				commandOptions();
			} catch (InvalidInputException e) {
				System.out.println(e);
			}
		}
		
	}
	
	
		
	public void commandOptions() throws InvalidInputException
	{
		System.out.println("What you like to do");
		System.out.println("1:Add Song; 2:Delete Song; 3:Play All; 4:Get Position; 5:Swap Order; 6:Exit");
		int command= kbd.nextInt();
		
		if(command >= 7 || command < 0)
		{
			throw new InvalidInputException();
		}
		else
		switch(command)
		{
		   case 1: 
		   {
				   System.out.println();
			       System.out.println("Please enter song title");
				   String song = kbd.next();
				   if(mode == 0)
				   {
					   linkPlayer.addNode(song);
				   }
				   else
				   {
					   listPlayer.addNode(song);
				   }
		           commandOptions();
		   }			       
		   case 2:
		   {
			   System.out.println("Please enter song title");
		       String song = kbd.next();
		       if(mode == 0)
		       {
		    	   linkPlayer.removeNode(song);
		       }
		       else
		       {
		    	   listPlayer.removeNode(song);
		       }
		       commandOptions();
		   }
		   case 3:
		   {
			   System.out.println("Playing:");
			   if(mode == 0)
			   {
				   linkPlayer.printList();
			   }
			   else
			   {
				   listPlayer.printList();
			   }
			   commandOptions();
		   }
		   case 4:
		   {
			   System.out.println("Please enter song title");
			   String song = kbd.next();
			   if(song.equals(Song1))
			   {
				   if(mode == 0)
				   {
					   System.out.println(song +" is number "+ linkPlayer.find(Song1) +" on the Playlist");
				   }
				   else
				   {
					   System.out.println(song +" is number "+ listPlayer.find(Song1) +" on the Playlist");
				   }
				   commandOptions(); 
			   }
			   else if(song.equals(Song2))
			   {
				   if(mode == 0)
				   {
					   System.out.println(song +" is number "+ linkPlayer.find(Song2) +" on the Playlist");
				   }
				   else
				   {
					   System.out.println(song +" is number "+ listPlayer.find(Song2) +" on the Playlist");
				   }
				   
				   commandOptions();
			   }
			   else if(song.equals(Song3))
			   {
				   if(mode == 0)
				   {
					   System.out.println(song +" is number "+ linkPlayer.find(Song3) +" on the Playlist");
				   }
				   else
				   {
					   System.out.println(song +" is number "+ listPlayer.find(Song3) +" on the Playlist");
				   }
			       commandOptions();
			   }
			   else
			   {
				   if(mode == 0)
				   {
					   System.out.println(song +" is number "+ linkPlayer.find(song) +" on the Playlist");
				   }
				   else
				   {
					   System.out.println(song +" is number "+ listPlayer.find(song) +" on the Playlist");
				   }
				   commandOptions();
			   }
		   }
		   case 5:
		   {
			   System.out.println("Please enter the first song title");
			   String song1 = kbd.next();
			   System.out.println("Please enter the next song title");
			   String song2 = kbd.next();
			   if(mode == 0)
			   {
				   Node n1 = linkPlayer.findNodeVal(song1); 
				   Node n2 = linkPlayer.findNodeVal(song2);
				   linkPlayer.swap(n1,n2);
			   }
			   else
			   {
				   Node n1 = listPlayer.findNodeVal(song1); 
				   Node n2 = listPlayer.findNodeVal(song2);
				   listPlayer.swap(n1,n2);
			   }
			  
			   commandOptions();			  
		   }
		   case 6:
		   {
			   System.out.println("Goodbye!");
			   break;
		   }
		}
	}
}
