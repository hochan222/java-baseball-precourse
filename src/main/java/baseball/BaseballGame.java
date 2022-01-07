package baseball;

import nextstep.utils.*;

//String input = Console.readLine();
//System.out.println("input : " + input);

public class BaseballGame {
    int _computerInputNumber = 0;
    int _retryCount = 0;

    public void getRandomSingleDigit() {
        int randomNumber = Randoms.pickNumberInRange(0, 1);
        System.out.println(randomNumber);
    }

    public void getComputerInputNumber() {

    }

    public void getUserInputNumber() {

    }

    public void checkValidInput() {

    }

    public void console_log() {
        System.out.printf("Hello world");
    }
}
