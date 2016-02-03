package co.touchlab.researchstack.backbone.step;

import co.touchlab.researchstack.backbone.answerformat.AnswerFormat;

public class QuestionStep extends Step
{
    private AnswerFormat answerFormat;

    private String placeholder;

    public QuestionStep(String identifier)
    {
        super(identifier);
    }

    public QuestionStep(String identifier, String title)
    {
        super(identifier, title);
        setOptional(true);
        setUseSurveyMode(true);
    }

    public QuestionStep(String identifier, String title, AnswerFormat format)
    {
        super(identifier, title);
        this.answerFormat = format;
    }

    @Override
    public Class getStepLayoutClass()
    {
        return getQuestionType().getStepBodyClass();
    }

    public AnswerFormat getAnswerFormat()
    {
        return answerFormat;
    }

    public void setAnswerFormat(AnswerFormat answerFormat)
    {
        this.answerFormat = answerFormat;
    }

    public String getPlaceholder()
    {
        return placeholder;
    }

    public void setPlaceholder(String placeholder)
    {
        this.placeholder = placeholder;
    }

    public AnswerFormat.QuestionType getQuestionType()
    {
        return answerFormat.getQuestionType();
    }
}
