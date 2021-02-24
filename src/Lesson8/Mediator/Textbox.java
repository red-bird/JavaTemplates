package Lesson8.Mediator;

public class Textbox implements Component {
    Mediator dialog;
    String text = "";

    public Textbox(Mediator dialog) {
        this.dialog = dialog;
    }

    @Override
    public void setMediator(Mediator mediator) {
        dialog = mediator;
    }

    @Override
    public String getName() {
        return "Checkbox";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
