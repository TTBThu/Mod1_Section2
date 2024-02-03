<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="xamp.VocabularyItem" %>
<%@ page import="xamp.Answer" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vocabulary Quiz</title>
    <script>
        function submitAnswer(selectedAnswer, correctAnswer, question) {
        	console.log(question);
        	<%! HttpSession session = request.getSession(); %>
        	Map<String, String> map1 = session.getAttribute("answer");
        	if (map1 == null) {
        		map1 = new HashMap<>();
        	}
            if (selectedAnswer === correctAnswer) {
            	map1.put(question, new Answer(selectedAnswer, true));
                alert("Correct!");
                
            } else {
            	map1.put(question, new Answer(selectedAnswer, false));
                alert("Incorrect. The correct answer is: " + correctAnswer);
            }
            setTimeout(function() {
                document.getElementById("quizForm").submit();
            }, 5000);
        }

        function updateQuiz() {
            document.getElementById("quizForm").submit();
        }
    </script>
</head>
<body>
    <h2>Vocabulary Quiz</h2>

    <form id="quizForm" action="DaySelectionServlet" method="post">
        <ul>
            <% 
                List<VocabularyItem> vocabularyList = (List<VocabularyItem>)request.getAttribute("vocabularyList");
                
                if (!vocabularyList.isEmpty()) {
                    Random random = new Random();
                    VocabularyItem quizItem = vocabularyList.get(random.nextInt(vocabularyList.size()));

                    // Lấy danh sách đáp án (bao gồm cả đáp án đúng và 3 đáp án sai)
                    List<String> answerOptions = new ArrayList<>();
                    answerOptions.add(quizItem.getDefinition());
                    while (answerOptions.size() < 4) {
                        VocabularyItem randomOption = vocabularyList.get(random.nextInt(vocabularyList.size()));
                        if (!answerOptions.contains(randomOption.getDefinition())) {
                            answerOptions.add(randomOption.getDefinition());
                        }
                    }

                    // Trộn ngẫu nhiên danh sách đáp án
                    Collections.shuffle(answerOptions);

                    // Hiển thị câu hỏi và đáp án
            %>
            <li>
                <strong><%= quizItem.getTerm() %></strong>: <br>
                <% for (int i = 0; i < answerOptions.size(); i++) { %>
                    <label>
                        <input type="radio" name="selectedAnswer" value="<%= answerOptions.get(i) %>" 
                               onclick="submitAnswer(this.value, '<%= quizItem.getDefinition() %>', '<%= quizItem.getTerm() %>')">
                        <%= answerOptions.get(i) %>
                    </label>
                    <br>
                <% } %>
            </li>
        </ul>
        <input type="hidden" name="action" value="nextQuestion">
        
        <% } else { %>
            <p>No vocabulary items available.</p>
        <% } %>
    </form>

    <!-- Add quiz functionality or other features as needed -->
</body>
</html>
