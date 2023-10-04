package penaltykick;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainController controller = new MainController(new GameService());
        controller.run();
    }
}
