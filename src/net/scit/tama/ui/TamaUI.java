package net.scit.tama.ui;

import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import net.scit.tama.dao.AnimalInfoDAO;
import net.scit.tama.dao.AnimalInfoMapper;
import net.scit.tama.dao.PlayerDAO;
import net.scit.tama.vo.AnimalInfo;
import net.scit.tama.vo.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * projectName     :tama
 * fileName        :TamaUI
 * author          :yuuna
 * since           :2022/06/02
 */
public class TamaUI {
     Scanner keyin = new Scanner(System.in);
     PlayerDAO playerDao = new PlayerDAO();
     AnimalInfoDAO animalInfoDAO = new AnimalInfoDAO();
     String select;

    public TamaUI() {
        start();
    }

    private void menu() {
        System.out.println("☆.。.:*°☆.。☆.。.:*°☆.。☆.。");
        System.out.println("     T   A   M   A");
        System.out.println("     ① 회원가입");
        System.out.println("     ② 로그인");
        System.out.println("     ③ 종료");
        System.out.println("☆.。.:*°☆.。☆.。.:*°☆.。☆.。");
        System.out.print("   메뉴를 선택해 주세요: ");
    }

    public void start() {
        while (true) {
            menu();
            select = keyin.next();
            switch (select) {
                case "1":
                    playerInput();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\t잘못된 선택이예요! 메뉴를 다시 선택해주세요~");
            }
        }
    }

    private void playerInput() {
        System.out.println("\n\t안녕하세요! 새로운 타마를 찾으시나요?");
        System.out.println("\t먼저 당신의 아이디를 알려주세요");
        System.out.print("\n\t아이디: ");
        String playerId = keyin.next();

        System.out.print("\t비밀번호: ");
        String playerPwd = keyin.next();

        Player player = new Player(playerId, playerPwd);
        int result = playerDao.playerInput(player);
        if(result != 1) {
            System.out.println("\t등록에 실패했어요 ㅠㅠ \n관리자에게 문의를 해보아요");
        }

        System.out.println("\n\t새로운 타마를 만날 준비가 되었군요!");
        intoTamaWorld(playerId); // 타마월드 입성
    }

    public void login() {
        System.out.println("\n\t타마의 정보를 가져올께요~ 먼저 아이디를 입력해주세요!");
        System.out.print("\t아이디: ");
        String playerId = keyin.next();
        Player player = playerDao.findById(playerId);

        if (player == null) {
            System.out.println("\t등록되지 않는 회원이예요! 등록을 먼저 진행해주세요 :)");
            playerInput();
        }

        System.out.println("\t다음 비밀번호를 입력해주세요!");
        System.out.print("\t비밀번호: ");
        String playerPwd = keyin.next();
        player = playerDao.findByPwd(playerPwd);

        if (player == null) {
            System.out.println("비밀번호가 틀렸어요~!! \n인생은 한번뿐이예요.. 프로그램을 종료합니다.");
            return;
        }

        intoTamaWorld(playerId); // 타마월드 입성

    }

    private void activityMenu() {
        System.out.println("☆.。.:*°☆.。☆.。.:*°☆.。☆.。.☆");
        System.out.println("     A C T I V I T Y");
        System.out.println("     ① 먹이 주기");
        System.out.println("     ② 산책 가기");
        System.out.println("     ③ 병원 가기");
        System.out.println("     ④ 상태 확인하기");
        System.out.println("     ⑤ 내일 만나기");
        System.out.println("☆.。.:*°☆.。☆.。.:*°☆.。☆.。.☆");
        System.out.print("   메뉴를 선택해 주세요: ");
    }

    /**
     * 타마월드 입성 서브 메뉴시작
     * 타마가 없으면 새로 생성 있으면 데이터 가져옴
     * 하루이상 로그인하지 않으면 상태가 나빠짐
     * @param playerId 플레이어 아이디로 타마를 찾음
     */
    private void intoTamaWorld(String playerId) {
        System.out.println("\n\t\\( > ㅅ < )/ WELECOME TO TAMA WORLD ☆.。.:*°☆.。");
        System.out.println("\t타마짱은 당신의 관심을 받고 자라납니다~");

        // 타마 생성 (findById로 AnimalInfo 가져옴)
        AnimalInfo animalInfo = animalInfoDAO.selectAnimalInfo(playerId);
        if(animalInfo == null) {
            System.out.println("\n\n\t아직 등록된 타마가 없는것 같군요! \n\t새로운 타마를 만나러 떠나볼까요?");
            makeTama(playerId);
            animalInfo = animalInfoDAO.selectAnimalInfo(playerId);                      // 데이터베이스의 default값 가져옴
        }

        // 타마 이어하기
        System.out.println("\n\t----------------------------------------------");
        System.out.println("\t                현재 성장중인 타마");
        System.out.println("\t------------------------------------------------");
        System.out.println("\t" + animalInfo);
        System.out.println("\t------------------------------------------------");
        System.out.println("\n\t" + animalInfo.getAnimalName() + "랑 함께 하시겠어요?");

        while (true) {
            System.out.println("\t1)네! 함께할래요~ 2)아니요 오늘은 그만할래요");
            System.out.print("\t선택: ");
            select = keyin.next();

            if ("1".equals(select)) {
                System.out.println("\t오늘도 " + animalInfo.getAnimalName() + "랑 함께 놀아볼까요!?");
                break;
            } else if ("2".equals(select)) {
                System.out.println("\n\t초기메뉴로 돌아갈께요!\n");
                start();
            }
        }
        while (true) {
            // 타마 생활 시작
            activityMenu();
            select = keyin.next();

            switch (select) {
                case "1":
                    feed(animalInfo); break;
                case "2":
                    walk(animalInfo); break;
                case "3":
                    goToClinic(animalInfo); break;
                case "4":
                    conditionChk(animalInfo); break;
                case "5":
                    System.out.println("\t내일 또 만나요~");
                    System.exit(0); break;
                default:
                    System.out.println("\t잘못된 선택이예요! 메뉴를 다시 선택해주세요~");
            }

        }

    }

    /**
     * 현재 상태 체크 >> 혜인짱
     */
    private void conditionChk(AnimalInfo animalInfo) {
        System.out.println("\t------------------------------------------------");
        System.out.println("\t" + animalInfo.getAnimalName() + "의 현재 상태");
        System.out.println("\t------------------------------------------------");
        System.out.println("\t" + animalInfo);

    }

    /**
     * 병원가기
     */
    private void goToClinic(AnimalInfo animalInfo) {
        String currCondition = animalInfo.getCondition();
        if (("좋음".equals(currCondition)) || ("보통".equals(currCondition))) {
            System.out.println("컨디션이 좋아서 병원에 가지 않아도 되요!!");
            System.out.println("현재 상태: " + animalInfo.getCondition());
            return;
        }

        int currMoney = animalInfo.getMoney();
        if (currMoney < 200) {
            System.out.println("현재 소지금: " + currMoney);
            System.out.println("\t현재 소지하신 금액이 너무 적어서 병원에 갈 수 없어요 ㅠㅠ ");
            return;
        }

        if(currCondition.equals("나쁨")) {
            treatmentBad(animalInfo);

        } else if(currCondition.equals("병")) {
            treatmentIll(animalInfo);
        }

    }

    private void treatmentIll(AnimalInfo animalInfo) {
        System.out.println("\n\t현재 [병] 상태예요. 치료하려면 500원이 차감됩니다.");
        System.out.println("\n\t1)치료하기 2)치료 안할래요");
        System.out.print("\t선택: ");
        select = keyin.next();

        if("2".equals(select)) {
            System.out.println("\n\t치료를 진행할게요~ 잠시만 기다려주세요...");
            // Thread 추가 3초지연
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            animalInfo.setCondition("좋음");
            animalInfo.setMoney(animalInfo.getMoney()-200);
            int result = animalInfoDAO.updateMoneyByClinic(animalInfo);
            if(result == 1) {
                System.out.println("\n\t치료가 완료되었어요! 즐거운 집으로 돌아갑니다");
            } else {
                System.out.println("\n\t예기치못한 문제가 발생했어요! 관리자에게 문의해주세요..!");
            }
            return;
        }
        System.out.println("치료를 중단합니다");
    }

    private void treatmentBad(AnimalInfo animalInfo) {
        System.out.println("\n\t현재 [나쁜] 상태예요. 치료하려면 200원이 차감됩니다.");
        System.out.println("\n\t1)치료하기 2)치료 안할래요");
        System.out.print("\t선택: ");
        select = keyin.next();

        if ("1".equals(select)) {
            System.out.println("\n\t치료를 진행할게요~ 잠시만 기다려주세요...");
            // Thread 추가 3초지연
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            animalInfo.setCondition("좋음");
            animalInfo.setMoney(animalInfo.getMoney() - 200);
            int result = animalInfoDAO.updateMoneyByClinic(animalInfo);
            if (result == 1) {
                System.out.println("\n\t치료가 완료되었어요! 즐거운 집으로 돌아갑니다");
            } else {
                System.out.println("\n\t예기치못한 문제가 발생했어요! 관리자에게 문의해주세요..!");
            }
            return;
        }
        System.out.println("치료를 중단합니다");
    }

    /**
     * 산책하기
     */
    private void walk(AnimalInfo animalInfo) {
        System.out.println("\n\n\t" + animalInfo.getAnimalName() + "과 즐거운 산책을 떠나보아요!");

        while (true) {
            System.out.println("\t산책 코스를 골라주세요!");
            System.out.println("\t1)공원 2)한강 3)등산");
            System.out.print("\t선택: ");
            select = keyin.next();

            switch (select) {
                case "1":
                    System.out.println("\n\t당신은" + animalInfo.getAnimalName() + "랑 공원에서 즐거운 산책중인데… ");
                    break;
                case "2":
                    System.out.println("\n\t당신은" + animalInfo.getAnimalName() + "랑 한강에서 행복한 산책중인데…");
                    break;
                case "3":
                    System.out.println("\n\t당신은" + animalInfo.getAnimalName() + "랑 힘겨운 등반중에 있는데… ");
                    break;
                default:
                    System.out.println("\n\t잘못된 선택이예요! 메뉴를 다시 선택해주세요~");
                    continue;
            }

            // sleep 사용해서 천천히 ... 이 떨어지게

            Random random = new Random();
            char randomtxt = (char) (random.nextInt(26) + 'a'); // a + 26까지
//            System.out.println("Generated Random Character: " + randomtxt);

            int money;
            if(randomtxt == 'a' || randomtxt == 'b' || randomtxt == 'c' ) {
                System.out.println("\n\t두둥! 500원을 발견했습니다!!!");
                money = 500;
            } else {
                System.out.println("\n\t어머나! 여기에 돈이? 50원을 주었습니다!");
                money = 50;
            }
            animalInfo.setMoney(animalInfo.getMoney()+money);
            animalInfoDAO.updateMoneyByWalk(animalInfo);
            System.out.println("\t당신은 행복한 마음으로 " + animalInfo.getAnimalName() + "와 함께 집으로 돌아갑니다~");
            return;
        }

    }

    /**
     * 먹이주기 >> 혜인짱
     */
    private void feed(AnimalInfo animalInfo) {

    }

    /**
     * 타마 등록
     * @param playerId 플레이어 아이디 FK로 타마를 생성
     */
    private void makeTama(String playerId) {
        System.out.println("\n\n\t당신의 소중한 타마의 종류를 골라주세요~");

        AnimalInfo createAnimal = new AnimalInfo();
        createAnimal.setPlayerId(playerId);
        while (true) {
            System.out.println("\t1)앵무새 / 2)강아지 / 3)고양이");
            System.out.print("\t선택: ");
            select = keyin.next();
            switch (select) {
                case "1":
                    System.out.println("\n\t당신은 화려한 무늬의 앵무새 알을 발견했습니다!!!");
                    // 텍스이미지 띄우기
                    createAnimal.setTypeSeq(1);
                    break;
                case "2":
                    System.out.println("\n\t당신은 사랑스러운 댕댕이를 구조했습니다!!!");
                    createAnimal.setTypeSeq(2);
                    break;
                case "3":
                    System.out.println("\n\t당신은 신비스러운 고양이에게 간택당했습니다!!!");
                    createAnimal.setTypeSeq(2);
                    break;
                default:
                    System.out.println("\n\t다른 종류는 준비중이예요 :) \n1~3번 사이에서 골라주세요!");
                    continue;
            }

            String type = null;
            if ("1".equals(select)) {
                type = "화려한";
            } else if ("2".equals(select)) {
                type = "사랑스러운";
            } else if ("3".equals(select)) {
                type = "신비스러운";
            }

            System.out.println("\n\t당신의 " +  type + " 타마의 이름을 지어주세요");
            System.out.println("\t수정할 수 없으니 신중하게 지어주세요");
            System.out.print("\t타마 이름: ");
            String name = keyin.next();
            createAnimal.setAnimalName(name);
            int result = animalInfoDAO.tamainput(createAnimal);

            if(result != 1) {
                System.out.println("\t알 수 없는 외부의 힘이 작용했어요..! \n자세한 사항은 관리자에게 문의해주세요");
                start();
            }

            System.out.println("\t자, 이제 당신의 " + type + " " + name + "랑 함께 놀아볼까요?");
            // 타마 월드로 돌아감
            return;
        }
    }
}
