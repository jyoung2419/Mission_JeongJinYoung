package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    int contentId;
    Scanner scanner;
    List<Quotation> quotationList = new ArrayList<>();

    App() {
        scanner = new Scanner(System.in);
        contentId = 0;
        quotationList = new ArrayList<>();
    }

    void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String sc = scanner.nextLine();

            Rq rq = new Rq(sc);

            if (rq.getAction().equals("종료")) {
                break;
            } else if (rq.getAction().equals("등록")) {
                write();
            } else if(rq.getAction().equals("목록")){
                list();
            } else if(rq.getAction().equals("삭제")){
                remove(rq);
            } else if(rq.getAction().equals("수정")){
                modify(rq);
            }
        }
    }
    private void write(){
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        contentId++;

        Quotation quotation = new Quotation(contentId, content, authorName);
        quotationList.add(quotation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", contentId);
    }

    private void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for (int i = quotationList.size() - 1; i >= 0; i--) {
            Quotation quotation = quotationList.get(i);
            System.out.printf("%d / %s / %s\n", quotation.contentId, quotation.authorName, quotation.content);
        }
    }

    private void remove(Rq rq) {
        int id = rq.getParamAsInt("id",0);

        if(id == 0){
            System.out.println("id를 정확히 입력 해 주세요.");
            return;
        }

        int deleteId = getId(id);

        if(deleteId == -1){
            System.out.printf("%d번 명언은 존재 하지 않습니다.\n",id);
            return;
        }

        quotationList.remove(deleteId);
        System.out.printf("%d번 명언을 삭제 했습니다.\n",id);
}

    private void modify(Rq rq) {
        int id = rq.getParamAsInt("id",0);

        if(id == 0){
            System.out.println("id를 정확히 입력 해 주세요.");
            return;
        }

        int modifyId = getId(id);

        if(modifyId == -1){
            System.out.printf("%d번 명언은 존재 하지 않습니다.\n",id);
            return;
        }

        Quotation quotation=quotationList.get(modifyId);
        System.out.printf("명언(기존) : %s\n",quotation.content);
        System.out.print("명언 : ");
        quotation.content=scanner.nextLine();
        System.out.printf("작가(기존) : %s\n",quotation.authorName);
        System.out.print("작가 : ");
        quotation.authorName=scanner.nextLine();
    }

    private int getId(int id) {
        for(int i=0;i<quotationList.size();i++){
            Quotation quotation=quotationList.get(i);
            if(quotation.contentId==id){
                return i;
            }
        }
        return -1;
    }
}