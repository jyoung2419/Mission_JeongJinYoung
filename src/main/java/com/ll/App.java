package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    int contentId = 0;
    Scanner scanner = new Scanner(System.in);
    List<Quotation> quotationList = new ArrayList<>();

    void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String sc = scanner.nextLine();

            if (sc.equals("종료")) {
                break;
            } else if (sc.equals("등록")) {
                action();
            } else if(sc.equals("목록")){
                list();
            }
        }
    }
    void action(){
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        contentId++;
        int id = contentId;

        Quotation quotation = new Quotation(id, content, authorName);
        quotationList.add(quotation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", contentId);
    }

    void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for (int i = quotationList.size() - 1; i >= 0; i--) {
            Quotation quotation = quotationList.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }
}