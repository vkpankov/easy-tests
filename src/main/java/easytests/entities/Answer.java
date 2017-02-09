package easytests.entities;

import easytests.entities.answer.CommonFieldsInterface;

public class Answer implements CommonFieldsInterface {
    private Integer id;
    private String text;
    private Integer questionId;

    public Integer getId() {
        return this.id;
    }
    public Answer setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getQuestionId() {
        return this.questionId;
    }
    public Answer setQuestionId(Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public Answer setText(String text){
        this.text = text;
        return this;
    }
}
