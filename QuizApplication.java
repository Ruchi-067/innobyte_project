import java.util.*;

class QuizApplication {

    static class Question {
        String questionText;
        List<String> options;
        int correctAnswer;

        public Question(String questionText, List<String> options, int correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public boolean isCorrect(int answer) {
            return answer == correctAnswer;
        }

        public void display() {
            System.out.println(questionText);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
        }
    }

    static class Quiz {
        String title;
        List<Question> questions;

        public Quiz(String title) {
            this.title = title;
            this.questions = new ArrayList<>();
        }

        public void addQuestion(Question question) {
            questions.add(question);
        }

        public void start() {
            System.out.println("Starting Quiz: " + title);
            Scanner scanner = new Scanner(System.in);
            int score = 0;

            for (Question question : questions) {
                question.display();
                System.out.print("Enter your answer (1-" + question.options.size() + "): ");
                int answer = scanner.nextInt();
                if (question.isCorrect(answer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer was: " + question.correctAnswer);
                }
                System.out.println();
            }

            System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Quiz Application!");

        Quiz quiz = new Quiz("General Knowledge Quiz");
        quiz.addQuestion(new Question(
                "What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Lisbon"),
                3
        ));
        quiz.addQuestion(new Question(
                "Which planet is known as the Red Planet?",
                Arrays.asList("Earth", "Mars", "Jupiter", "Venus"),
                2
        ));
        quiz.addQuestion(new Question(
                "What is the largest mammal?",
                Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Great White Shark"),
                2
        ));

        quiz.start();

        System.out.println("Thank you for playing!");
    }
}

