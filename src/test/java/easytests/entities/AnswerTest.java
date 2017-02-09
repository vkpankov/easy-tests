package easytests.entities;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author vkpankov
 */
public class AnswerTest {
    @Test
    public void testQuestionType() throws Exception {
        Answer testAnswer = new Answer();
        testAnswer.setQuestionId(1);
        assertEquals(1, (long)testAnswer.getQuestionId());
    }

    @Test
    public void testText() throws Exception {
        Answer testAnswer = new Answer();
        testAnswer.setText("test");
        assertEquals("test", testAnswer.getText());
    }
}
