package com.webhenric;

import java.util.ArrayList;
import java.util.List;

class StandardAlgorithm {

    String compute(char[] multiplicand, char[] multiplier) {
        List<String> listOfResults = new ArrayList<>();
        for (int i = multiplier.length - 1; i >= 0; i--) {
            listOfResults.add(multiply(multiplier[i], multiplicand));
        }
        return add(listOfResults);
    }

    String multiply(char multiplier_digit, char[] multiplicand) {
        StringBuilder stringBuilder = new StringBuilder();
        int product;
        int carry = 0;
        int multiplier = Character.digit(multiplier_digit, Character.MAX_RADIX);
        for (int i = multiplicand.length - 1; i >= 0; i--) {
            product = multiplier * Character.digit(multiplicand[i], Character.MAX_RADIX);
            product += carry;

            if (product > 9) {
                carry = product / 10;
            } else {
                carry = 0;
            }
            stringBuilder.append(product % 10);
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    String add(List<String> results) {
        StringBuilder accumulation = new StringBuilder();
        StringBuilder trailingZeroes = new StringBuilder();
        final char[][] arrayOfCharArrays = new char[results.size()][];
        for (int i = 0, resultsSize = results.size(); i < resultsSize; i++) {
            String result = results.get(i);
            arrayOfCharArrays[i] = (result + trailingZeroes.toString()).toCharArray();
            trailingZeroes.append('0');
        }
        int sum = 0;
        int y;
        int carry = 0;
        int lengthOfLastNumber = arrayOfCharArrays[arrayOfCharArrays.length - 1].length;
        for (int n =1; n <= lengthOfLastNumber; n++) {
            for (char[] aCharArray : arrayOfCharArrays) {
                y = aCharArray.length - n;
                if (y < 0) {
                    continue;
                }
                sum += Character.digit(aCharArray[y], Character.MAX_RADIX);
            }
            sum += carry;
            if (sum > 9) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            accumulation.append(sum % 10);
            sum = 0;
        }


        return accumulation.reverse().toString();
    }
}
