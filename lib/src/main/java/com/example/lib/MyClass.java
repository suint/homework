/*
 * MyClass.java
 * Kelly Mi
 * Section 080
 * Heron's Formula/Seconds to days/hours/minutes/seconds converter
 * 2.12.18
 */

package com.example.lib;
import java.util.Scanner;

public class MyClass {
  public static void main(String[] args){
    System.out.println("Type 1 to use Heron's formula to find the area of a triangle.");
    System.out.println("Type 2 to convert a number from seconds to hours/minutes/seconds.");

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();

    try {
      if (a == 1) {
        heronsFormula();
      } else if (a == 2) {
        convertSeconds();
      } else {
        throw new Exception();
      }
    } catch (Exception e){

    }
  }
  //calculates area of user-defined triangle using Heron's formula, also gives semiperimeter & angle of gamma
  static void heronsFormula(){
    System.out.println("Please enter side lengths of a triangle. (Single line, separated by spaces)");
    Scanner sc = new Scanner(System.in);

    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double c = sc.nextDouble();

    //semiperimeter (used in Heron's formula)
    double s = (a + b + c)/2;
    //Heron's formula
    double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    //law of cosines & convert from radian to degree
    double gamma = (180 / Math.PI) * Math.acos((Math.pow(c, 2) - Math.pow(a, 2) - Math.pow(b,2))/(-2 * a * b));

    System.out.format("The length of the semiperimeter s is %1$.2f. The area of the triangle A is %2$.2f. The angle between a and b is %3$.2f.", s, A, gamma);
  }
  //converts user-defined seconds value to days/hours/minutes/seconds
  static void convertSeconds(){
    System.out.println("Please enter a length of time in seconds.");

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();

    int d = (a - (a % 86400)) / 86400;
    int h = ((a - (a % 3600)) / 3600) - (d * 24);
    int m = ((a - (a % 60)) / 60) - (h * 60) - (d * 1440);
    int s = a - (m * 60) - (h * 3600) - (d * 86400);

    if (d > 0) {
      if (d == 1) {
        System.out.print(d + " day ");
      } else {
        System.out.print(d + " days ");
      }
    }

    if (h > 0 || d > 0) {
      if (h == 1) {
        System.out.print(h + " hour ");
      } else {
        System.out.print(h + " hours ");
      }
    }

    if (m > 0 || (d > 0 || h > 0)) {
      if (m == 1) {
        System.out.print(m + " minute ");
      } else {
        System.out.print(m + " minutes ");
      }
    }

    if (s > 0 || (d > 0 || h > 0 || m > 0)){
      if (s == 1) {
        System.out.print(s + " second");
      } else {
        System.out.print(s + " seconds");
      }
    }
  }
}