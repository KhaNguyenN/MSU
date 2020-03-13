import java.util.Scanner;
public class StrangeCalc {
public static void main(String[] args) {
Scanner keys = new Scanner( System.in );
int value = 0;
String command;
do {
System.out.println("value: " + value);
System.out.print("? ");
command = keys.nextLine();
if (command.equals("twice")) {
value *= 2;
}
else if (command.equals("hop")) {
value = 3 * value + 1;
}
else if (command.equals("shrink")) {
value /= 2;
}
} while(!command.equals( "quit" ));
}
}