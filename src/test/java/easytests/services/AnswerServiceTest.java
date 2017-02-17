package easytests.services;

import java.util.List;

import easytests.entities.Answer;
import easytests.entities.Question;
import easytests.mappers.AnswersMapper;
import easytests.mappers.QuestionsMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.*;

import javax.annotation.PostConstruct;

import static org.junit.Assert.*;

/**
 * @author vkpankov
 */

@ComponentScan
@SpringBootTest
@RunWith(SpringRunner.class)

public class AnswerServiceTest {

    @InjectMocks
    private  AnswerService answerService;
    @Mock
    private AnswersMapper answersMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    @Rollback
    public void testGetAnswerById()
    {

        Answer answer = answerService.getAnswerById(1);
        verify(answersMapper).readById(1);

    }

    @Test
    @Rollback
    public void testGetAnswersByQuestionId() {

        List<Answer> answers = answerService.getAnswersByQuestionId(1);
        verify(answersMapper).readByQuestionId(1);

    }


    @Test
    @Rollback
    public void testSaveAnswer() {


        Answer testAnswer = new Answer();
        testAnswer.setQuestionId(1);
        testAnswer.setText("test");

        answerService.saveAnswer(testAnswer);
        verify(answersMapper).create(testAnswer);
        //TODO: Add verify for saveAnswer(update)
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteAnswer(){

        Answer testAnswer = new Answer();
        testAnswer.setId(1);
        testAnswer.setText("test");

        answerService.deleteAnswer(testAnswer);

        verify(answersMapper).delete(testAnswer);

    }

}
