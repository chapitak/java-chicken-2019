import controller.OrderController;
import controller.PaymentController;
import domain.MainMenu;
import domain.MainMenuRepository;
import domain.TableRepository;
import domain.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Tables tables = new Tables(TableRepository.tables());
        int mainMenuNumber;
        do {
            final List<MainMenu> mainMenus = MainMenuRepository.mainMenus();
            OutputView.printMainMenu(mainMenus);

            mainMenuNumber = InputView.inputMainMenuNumber();

            if (mainMenuNumber == 1) {
                OrderController orderController = new OrderController(tables);
                orderController.run();
            }
            if (mainMenuNumber == 2) {
                PaymentController paymentController = new PaymentController(tables);
                paymentController.run();
            }
        } while (mainMenuNumber != 3);

    }
}
