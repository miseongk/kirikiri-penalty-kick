package penaltykick;

import java.util.Scanner;

public class Application {
    private static final int shoot = 5;
    private static final int numberLimit = 3;
    private static final int one = 1;
    private static final int zero = 0;

    private static class Computer {
        int[] com = new int[shoot];
        private void setPosition() {
            for (int i = 0; i < shoot; i++) {
                com[i] = (int) (Math.random() * numberLimit + one);
            }
        }
        public int[] getPosition() {
            return com;
        }
    }

    private static class Player {
        int[] player = new int[shoot];

        public int[] getPosition() {
            return player;
        }

        public void setPosition(int[] input) {
            for (int i : input) {
                player[i] = input[i];
            }
        }
    }

    private static char[] Result(Computer com, Player player) {
        char[] result = new char[shoot];
        for (int i = 0; i < shoot; i++) {
            if (com.getPosition()[i] != player.getPosition()[i]) {
                result[i] = 'O';
            } else result[i] = 'X';
        }
        return result;
    }

    private static int Score(char[] result, int score) {
        for (int i = 0; i < shoot; i++) {
            if (result[i] == 'O') {
                score++;
            }
        }
        return score;
    }
    private static void GameResult(Player player1, Player player2, Computer com) {
        char[] result1;
        int score1 = zero;
        char[] result2;
        int score2 = zero;

        result1 = Result(com, player1);
        result2 = Result(com, player2);

        System.out.print("플레이어1 : ");
        for (char c : result1) {
            System.out.print(c+" ");
        }
        System.out.print("\n플레이어2 : ");
        for (char c : result2) {
            System.out.print(c+" ");
        }
        score1 = Score(result1, score1);
        score2 = Score(result2, score2);

        if (score1 == score2) {
            System.out.println("\n무승부입니다.");
        } else if (score1 > score2) {
            System.out.print("\n플레이어1이(가) 우승했습니다\uD83C\uDF89");
        } else System.out.println("\n플레이어2이(가) 우승했습니다\uD83C\uDF89");
    }
    public static void main(String[] args) {
        int[] tmp = new int[shoot];

        Computer com = new Computer();
        com.setPosition();

        Scanner sc = new Scanner(System.in);

        System.out.print("\n플레이어1 : ");
        try {
            for (int i : tmp) {
                tmp[i] = sc.nextInt();
                if (tmp[i] > shoot || tmp[i] < one) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error!");
        }
        Player player1 = new Player();
        player1.setPosition(tmp);

        System.out.print("플레이어2 : ");
        try {
            for (int i : tmp) {
                tmp[i] = sc.nextInt();
                if (tmp[i] > shoot || tmp[i] < one) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error!");
        }
        Player player2 = new Player();
        player2.setPosition(tmp);

        System.out.println("\n게임 결과");

        GameResult(player1, player2, com);
    }
}
