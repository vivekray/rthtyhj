import java.util.Scanner;

public class Gambler {
	static int bets = 0;

	void gambler( int stake,int goal,int no_Of_Times) {
        int wins = 0;
		for (int i = 0; i < no_Of_Times; i++) {
			int cash = stake;
			while (cash > 0 && cash < goal) {
				bets++;
				if (Math.random() < 0.5) {
					cash++;
				} else {
					cash--;
				}
			}
			if (cash == goal)
				wins++;
		}
		System.out.println(wins);
		float win = ((float) wins / no_Of_Times) * 100;
		float loss = 100 - win;
		System.out.println("Win %=" + win);
		System.out.println("Loss %=" + loss);
		

	}

	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter values");
		int s = sc.nextInt();
		int g = sc.nextInt();
		int nott = sc.nextInt();

		Gambler ob=new Gambler();
		ob.gambler(s,g,nott);
		sc.close();

	}

}
