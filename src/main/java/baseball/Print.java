package baseball;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public static void printEndGame() {
        System.out.printf("게임 끝");
    }

    public static void printEnterNumber() {
        System.out.printf("숫자를 입력해 주세요 : ");
    }

    public static void printComputerBallCount(StringBuilder computerBallCount) {
        System.out.println("computer number: " + computerBallCount.toString());
    }

    public static void printCheckGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printSuccessfulGameEnd() {
        System.out.println("3스트라이크");
        System.out.println("세개의 숫자를 모두 맞히셨습니다. 게임 종료");
    }

    public static void printFeedback(int strikeCount, int ballCount) {
        List<String> baseballBallCount = new ArrayList<String>();

        if (isExistCount(strikeCount)) {
            baseballBallCount.add(strikeCount + "스트라이크");
        }

        if (isExistCount(ballCount)) {
            baseballBallCount.add(ballCount + "볼");
        }

        if (!isExistCount(strikeCount) && !isExistCount(ballCount)) {
            baseballBallCount.add("낫싱");
        }

        String result = String.join(" ", baseballBallCount);

        System.out.println(result);
    }

    public static boolean isExistCount(int count) {
        return count > 0;
    }
}
