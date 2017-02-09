package easytests.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import easytests.config.DatabaseConfig;
import easytests.entities.Answer;
import easytests.entities.Question;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import static org.junit.Assert.*;

/**
 * @author vkpankov
 */

@ComponentScan
@SpringBootTest
@RunWith(SpringRunner.class)

public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    private Question genTestQuestion(){

        Question testQuestion = new Question();
        testQuestion.setType(0);
        testQuestion.setText("testquestion");

        Answer answer = new Answer();
        answer.setText("testanswer");

        List<Answer> answers = new ArrayList<Answer>();
        answers.add(answer);
        testQuestion.setAnswers(answers);

        return testQuestion;
    }


    @Test
    @Transactional
    @Rollback(true)
    public void testInsertQuestionWithAnswers(){
        Question testQuestion = genTestQuestion();

        questionService.insertQuestionWithAnswers(testQuestion);

        Question question = questionService.getQuestionById(testQuestion.getId());

        assertNotNull(question);
        assertEquals("testquestion", question.getText());
        assertEquals("testanswer",question.getAnswers().get(0).getText());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateQuestion()
    {
        Question testQuestion = genTestQuestion();

        questionService.insertQuestionWithAnswers(testQuestion);

        testQuestion.setText("updatedtext");
        Answer testAnswer = testQuestion.getAnswers().get(0);
        testAnswer.setText("updatedanswer");

        questionService.updateQuestion(testQuestion);

        Question updatedQuestion = questionService.getQuestionById(testQuestion.getId());

        assertEquals("updatedtext",updatedQuestion.getText());
        assertEquals("updatedanswer",updatedQuestion.getAnswers().get(0).getText());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteQuestion(){

        Question testQuestion = genTestQuestion();

        questionService.insertQuestionWithAnswers(testQuestion);
        questionService.deleteQuestion(testQuestion);

        Question deletedQuestion = questionService.getQuestionById(testQuestion.getId());

        assertNull(deletedQuestion);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetQuestionById()
    {
        Question testQuestion = genTestQuestion();
        questionService.insertQuestionWithAnswers(testQuestion);

        Question question = questionService.getQuestionById(testQuestion.getId());

        assertNotNull(question);
        assertEquals(testQuestion.getAnswers().size(),question.getAnswers().size());
        assertEquals(testQuestion.getAnswers().get(0).getText(),question.getAnswers().get(0).getText());

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetAllQuestions()
    {
        Question testQuestion = genTestQuestion();

        questionService.insertQuestionWithAnswers(testQuestion);

        List<Question> questions = questionService.getAllQuestions();
        assertNotNull(questions);
    }


}
