package Lesson8.Mediator;

public interface Mediator {
    public void notify(Component sender, String event);
    public Component getOkButton();
    public Component getRegButton();
    public Component getLogButton();
    public Component getLoginUsername();
    public Component getLoginPassword();
    public Component getRegistrationUsername();
    public Component getRegistrationPassword();
    public Component getRegistrationEmail();
    public Component getCheckbox();
}
