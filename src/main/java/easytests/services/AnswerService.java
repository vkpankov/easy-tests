package easytests.services;

import easytests.entities.Answer;
import easytests.mappers.AnswersMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vkpankov
 */
@Service
public class AnswerService {

    @Autowired
    private AnswersMapper answersMapper;

    public void saveAnswer(Answer answer) {

        Answer readAnswer = null;

        if (answer.getId() != null) {
            readAnswer = getAnswerById(answer.getId());
        }
        if (readAnswer == null) {
            answersMapper.create(answer);
        } else {

            answersMapper.update(answer);

        }
    }

    public void deleteAnswer(Answer answer) {

        answersMapper.delete(answer);

    }

    public Answer getAnswerById(Integer id) {

        return answersMapper.readById(id);

    }

    public List<Answer> getAnswersByQuestionId(int questionId) {

        return answersMapper.readByQuestionId(questionId);

    }

}
