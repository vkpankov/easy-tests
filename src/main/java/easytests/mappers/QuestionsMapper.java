package easytests.mappers;

import easytests.entities.Answer;
import easytests.entities.Question;

import java.util.List;
import org.apache.ibatis.annotations.*;

/**
 * @author vkpankov
 */
@Mapper
public interface QuestionsMapper {

    @Select("SELECT answer_id,answer_text FROM answers WHERE answer_qid=#{qId}")
    @Results(
            {
                    @Result(property = "id", column = "answer_id"),
                    @Result(property = "text", column = "answer_text"),
                    @Result(property = "questionId", column = "answer_qid")
            })
    List<Answer> readAnswerByQuestionId(Integer qId);

    @Select("SELECT question_id,question_text,question_type FROM questions WHERE question_id=#{qId}")
    @Results(
            {
                    @Result(property = "id", column = "question_id"),
                    @Result(property = "text", column = "question_text"),
                    @Result(property = "type", column = "question_type"),
                    @Result(property = "answers", column = "question_id", javaType = List.class,
                            many = @Many(select = "readAnswerByQuestionId"))
            })
    Question readById(Integer qId);

    @Select("SELECT question_id,question_text FROM questions")
    @Results(
            {
                    @Result(property = "id", column = "question_id"),
                    @Result(property = "text", column = "question_text"),
                    @Result(property = "type", column = "question_type"),
                    @Result(property = "answers", column = "question_id", javaType = List.class,
                            many = @Many(select = "readAnswerByQuestionId"))
            })
    List<Question> readAll();

    @Insert("INSERT INTO questions (question_text,question_type) VALUES (#{text},#{type})")
    @Options(useGeneratedKeys = true, keyColumn = "question_id")
    void create(Question question);

    @Update("UPDATE questions SET question_text=#{text}, question_type=#{type} WHERE question_id=#{id}")
    void update(Question question);

    @Delete("DELETE FROM questions WHERE question_id=#{id}")
    void delete(Question question);

}
