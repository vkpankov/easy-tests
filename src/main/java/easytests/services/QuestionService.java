package easytests.services;

import easytests.entities.Answer;
import easytests.entities.Question;
import easytests.mappers.AnswersMapper;
import easytests.mappers.QuestionsMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vkpankov
 */

@Service
public class QuestionService {

    @Autowired
    private AnswersMapper answersMapper;

    @Autowired
    private QuestionsMapper questionsMapper;

    public static boolean containsId(List<Answer> list, int id) {

        for (Answer answer : list) {
            if (answer.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void saveQuestion(Question question) {
        Question readQuestion = null;

        if (question.getId() != null) {
            readQuestion = questionsMapper.readById(question.getId());
        }

        if (readQuestion == null) {
            questionsMapper.create(question);
        } else {
            questionsMapper.update(question);
        }
    }

    public void saveQuestionWithAnswers(Question question) {

        Question readQuestion = null;

        if (question.getId() != null) {
            readQuestion = questionsMapper.readById(question.getId());
        }

        final List<Answer> answers = question.getAnswers();

        if (readQuestion == null) {

            questionsMapper.create(question);

            for (Answer answer: answers) {
                answer.setQuestionId(question.getId());
                answersMapper.create(answer);
            }

        } else {

            questionsMapper.update(question);

            final List<Answer> readAnswers = readQuestion.getAnswers();

            for (Answer answer: readAnswers) {

                if (!containsId(answers, answer.getId())) {

                    answersMapper.delete(answer);

                }

            }

            for (Answer answer: answers) {

                if (answer.getId() != null) {

                    answersMapper.update(answer);

                } else {
                    answer.setQuestionId(question.getId());
                    answersMapper.create(answer);
                }

            }

        }
    }

    public void deleteQuestion(Question question) {

        questionsMapper.delete(question);

    }

    public Question getQuestionById(Integer id) {

        return questionsMapper.readById(id);

    }

    public List<Question> getAllQuestions() {
        return questionsMapper.readAll();
    }

}
