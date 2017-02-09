package easytests.entities.question;

import easytests.entities.Answer;
import easytests.entities.Question;

import java.util.List;

/**
 * @author vkpankov
 */
public interface CommonFieldsInterface {
    String getText();

    Question setText(String text);

    Integer getType();

    Question setType(Integer text);

    List<Answer> getAnswers();

    Question setAnswers(List<Answer> answers);

}
