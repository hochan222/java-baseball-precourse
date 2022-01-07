package baseball;

import nextstep.utils.Randoms;

public class Util {

    public static void resetBallCount(StringBuilder str) {
        str.setLength(0);
    }

    public static int getRandomSingleDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
