package org.researchstack.backbone.step.navigation;

import org.researchstack.backbone.model.survey.NavigationStep;
import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.result.TaskResult;
import org.researchstack.backbone.step.FormStep;
import org.researchstack.backbone.step.QuestionStep;

import java.util.List;

/**
 * Created by TheMDP on 1/3/17.
 */

public class NavigationFormStep extends FormStep implements NavigationStep {

    // MARK: Stuff you can't extend on a protocol
    String skipToStepIdentifier;
    boolean skipIfPassed;

    public NavigationFormStep(String identifier, String title, String text) {
        super(identifier, title, text);
    }

    public NavigationFormStep(String identifier, String title, String text, List<QuestionStep> steps) {
        super(identifier, title, text, steps);
    }

    @Override
    public String getNextStepIdentifier(TaskResult result, List<TaskResult> additionalTaskResults) {
        // TODO: this is what is called SBADirectNavigationalRule, is this what we want?
        return skipToStepIdentifier;
    }

    @Override
    public QuestionStep matchingSurveyStep(StepResult result) {
        if (result.getIdentifier().equals(getIdentifier())) {
            return this;
        }
        return null;
    }

    @Override
    public String getSkipToStepIdentifier() {
        return skipToStepIdentifier;
    }

    @Override
    public void setSkipToStepIdentifier(String identifier) {
        skipToStepIdentifier = identifier;
    }

    @Override
    public boolean getSkipIfPassed() {
        return skipIfPassed;
    }

    @Override
    public void setSkipIfPassed(boolean skipIfPassed) {
        this.skipIfPassed = skipIfPassed;
    }
}
