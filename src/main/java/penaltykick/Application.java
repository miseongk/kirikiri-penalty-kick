package penaltykick;

import penaltykick.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
