package com.githab.grinevskaya_ab;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        do {
            System.out.print("Введите выражение: ");
            str = input.nextLine();
        } while (Objects.equals(str, ""));
        input.close(); // закрытие сканера

        int code_res = calc_str(str);
        System.out.println(code_res == 0 ? "Результат: " + result : "Невалидное значение");
    }

    static double result = 0;

    static int calc_str(String str) {
        StringBuilder str_num = new StringBuilder("0"); //  init 0 если первая цифра < 0
        String signs = "*/%+-";
        char sign = ' '; //текущий знак
        int code_res = 0;

        for (char c : str.toCharArray()) {
            if (c == ' ' || c == '=') continue;

            if (signs.contains(c + "")) {
                make_operation_int(Double.parseDouble(str_num.toString()), sign); //Integer.parseInt
                str_num = new StringBuilder("0");
                sign = c;
            } else if ((c >= '0' && c <= '9') || c == '.') {
                str_num.append(c);
            } else {
                code_res = 1;
                break;
            }
        }

        if (code_res == 0)
            make_operation_int(Double.parseDouble(str_num.toString()), sign); // для операци над последним числом
        return code_res;
    }

    static void make_operation_int(double num, char sign) {
        switch (sign) {
            case '-':
                result -= num;
                break;
            case '%':
                result %= num;
                break;
            case '/':
                result /= num;
                break;
            case '*':
                result *= num;
                break;
            default:
                result += num;
                break;
        }
    }
}