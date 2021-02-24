package Lesson8.Mediator;

public class Checkbox implements Component {
    Mediator dialog;
    boolean check = false;

    public Checkbox(Mediator dialog) {
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

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public void check() {
        dialog.notify(this, "check");
    }
}
