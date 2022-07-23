package com.interview;

import org.junit.jupiter.api.Test;


public class InterviewQuestions {

    @Test
    void starPattern1() {
//        *             i=1;j=1
//        **            i=2;j=2
//        ***           i=3;j=3
//        ****          i=4;j=4
//        *****         i=5;j=5

        int starSize = 5;
        for (int i = 0; i < starSize; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    void starPattern2(){
//        *****     i=1;j=5
//        ****      i=2;j=4
//        ***       i=3;j=3
//        **        i=4;j=2
//        *         i=5;j=1
        int starSize = 5;
        for(int i=1;i<=starSize;i++){
            for(int j=starSize;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    void starPattern3(){
//             *        For space, we can use Pattern 2
//            **        For star we can use Pattern 1
//           ***
//          ****
//         *****
        int starSize = 5;
        for(int i=1;i<=starSize;i++){

            for(int j=starSize-1;j>=i;j--){
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    void starPattern4(){
//        *****     For space, we can use pattern 1
//         ****     For star we can use pattern 2
//          ***
//           **
//            *
        int starSize = 5;
        for(int i=1;i<=starSize;i++){
            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }
            for(int k=starSize;k>=i;k--){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    @Test
    void starPattern5(){
//        *         i=1;j=1
//        **        i=2;j=2
//        ***       i=3;j=3
//        ****      i=4;j=4
//        *****     i=5;j=5
//        ****      i=2;j=4
//        ***       i=3;j=3
//        **        i=4;j=2
//        *         i=5;j=1

        int starSize = 5;
        for(int i=1;i<=starSize;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=starSize;i++){
            for(int j=starSize-1;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    @Test
    void starPattern6(){
//             *        For space, we can use Pattern 2
//            **        For star we can use Pattern 1
//           ***
//          ****
//         *****
//          ****     For space, we can use pattern 1
//           ***     For star we can use pattern 2
//            **
//             *

        int starSize = 5;
        for(int i=1;i<=starSize;i++){
            for(int j=starSize-1;j>=i;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=starSize;i++){
            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }
            for (int k=starSize-1;k>=i;k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    void starPattern7() {
//             *        Same Pattern 3 algorithm with space * in k iterator
//            * *
//           * * *
//          * * * *
//         * * * * *

//        for(int i=1;i<=5;i++){
//            for(int j=5;j>=i;j--){
//                System.out.print(" ");
//            }
//            for(int k=1;k<=i;k++){
//                System.out.print(" *");
//            }
//            System.out.println();
//        }

        for(int i=1;i<=5;i++){
            for(int j=5;j>=1;j--){
                if(j>i){
                    System.out.print(" ");
                }else{
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }


}
