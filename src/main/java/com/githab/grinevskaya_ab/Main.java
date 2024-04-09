package com.githab.grinevskaya_ab;


import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        do {
            System.out.print("Введите выражение: ");
            str = input.nextLine();
        } while (Objects.equals(str, ""));
        System.out.print("Результат:" + calc_str(str));
    }


    static double calc_str(String str) {
        String str_num = "";
        String signs = "+-*/%";
        double result = 0;
        char sign = ' '; //текущий знак

        for (char c : str.toCharArray()) {
            if (c == ' ' || c == '=') continue;

            if (signs.contains(c + "")) {
                result = make_operation_int(result, Double.parseDouble(str_num), sign); //Integer.parseInt
                str_num = "";
                sign = c;
            } else
                str_num += c;
        }

        return result = make_operation_int(result, Double.parseDouble(str_num), sign);
    }

    static double make_operation_int(double res, double num, char sign) {
        switch (sign) {
            case '-':
                res -= num;
                break;
            case '%':
                res %= num;
                break;
            case '/':
                res /= num;
                break;
            case '*':
                res *= num;
                break;
            default:
                res += num;
                break;
        }
        return res;
    }
}