package easytests.entities;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author vkpankov
 */
public class QuestionTest {
    @Test
    public void testType() throws Exception {
        Question testQuestion = new Question();
        testQuestion.setType(1);
        assertEquals(1, (long)testQuestion.getType());
    }

    @Test
    public void testText() throws Exception {
        Question testQuestion = new Question();
        testQuestion.setText("test");
        assertEquals("test", testQuestion.getText());
    }

    @Test
    public void testAnswers() throws Exception {
        Question testQuestion = new Question();

        Answer answer = new Answer();
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(answer);

        testQuestion.setAnswers(answers);
        assertEquals(answers,testQuestion.getAnswers());

    }

}
