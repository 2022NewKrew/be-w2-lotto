import repository.LottoRepositoryInMemory;
import service.LottoService;
import service.LottoServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        LottoService lottoService = new LottoServiceImpl(new LottoRepositoryInMemory());
        lottoService.run();

//        Member member1 = new Member();
//        member1.setName("test1");
//        member1.setAge(2);
//
//        Member member2 = new Member();
//        member2.setName("test2");
//        member2.setAge(3);
//
//        List<Member> memberList = new ArrayList<>();
//        memberList.add(member1);
//        memberList.add(member2);

    }

//    static class Member {
//        String name;
//        int age;
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
}
