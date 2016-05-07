import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 問題番号記入
		String exam = "n6";

		new GetColor(exam);
		new Rensa().print();

		long start = 0;
		long end = 0;
		// 入力読み込み
		Scanner scan = new Scanner(System.in);

		System.out.println("ネクストを入力してください（数字）");
		System.out.println("正解条件（連鎖数）を記入してください（0は全消し）");
		try {
			long sub;
			long num = scan.nextLong();
			if (String.valueOf(num).length() % 2 == 0) {
				for (int i = String.valueOf(num).length() - 1; i >= 0; i--) {
					sub = num / (long) Math.pow(10, i);
					GlobalVal.nextTsumo.add((int) sub);
					num %= (int) (Math.pow(10, i));
				}
			} else {
				scan.close();
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("ネクスト入力が正しくありません");
		}

		// クリア条件
		try {
			int seikai = scan.nextInt();

			start = System.currentTimeMillis();
			new CalculateChain(seikai);
			end = System.currentTimeMillis();
		} catch (Exception e) {
			System.out.println("正解条件入力が正しくありません");
		}
		scan.close();

		// 正解表示
		if (GlobalVal.success.size() > 0) {
			System.out.println("正解パターン");
			for (int i = 0; i < (GlobalVal.nextTsumo.size() / 2); i++) {
				GlobalVal.p[0][3] = GlobalVal.nextTsumo.get(i * 2);
				GlobalVal.p[1][3] = GlobalVal.nextTsumo.get(i * 2 + 1);
				new Put().put(GlobalVal.success.get(i), true);
			}
			System.out.println("計算終了");
			System.out.println("計算時間：" + (end - start));
		} else
			System.out.println("正解パターンありませんでした");
	}
}
