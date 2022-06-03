package net.scit.tama.ui;

import net.scit.tama.dao.AnimalInfoDAO;
import net.scit.tama.dao.PlayerDAO;
import net.scit.tama.vo.AnimalInfo;
import net.scit.tama.vo.Player;

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
                    System.out.println("잘못된 선택이예요! 메뉴를 선택해주세요~");
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
            System.out.println("등록에 실패했어요 ㅠㅠ");
        }

        System.out.println("새로운 타마를 만날 준비가 되었군요!");
        intoTamaWorld(playerId); // 타마월드 입성
    }

    public void login() {
        System.out.println("\n\t타마의 정보를 가져올께요~ 먼저 아이디를 입력해주세요!");
        System.out.print("\t아이디: ");
        String playerId = keyin.next();
        Player player = playerDao.findById(playerId);

        if (player == null) {
            System.out.println("등록되지 않는 회원이예요! 등록을 먼저 진행해주세요 :)");
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

    private void menu() {
        System.out.println("☆.。.:*°☆.。☆.。.:*°☆.。☆.。");
        System.out.println("     T   A   M   A");
        System.out.println("     ① 회원가입");
        System.out.println("     ② 로그인");
        System.out.println("     ③ 종료");
        System.out.println("☆.。.:*°☆.。☆.。.:*°☆.。☆.。");
        System.out.print("   메뉴를 선택해 주세요: ");
    }

    /**
     * 타마월드 입성 서브 메뉴시작
     * 타마가 없으면 새로 생성 있으면 데이터 가져옴
     * @param playerId 플레이어 아이디로 타마를 찾음
     */
    private void intoTamaWorld(String playerId) {
        System.out.println("\n\n\t\\( > ㅅ < )/ WELECOME TO TAMA WORLD ☆.。.:*°☆.。");
        System.out.println("\t타마짱은 당신의 관심을 받고 자라납니다~");

        // findById로 AnimalInfo 가져옴
        AnimalInfo animalInfo = animalInfoDAO.selectAnimalInfo(playerId);
        if(animalInfo == null) {
            System.out.println("\t아직 등록된 타마가 없는것 같군요! 새로운 타마를 만나러 떠나볼까요?");
            makeTama(playerId);
        }

        // 타마 생활 시작
        // coding here

    }

    /**
     * 타마 등록
     * @param playerId 플레이어 아이디 FK로 타마를 생성
     */
    private void makeTama(String playerId) {
        System.out.println("\n\n\t당신의 소중한 타마의 종류를 골라주세요");

        AnimalInfo createAnimal = new AnimalInfo();
        createAnimal.setPlayerId(playerId);
        while (true) {
            System.out.println("\t1)앵무새 / 2)강아지 / 3)고양이");
            System.out.print("\t선택: ");
            select = keyin.next();
            switch (select) {
                case "1":
                    System.out.println("당신은 화려한 무늬의 앵무새 알을 발견했습니다!!!");
                    // 텍스이미지 띄우기
                    createAnimal.setTypeSeq(1);
                    break;
                case "2":
                    System.out.println("당신은 사랑스러운 댕댕이를 구조했습니다!!!");
                    createAnimal.setTypeSeq(2);
                    break;
                case "3":
                    System.out.println("당신은 신비스러운 고양이에게 간택당했습니다!!!");
                    createAnimal.setTypeSeq(2);
                    break;
                default:
                    System.out.println("다른 종류는 준비중이예요 :) \n1~3번 사이에서 골라주세요!");
                    continue;
            }

            String type = null;
            switch (select) {
                case "1":
                    type = "화려한";
                    break;
                case "2":
                    type = "사랑스러운";
                    break;
                case "3":
                    type = "신비스러운";
                    break;
            }

            System.out.println("당신의" +  type + " 타마의 이름을 지어주세요");
            System.out.println("수정할 수 없으니 신중하게 지어주세요");
            System.out.print("타마 이름: ");
            String name = keyin.next();
            createAnimal.setAnimalName(name);
            int result = animalInfoDAO.tamainput(createAnimal);

            if(result != 1) {
                System.out.println("알 수 없는 외부의 힘이 작용했어요..! \n자세한 사항은 관리자에게 문의해주세요");
                menu();
            }

            System.out.println("자, 이제 타마를 키우러 가볼까요?");
            // 타마 월드로 돌아감
            return;
        }
    }
}
