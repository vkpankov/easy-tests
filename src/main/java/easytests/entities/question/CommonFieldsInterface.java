package easytests.entities.question;

import easytests.entities.Answer;
import easytests.entities.Question;

import java.util.List;

/**
 * Created by Admin on 08.02.2017.
 */
public interface CommonFieldsInterface {
    public String getText();
    public Question setText(String text);
    public Integer getType();
    public Question setType(Integer text);

    public List<Answer> getAnswers();
    public Question setAnswers(List<Answer> answers);

}
