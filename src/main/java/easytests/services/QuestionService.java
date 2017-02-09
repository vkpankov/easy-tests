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

    public void insertQuestionWithAnswers(Question question) {
        questionsMapper.create(question);
        for (Answer answer: question.getAnswers()) {
            answer.setQuestionId(question.getId());
            answersMapper.create(answer);
        }

    }

    public void updateQuestion(Question question) {
        questionsMapper.update(question);
        final List<Answer> answers = question.getAnswers();

        for (Answer answer: answers) {

            answersMapper.update(answer);

        }
    }

    public void deleteQuestion(Question question) {

        questionsMapper.delete(question);

        final List<Answer> answers = question.getAnswers();
        for (Answer answer: answers) {

            answersMapper.delete(answer);

        }

    }

    public Question getQuestionById(Integer id) {
        return questionsMapper.readById(id);
    }

    public List<Question> getAllQuestions() {
        return questionsMapper.readAll();
    }

}
