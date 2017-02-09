package easytests.mappers;

import easytests.entities.Answer;
import easytests.entities.Question;
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
public class QuestionsMapperTest {

    @Autowired
    private QuestionsMapper questionsMapper;

    private Question genTestQuestion(){
        Question testQuestion = new Question();
        testQuestion.setText("test");
        testQuestion.setType(0);
        return testQuestion;
    }


    @Test
    @Rollback(true)
    public void testReadById() {
        Question testQuestion = genTestQuestion();
        questionsMapper.create(testQuestion);
        Question selQuestion  = questionsMapper.readById(testQuestion.getId());
        assertEquals(testQuestion.getText(),selQuestion.getText());
    }

    @Test
    @Rollback(true)
    public void testReadAll() {
        Question testQuestion = genTestQuestion();
        questionsMapper.create(testQuestion);
        List<Question> questions  = questionsMapper.readAll();
        assertNotNull(questions);
    }

    @Test
    @Rollback(true)
    public void testCreate()
    {
        Question testQuestion = genTestQuestion();
        questionsMapper.create(testQuestion);
        Question selQuestion  = questionsMapper.readById(testQuestion.getId());
        assertNotNull(selQuestion);
        assertEquals("test",selQuestion.getText());
    }

    @Test
    @Rollback(true)
    public void testDelete()
    {
        Question testQuestion = genTestQuestion();
        questionsMapper.create(testQuestion);
        questionsMapper.delete(testQuestion);
        Question selQuestion  = questionsMapper.readById(testQuestion.getId());
        assertNull(selQuestion);
    }

    @Test
    @Rollback(true)
    public void testUpdate()
    {
        Question testQuestion = genTestQuestion();
        questionsMapper.create(testQuestion);
        testQuestion.setText("updated");
        questionsMapper.update(testQuestion);
        Question selQuestion  = questionsMapper.readById(testQuestion.getId());
        assertEquals("updated",selQuestion.getText());
    }

}
