package baseball;

import nextstep.utils.*;

public class BaseballGame {
    String _state = new String("");

    StringBuilder _computerNumber = new StringBuilder();
    StringBuilder _userNumber = new StringBuilder();
    int _retryCount = 0;

    public int getRandomSingleDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void setComputerNumber() {
        _computerNumber.append(getRandomSingleDigit()).append(getRandomSingleDigit())
            .append(getRandomSingleDigit());
    }

//    public void getUserInput() {
//        String input = Console.readLine();
//        System.out.println("숫자를 입력해 주세요 : " + input);
//    }

    public void getUserInputNumber() {

    }

    public void checkValidInput() {

    }

    public void init() {

    }

    public void printComputerNumber() {
        System.out.println(_computerNumber.toString());
    }

    public void play() {
        setComputerNumber();
//        getUserInput();

        printComputerNumber();
    }
}
