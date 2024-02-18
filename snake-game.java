import java.util.Scanner;
import java.util.Random;

public class SnakeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Snake Game!");
        System.out.println("Use 'WASD' keys to move the snake.");
        System.out.println("Let's start!");

        int width = 20;
        int height = 10;
        char[][] grid = new char[height][width];
        int snakeX = width / 2;
        int snakeY = height / 2;
        int foodX = new Random().nextInt(width);
        int foodY = new Random().nextInt(height);
        boolean isGameOver = false;
        char direction = ' ';

        while (!isGameOver) {
            // Draw the grid
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == snakeY && j == snakeX) {
                        grid[i][j] = '*'; // Snake body
                    } else if (i == foodY && j == foodX) {
                        grid[i][j] = '@'; // Food
                    } else {
                        grid[i][j] = '.'; // Empty space
                    }
                }
            }

            // Display the grid
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }

            // Handle user input
            System.out.print("Enter your move (W/A/S/D): ");
            direction = scanner.next().charAt(0);

            // Move the snake
            switch (direction) {
                case 'W':
                    snakeY--;
                    break;
                case 'A':
                    snakeX--;
                    break;
                case 'S':
                    snakeY++;
                    break;
                case 'D':
                    snakeX++;
                    break;
            }

            // Check if the snake eats the food
            if (snakeX == foodX && snakeY == foodY) {
                System.out.println("Yum! You ate the food!");
                foodX = new Random().nextInt(width);
                foodY = new Random().nextInt(height);
            }

            // Check if the snake hits the wall
            if (snakeX < 0 || snakeX >= width || snakeY < 0 || snakeY >= height) {
                System.out.println("Game Over! You hit the wall.");
                isGameOver = true;
            }

            // Add more game logic here...

        }

        System.out.println("Thank you for playing the Snake Game!");
        scanner.close();
    }
}
