package programs;

/**
 * Created by pradeep on 26/6/16.
 */
public class TelephoneWord {

    public static int count = 0;

    public static void generate(int[] phoneNumber, int startIndex, char[] charNumber) {
//        System.out.println("generate : " + "phoneNumber : " + phoneNumber.length + " startIndex : " + startIndex + " charNumber : " + charNumber.length);

        if (startIndex == phoneNumber.length) {
            System.out.println(charNumber);
            count++;
            return;
        }
        for (int index = 0; index < 3; index++) {
            charNumber[startIndex] = getChar(phoneNumber[startIndex], index + 1);
            generate(phoneNumber, startIndex + 1, charNumber);
        }

    }

    private static char getChar(int number, int position) {
//        System.out.println("getChar : " + number + " position : " + position);
        char selectedChar = 0;

        switch (number) {
            case 2:
                if (position == 1) {
                    selectedChar = 'A';
                } else if (position == 2) {
                    selectedChar = 'B';
                } else if (position == 3) {
                    selectedChar = 'C';
                }
                break;
            case 3:
                if (position == 1) {
                    selectedChar = 'D';
                } else if (position == 2) {
                    selectedChar = 'E';
                } else if (position == 3) {
                    selectedChar = 'F';
                }
                break;
            case 4:
                if (position == 1) {
                    selectedChar = 'G';
                } else if (position == 2) {
                    selectedChar = 'H';
                } else if (position == 3) {
                    selectedChar = 'I';
                }
                break;
            case 5:
                if (position == 1) {
                    selectedChar = 'J';
                } else if (position == 2) {
                    selectedChar = 'K';
                } else if (position == 3) {
                    selectedChar = 'L';
                }
                break;
            case 6:
                if (position == 1) {
                    selectedChar = 'M';
                } else if (position == 2) {
                    selectedChar = 'N';
                } else if (position == 3) {
                    selectedChar = 'O';
                }
                break;
            case 7:
                if (position == 1) {
                    selectedChar = 'P';
                } else if (position == 2) {
                    selectedChar = 'R';
                } else if (position == 3) {
                    selectedChar = 'S';
                }
                break;
            case 8:
                if (position == 1) {
                    selectedChar = 'T';
                } else if (position == 2) {
                    selectedChar = 'U';
                } else if (position == 3) {
                    selectedChar = 'V';
                }
                break;
            case 9:
                if (position == 1) {
                    selectedChar = 'W';
                } else if (position == 2) {
                    selectedChar = 'X';
                } else if (position == 3) {
                    selectedChar = 'Y';
                }
                break;
        }


//        System.out.println("selectedChar : " + selectedChar);
        return selectedChar;
    }

    public static void main(String[] args) {
        int[] phoneNumber = {4, 9, 7};
        char[] charNumber = new char[phoneNumber.length];
        generate(phoneNumber, 0, charNumber);
        System.out.println("Total number of numbers : " + count);
    }
}
