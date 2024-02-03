package sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xamp.VocabularyItem;

@WebServlet("/DaySelectionServlet")
public class DaySelectionServlet extends HttpServlet {
	public DaySelectionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String action = request.getParameter("action");
    	if (action == null) {
    		throw new RuntimeException("Error");
    	} else {
    		HttpSession session = request.getSession();
    		switch (action) {
    		case "firstQuestion":
    			// Nhận dữ liệu từ form
    	        String selectedDay1 = request.getParameter("selectedDay");
    	        session.setAttribute("selectedDay", selectedDay1);
    	        
    	        // Truyền danh sách từ vựng đến JSP
    	        request.setAttribute("vocabularyList", createVocabularyList(selectedDay1));
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/VocabularyQuiz.jsp");
    	        dispatcher.forward(request, response);
    	        
    	        break;
    		case "nextQuestion":
    			//ép kiểu từ object về String, up/down casting
    			String selectedDay2 = (String)session.getAttribute("selectedDay");
    		
    			// Truyền danh sách từ vựng đến JSP
    	        request.setAttribute("vocabularyList", createVocabularyList(selectedDay2));
    	        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/jsp/VocabularyQuiz.jsp");
    	        dispatcher1.forward(request, response);
    			break;
    		}
    	}

}
	private List<VocabularyItem> createVocabularyList(String selectedDay) {
		// Tạo danh sách từ vựng tương ứng với ngày đã chọn
		// Dựa vào selectedDay, bạn có thể quyết định sử dụng danh sách từ vựng nào
		List<VocabularyItem> vocabularyList = new ArrayList<>();
		// Ví dụ cho ngày "月"
		if ("月".equals(selectedDay)) {
			vocabularyList.add(new VocabularyItem("メソッド", "Method"));
			vocabularyList.add(new VocabularyItem("変数", "Variable"));
			vocabularyList.add(new VocabularyItem("オブジェクト", "Object"));
			vocabularyList.add(new VocabularyItem("配列", "Array"));
			vocabularyList.add(new VocabularyItem("条件分岐", "Conditional statements"));
			vocabularyList.add(new VocabularyItem("ループ", "Loop"));
			vocabularyList.add(new VocabularyItem("継承", "Inheritance"));
			vocabularyList.add(new VocabularyItem("インターフェース", "Interface"));
			vocabularyList.add(new VocabularyItem("例外処理", "Exception handling"));
			vocabularyList.add(new VocabularyItem("ジェネリクス", "Generics"));
			vocabularyList.add(new VocabularyItem("パッケージ", "Package"));
			vocabularyList.add(new VocabularyItem("インスタンス", "Instance"));
			vocabularyList.add(new VocabularyItem("ポリモーフィズム", "Polymorphism"));
			vocabularyList.add(new VocabularyItem("スレッド", "Thread"));
			vocabularyList.add(new VocabularyItem("コーディング", "Coding"));
			vocabularyList.add(new VocabularyItem("デバッグ", "Debug"));
			vocabularyList.add(new VocabularyItem("フレームワーク", "Framework"));

			return vocabularyList;
		} else if ("火".equals(selectedDay)) {
			vocabularyList.add(new VocabularyItem("ビジネス礼儀", "Business etiquette"));
			vocabularyList.add(new VocabularyItem("会議マナー", "Meeting etiquette"));
			vocabularyList.add(new VocabularyItem("電話マナー", "Telephone etiquette"));
			vocabularyList.add(new VocabularyItem("メールの作法", "Email etiquette"));
			vocabularyList.add(new VocabularyItem("服装マナー", "Dress code manners"));
			vocabularyList.add(new VocabularyItem("時間厳守", "Punctuality"));
			vocabularyList.add(new VocabularyItem("挨拶の仕方", "Greeting etiquette"));
			vocabularyList.add(new VocabularyItem("ビジネスボウ", "Bowing etiquette"));
			vocabularyList.add(new VocabularyItem("上司とのコミュニケーション", "Communication with superiors"));
			vocabularyList.add(new VocabularyItem("ビジネスプレゼンテーション", "Business presentation"));
			vocabularyList.add(new VocabularyItem("最新ニュース", "Latest news"));
			vocabularyList.add(new VocabularyItem("政治", "Politics"));
			vocabularyList.add(new VocabularyItem("経済", "Economy"));
			vocabularyList.add(new VocabularyItem("国際関係", "International relations"));
			vocabularyList.add(new VocabularyItem("社会問題", "Social issues"));
			vocabularyList.add(new VocabularyItem("環境問題", "Environmental issues"));
			vocabularyList.add(new VocabularyItem("科学技術の進歩", "Advances in science and technology"));
			vocabularyList.add(new VocabularyItem("イノベーション", "Innovation"));
			vocabularyList.add(new VocabularyItem("人権問題", "Human rights issues"));
			vocabularyList.add(new VocabularyItem("持続可能な発展", "Sustainable development"));

			return vocabularyList;
		} else if ("水".equals(selectedDay)) {
			vocabularyList.add(new VocabularyItem("就職", "Employment"));
			vocabularyList.add(new VocabularyItem("求人", "Job opportunity"));
			vocabularyList.add(new VocabularyItem("履歴書", "Resume"));
			vocabularyList.add(new VocabularyItem("面接", "Interview"));
			vocabularyList.add(new VocabularyItem("エントリーシート", "Application form"));
			vocabularyList.add(new VocabularyItem("内定", "Job offer"));
			vocabularyList.add(new VocabularyItem("選考", "Selection process"));
			vocabularyList.add(new VocabularyItem("インターンシップ", "Internship"));
			vocabularyList.add(new VocabularyItem("キャリアフェア", "Career fair"));
			vocabularyList.add(new VocabularyItem("転職", "Job change"));
			vocabularyList.add(new VocabularyItem("就活生", "Job-seeking student"));
			vocabularyList.add(new VocabularyItem("企業説明会", "Company information session"));
			vocabularyList.add(new VocabularyItem("紹介状", "Letter of introduction"));
			vocabularyList.add(new VocabularyItem("内々定", "Unofficial job offer"));
			vocabularyList.add(new VocabularyItem("職務経歴書", "Professional history"));

			return vocabularyList;
		} else if ("木".equals(selectedDay)) {
			vocabularyList.add(new VocabularyItem("コンピュータ基本操作", "Basic Computer Operation"));
			vocabularyList.add(new VocabularyItem("インターネット", "Internet"));
			vocabularyList.add(new VocabularyItem("ソフトウェア", "Software"));
			vocabularyList.add(new VocabularyItem("ハードウェア", "Hardware"));
			vocabularyList.add(new VocabularyItem("ネットワーク", "Network"));
			vocabularyList.add(new VocabularyItem("データベース", "Database"));
			vocabularyList.add(new VocabularyItem("クラウドコンピューティング", "Cloud Computing"));
			vocabularyList.add(new VocabularyItem("セキュリティ", "Security"));
			vocabularyList.add(new VocabularyItem("プログラミング", "Programming"));
			vocabularyList.add(new VocabularyItem("ファイル管理", "File Management"));
			vocabularyList.add(new VocabularyItem("ハッキング", "Hacking"));
			vocabularyList.add(new VocabularyItem("ウイルス対策", "Virus Protection"));
			vocabularyList.add(new VocabularyItem("バックアップ", "Backup"));
			vocabularyList.add(new VocabularyItem("インターフェース", "Interface"));
			vocabularyList.add(new VocabularyItem("ソーシャルメディア", "Social Media"));
			vocabularyList.add(new VocabularyItem("モバイルデバイス", "Mobile Devices"));
			vocabularyList.add(new VocabularyItem("プロジェクト管理", "Project Management"));
			vocabularyList.add(new VocabularyItem("サポート", "Support"));

			return vocabularyList;
		} else if ("金".equals(selectedDay)) {
			vocabularyList.add(new VocabularyItem("ネゴシエーション", "Negotiation"));
			vocabularyList.add(new VocabularyItem("チームワーク", "Teamwork"));
			vocabularyList.add(new VocabularyItem("コラボレーション", "Collaboration"));
			vocabularyList.add(new VocabularyItem("ファシリテーション", "Facilitation"));
			vocabularyList.add(new VocabularyItem("フィードバック", "Feedback"));
			vocabularyList.add(new VocabularyItem("レポート", "Report"));
			vocabularyList.add(new VocabularyItem("プロポーザル", "Proposal"));
			vocabularyList.add(new VocabularyItem("契約書", "Contract"));
			vocabularyList.add(new VocabularyItem("メール", "Email"));
			vocabularyList.add(new VocabularyItem("プレゼン資料", "Presentation Material"));
			vocabularyList.add(new VocabularyItem("企画書", "Business Plan"));
			vocabularyList.add(new VocabularyItem("請求書", "Invoice"));
			vocabularyList.add(new VocabularyItem("受領書", "Receipt"));
			vocabularyList.add(new VocabularyItem("報告書", "Report Document"));
			vocabularyList.add(new VocabularyItem("マニュアル", "Manual"));

			return vocabularyList;
		} else if ("土".equals(selectedDay)) {
			vocabularyList.add(new VocabularyItem("プログラム", "Program"));
			vocabularyList.add(new VocabularyItem("データベース", "Database"));
			vocabularyList.add(new VocabularyItem("設計", "Design"));
			vocabularyList.add(new VocabularyItem("開発者", "Developer"));
			vocabularyList.add(new VocabularyItem("テスト", "Testing"));
			vocabularyList.add(new VocabularyItem("プロジェクト", "Project"));
			vocabularyList.add(new VocabularyItem("仕様書", "Specification document"));
			vocabularyList.add(new VocabularyItem("ソフトウェア", "Software"));
			vocabularyList.add(new VocabularyItem("ハードウェア", "Hardware"));
			vocabularyList.add(new VocabularyItem("インターフェース", "Interface"));
			vocabularyList.add(new VocabularyItem("クライアント", "Client"));
			vocabularyList.add(new VocabularyItem("サーバー", "Server"));
			vocabularyList.add(new VocabularyItem("ソースコード", "Source code"));
			vocabularyList.add(new VocabularyItem("フレームワーク", "Framework"));
			vocabularyList.add(new VocabularyItem("セキュリティ", "Security"));
			vocabularyList.add(new VocabularyItem("バグ", "Bug"));
			vocabularyList.add(new VocabularyItem("アップデート", "Update"));
			vocabularyList.add(new VocabularyItem("マイクロサービス", "Microservices"));

			return vocabularyList;
		}

		return vocabularyList; // Trả về danh sách trống nếu không có ngày nào khớp
	}
}
