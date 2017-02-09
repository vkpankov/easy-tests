package easytests.entities;

import easytests.entities.question.CommonFieldsInterface;

import java.util.List;

public class Question implements CommonFieldsInterface {
    private Integer id;
    private String text;
    private Integer type;
    private List<Answer> answers;


    public Integer getId() {
        return this.id;
    }
    public Question setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public Integer getType() {
        return this.type;
    }
    @Override
    public Question setType(Integer type) {
        this.type = type;
        return this;
    }

    @Override
    public String getText() {
        return this.text;
    }
    @Override
    public Question setText(String text){
        this.text = text;
        return this;
    }

    @Override
    public List<Answer> getAnswers(){
        return this.answers;
    }

    @Override
    public Question setAnswers(List<Answer> answers){
        this.answers = answers;
        return this;
    }

}
