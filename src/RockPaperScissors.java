import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	private static final String errorMessage = "����񂯂�̎����͂��Ă������� ���͒l�F";

	private static final String[] rockPaperScissors = { "�O�[", "�p�[", "�`���L" };

	private static final String rock = "�O�[";

	private static final String paper = "�p�[";

	private static final String scissors = "�`���L";

	private static final String end = "�I��";

	private static final String win = "����\n";

	private static final String lose = "����\n";

	private static final String aiko = "������\n";

	private static Scanner scanner = new Scanner(System.in);

	// �v���O�����Ƃ���񂯂���s�����\�b�h
	public static void main(String[] args) {

		//����񂯂�̏��������𔻒�
		fight();

	}

	private static void fight() {

		System.out.println("����񂯂�̎����͂��Ă�������");
		String input = scanner.next();

		// ���͒l���m�F��
		// �E����񂯂�̎�łȂ��ꍇ
		// ��L�̏ꍇ�̓G���[���b�Z�[�W��ԋp
		// �u�I���v����͂����ꍇ�A�v���O�����I��
		if (input.equals(end)) {
			return;
		} else if (!(input.equals(rock) || input.equals(paper) || input.equals(scissors))) {
			System.out.println(errorMessage + input);
			return;
		}

		// �v���O�������̂���񂯂�̎�𐶐�����
		Random r = new Random();
		String programHand = rockPaperScissors[r.nextInt(3)];

		// �݂��̂���񂯂�̎���o��
		System.out.println("\n�v���O�����̎�́c\n");
		sleep(1000);
		System.out.println(programHand);
		sleep(1000);
		System.out.println("\n���s�́c�I\n");
		sleep(1000);

		// ����񂯂�̌��ʂ�ԋp����
		if (input.equals(rock)) {
			if (programHand.equals(rock)) {
				System.out.println(aiko);
			} else if (programHand.equals(paper)) {
				System.out.println(lose);
			} else {
				System.out.println(win);
			}
		} else if (input.equals(paper)) {
			if (programHand.equals(rock)) {
				System.out.println(win);
			} else if (programHand.equals(paper)) {
				System.out.println(aiko);
			} else {
				System.out.println(lose);
			}
		} else {
			if (programHand.equals(rock)) {
				System.out.println(lose);
			} else if (programHand.equals(paper)) {
				System.out.println(win);
			} else {
				System.out.println(aiko);
			}
		}

		// �u�I���v����͂����܂ŌJ��Ԃ�
		fight();
	}

	// �w�莞�ԕ��������~�߂�
	private static void sleep(int time) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// ���ɉ������Ȃ�
		}
	}

}
