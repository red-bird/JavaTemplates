package Lesson8.Mediator;

public class AuthenticationDialog implements Mediator {
    private String title;
    private Checkbox checkbox;
    private Textbox loginUsername, loginPassword;
    private Textbox registrationUsername, registrationPassword, registrationEmail;
    private Button okButton, regButton, logButton;

    public AuthenticationDialog() {
        this.title = "Main";
        this.checkbox = new Checkbox(this);
        checkbox.setCheck(false);
        this.loginPassword = new Textbox(this);
        this.loginUsername = new Textbox(this);
        this.registrationEmail = new Textbox(this);
        this.registrationPassword = new Textbox(this);
        this.registrationUsername = new Textbox(this);
        this.okButton = new Button(this);
        this.regButton = new Button(this);
        this.logButton = new Button(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == logButton && event.equals("click")){
            title = "Login in";
            System.out.println("Login in page");
        }
        if (sender == regButton && event.equals("click")){
            title = "Registration";
            System.out.println("Registration page");
        }
        if (sender == okButton && event.equals("click")) {
            if (title.equals("Login in")){
                if (loginUsername.getText().equals("admin")  && loginPassword.getText().equals("admin")){
                    title = "Logged in";
                    System.out.println("Logged in");
                }
                else {
                    System.out.println("Wrong username or password");
                }
            }
            else if (title.equals("Registration")){
                // some registration logic
                title = "Logged in";
                System.out.println("Registration complete");
            }
        }

    }


    public String getTitle() {
        return title;
    }

    public Checkbox getCheckbox() {
        return checkbox;
    }

    public Textbox getLoginUsername() {
        return loginUsername;
    }

    public Textbox getLoginPassword() {
        return loginPassword;
    }

    public Textbox getRegistrationUsername() {
        return registrationUsername;
    }

    public Textbox getRegistrationPassword() {
        return registrationPassword;
    }

    public Textbox getRegistrationEmail() {
        return registrationEmail;
    }

    public Button getOkButton() {
        return okButton;
    }

    public Button getRegButton() {
        return regButton;
    }

    public Button getLogButton() {
        return logButton;
    }
}
