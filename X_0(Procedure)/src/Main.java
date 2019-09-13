import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int stepsCount = 9;

        String player1 = "Player1";
        String player2 = "Player2";

        String currentPlayer = player1;

        char player1Symbol = 'X';
        char player2Symbol = '0';

        char defaultSymbol = '_';

        int[][] finishResults = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


        char[] board = new char[9];

        for (int i = 0; i < board.length; i++)
        {
            board[i] = defaultSymbol;
        }


        while (stepsCount > 0)
        {
            // Вывод игрового поля

            System.out.println();
            System.out.println();

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    int symbolIndex = i * 3 + j;
                    char symbol = board[symbolIndex];

                    System.out.print("|" + symbol);
                }

                System.out.println("|");
            }

            System.out.println();
            System.out.println();

            // Делаем ход

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ходит " + currentPlayer + ".");
            System.out.print(currentPlayer + ", введите номер ячейки в которую хотите сделать ход (от 1 до 9): ");

            int cellIndex = scanner.nextInt() - 1;

            if(cellIndex < 0 || cellIndex > 8 || board[cellIndex] != defaultSymbol)
            {
                System.out.println();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Ячейка занята, либо введен неправильный номер. Выбирете другую.");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println();
                continue;
            }

            char currentPlayerSymbol;

            if (currentPlayer.equals(player1))
            {
                currentPlayerSymbol = player1Symbol;
            }else
            {
                currentPlayerSymbol = player2Symbol;
            }

            board[cellIndex] = currentPlayerSymbol;

            stepsCount--;

            // Проверяем на победу

            for (int i = 0; i < finishResults.length; i++)
            {
                int[] result = finishResults[i];

                int index1 = result[0];
                int index2 = result[1];
                int index3 = result[2];

                if(board[index1] == currentPlayerSymbol & board[index2] == currentPlayerSymbol & board[index3] == currentPlayerSymbol)
                {
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Игра закончена. Победил игрок " + currentPlayer);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println();

                    return;
                }
            }

            // Проверяем на ничью

            if(stepsCount == 0)
            {
                System.out.println();
                System.out.println("=======================================");
                System.out.println("Игра закончена. Ничья");
                System.out.println("=======================================");
                System.out.println();
            }

            // Меняем игрока

            if(currentPlayer.equals(player1))
            {
                currentPlayer = player2;
            }
            else
            {
                currentPlayer = player1;
            }
        }
    }
}
