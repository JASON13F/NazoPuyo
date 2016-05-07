import java.util.ArrayList;

public class Rensa {
	int con[][] = new int[GlobalVal.height][GlobalVal.width];
	boolean isDelete = true;
	ArrayList<Integer> conList = new ArrayList<>();

	public void rensa(boolean print) {
		isDelete = true;
		GlobalVal.chainNum = 0;

		while (isDelete) {
			if (print)
				print();
			drop();
			if (print) {
				System.out.println("drop");
				print();
			}

			isDelete = false;
			int connect = 0;

			for (int i1 = 0; i1 < GlobalVal.height; i1++) {
				for (int i2 = 0; i2 < GlobalVal.width; i2++) {
					if (GlobalVal.p[i1][i2] > 0 && con[i1][i2] == 0) {
						connect = checkCon(i1, i2, 1);

						for (int i = 0; i < (conList.size() / 2); i++)
							con[conList.get(i * 2)][conList.get((i * 2) + 1)] = connect;

						conList.clear();
					}
				}
			}

			delete();
			if (isDelete) {
				GlobalVal.chainNum++;
				if (print)
					System.out.println("連鎖数：" + GlobalVal.chainNum);
			}
			conReset();
		}
	}

	public int checkCon(int i1, int i2, int connect) {
		con[i1][i2] = 1;
		conList.add(i1);
		conList.add(i2);

		// 上方向確認
		if (i1 > 1 && GlobalVal.p[i1 - 1][i2] == GlobalVal.p[i1][i2] && con[i1 - 1][i2] == 0)
			connect = checkCon(i1 - 1, i2, connect + 1);
		// 下方向確認
		if (i1 < (GlobalVal.height - 1) && GlobalVal.p[i1 + 1][i2] == GlobalVal.p[i1][i2] && con[i1 + 1][i2] == 0)
			connect = checkCon(i1 + 1, i2, connect + 1);
		// 左方向確認
		if (i2 > 0 && GlobalVal.p[i1][i2 - 1] == GlobalVal.p[i1][i2] && con[i1][i2 - 1] == 0)
			connect = checkCon(i1, i2 - 1, connect + 1);
		// 右方向確認
		if (i2 < (GlobalVal.width - 1) && GlobalVal.p[i1][i2 + 1] == GlobalVal.p[i1][i2] && con[i1][i2 + 1] == 0)
			connect = checkCon(i1, i2 + 1, connect + 1);

		return connect;
	}

	public void delete() {
		for (int i1 = 0; i1 < GlobalVal.height; i1++) {
			for (int i2 = 0; i2 < GlobalVal.width; i2++) {
				if (con[i1][i2] > 3) {
					GlobalVal.p[i1][i2] = 0;
					isDelete = true;
				}
			}
		}
	}

	public void drop() {
		boolean drop = false;

		for (int i2 = 0; i2 < GlobalVal.width; i2++) {
			for (int i1 = 0; i1 < (GlobalVal.height - 1); i1++) {
				if (GlobalVal.p[i1][i2] != 0 && GlobalVal.p[i1 + 1][i2] == 0) {
					GlobalVal.p[i1 + 1][i2] = GlobalVal.p[i1][i2];
					GlobalVal.p[i1][i2] = 0;
					drop = true;
				}

				if (i1 == (GlobalVal.height - 2) && drop) {
					drop = false;
					i1 = -1;
				}
			}
		}
	}

	public void conReset() {
		for (int i1 = 0; i1 < 12; i1++) {
			for (int i2 = 0; i2 < 6; i2++)
				con[i1][i2] = 0;
		}
	}

	public void print() {
		for (int i1 = 0; i1 < GlobalVal.height; i1++) {
			for (int i2 = 0; i2 < GlobalVal.width; i2++)
				System.out.print(GlobalVal.p[i1][i2] + " ");
			System.out.println();
		}
		System.out.println();
	}
}
