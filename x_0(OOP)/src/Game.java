import java.util.Scanner;

public class Game
{

    private Player _currentPlayer;
    private Player _player_1;
    private Player _player_2;

    private String[][] _cells = new String[3][3];

    private final String _DEFAULT_SYMBOL = "_";

    private int[][] _finishResults = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


    public Game()
    {
        start();
    }


    private void start()
    {
        _player_1 = new Player("Игрок 1", "X");
        _player_1 = new Player("Игрок 2", "O");

        _currentPlayer = _player_1;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                _cells[i][j] = _DEFAULT_SYMBOL;
            }
        }

        loop();
    }


    private void loop()
    {


    }


    private void changePlayer()
    {
        if(_currentPlayer.equals(_player_1))
        {
            _currentPlayer = _player_2;
        }else
        {
            _currentPlayer = _player_1;
        }
    }


    private void showGameState()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.print("|");

            for (int j = 0; j < 3; j++)
            {
                System.out.print(_cells[i][j]);
                System.out.print("|");
            }

            System.out.print("\n");
        }
    }


    private int[] getInput()
    {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.next();

//        if(data.length() != 2)
//        {
//            System.out.println("ererer");
//            System.out.println("Неправильный ввод");
//            getInput();
//        }

        int row = Character.getNumericValue(data.charAt(0));
        int column = Character.getNumericValue(data.charAt(1));

        if(row > 2 || column > 2 || row < 0 || column < 0)
        {
            System.out.println("Неправильный ввод");
            getInput();
        }

        int[] rez = {row, column};
        return rez;
    }


    private boolean checkGameFinish()
    {
        String[] cells_inline = new String[9];

        int index = 0;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                cells_inline[index] = _cells[i][j];
                index++;
            }
        }

        String playerSymbol = _currentPlayer.getSymbol();

        for(int i = 0; i < _finishResults.length; i++)
        {
            int[] result = _finishResults[i];

            if(cells_inline[result[0]].equals(playerSymbol) && cells_inline[result[1]].equals(playerSymbol) && cells_inline[result[2]].equals(playerSymbol))
            {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args)
    {
        new Game();
    }

}
