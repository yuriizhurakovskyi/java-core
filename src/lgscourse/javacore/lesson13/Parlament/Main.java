package lgscourse.javacore.lesson13.Parlament;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VerkhovnaRada verkhovnaRada = VerkhovnaRada.getInstance();
		while(true) {
			showMenu();
			String choice = scanner.nextLine().toLowerCase();
			switch(choice) {
			case "1":
				System.out.println("������ ����� �������: ");
				verkhovnaRada.addParliamentaryParty(new ParliamentaryParty(scanner.nextLine()));
				break;
			case "2":
				System.out.println("������ ����� �������: ");
				verkhovnaRada.removeParliamentaryParty(scanner.nextLine());
				break;
			case "3":
				verkhovnaRada.showAllParliamentaryPartyNames();
				break;
			case "4":
				System.out.println("������ ����� �������: ");
				verkhovnaRada.clearParliamentaryParty(scanner.nextLine());
				break;
			case "5":
				System.out.println("������ ����� �������: ");
				verkhovnaRada.showParliamentaryParty(scanner.nextLine());
				break;
			case "6":
				System.out.println("������ ����� �������: ");
				String parliamentaryPartyName = scanner.nextLine();
				System.out.println("������ ��'� ��������");
				String firstName = scanner.nextLine();
				System.out.println("������ ������� ��������");
				String lastName = scanner.nextLine();
				System.out.println("������ �� ��������");
				try {
					int age = Integer.parseInt(scanner.nextLine());
					System.out.println("�� ������� � ����������? ������ ��� ��� ��");
					boolean isBriberied = false;
					String res = scanner.nextLine();
					if(res.equalsIgnoreCase("���"))
						isBriberied = true;
					MP mp = new MP(firstName, lastName, age, isBriberied);
					mp.giveBribery(new Random().nextInt(5000));
					verkhovnaRada.addRepresentativeToParliamentaryParty(mp, parliamentaryPartyName);
				}catch(NumberFormatException nfe) {
					System.out.println("������� ������ ����");
				}
				break;
			case "7":
				System.out.println("������ ��'� ��������");
				String firstName1 = scanner.nextLine();
				System.out.println("������ ������� ��������");
				String lastName1 = scanner.nextLine();
				System.out.println("������ �� ��������");
				try {
					int age = Integer.parseInt(scanner.nextLine());
					if(verkhovnaRada.getRepresentativeIfExists(firstName1, lastName1, age)!=null) {
						verkhovnaRada.deleteRepresentative(verkhovnaRada.getRepresentativeIfExists(firstName1, lastName1, age));
					}else System.out.println("������ �������� ����");
				}catch(NumberFormatException nfe) {
					System.out.println("������� ������ ����");
				}
				break;
			case "8":
				System.out.println("������ ����� �������: ");
				verkhovnaRada.showALLBriberied(scanner.nextLine());
				break;
			case "9":
				System.out.println("������ ����� �������: ");
				verkhovnaRada.showTheMostBriberied(scanner.nextLine());
				break;
			case "exit":
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("������� ����");
				break;
			}
		}
	}

	private static void showMenu() {
		System.out.println("\n���� :");
		System.out.println("������ 1 ��� ������ �������"); 
		System.out.println("������ 2 ��� �������� ��������� �������");
		System.out.println("������ 3 ��� ������� ��  �������");
		System.out.println("������ 4 ��� �������� ��������� �������");
		System.out.println("������ 5 ��� ������� ��������� �������");
		System.out.println("������ 6 ��� ������ �������� � �������");
		System.out.println("������ 7 ��� �������� �������� � �������");
		System.out.println("������ 8 ��� ������� ������ ���������");
		System.out.println("������ 9 ��� ������� ���������� ���������");
		System.out.println("exit - ��� �����\n");
	}

}
