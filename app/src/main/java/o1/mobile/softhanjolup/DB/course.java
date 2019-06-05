package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class course {
    SQLiteDatabase db;

    course(SQLiteDatabase db){
        this.db = db;
    }

    public void createCourseDB(SQLiteDatabase db){
        //id, year, semester, courseName, credit, index, done


        //1학년 1학기
        db.execSQL("INSERT INTO DB_Course VALUES(0,1, 1,'인성세미나',1,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(1,1, 1,'Practical English1',1,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(2,1, 1,'인성과 리더십',2,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(3,1, 1,'창의와 사고',2,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(4,1, 1,'미술 감상과 비평',2,7, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(5,1, 1,'컴퓨터 프로그래밍',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(6,1, 1,'웹 프로그래밍',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(7,1, 1,'이산수학',3,5, 0);");


        //1학년 2학기
        db.execSQL("INSERT INTO DB_Course VALUES(11,1, 2,'Practical English2',1,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(12,1, 2,'인성과 리더십',2,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(13,1, 2,'창의와 사고',2,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(14,1, 2,'과학기술 글쓰기',2,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(15,1, 2,'소프트웨어 생태계',2,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(16,1, 2,'글로벌리더십',2,2, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(17,1, 2,'소프트웨어 구현 패턴',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(18,1, 2,'로봇공학',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(19,1, 2,'확률통계',3,5, 0);");


        //2학년 1학기
        db.execSQL("INSERT INTO DB_Course VALUES(21,2, 1,'Practical English3',1,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(22,2, 1,'세계와 문화',2,2, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(23,2, 1,'자료구조',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(24,2, 1,'객체지향 프로그래밍',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(25,2, 1,'운영체제',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(26,2, 1,'경제학개론',2,6, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(27,2, 1,'에듀에코세미나',1,6, 0);");


        //2학년 2학기
        db.execSQL("INSERT INTO DB_Course VALUES(31,2, 2,'Practical English4',1,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(32,2, 2,'사회봉사',0,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(33,2, 2,'세계와 문화',2,2, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(34,2, 2,'사회와 역사',2,2, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(35,2, 2,'네트워크',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(36,2, 2,'알고리즘',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(37,2, 2,'데이터베이스',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(38,2, 2,'Business English',2,3, 0);");


        //3학년 1학기
        db.execSQL("INSERT INTO DB_Course VALUES(41,3,1,'사회와 역사',2,2, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(42,3,1,'모바일 프로그래밍',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(43,3,1,'졸업작품1',1,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(44,3,1,'경영학원론',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(45,3,1,'소프트웨어 산업 세미나',2,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(46,3,1,'소프트웨어 공학',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(47,3,1,'트랙1',3,4, 0);");


        //3학년 2학기
        db.execSQL("INSERT INTO DB_Course VALUES(51,3, 2,'진로세미나',1,1, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(52,3, 2,'그래픽스',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(53,3, 2,'마케팅',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(54,3, 2,'컴퓨터 구조',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(55,3, 2,'졸업작품2',1,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(56,3, 2,'트랙2',3,4, 0);");


        //4학년 1학기
        db.execSQL("INSERT INTO DB_Course VALUES(61,4, 1,'멀티미디어 실습',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(62,4, 1,'기업가정신',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(63,4, 1,'졸업작품3',1,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(64,4, 1,'현장실습',1,6, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(65,4, 1,'트랙3',3,4, 0);");


        //4학년 2학기
        db.execSQL("INSERT INTO DB_Course VALUES(71,4, 2,'HCI',3,5, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(72,4, 2,'기술경영',3,6, 0);");
        db.execSQL("INSERT INTO DB_Course VALUES(73,4, 2,'트랙4',3,4, 0);");

    }
}
