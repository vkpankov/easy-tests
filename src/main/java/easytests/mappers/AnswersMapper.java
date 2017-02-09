package easytests.mappers;

import easytests.entities.Answer;

import java.util.List;
import org.apache.ibatis.annotations.*;

/**
 * @author vkpankov
 */
@Mapper
public interface AnswersMapper {

    @Select("SELECT answer_id,answer_text,answer_qid FROM answers WHERE answer_id = #{answerId}")
    @Results({
            @Result(property = "id", column = "answer_id"),
            @Result(property = "text", column = "answer_text"),
            @Result(property = "questionId", column = "answer_qid")
            })
    Answer readById(Integer answerId);

    @Select("SELECT * FROM answers WHERE answer_qid = #{qId}")
    @Results({
            @Result(property = "id", column = "answer_id"),
            @Result(property = "text", column = "answer_text"),
            @Result(property = "questionId", column = "answer_qid")
            })
    List<Answer> readByQuestionId(Integer qId);

    @Insert("INSERT INTO answers (answer_text,answer_qid) VALUES (#{text},#{questionId})")
    @Options(useGeneratedKeys = true, keyColumn = "answer_id")
    int create(Answer answer);

    @Delete("DELETE FROM answers WHERE answer_id=#{id}")
    int delete(Answer answer);

    @Update("UPDATE answers SET answer_text=#{text} WHERE answer_id=#{id}")
    int update(Answer answer);

}
