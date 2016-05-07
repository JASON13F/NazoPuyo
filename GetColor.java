import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class GetColor {
	int rgb, r, g, b;
	int colorNum = 0;
	ArrayList<Integer> cList = new ArrayList<>();

	public GetColor(String num) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("image/NazoMain/" + num + ".png"));
		} catch (IOException e) {
			System.out.println("ファイル読み込みエラー");
		}

		// 色抽出
		int tate = 5;
		for (int i1 = 1; i1 < (GlobalVal.height * 2); i1 += 2) {
			for (int i2 = 1; i2 < (GlobalVal.width * 2); i2 += 2) {
				// 縦範囲取得
				for (int i3 = -tate; i3 < tate; i3++)
					rgb += image.getRGB(image.getWidth() * i2 / (GlobalVal.width * 2),
							image.getHeight() * i1 / (GlobalVal.height * 2) + i3);
				rgb /= (tate * 2);
				Color color = new Color(rgb);
				r = color.getRed();
				g = color.getGreen();
				b = color.getBlue();
				separate((i1 - 1) / 2, (i2 - 1) / 2, false);
				// check();
				rgb = 0;
			}
		}
	}

	public void separate(int y, int x, boolean print) {
		if (!cList.contains(g) && g < 254) {
			switch (colorNum) {
			case 0:
				cList.add(g);
				GlobalVal.p[y][x] = 1;
				colorNum++;
				if (print)
					System.out.print("１");
				break;
			case 1:
				cList.add(g);
				GlobalVal.p[y][x] = 2;
				colorNum++;
				if (print)
					System.out.print("２");
				break;
			case 2:
				cList.add(g);
				GlobalVal.p[y][x] = 3;
				colorNum++;
				if (print)
					System.out.print("３");
				break;
			case 3:
				cList.add(g);
				GlobalVal.p[y][x] = 4;
				colorNum++;
				if (print)
					System.out.print("４");
				break;
			default:
				break;
			}
		} else {
			switch (cList.indexOf(g)) {
			case 0:
				GlobalVal.p[y][x] = 1;
				if (print)
					System.out.print("１");
				break;
			case 1:
				GlobalVal.p[y][x] = 2;
				if (print)
					System.out.print("２");
				break;
			case 2:
				GlobalVal.p[y][x] = 3;
				if (print)
					System.out.print("３");
				break;
			case 3:
				GlobalVal.p[y][x] = 4;
				if (print)
					System.out.print("４");
				break;
			default:
				break;
			}
		}
	}

	public void check() {
		System.out.print(g + " ");
		// System.out.print("(" + r + "," + g + "," + b + ")");
	}
}
