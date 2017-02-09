package easytests.mappers;

import easytests.entities.Answer;
import easytests.entities.Question;
import easytests.services.QuestionService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author vkpankov
 */

@ComponentScan
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnswersMapperTest {
    @Autowired
    private AnswersMapper answersMapper;
    @Autowired
    private QuestionsMapper questionsMapper;

    private Question testQuestion;
    private Answer testAnswer;

    private Answer genTestAnswer(){
        Answer answer = new Answer();
        answer.setQuestionId(testQuestion.getId());
        answer.setText("test");
        return answer;
    }

    @Before
    public void setup(){
        testQuestion = new Question();
        testQuestion.setText("test");
        testQuestion.setType(0);
        questionsMapper.create(testQuestion);
    }
    @After
    public void clean(){
        questionsMapper.delete(testQuestion);
        testQuestion = null;
    }


    @Test
    @Rollback(true)
    public void testCreate()
    {
       Answer testAnswer = genTestAnswer();
        answersMapper.create(testAnswer);
        Answer selAnswer  = answersMapper.readById(testAnswer.getId());
        assertNotNull(selAnswer);
        assertEquals("test",selAnswer.getText());
    }

    @Test
    @Rollback(true)
    public void testDelete()
    {
        Answer testAnswer = genTestAnswer();
        answersMapper.create(testAnswer);
        answersMapper.delete(testAnswer);
        Answer selAnswer  = answersMapper.readById(testAnswer.getId());
        assertNull(selAnswer);
    }

    @Test
    @Rollback(true)
    public void testUpdate()
    {
        Answer testAnswer = genTestAnswer();
        answersMapper.create(testAnswer);
        testAnswer.setText("updated");
        answersMapper.update(testAnswer);
        Answer selAnswer  = answersMapper.readById(testAnswer.getId());
        assertEquals("updated",selAnswer.getText());
    }

    @Test
    @Rollback(true)
    public void testReadByQuestionId() {
        Answer testAnswer = genTestAnswer();
        answersMapper.create(testAnswer);
        List<Answer> answers = answersMapper.readByQuestionId(testQuestion.getId());
        assertNotNull(answers);
        assertEquals(1,answers.size());
        assertEquals("test", answers.get(0).getText());
    }



}
