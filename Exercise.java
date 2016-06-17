package GuessingGame;
import java.util.Scanner;
public class Exercise {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		do{
			System.out.println("Choose the level：（5，7，9）; ");
			System.out.println("If you want to exit the game, print 'EXIT'.");
			num = scan.nextInt();
		}while(num!=5 && num!=7 && num!=9);
		char[] chs = generateArray(num);
		
		int count=0;
		while(true){
			System.out.println("Guess:");
			Scanner scanner=new Scanner(System.in);
			String str = scanner.next().toUpperCase();
			if(str.equals("EXIT")){
				System.out.println("Bye~");
				break;
			}
			char[] input = str.toCharArray();
			
			int[] result = check(chs, input);
			if(result[0]!=chs.length){
			
				count++;
				System.out.println("right letter:"+result[1]+" right positon:"+result[0]);			
			}else{
				int score = 100*chs.length-count*10;
				System.out.println("congruatulation! Your score="+score);
				break;
			}
		}
		
		
		
			
				
	}
	public static char[] generateArray(int num){

		
		char[] chs = new char[num];
		char[] letters ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int index;
		boolean[] flag = new boolean[letters.length];
		for (int i = 0; i<chs.length;i++){
			do{
				index = (int)(Math.random()*(letters.length));
			}while(flag[index]);
				chs[i]=letters[index];
				flag[index]=true;
		}
		return chs;
	}
	public static int[] check(char[] chs, char[] input){
		int[] result = new int[2];
		for (int i=0; i<input.length;i++){
			for(int j=0; j<chs.length;j++){
				if(chs[i]==input[j]){
					result[1]++;
					if(i==j){
						result[0]++;
					}
					break;//当已经找到那个对的字母后就不需要再继续找了，退到for i
				}
			}
		}
		return result;
		
	}

}
