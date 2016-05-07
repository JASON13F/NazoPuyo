public class CalculateChain {
	int next[];
	int sub[][] = new int[GlobalVal.height][GlobalVal.width];

	public CalculateChain(int chainNum) {
		next = new int[GlobalVal.nextTsumo.size() / 2];
		boolean finish = true;
		Put p = new Put();
		Input();

		while (finish) {
			finish = false;
			Next();

			for (int i = 0; i < (GlobalVal.nextTsumo.size() / 2); i++) {
				GlobalVal.p[0][3] = GlobalVal.nextTsumo.get(i * 2);
				GlobalVal.p[1][3] = GlobalVal.nextTsumo.get(i * 2 + 1);
				p.put(next[i], false);
			}
			if (Check(chainNum)) {
				for (int i : next)
					GlobalVal.success.add(i);
				Output();
				break;
			} else
				Output();

			// ループ終了条件
			for (int i : next) {
				if (i < 21)
					finish = true;
			}
		}
	}

	public void Next() {
		next[0]++;

		for (int i = 0; i < next.length - 1; i++) {
			if (next[i] > 21) {
				next[i] = 0;
				next[i + 1]++;
			}
		}
	}

	public void Input() {
		for (int i1 = 0; i1 < GlobalVal.height; i1++) {
			for (int i2 = 0; i2 < GlobalVal.width; i2++)
				sub[i1][i2] = GlobalVal.p[i1][i2];
		}
	}

	public void Output() {
		for (int i1 = 0; i1 < GlobalVal.height; i1++) {
			for (int i2 = 0; i2 < GlobalVal.width; i2++)
				GlobalVal.p[i1][i2] = sub[i1][i2];
		}
	}

	public boolean Check(int chainNum) {
		boolean check = true;

		if (chainNum == 0) {
			for (int i1 = 0; i1 < GlobalVal.height; i1++) {
				for (int i2 = 0; i2 < GlobalVal.width; i2++) {
					if (GlobalVal.p[i1][i2] != 0)
						check = false;
				}
			}
		} else {
			if (GlobalVal.chainNum < chainNum)
				check = false;
		}

		if (check) {
			return true;
		} else
			return false;
	}
}
