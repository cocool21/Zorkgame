import java.util.Scanner;
import java.util.Random;

public class ZorkGame {
	static boolean secret = false;

	public static void main(String[] args) {
		int roomNum = 1, oldRoomNum, roomCounter = 1,i=0;
		Scanner keyboard = new Scanner(System.in);
		Random rnd = new Random();
		printOutput(roomNum, secret);
		System.out.println("You've visted "+roomCounter+" rooms");
		int typein = keyboard.nextInt();
		oldRoomNum = roomNum;
		roomNum = whereToGo(roomNum, typein);
		if (roomNum != oldRoomNum && roomNum!=0) {
			roomCounter++;
		}
		System.out.println("You've visted "+roomCounter+" rooms");
		// System.out.println(roomNum);
		while (roomNum <= 8 && roomNum >= 1) {
			printOutput(roomNum, secret);
			oldRoomNum = roomNum;
			roomNum = whereToGo(roomNum, keyboard.nextInt());
			if (roomNum != oldRoomNum) {
				roomCounter++;
			}
			if(roomNum ==6){
				i=1+rnd.nextInt(4);
			}
			if(i==2){
				secret=true;
			}
			System.out.println("You've visted "+roomCounter+" rooms");
		}
		System.out.println("You are outside of the room. \nGood Bye!");
		keyboard.close();
	}

	private static void printOutput(int num,boolean secret){
		
		switch(num){
		
		case 1: System.out.println("You are standing in the foyer room of an old house. \nYou see a dead scorpion.\nYou can (0)exit the house, (1) exit to the north.");
		        break;
		case 2: System.out.println("You are standing in the front room of an old house. \nYou see a piano.\nYou can (1)exit to the west, (2) exit to the south,(3) exit to the east.");
		        break;
		case 3: System.out.println("You are standing in the library of an old house. \nYou see spiders.\nYou can (1)exit to the north, (2) exit to the east.");
		        break;
		case 4: System.out.println("You are standing in the kitchen of an old house. \nYou see bats.\nYou can (1)exit to the west, (2) exit to the north.");
		        break;
        case 5: System.out.println("You are standing in the dining room of an old house. \nYou see dust and an empty house.\nYou can (1)exit the south .");
                break;
		case 6: if(secret==true ){
				   System.out.println("You are standing in the vault room of an old house. \nYou see three walking skeletons.\nYou can go to the east (1)the normal door, (2) the secret door.");
		}else {System.out.println("You are standing in the vault room of an old house. \nYou see three walking skeletons.\nYou can (1) go to the east.");}       	
		
		        break;
		case 7: System.out.println("You are standing in the parlor of an old house. \nYou see a treasure chest.\nYou can (1)exit to the west, (2) exit to the south.");
		        break;
		case 8: System.out.println("You are standing in the secret room of an old house. \nYou see piles of gold.\nYou can (1)exit to the west.");
		        break;
		}
	}

	private static int whereToGo(int num, int typein) {
		int roomNum = num;

		switch (num) {
		case 1:
			if (typein == 0) {
				roomNum = 0;
			} else if (typein == 1) {
				roomNum = 2;
			} else {
				System.out.println("Invalid input");
			}
			break;

		case 2:
			if (typein == 1) {
				roomNum = 3;
			} else if (typein == 2) {
				roomNum = 1;
			} else if (typein == 3) {
				roomNum = 4;
			} else {
				System.out.println("Invalid input");
			}
			break;

		case 3:
			if (typein == 1) {
				roomNum = 5;
			} else if (typein == 2) {
				roomNum = 2;
			} else {
				System.out.println("Invalid input");
			}
			break;

		case 4:
			if (typein == 1) {
				roomNum = 2;
			} else if (typein == 2) {
				roomNum = 7;
			} else {
				System.out.println("Invalid input");
			}
			break;

		case 5:
			if (typein == 1) {
				roomNum = 3;
			} else {
				System.out.println("Invalid input");
			}
			break;

		case 6:
			if (typein == 1) {
				roomNum = 7;
			} else if (typein == 2) {// 25% for exit to room 8
				roomNum = 8;
			} else {
				System.out.println("Invalid input");
			}
			break;

		case 7:
			if (typein == 1) {
				roomNum = 6;
			} else if (typein == 2) {
				roomNum = 4;
			} else {
				System.out.println("Invalid input");
			}
			break;

		case 8:
			if (typein == 1) {
				roomNum = 6;
			} else {
				System.out.println("Invalid input");
			}
			break;
		}
		return roomNum;
	}

}
