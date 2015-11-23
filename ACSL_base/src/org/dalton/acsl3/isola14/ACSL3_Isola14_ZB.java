package org.dalton.acsl3.isola14;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class ACSL3_Isola14_ZB {
  static Map<Integer, String> map = new TreeMap<Integer, String>();

  public static void main(String[] args) {
    map.put(1, new String("0,0"));
    map.put(2, new String("1,0"));
    map.put(3, new String("2,0"));
    map.put(4, new String("3,0"));
    map.put(5, new String("4,0"));
    map.put(6, new String("5,0"));
    map.put(7, new String("6,0"));
    map.put(8, new String("0,1"));
    map.put(9, new String("1,1"));
    map.put(10, new String("2,1"));
    map.put(11, new String("3,1"));
    map.put(12, new String("4,1"));
    map.put(13, new String("5,1"));
    map.put(14, new String("6,1"));
    map.put(15, new String("0,2"));
    map.put(16, new String("1,2"));
    map.put(17, new String("2,2"));
    map.put(18, new String("3,2"));
    map.put(19, new String("4,2"));
    map.put(20, new String("5,2"));
    map.put(21, new String("6,2"));
    map.put(22, new String("0,3"));
    map.put(23, new String("1,3"));
    map.put(24, new String("2,3"));
    map.put(25, new String("3,3"));
    map.put(26, new String("4,3"));
    map.put(27, new String("5,3"));
    map.put(28, new String("6,3"));
    map.put(29, new String("0,4"));
    map.put(30, new String("1,4"));
    map.put(31, new String("2,4"));
    map.put(32, new String("3,4"));
    map.put(33, new String("4,4"));
    map.put(34, new String("5,4"));
    map.put(35, new String("6,4"));
    map.put(36, new String("0,5"));
    map.put(37, new String("1,5"));
    map.put(38, new String("2,5"));
    map.put(39, new String("3,5"));
    map.put(40, new String("4,5"));
    map.put(41, new String("5,5"));
    map.put(42, new String("6,5"));
    map.put(43, new String("0,6"));
    map.put(44, new String("1,6"));
    map.put(45, new String("2,6"));
    map.put(46, new String("3,6"));
    map.put(47, new String("4,6"));
    map.put(48, new String("5,6"));
    map.put(49, new String("6,6"));
    Scanner scan = new Scanner(System.in);
    for (int k = 0; k < 5; k++) {
      String input = scan.nextLine();
      input = input.substring(0, input.length() - 3);
      int plus = Integer.parseInt(input.split(", ")[0]);
      int cross = Integer.parseInt(input.split(", ")[1]);
      int crossX = Integer.parseInt(map.get(cross).split(",")[0]);
      int crossY = Integer.parseInt(map.get(cross).split(",")[1]);
      int plusX = Integer.parseInt(map.get(plus).split(",")[0]);
      int plusY = Integer.parseInt(map.get(plus).split(",")[1]);
      // x, y
      int[][] board = new int[7][7];
      board[plusX][plusY] = 8;
      board[crossX][crossY] = 9;
      fillBoard(board, input.split(", "));
      // printGrid(board);
      // System.out.println(canMove(plusX, plusY, board));
      // check moving up
      int[][] upBoard = new int[7][7];
      int[][] downBoard = new int[7][7];
      int[][] leftBoard = new int[7][7];
      int[][] rightBoard = new int[7][7];
      int[][] upleftBoard = new int[7][7];
      int[][] uprightBoard = new int[7][7];
      int[][] downleftBoard = new int[7][7];
      int[][] downrightBoard = new int[7][7];
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          upBoard[i][j] = board[i][j];
          downBoard[i][j] = board[i][j];
          leftBoard[i][j] = board[i][j];
          rightBoard[i][j] = board[i][j];
          upleftBoard[i][j] = board[i][j];
          uprightBoard[i][j] = board[i][j];
          downrightBoard[i][j] = board[i][j];
          downleftBoard[i][j] = board[i][j];
        }
      }
      // up
      for (int y = crossY + 1; y < board.length; y++) {
        if (board[crossX][y] != 0)
          break;
        else
          upBoard[crossX][y] = 1;
      }
      // down
      for (int y = crossY - 1; y >= 0; y--) {
        if (board[crossX][y] != 0)
          break;
        else
          downBoard[crossX][y] = 1;
      }
      // left
      for (int x = crossX - 1; x >= 0; x--) {
        if (board[x][crossY] != 0)
          break;
        else
          leftBoard[x][crossY] = 1;
      }
      // right
      for (int x = crossX + 1; x < board.length; x++) {
        if (board[x][crossY] != 0)
          break;
        else
          rightBoard[x][crossY] = 1;
      }
      // upright
      for (int x = crossX + 1, y = crossY + 1; x < board.length && y < board.length; x++, y++) {
        if (board[x][y] != 0)
          break;
        else
          uprightBoard[x][y] = 1;
      }
      // upleft
      for (int x = crossX - 1, y = crossY + 1; x >= 0 && y < board.length; x--, y++) {
        if (board[x][y] != 0)
          break;
        else
          upleftBoard[x][y] = 1;
      }
      // downright
      for (int x = crossX + 1, y = crossY - 1; x < board.length && y >= 0; x++, y--) {
        if (board[x][y] != 0)
          break;
        else
          downrightBoard[x][y] = 1;
      }
      // downleft
      for (int x = crossX - 1, y = crossY - 1; x >= 0 && y >= 0; x--, y--) {
        if (board[x][y] != 0)
          break;
        else
          downleftBoard[x][y] = 1;
      }

      String output = "";

      if (!canMove(plusX, plusY, upBoard)) {
        for (int x = 0; x < upBoard.length; x++) {
          for (int y = 0; y < upBoard.length; y++) {
            if (upBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      } else if (!canMove(plusX, plusY, downBoard)) {
        for (int x = 0; x < downBoard.length; x++) {
          for (int y = 0; y < downBoard.length; y++) {
            if (downBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      } else if (!canMove(plusX, plusY, leftBoard)) {
        for (int x = 0; x < leftBoard.length; x++) {
          for (int y = 0; y < leftBoard.length; y++) {
            if (leftBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      } else if (!canMove(plusX, plusY, rightBoard)) {
        for (int x = 0; x < rightBoard.length; x++) {
          for (int y = 0; y < rightBoard.length; y++) {
            if (rightBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      } else if (!canMove(plusX, plusY, upleftBoard)) {
        for (int x = 0; x < upleftBoard.length; x++) {
          for (int y = 0; y < upleftBoard.length; y++) {
            if (upleftBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      } else if (!canMove(plusX, plusY, downrightBoard)) {
        for (int x = 0; x < downrightBoard.length; x++) {
          for (int y = 0; y < downrightBoard.length; y++) {
            if (downrightBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      } else if (!canMove(plusX, plusY, downleftBoard)) {
        for (int x = 0; x < downleftBoard.length; x++) {
          for (int y = 0; y < downleftBoard.length; y++) {
            if (downleftBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      } else if (!canMove(plusX, plusY, uprightBoard)) {
        for (int x = 0; x < uprightBoard.length; x++) {
          for (int y = 0; y < uprightBoard.length; y++) {
            if (uprightBoard[x][y] != board[x][y]) {
              for (Entry<Integer, String> entry : map.entrySet()) {
                if (stringify(x, y).equals(entry.getValue())) {
                  output += entry.getKey() + ", ";
                }
              }
            }
          }
        }
      }
      if (output.length() != 0)
        System.out.println(output.substring(0, output.length() - 2));
      else
        System.out.println("NONE");
    }
  }// main

  private static Object stringify(int x, int y) {
    return x + "," + y;
  }

  private static void fillBoard(int[][] board, String[] split) {
    for (int i = 2; i < split.length; i++) {
      int x = Integer.parseInt(map.get(Integer.parseInt(split[i])).split(",")[0]);
      int y = Integer.parseInt(map.get(Integer.parseInt(split[i])).split(",")[1]);
      board[x][y] = 1;
    }
  }

  private static boolean canMove(int plusX, int plusY, int[][] board) {
    boolean left = (plusX != 0) && board[plusX - 1][plusY] == 0;
    boolean right = (plusX != 6) && board[plusX + 1][plusY] == 0;
    boolean top = (plusY != 6) && board[plusX][plusY + 1] == 0;
    boolean bottom = (plusY != 0) && board[plusX][plusY - 1] == 0;
    boolean tl = (plusX != 0 && plusY != 6) && board[plusX - 1][plusY + 1] == 0;
    boolean tr = (plusX != 6 && plusY != 6) && board[plusX + 1][plusY + 1] == 0;
    boolean bl = (plusX != 0 && plusY != 0) && board[plusX - 1][plusY - 1] == 0;
    boolean br = (plusX != 6 && plusY != 0) && board[plusX + 1][plusY - 1] == 0;
    return left || right || top || bottom || tl || tr || bl || br;
  }

  public static void printGrid(int[][] a) {
    for (int y = a.length - 1; y >= 0; y--) {
      for (int x = 0; x < a[0].length; x++)
        System.out.print(a[x][y] + " ");
      System.out.println();
    }
  }
}// class
