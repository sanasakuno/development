import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	private static final String errorMessage = "じゃんけんの手を入力してください 入力値：";

	private static final String[] rockPaperScissors = { "グー", "パー", "チョキ" };

	private static final String rock = "グー";

	private static final String paper = "パー";

	private static final String scissors = "チョキ";

	private static final String end = "終了";

	private static final String win = "勝ち\n";

	private static final String lose = "負け\n";

	private static final String aiko = "あいこ\n";

	private static Scanner scanner = new Scanner(System.in);

	// プログラムとじゃんけんを行うメソッド
	public static void main(String[] args) {

		//じゃんけんの勝ち負けを判定
		fight();

	}

	private static void fight() {

		System.out.println("じゃんけんの手を入力してください");
		String input = scanner.next();

		// 入力値を確認し
		// ・じゃんけんの手でない場合
		// 上記の場合はエラーメッセージを返却
		// 「終了」を入力した場合、プログラム終了
		if (input.equals(end)) {
			return;
		} else if (!(input.equals(rock) || input.equals(paper) || input.equals(scissors))) {
			System.out.println(errorMessage + input);
			return;
		}

		// プログラム側のじゃんけんの手を生成する
		Random r = new Random();
		String programHand = rockPaperScissors[r.nextInt(3)];

		// 互いのじゃんけんの手を出力
		System.out.println("\nプログラムの手は…\n");
		sleep(1000);
		System.out.println(programHand);
		sleep(1000);
		System.out.println("\n勝敗は…！\n");
		sleep(1000);

		// じゃんけんの結果を返却する
		if (input.equals(rock)) {
			if (programHand.equals(rock)) {
				System.out.println(aiko);
			} else if (programHand.equals(paper)) {
				System.out.println(lose);
			} else {
				System.out.println(win);
			}
		} else if (input.equals(paper)) {
			if (programHand.equals(rock)) {
				System.out.println(win);
			} else if (programHand.equals(paper)) {
				System.out.println(aiko);
			} else {
				System.out.println(lose);
			}
		} else {
			if (programHand.equals(rock)) {
				System.out.println(lose);
			} else if (programHand.equals(paper)) {
				System.out.println(win);
			} else {
				System.out.println(aiko);
			}
		}

		// 「終了」を入力されるまで繰り返す
		fight();
	}

	// 指定時間分処理を止める
	private static void sleep(int time) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// 特に何もしない
		}
	}

}
