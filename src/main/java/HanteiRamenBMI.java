import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/HanteiRamenBMI")
public class HanteiRamenBMI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// -------- 文字コード設定 --------
		request.setCharacterEncoding("UTF-8");

		// CSVファイルのパスを指定
		String csvFilePath = "../workspace/EDS-Ramen/ra-men.csv";

		//csv入力先
		List<String> typeList = new ArrayList<>();
		List<String> calList = new ArrayList<>();
		List<String> nameList = new ArrayList<>();
		List<String> locList = new ArrayList<>();
		List<String> priceList = new ArrayList<>();
		List<String> reviewList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		List<String> urlList = new ArrayList<>();
		List<String> jpgList = new ArrayList<>();

		//出力先
		List<String> typeListout = new ArrayList<>();
		List<String> calListout = new ArrayList<>();
		List<String> nameListout = new ArrayList<>();
		List<String> locListout = new ArrayList<>();
		List<String> priceListout = new ArrayList<>();
		List<String> reviewListout = new ArrayList<>();
		List<String> urlListout = new ArrayList<>();
		List<String> jpgListout = new ArrayList<>();

		try {
			File inFile = new File(csvFilePath);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			String line = null;
			// CSVファイルを1行毎に読み込む.
			while ((line = br.readLine()) != null) {
				String[] strList = line.split(",", 0); // 行データを配列化.

				typeList.add(strList[0]);
				calList.add(strList[1]);
				nameList.add(strList[2]);
				locList.add(strList[3]);
				priceList.add(strList[4]);
				reviewList.add(strList[5]);
				userList.add(strList[6]);
				urlList.add(strList[7]);
				jpgList.add(strList[8]);
			}

		} catch (IOException e) {
			System.out.println(e);
		}

		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));

		List<Integer> intcalList = new ArrayList<>();
		for (int i = 1; i < calList.size(); i++) {
			intcalList.add(Integer.parseInt(calList.get(i)));
		}

		//System.out.println("関数実行前");
		List<Integer> threeList = getBMItothree(intcalList, height, weight);
		//System.out.println("関数実行完了");
		//System.out.println(threeList.get(0));
		//System.out.println(threeList.get(1));
		//System.out.println(threeList.get(2));

		for (int i = 0; i < threeList.size(); i++) {
			for (int j = 1; j < calList.size(); j++) {
				if (Integer.parseInt(calList.get(j)) == (threeList.get(i))) {
					typeListout.add(typeList.get(j));
					calListout.add(calList.get(j));
					nameListout.add(nameList.get(j));
					locListout.add(locList.get(j));
					priceListout.add(priceList.get(j));
					reviewListout.add(reviewList.get(j));
					urlListout.add(urlList.get(j));
					jpgListout.add(jpgList.get(j));
				}
			}
		}
		///System.out.println("テスト用");
		double bmi = weight / (height * height);
		String humanType;
		if (bmi >= 25) {
			humanType = "肥満型";
		} else if (bmi <= 18) {
			humanType = "やせ型";
		} else {
			humanType = "標準型";
		}
		//System.out.println(bmi);
		//System.out.println(nameListout.get(0));
		//System.out.println(nameListout.get(1));
		//System.out.println(nameListout.get(2));
		//System.out.println(humanType+":"+bmi);

		request.setAttribute("typeListout", typeListout);
		request.setAttribute("calListout", calListout);
		request.setAttribute("nameListout", nameListout);
		request.setAttribute("locListout", locListout);
		request.setAttribute("priceListout", priceListout);
		request.setAttribute("reviewListout", reviewListout);
		request.setAttribute("urlListout", urlListout);
		request.setAttribute("jpgListout", jpgListout);
		
		request.setAttribute("humantype", humanType);
		RequestDispatcher rd = request.getRequestDispatcher("/RamenOutputBMI.jsp");
		rd.forward(request, response);

	}

	/**
	 * ▼▼▼▼▼各処理メソッド▼▼▼▼▼
	 */

	public List<Integer> getBMItothree(List<Integer> list, double height, double weight) {
		double bmi = weight / (height * height);

		List<int[]> indexValueColorie = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			indexValueColorie.add(new int[] { i, list.get(i) });
		}

		if (bmi > 18) {//やせ型であるとき
			indexValueColorie.sort((a, b) -> Integer.compare(a[1],b[1]));//カロリーで高い順
		} else {//肥満型であるとき
			indexValueColorie.sort((a, b) -> Integer.compare(b[1], a[1]));//カロリーで低い順
		}

		List<Integer> threeIndexes = new ArrayList<>();
		for (int i = 0; i < 3 && i < indexValueColorie.size(); i++) {
			threeIndexes.add(indexValueColorie.get(i)[1]);
		}

		List<Integer> listB = new ArrayList<Integer>(new LinkedHashSet<>(threeIndexes));
		return listB;

	}

}