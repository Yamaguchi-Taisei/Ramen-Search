
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/HanteiRamenRandom")
public class HanteiRamenRandom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// -------- 文字コード設定 --------
		request.setCharacterEncoding("UTF-8");

		// CSVファイルのパスを指定
		String csvFilePath = "../workspace/EDS-Ramen/ra-men.csv";

		// -------- 占い結果生成  --------
		String num = request.getParameter("num");
		
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
            while( (line = br.readLine()) != null) {
                String[] strList = line.split(",",0); // 行データを配列化.
                
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
            
		}catch(IOException e) {
            System.out.println(e);
        }
		
		int number = Integer.parseInt(num)%typeList.size();
		
		request.setAttribute("type", typeList.get(number));
		request.setAttribute("cal", calList.get(number));
		request.setAttribute("name", nameList.get(number));
		request.setAttribute("loc", locList.get(number));
		request.setAttribute("price", priceList.get(number));
		request.setAttribute("review", reviewList.get(number));
		request.setAttribute("url", urlList.get(number));
		request.setAttribute("jpg", jpgList.get(number));
		
		RequestDispatcher rd = request.getRequestDispatcher("/RamenOutputRandom.jsp");
		rd.forward(request, response);
		
	}

}
