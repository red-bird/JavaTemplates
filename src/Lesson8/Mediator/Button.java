package Lesson8.Mediator;

public class Button implements Component {
    Mediator dialog;

    public Button(Mediator dialog) {
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

    public void click(){
        dialog.notify(this, "click");
    }
}
