public class Put {
	Rensa r = new Rensa();

	public void put(int num, boolean print) {
		int sub = 0;
		GlobalVal.chainNum = 0;

		// [0][3]と[1][3]の位置にネクストぷよを置く
		if (GlobalVal.p[0][3] != 0 && GlobalVal.p[1][3] != 0) {
			switch (num) {
			case 0:
				GlobalVal.p[0][0] = GlobalVal.p[0][3];
				GlobalVal.p[1][0] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 1:
				GlobalVal.p[0][1] = GlobalVal.p[0][3];
				GlobalVal.p[1][1] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 2:
				GlobalVal.p[0][2] = GlobalVal.p[0][3];
				GlobalVal.p[1][2] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 3:
				r.rensa(print);
				break;
			case 4:
				GlobalVal.p[0][4] = GlobalVal.p[0][3];
				GlobalVal.p[1][4] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 5:
				GlobalVal.p[0][5] = GlobalVal.p[0][3];
				GlobalVal.p[1][5] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 6:
				GlobalVal.p[1][0] = GlobalVal.p[0][3];
				GlobalVal.p[0][0] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 7:
				GlobalVal.p[1][1] = GlobalVal.p[0][3];
				GlobalVal.p[0][1] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 8:
				GlobalVal.p[1][2] = GlobalVal.p[0][3];
				GlobalVal.p[0][2] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 9:
				sub = GlobalVal.p[0][3];
				GlobalVal.p[0][3] = GlobalVal.p[1][3];
				GlobalVal.p[1][3] = sub;
				r.rensa(print);
				break;
			case 10:
				GlobalVal.p[1][4] = GlobalVal.p[0][3];
				GlobalVal.p[0][4] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 11:
				GlobalVal.p[1][5] = GlobalVal.p[0][3];
				GlobalVal.p[0][5] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 12:
				GlobalVal.p[0][0] = GlobalVal.p[0][3];
				GlobalVal.p[0][1] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 13:
				GlobalVal.p[0][1] = GlobalVal.p[0][3];
				GlobalVal.p[0][2] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 14:
				GlobalVal.p[0][2] = GlobalVal.p[0][3];
				GlobalVal.p[0][3] = GlobalVal.p[1][3];
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 15:
				GlobalVal.p[0][4] = GlobalVal.p[1][3];
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 16:
				GlobalVal.p[0][4] = GlobalVal.p[0][3];
				GlobalVal.p[0][5] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 17:
				GlobalVal.p[0][1] = GlobalVal.p[0][3];
				GlobalVal.p[0][0] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 18:
				GlobalVal.p[0][2] = GlobalVal.p[0][3];
				GlobalVal.p[0][1] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 19:
				GlobalVal.p[0][2] = GlobalVal.p[1][3];
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 20:
				GlobalVal.p[0][4] = GlobalVal.p[0][3];
				GlobalVal.p[0][3] = GlobalVal.p[1][3];
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			case 21:
				GlobalVal.p[0][5] = GlobalVal.p[0][3];
				GlobalVal.p[0][4] = GlobalVal.p[1][3];
				GlobalVal.p[0][3] = 0;
				GlobalVal.p[1][3] = 0;
				r.rensa(print);
				break;
			default:
				break;
			}
		} else
			System.out.println("ネクストが正しく置かれていません");
	}
}
