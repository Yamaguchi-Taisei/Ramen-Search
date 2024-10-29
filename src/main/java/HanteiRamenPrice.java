import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
@WebServlet("/HanteiRamenPrice")
public class HanteiRamenPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// -------- 文字コード設定 --------
		request.setCharacterEncoding("UTF-8");

		// CSVファイルのパスを指定
		String csvFilePath = "../workspace/EDS-Ramen/ra-men.csv";

		// -------- 占い結果生成  --------
		String ramenType = request.getParameter("ramenType");

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
		List<Integer> indexList = getType(typeList, ramenType);
		List<Integer> typePrice = new ArrayList<>();

		Iterator<Integer> iterator = indexList.iterator();
		while (iterator.hasNext()) {
			Integer index = iterator.next();
			typePrice.add(Integer.parseInt(priceList.get(index)));
		}

		List<Integer> topList = getTop(typePrice);

		for (int i = 0; i < topList.size(); i++) {
			for (int j = 0; j < priceList.size(); j++) {
				if (priceList.get(j).equals(String.valueOf(topList.get(i)))) {
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

		request.setAttribute("typeListout", typeListout);
		request.setAttribute("calListout", calListout);
		request.setAttribute("nameListout", nameListout);
		request.setAttribute("locListout", locListout);
		request.setAttribute("priceListout", priceListout);
		request.setAttribute("reviewListout", reviewListout);
		request.setAttribute("urlListout", urlListout);
		request.setAttribute("jpgListout", jpgListout);

		RequestDispatcher rd = request.getRequestDispatcher("/RamenOutputPrice.jsp");
		rd.forward(request, response);

	}

	/**
	 * ▼▼▼▼▼各処理メソッド▼▼▼▼▼
	 */

	public List<Integer> getType(List<String> list, String name) {
		List<Integer> listIndex = new ArrayList<>();
		int count = 0;
		while (count < list.size()) {
			String type = list.get(count);
			if (type.equals(name)) {
				listIndex.add(count);
			}
			count++;
		}
		return listIndex;
	}

	public List<Integer> getTop(List<Integer> list) {

		List<int[]> indexValuePairs = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			indexValuePairs.add(new int[] { i, list.get(i) });
		}

		indexValuePairs.sort((a, b) -> Integer.compare(b[1], a[1]));
		Collections.reverse(indexValuePairs);

		List<Integer> top3Indexes = new ArrayList<>();
		for (int i = 0; i < 3 && i < indexValuePairs.size(); i++) {
			top3Indexes.add(indexValuePairs.get(i)[1]);
		}
		List<Integer> listB = new ArrayList<Integer>(new LinkedHashSet<>(top3Indexes));
		return listB;

	}

}